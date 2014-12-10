/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.worldconcepts.mavenleetcode;

import com.worldconcepts.codestudy.SegmentTree;
import java.util.Stack;

/**
 *
 * @author sydney
 */
public class LargestRectangleArea {

    private SegmentTree st;

    public int largestRectangleArea2(int[] height) {
        st = new SegmentTree(height);
        //st.constructMinIndexSegTree(height);

        return largestRectangleAreaRecursive2(height, 0, height.length - 1);
    }

    public int largestRectangleAreaRecursive2(int[] height, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            return height[startIndex];
        }
        if (endIndex == startIndex + 1) {
            return Math.max(Math.min(height[endIndex], height[startIndex]) * 2, Math.max(height[endIndex], height[startIndex]));
        }

        int minIndex = st.rangeMinIndex(startIndex, endIndex);
        int minValue = height[minIndex];

        int maxarea = (endIndex - startIndex + 1) * minValue;
        int arealeft = largestRectangleAreaRecursive2(height, startIndex, minIndex - 1);
        int arearight = largestRectangleAreaRecursive2(height, minIndex + 1, endIndex);
        maxarea = Math.max(arealeft, maxarea);
        maxarea = Math.max(arearight, maxarea);

        return maxarea;
    }

    public int largestRectangleArea1(int[] height) {
        if (height.length < 1) {
            return 0;
        }
        if (height.length < 2) {
            return height[0];
        }
        Stack<Integer> s1 = new Stack<>();
        s1.push(0);
        int maxarea = height[0];
        int currenttop;
        for (int i = 1; i < height.length; i++) {
            currenttop = s1.peek();
          
            if (height[i] < height[currenttop]) {
                do {
                    int minindex = s1.pop();
                    if (s1.size() > 0) {
                        currenttop = s1.peek();
                    } else {
                        currenttop = -1;
                    }
                    if (height[minindex] * (i - currenttop - 1) > maxarea) {
                        maxarea = height[minindex] * (i - currenttop - 1);
                    }
                } while (s1.size() > 0 && height[currenttop] > height[i]);
            }
            s1.push(i);
        }
        while (s1.size() > 0) {
            int minindex = s1.pop();
            if (s1.size() > 0) {
                currenttop = s1.peek();
            } else {
                currenttop = -1;
            }
            if (height[minindex] * (height.length - 1 - currenttop) > maxarea) {
                maxarea = height[minindex] * (height.length - 1 - currenttop);
            }
        }
        return maxarea;
    }

}
