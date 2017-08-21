package bogglesolver;

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