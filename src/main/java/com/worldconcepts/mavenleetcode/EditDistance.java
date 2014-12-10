/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.worldconcepts.mavenleetcode;

import java.util.ArrayList;

/**
 *
 * @author sydney
 */
public class EditDistance {

    public int minDistance1(String word1, String word2) {
        word1 = word1.trim();
        word2 = word2.trim();
        int l1 = word1.length();
        int l2 = word2.length();

        ArrayList<Integer> si = sharedCharsIndexes2(word1, word2);
        if (si.isEmpty()) {
            return Math.max(l1, l2);
        }
        int[] distances = new int[si.size() / 2 + 1];
        for (int i = 0; i < si.size() / 2; i++) {
            distances[i] = Math.max(si.get(2 * i), si.get(2 * i + 1));
        }
        distances[si.size() / 2] = Math.max(l2, l1);

        for (int i = 0; i < si.size() / 2; i++) {
            for (int j = i + 1; j < si.size() / 2; j++) {
                if (si.get(2 * j) > si.get(2 * i)) {
                    int tempdis = distances[i] + Math.max(si.get(2 * j) - si.get(2 * i) - 1, si.get(2 * j + 1) - si.get(2 * i + 1) - 1);
                    distances[j] = Math.min(distances[j], tempdis);
                }
            }
            int tempdis = distances[i] + Math.max(l1 - si.get(2 * i) - 1, l2 - si.get(2 * i + 1) - 1);
            distances[si.size() / 2] = Math.min(distances[si.size() / 2], tempdis);
        }
        return distances[si.size() / 2];
    }

    private ArrayList<Integer> sharedCharsIndexes(String word1, String word2) {
        ArrayList<Integer> out1 = new ArrayList<>();
        ArrayList<Integer> out2 = new ArrayList<>();
        ArrayList<Character> wa2 = new ArrayList<>();

        for (int i = 0; i < word2.length(); i++) {
            wa2.add(word2.charAt(i));
        }
        for (int i = 0; i < word1.length(); i++) {
            if (wa2.contains(word1.charAt(i))) {
                out1.add(i);
                int j = wa2.indexOf(word1.charAt(i));
                out1.add(j);
                wa2.remove((Character) word1.charAt(i));
                wa2.add(j, Character.MIN_VALUE);
            }
        }
        return out1;
    }

    private ArrayList<Integer> sharedCharsIndexes2(String word1, String word2) {
        //ArrayList<Integer> out1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> currentPaths = new ArrayList<>();

        ArrayList<Character> wa2 = new ArrayList<>();
        for (int i = 0; i < word2.length(); i++) {
            wa2.add(word2.charAt(i));
        }
        for (int i = 0; i < word1.length(); i++) {
            if (wa2.contains(word1.charAt(i))) { // find a new pair
                int w2index = wa2.indexOf(word1.charAt(i));

                ProcessPaths(currentPaths, i, w2index);
                wa2.remove((Character) word1.charAt(i));
                wa2.add(w2index, Character.MIN_VALUE);
            }
        }

        return LongestPaths(currentPaths);
    }

    private void ProcessPaths(ArrayList<ArrayList<Integer>> currentPaths,
            int w1Index, int w2Index) {
        if (currentPaths.isEmpty()) {
            ArrayList<Integer> newPath = new ArrayList<Integer>();
            newPath.add(w1Index);
            newPath.add(w2Index);
            currentPaths.add(newPath);
        } else {
            int maxPathLength = 2;
            int pairused = 0;
            for (int pathindex = currentPaths.size() - 1; pathindex > -1; pathindex--) {
                ArrayList<Integer> temppath = currentPaths.get(pathindex);
                if (w2Index > temppath.get(temppath.size() - 1)) {
                    pairused = 1;
                    temppath.add(w1Index);
                    temppath.add(w2Index);
                    if (temppath.size() > maxPathLength) {
                        maxPathLength = temppath.size();
                    } else {
                        currentPaths.remove(pathindex);
                    }
                }
            }
            if (pairused == 0) {
                ArrayList<Integer> newPath = new ArrayList<Integer>();
                newPath.add(w1Index);
                newPath.add(w2Index);
                currentPaths.add(newPath);
            }
        }
    }

    private ArrayList<Integer> LongestPaths(ArrayList<ArrayList<Integer>> currentPaths) {
        ArrayList<Integer> out1 = new ArrayList<>();
        if (!currentPaths.isEmpty()) {
            out1 = currentPaths.get(0);
            for (int i = 1; i < currentPaths.size(); i++) {
                ArrayList<Integer> out2 = currentPaths.get(i);
                if (out2.size() > out1.size()) {
                    out1 = out2;
                }
            }
        }
        return out1;
    }

    public int minDistance2(String word1, String word2) {
        ArrayList<ArrayList<Integer>> currentPaths = new ArrayList<>();

        ArrayList<Character> wa2 = new ArrayList<>();
        for (int i = 0; i < word2.length(); i++) {
            wa2.add(word2.charAt(i));
        }
        for (int i = 0; i < word1.length(); i++) {
            if (wa2.contains(word1.charAt(i))) { // find a new pair
                int w2index = wa2.indexOf(word1.charAt(i));

                ProcessPaths2(currentPaths, word1, i, word2, w2index);
                wa2.remove((Character) word1.charAt(i));
                wa2.add(w2index, Character.MIN_VALUE);
            }
        }
        int minDistance = Math.max(word1.length(), word2.length());
        for (int i = 0; i < currentPaths.size(); i++) {
            ArrayList<Integer> temppath = currentPaths.get(i);
            if (temppath.get(temppath.size() - 1) < minDistance) {
                minDistance = temppath.get(temppath.size() - 1);
            }
        }
        return minDistance;
    }

    private void ProcessPaths2(ArrayList<ArrayList<Integer>> currentPaths,
            String word1, int w1Index, String word2, int w2Index) {
        int l1 = word1.length();
        int l2 = word2.length();

        if (currentPaths.isEmpty()) {
            ArrayList<Integer> newPath = new ArrayList<Integer>();
            int tempDistance = Math.max(w1Index, w2Index)
                    + Math.max(l1 - w1Index - 1, l2 - w2Index - 1);
            if (tempDistance <= Math.max(l1, l2)) {
                newPath.add(w1Index);
                newPath.add(w2Index);
                newPath.add(tempDistance);
                currentPaths.add(newPath);
            }
        } else {
            int MinDistance = Math.max(l1, l2);
            for (int pathindex = currentPaths.size() - 1; pathindex > -1; pathindex--) {
                ArrayList<Integer> temppath = currentPaths.get(pathindex);
                int currentDistance = temppath.get(temppath.size() - 1);
                int oldW1Index = temppath.get(temppath.size() - 3);
                int oldW2Index = temppath.get(temppath.size() - 2);
                if (w2Index > oldW2Index) {
                    int diffDistance = Math.max(l1 - oldW1Index - 1, l2 - oldW2Index - 1)
                            - Math.max(w1Index - oldW1Index - 1, w2Index - oldW2Index - 1)
                            - Math.max(l1 - w1Index - 1, l2 - w2Index - 1);
                    if (diffDistance > 0) {
                        temppath.remove(temppath.size() - 1);
                        temppath.add(w1Index);
                        temppath.add(w2Index);
                        temppath.add(currentDistance - diffDistance);
                        currentDistance = currentDistance - diffDistance;
                    }
                    if (currentDistance <= MinDistance) {
                        MinDistance = currentDistance;
                    } else {
                        currentPaths.remove(pathindex);
                    }
                }
            }
            if (MinDistance == Math.max(l1, l2)) {
                ArrayList<Integer> newPath = new ArrayList<Integer>();
                int tempDistance = Math.max(w1Index, w2Index)
                        + Math.max(l1 - w1Index - 1, l2 - w2Index - 1);
                if (tempDistance <= Math.max(l1, l2)) {
                    newPath.add(w1Index);
                    newPath.add(w2Index);
                    newPath.add(tempDistance);
                    currentPaths.add(newPath);
                }
            }
        }
    }

    public int minDistance3(String word1, String word2) {
        //word1 = word1.trim();
        //word2 = word2.trim();
        int l1 = word1.length();
        int l2 = word2.length();
        int minDistance = Math.max(l2, l1);

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) { // find a new pair
                    int currentDistance = Math.max(i, j) + minDistance3(word1.substring(i + 1), word2.substring(j + 1));
                    if (currentDistance < minDistance) {
                        minDistance = currentDistance;
                    }
                }
            }
        }
        return minDistance;
    }

    public int minDistance4(String word1, String word2) {

        int l1 = word1.length();
        int l2 = word2.length();
        int minDistance = Math.max(l2, l1);

        ArrayList<DistancePair> allpairs = new ArrayList<>();
        allpairs.add(new DistancePair(word1, word2, 0));
        while (allpairs.size() > 0) {
            DistancePair currentPair = allpairs.remove(allpairs.size() - 1);
            int pairfound = 0;
            for (int i = 0; i < currentPair.word1.length(); i++) {
                for (int j = 0; j < currentPair.word2.length(); j++) {
                    if (currentPair.word1.charAt(i) == currentPair.word2.charAt(j)) { // find a new pair
                        pairfound = 1;
                        allpairs.add(new DistancePair(currentPair.word1.substring(i + 1), currentPair.word2.substring(j + 1), Math.max(i, j) + currentPair.offset));
                    }
                }
            }
            if (pairfound == 0) {
                if (currentPair.offset + Math.max(currentPair.word1.length(), currentPair.word2.length()) < minDistance) {
                    minDistance = currentPair.offset + Math.max(currentPair.word1.length(), currentPair.word2.length());
                }
            }
        }
        return minDistance;
    }

    public class DistancePair {

        public String word1;
        public String word2;
        public int offset;

        public DistancePair(String w1, String w2, int off) {
            word1 = w1;
            word2 = w2;
            offset = off;
        }
    }

}
