package com.javaapp.demo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Unit test for JavaApp.
 */
public class JavaAppTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAppConstructor() {
        try {
            new JavaApp();
        } catch (Exception e) {
            fail("Construction failed.");
        }
    }

    @Test
    public void testAppMain()
    {
        JavaApp.main(null);
        try {
            assertEquals("Pipeline SUCCESS – Java project is ready" + System.getProperty("line.separator"), outContent.toString());
        } catch (AssertionError e) {
            fail("\"message\" is not \"Pipeline SUCCESS – Java project is ready\"");
        }
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
