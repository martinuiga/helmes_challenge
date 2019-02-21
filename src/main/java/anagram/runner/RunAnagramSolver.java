package anagram.runner;

import java.util.ArrayList;
import java.util.List;

import anagram.solver.AnagramSolver;

public class RunAnagramSolver {

    // Find all distinct combinations of given length
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String[] A = { "Tere", "kere", "pere" };
        int k = 2;

        AnagramSolver anagramSolver = new AnagramSolver();

        List<String> combinations = anagramSolver.recurse(A, "", 0, A.length, k, new ArrayList<String>());

        System.out.println(combinations);


        for (String combination : combinations) {
            anagramSolver.isAnagram("eret erek", combination);
        }

        long stop = System.currentTimeMillis() - startTime;
        System.out.println(stop);

    }
}
