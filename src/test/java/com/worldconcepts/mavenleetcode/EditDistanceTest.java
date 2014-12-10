/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.worldconcepts.mavenleetcode;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 *
 * @author sydney
 */
public class EditDistanceTest {

    public EditDistanceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of minDistance1 method, of class EditDistance.
     */
    @Ignore
    @Test
    public void testMinDistance1() {
        System.out.println("minDistance1");
        EditDistance instance = new EditDistance();
        //assertEquals(6, instance.minDistance1("abcwwmn", "wefw"));
        //assertEquals(2, instance.minDistance1("ab", "bc"));
        //assertEquals(2, instance.minDistance1("sea", "eat"));
        //assertEquals(3, instance.minDistance1("horse", "ros"));
        assertEquals(3, instance.minDistance1("mart", "karma"));
    }

    /**
     * Test of minDistance2 method, of class EditDistance.
     */
    @Ignore
    @Test
    public void testMinDistance2() {
        System.out.println("minDistance2");
        EditDistance instance = new EditDistance();
        assertEquals(6, instance.minDistance2("abcwwmn", "wefw"));
        assertEquals(2, instance.minDistance2("ab", "bc"));
        assertEquals(2, instance.minDistance2("sea", "eat"));
        assertEquals(3, instance.minDistance2("horse", "ros"));
        assertEquals(3, instance.minDistance2("mart", "karma"));
        assertEquals(6, instance.minDistance2("plasma", "altruism"));
    }

    @Ignore
    @Test
    public void testMinDistance3() {
        System.out.println("minDistance3");
        EditDistance instance = new EditDistance();
        assertEquals(6, instance.minDistance3("abcwwmn", "wefw"));
        assertEquals(2, instance.minDistance3("ab", "bc"));
        assertEquals(2, instance.minDistance3("sea", "eat"));
        assertEquals(3, instance.minDistance3("horse", "ros"));
        assertEquals(3, instance.minDistance3("mart", "karma"));
        assertEquals(6, instance.minDistance3("plasma", "altruism"));
        assertEquals(27, instance.minDistance3("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }

    /**
     * Test of minDistance4 method, of class EditDistance.
     */
    //@Ignore
    @Test
    public void testMinDistance4() {
        System.out.println("minDistance4");
        EditDistance instance = new EditDistance();
        /*assertEquals(6, instance.minDistance4("abcwwmn", "wefw"));
         assertEquals(2, instance.minDistance4("ab", "bc"));
         assertEquals(2, instance.minDistance4("sea", "eat"));
         assertEquals(3, instance.minDistance4("horse", "ros"));
         assertEquals(3, instance.minDistance4("mart", "karma"));
         assertEquals(6, instance.minDistance4("plasma", "altruism"));*/
        assertEquals(27, instance.minDistance4("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }

}
