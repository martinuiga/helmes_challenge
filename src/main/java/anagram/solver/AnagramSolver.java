package anagram.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramSolver {

    // Function to print all distinct combinations of length k
    public List<String> recurse(String[] A, String out, int i, int n, int k, List<String> combinations) {
        if (k > n) {
            return combinations;
        }

        if (k == 0) {

            // Check if length is bigger than anagram length then dont add
            combinations.add(out.trim().toLowerCase());
            return combinations;
        }

        for (int j = i; j < n; j++) {
            recurse(A, out + " " + (A[j]), j + 1, n, k - 1, combinations);
        }

        return combinations;
    }

    public boolean isAnagram(String s1, String s2) {
        //Removing white spaces from s1 and s2 and converting case to lower case

        String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();
        String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();

        //Initially setting status as true
        boolean status = true;

        if (copyOfs1.length() != copyOfs2.length()) {
            //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length

            status = false;
        } else {
            //Constructing a map containing character as a key and character occurrences as a value

            HashMap<Character, Integer> map = new HashMap<Character, Integer>();

            for (int i = 0; i < copyOfs1.length(); i++) {
                //Getting char from copyOfs1

                char charAsKey = copyOfs1.charAt(i);

                //Initializing char count to 0

                int charCountAsValue = 0;

                //Checking whether map contains this char

                if (map.containsKey(charAsKey)) {
                    //If contains, retrieving it's count

                    charCountAsValue = map.get(charAsKey);
                }

                //Putting char and it's count to map with pre-incrementing char count

                map.put(charAsKey, ++charCountAsValue);

                //Getting char from copyOfs2

                charAsKey = copyOfs2.charAt(i);

                //Initializing char count to 0

                charCountAsValue = 0;

                //Checking whether map contains this char

                if (map.containsKey(charAsKey)) {
                    //If contains, retrieving it's count

                    charCountAsValue = map.get(charAsKey);
                }

                //Putting char and it's count to map with pre-decrementing char count

                map.put(charAsKey, --charCountAsValue);
            }

            //Checking each character and it's count

            for (int value : map.values()) {
                if (value != 0) {
                    //If character count is not equal to 0, then setting status as false

                    status = false;
                }
            }

        }
        return status;
    }

}
