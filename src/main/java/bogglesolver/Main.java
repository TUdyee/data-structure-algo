package bogglesolver;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //1. Setup dictionary
        String[] dictWords = {"axe", "axek", "able", "boy", "cat"};
        Dictionary dict = new Dictionary(dictWords);
        
        //2. Setup (M x N) matrix
        char array[][]   = 
            {
                {'a', 'b', 'l', 'e'},
                {'u', 'x', 'k', 'c'},
                {'q', 's', 'e', 'd'}
            };
        Matrix matrix = new Matrix(array);

        //3. Finally, lets search for words in matrix
        List<String> foundWords = new Solver().findWords(matrix, 0, 0, dict);

        //4. Print
        System.out.println(System.lineSeparator() + "List of words found : " + foundWords);
    }
}