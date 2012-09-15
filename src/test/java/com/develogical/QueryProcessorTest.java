package com.develogical;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.StringContains.containsString;
import junit.framework.TestSuite;

import org.junit.Test;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void unkownQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is("Sorry, no clue"));
    }

    @Test
    public void knowsAboutSpa() throws Exception {
        assertThat(queryProcessor.process("SPA2012"), containsString("conference"));
    }
    
    @Test
	public void knowsAboutCDWorkshop() throws Exception {
        assertThat(queryProcessor.process("Eendje"), containsString("Fantastische workshops!"));
	}

    @Test
	public void knowsAboutMyDesires() throws Exception {
        assertThat(queryProcessor.process("Lunch!"), containsString("Didn't you have enough?"));
	}
    
    @Test
	public void addNumbers() throws Exception {
        assertThat(queryProcessor.process("what is 17 plus 7"), is("24"));
	}
    
}
