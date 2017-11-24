package bogglesolver;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    
    private Cell[][] matrix;

    public class Cell {
        int x;
        int y;
        char ch;
        boolean visited;
        public Cell(int x, int y, char ch) {
            this.x = x;
            this.y = y;
            this.ch = ch;
        }
    }
    
    public Matrix(char[][] inputMatrix) {
        int rows = inputMatrix.length;
        int cols = inputMatrix[0].length;
        matrix = new Cell[rows][cols];
        for (int x=0; x<rows; x++) {
            for (int y=0; y<cols; y++) {
                Cell cell = new Cell(x, y, inputMatrix[x][y]);
                matrix[x][y] = cell;
            }
        }

        //used for debugging only
        print(false);
    }

    public List<Matrix.Cell> getNeighbors(Cell cell) {
        /*
        (-1, -1)   (-1, 0)     (-1, 1)
        (0, -1)     currCell   (0, 1)
        (1, -1)    (1, 0)      (1, 1)
         */
        int rows = this.getRowSize();
        int cols = this.getColSize();
        int[][] moves = 
                        {
                           {-1, -1}, {-1, 0}, {-1, 1},
                           {0, -1},           {0, 1},
                           {1, -1}, {1, 0}, {1, 1},
                        };
        
        List<Matrix.Cell> neighbors = new ArrayList<>();
        for (int[] move : moves) {
            int x = cell.x + move[0];
            int y = cell.y + move[1];
            boolean isValidCell = (x >= 0 && x < rows) && (y >= 0 && y < cols);
            if (isValidCell) {
                neighbors.add(this.getCell(x, y));
            }
        }
        return neighbors;
    }
    
    public Cell getCell(int x, int y) {
        return matrix[x][y];
    }
    
    public int getRowSize() {
        return matrix.length;
    }
    
    public int getColSize() {
        return matrix[0].length;
    }
    
    private void print(boolean isDebugEnabled) {
        if (!isDebugEnabled) {
            return;
        }

        int rows = getRowSize();
        int cols = getColSize();
        debug("[" + System.lineSeparator());
        for (int x=0; x<rows; x++) {
            for (int y=0; y<cols; y++) {
                debug(matrix[x][y].ch + " ");
            }
            debug(System.lineSeparator());
        }
        debug("]" + System.lineSeparator());
        debug(System.lineSeparator());
    }

    private void debug(String string) {
        System.out.print(string);
    }
}