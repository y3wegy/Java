package com.algorithm.search;

import org.apache.log4j.Logger;

/**
 * Created by Rui on 8/24/2015.
 */
public class LevenShiteinDistance {
    public static final Logger logger = Logger.getLogger(LevenShiteinDistance.class);
    private static final String TEXT = "I am a good man,can you help me?";

    public static void main(String[] args) {
        String targetText = "good";
        int[] v0 = new int[targetText.length() + 1];
        int[] v1 = new int[targetText.length() + 1];
        LevenShiteinDistance levenShiteinDistance = new LevenShiteinDistance();
        int distance = levenShiteinDistance.editDistance(TEXT, v0, v1, targetText);
        logger.info("TEXT:" + TEXT + "  \ntartgetText:" + targetText + "\nDistance:" + distance);
    }

    /**
     * Calculate edit distance from targetText to known word.
     *
     * @param word known word
     * @param v0   int array of length targetText.length() + 1
     * @param v1   int array of length targetText.length() + 1
     * @return distance
     */
    private int editDistance(String word, int[] v0, int[] v1, String targetText) {
        // initialize v0 (prior row of distances) as edit distance for empty 'word'
        for (int i = 0; i < v0.length; i++)
            v0[i] = i;
        // calculate updated v0 (current row distances) from the previous row v0
        for (int i = 0; i < word.length(); i++) {

            // first element of v1 = delete (i+1) chars from target to match empty 'word'
            v1[0] = i + 1;

            // use formula to fill in the rest of the row
            for (int j = 0; j < targetText.length(); j++) {
                int cost = (word.charAt(i) == targetText.charAt(j)) ? 0 : 1;
                v1[j + 1] = minimum(v1[j] + 1, v0[j + 1] + 1, v0[j] + cost);
            }

            // swap v1 (current row) and v0 (previous row) for next iteration
            int[] hold = v0;
            v0 = v1;
            v1 = hold;
        }

        // return final value representing best edit distance
        return v0[targetText.length()];
    }

    private int minimum(int... values) {
        int minValue = values[0];
        for (int value : values) {
            if (minValue > value) {
                minValue = value;
            }
        }
        return minValue;
    }
}
