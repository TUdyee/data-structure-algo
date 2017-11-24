package bogglesolver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solver {

    public Solver() { }
    
    private class Tuple {
        Matrix.Cell cell;
        String prefix;
        public Tuple(Matrix.Cell cell, String prefix) {
           this.cell = cell;
           this.prefix = prefix;
        }
    }

    //uses BFS algorithm to find words in matrix
    public List<String> findWords(Matrix matrix, int i, int j, Dictionary dict) {
        Queue<Tuple> queue = new LinkedList<Tuple>();
        Matrix.Cell cell = matrix.getCell(i, j);
        String startPrefix = "" + cell.ch;
        if (dict.startsWith(startPrefix)) {
            //add character at start node[i, j] into queue
            cell.visited = true;
            queue.add(new Tuple(cell, startPrefix));
        }
        return findWords(queue, matrix, dict);
    }

    private List<String> findWords(Queue<Tuple> queue, Matrix matrix, Dictionary dict) {
        List<String> words = new ArrayList<>();
        while(!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            List<Matrix.Cell> neighbors = matrix.getNeighbors(tuple.cell);
            for (Matrix.Cell neighbor : neighbors) {
                if (! neighbor.visited) {
                    String word = tuple.prefix + matrix.getCell(neighbor.x, neighbor.y).ch;
                    if (dict.startsWith(word)) {
                        if (dict.contains(word)) {
                            //found a word, lets add to list
                            words.add(word);
                        }
                        //only those cells that are valid prefix should
                        //be marked as visited
                        neighbor.visited = true;
                        queue.add(new Tuple(matrix.getCell(neighbor.x, neighbor.y), word));
                    }
                }
            }
        }
        return words;
    }
}