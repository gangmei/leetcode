/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.worldconcepts.mavenleetcode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author sydney
 */
public class LargestRectangleAreaTest {

    private int[] testdata1;
    private int[] testdata2;
    private int[] testdata3;
    private int[] testdata4;
    private int[] testdata5;

    public LargestRectangleAreaTest() {
        testdata1 = new int[]{2, 1, 5, 6, 2, 3};

        String[] snumbers = LeetcodeUtilityFunctions.Utilityfunctions.readFromFile(".\\data\\largestrec1.txt");
        testdata2 = new int[snumbers.length];
        for (int i = 0; i < snumbers.length; i++) {
            testdata2[i] = Integer.parseInt(snumbers[i]);
        }

        snumbers = LeetcodeUtilityFunctions.Utilityfunctions.readFromFile(".\\data\\largestrec2.txt");
        testdata3 = new int[snumbers.length];
        for (int i = 0; i < snumbers.length; i++) {
            testdata3[i] = Integer.parseInt(snumbers[i]);
        }

        snumbers = LeetcodeUtilityFunctions.Utilityfunctions.readFromFile(".\\data\\largestrec3.txt");
        testdata4 = new int[snumbers.length];
        for (int i = 0; i < snumbers.length; i++) {
            testdata4[i] = Integer.parseInt(snumbers[i]);
        }

        testdata5 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 2147483647};
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of largestRectangleArea2 method, of class LargestRectangleArea.
     */
    @Test
    public void testLargestRectangleArea2() {
        System.out.println("largestRectangleArea2");
        LargestRectangleArea instance = new LargestRectangleArea();
        assertEquals(10, instance.largestRectangleArea2(testdata1));
        //assertEquals(30000, instance.largestRectangleArea2(testdata2));
        //assertEquals(1234321, instance.largestRectangleArea2(testdata4));

    }

    /**
     * Test of largestRectangleAreaRecursive2 method, of class
     * LargestRectangleArea.
     */
    @Test
    @Ignore
    public void testLargestRectangleAreaRecursive2() {
        System.out.println("largestRectangleAreaRecursive2");
        int[] height = null;
        int startIndex = 0;
        int endIndex = 0;
        LargestRectangleArea instance = new LargestRectangleArea();
        int expResult = 0;
        int result = instance.largestRectangleAreaRecursive2(height, startIndex, endIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of largestRectangleArea1 method, of class LargestRectangleArea.
     */
    @Test
    public void testLargestRectangleArea1() {
        System.out.println("largestRectangleArea1");
        LargestRectangleArea instance = new LargestRectangleArea();
        //assertEquals(10, instance.largestRectangleArea1(testdata1));
        //assertEquals(30000, instance.largestRectangleArea1(testdata2));
        //assertEquals(1234321, instance.largestRectangleArea1(testdata4));
        assertEquals(2147483647, instance.largestRectangleArea1(testdata5));
    }

}
