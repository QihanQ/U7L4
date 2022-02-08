import java.util.ArrayList;
import java.util.Locale;
import java.util.Collections;

public class ArrayListAlgorithms {
    /**
     * Returns true if any of the elements in stringList contain
     * target as a substring; false otherwise.
     * <p>
     * Does NOT mutate (modify) elements of stringList.
     * PRECONDITION: stringList.size() > 0
     *
     * @param stringList original arraylist of Strings
     * @return true if target is found in any of the strings, false otherwise
     */
    public static boolean containsTarget(ArrayList<String> stringList, String target) {
        for (String n : stringList) {
            if (n.indexOf(target) != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns number of elements in intList that are less than the
     * average of all elements.
     * <p>
     * Does NOT mutate (modify) elements of intList.
     * PRECONDITION: intList.size() > 0
     *
     * @param intList original arraylist of Integers
     * @return the number of ints in intList that are less than the average
     */
    public static int belowAverage(ArrayList<Integer> intList) {
        int sum = 0;
        int count = 0;
        for (int n : intList) {
            sum += n;
        }
        double average = (double) sum / intList.size();
        for (int j : intList) {
            if (j < average) {
                count++;
            }
        }
        return count;
    }

    /**
     * Replaces all words in wordList that end in "s" with the all-uppercase
     * version of the word.  For example, "apples" should be replaced with "APPLES".
     * Assume all letters of all words in wordList are lowercase initially (no need
     * to worry about checking for case or converting first to lowercase)
     * <p>
     * DOES mutate (modify) elements of wordList.
     * PRECONDITION: wordList.size() > 0
     *
     * @param wordList original arraylist of words
     */
    public static void replaceWithCaps(ArrayList<String> wordList) {
        for (int n = 0; n < wordList.size(); n++) {
            String s = wordList.get(n);
            if (s.substring(s.length() - 1, s.length()).equals("s")) {
                wordList.set(n, s.toUpperCase());
            }
        }
    }

    /**
     * Returns the index at which the minimum value of all integers in
     * intList appears; if the minimum value appears more than once in
     * the arraylist, return the index of the first occurrence
     * <p>
     * Does NOT mutate (modify) elements in intList.
     * PRECONDITION: intList.size() > 0
     *
     * @param intList original arraylist of Integers
     * @return the index at which the minimum value occurs
     */
    public static int indexOfMinimum(ArrayList<Integer> intList) {
        int min = intList.get(0);
        int ind = 0;
        int count = -1;
        for (int n : intList) {
            count++;
            if (n < min) {
                min = n;
                ind = count;
            }
        }
        return ind;
    }

    /**
     * Returns true if two array lists of the same length contain the exact
     * same elements in the same order (i.e. the two arraylists are identical).
     * Returns false otherwise.
     * <p>
     * Does NOT mutate (modify) elements in either arraylist
     * PRECONDITION: numList1.size() == numList2.size()
     *
     * @param numList1 first arraylist of Integers
     * @param numList2 second arraylist of Integers, has the same size a first
     * @return true if both arraylists are identical, element for element
     */
    public static boolean areIdentical(ArrayList<Integer> numList1, ArrayList<Integer> numList2) {
        for (int n = 0; n < numList1.size(); n++) {
            if (numList1.get(n) != numList2.get(n)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes all elements from numList that are ODD Integers.
     * <p>
     * DOES mutate (modify) elements in numList
     * PRECONDITION: numList1.size() > 0
     *
     * @param numList1 arraylist of Integers
     */
    public static void removeOdds(ArrayList<Integer> numList) {
        for (int n = 0; n < numList.size(); n++) {
            if (numList.get(n) % 2 != 0) {
                numList.remove(n);
                n--;
            }
        }
    }

    /**
     * Removes all elements from wordList that contain an a, e, i , and/or o.
     * All other words (i.e. those that have u and/or y as the vowel
     * such as "ugh" or "sly", or no vowels, like "psh"), add a duplicate of
     * that element to wordList at an adjacent index.
     * <p>
     * Assume all words have lowercase letters (i.e. no need to check for case)
     * <p>
     * DOES mutate (modify) elements in wordList
     * PRECONDITION: wordList.size() > 0
     *
     * @param wordList arraylist of Strings
     */
    public static void wackyVowels(ArrayList<String> wordList) {
        for (int n = 0; n < wordList.size(); n++) {
            if (wordList.get(n).indexOf("a") != -1 || wordList.get(n).indexOf("e") != -1 || wordList.get(n).indexOf("i") != -1 || wordList.get(n).indexOf("o") != -1) {
                wordList.remove(n);
                n--;
            } else {
                wordList.add(n, wordList.get(n));
                n++;
            }
        }
    }

    /**
     * Removes all duplicate values from an intList, leaving only the first
     * occurrence in the arrayList; for example, this method will modify
     * [1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2] --> [1, 2, 5, 4, 6, 8, 7]
     * <p>
     * DOES mutate (modify) elements in intList
     * PRECONDITION: intList.size() > 0
     *
     * @param intList intList of Integers
     */
    public static void removeDuplicates(ArrayList<Integer> intList) {
        for (int n = 0; n < intList.size(); n++) {
            for (int j = n + 1; j < intList.size(); j++) {
                if (intList.get(n) == intList.get(j)) {
                    intList.remove(j);
                    j--;
                }
            }
        }
    }
    /** Adds an uppercase version of each string directly AFTER the string
     *  in wordList; for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "HELLO", "my", "MY", "best", "BEST", "friend", "FRIEND"]
     *
     *  Assume all words have lowercase letters originally
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void duplicateUpperAfter(ArrayList<String> wordList)
    {
        for(int n = 0; n < wordList.size(); n ++)
        {
            wordList.add(n + 1,wordList.get(n).toUpperCase());
            n++;
        }
    }
    /** Appends an uppercase version of each string to the END of of wordList;
     *  the uppercase versions appear in the same order as the lowercase versions
     *  for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "my", "best", "friend", "HELLO", "MY", "BEST", "FRIEND"]
     *
     *  Assume all words have lowercase letters originally
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void duplicateUpperEnd(ArrayList<String> wordList)
    {
        int len = wordList.size();
        for(int n = 0; n < len; n++)
        {
            wordList.add(wordList.get(n).toUpperCase());
        }
    }
    /** Returns an arraylist of Strings that represents the input sentence parsed
     *  into separate words (using a space: " " as the delimiter) and REVERSED
     *  For example, if sentence = "This is my sentence!"
     *  this method return [sentence!, my, is, This]
     *
     *  PRECONDITION: sentence does not end with a space
     *
     *  @param sentence  the input String that represents one or more words
    separated by spaces
     *  @return  new arraylist of Strings containing the words of sentence reversed
     */
    public static ArrayList<String> parseWordsAndReverse(String sentence)
    {
        int ind = sentence.indexOf(" ");
        ArrayList<String> fin = new ArrayList<String>();
        while(ind != -1)
        {
            fin.add(0, sentence.substring(0,ind));
            sentence = sentence.substring(ind + 1);
            ind = sentence.indexOf(" ");
        }
        fin.add(0, sentence);
        return fin;
    }
    /** Removes all words from wordList that begin with "b" and inserts them at the
     *  front of wordList; all "b" words that are moved should appear in the same order
     *  in the modified arrayList as they did before being moved
     *
     *  For example, this method will take a wordList:
     *  ["apple", "banana", "cherry", "donut", "bagel", "danish", "berry", "baguette", "soda"]
     *  and modify it to
     *  ["banana", "bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"]
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITIONS: wordList.size() > 0, all strings in wordList have at least one character
     *
     *  @param wordList  arraylist of words
     */
    public static void moveBWords(ArrayList<String> wordList) {
        int count = 0;
        for (int n = 0; n < wordList.size(); n++) {
            if (wordList.get(n).substring(0, 1).equals("b")) {
                String s = wordList.get(n);
                wordList.remove(n);
                wordList.add(count, s);
                count++;
            }
        }
    }
    /** Returns Arraylist of Integers that contain all mode(s) of the int array numList.
     *  If elements in numList all appear exactly once, there is no mode, and this method
     *  should return an empty list
     *
     *  For example, if numList is: [1, 2, 3, 2, 4, 5, 5, 6],
     *  then numList contains two modes: 2, 5
     *  and this method returns an arraylist containing 2 and 5 (in any order)
     *  If numList is: [1, 2, 3, 2, 4, 5, 5, 6, 6, 7, 6],
     *  then numList contains one mode: 6
     *  and this method returns an arrayList containing 6
     *  If numList is: [1, 2, 3, 4, 5, 6], then numList contains no mode
     *  and this method returns an empty arrayList: []
     *  If numList is: [2, 2, 2, 3, 3, 3, 4, 4, 4],
     *  then numList contains three modes: 2, 3, 4
     *  and this method returns an arrayList containing 2, 3, and 4 (in any order)
     *
     *  Does NOT mutate (modify) elements in numList
     *  PRECONDITIONS: numList.length > 0
     *
     *  @param numList  numList of ints
     */
    public static ArrayList<Integer> modes(int[] numList) {
        int count = 0;
        int occurences = 0;
        ArrayList<Integer> mode = new ArrayList<Integer>();
        for (int n = 0; n < numList.length; n++)
        {
            mode.add(numList[n]);
        }
        Collections.sort(mode);
        for(int j = 0; j < mode.size(); j++)
        {
            for(int k = j + 1; k < mode.size(); k++)
            {
                if (mode.get(j) == mode.get(k)) {
                    count++;
                    mode.remove(k);
                    k--;
                }
                else if(count == 0 && mode.get(j) != mode.get(k))
                {
                    mode.remove(j);
                    j--;
                }
            }
            if(occurences == 0)
            {
                occurences = count;
            }
            if(occurences > count)
        }
    }
}
