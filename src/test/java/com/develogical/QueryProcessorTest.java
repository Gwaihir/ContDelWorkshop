package com.develogical;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.StringContains.containsString;

import org.junit.Test;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void unkownQuery() throws Exception {
        assertThat(queryProcessor.process("31fb0: test"), is(""));
    }

    @Test
    public void knowsAboutSpa() throws Exception {
        assertThat(queryProcessor.process("31fb0: SPA2012"), containsString("conference"));
    }
    
    @Test
	public void knowsAboutCDWorkshop() throws Exception {
        assertThat(queryProcessor.process("31fb0: Eendje"), containsString("Fantastische workshops!"));
	}

    @Test
	public void addNumbers() throws Exception {
        assertThat(queryProcessor.process("31fb0: what is 17 plus 7"), is("24"));
	}

    @Test
	public void substract() throws Exception {
        assertThat(queryProcessor.process("31fb0: what is 17 minus 7"), is("10"));
	}

    @Test
	public void whichIsLargest() throws Exception {
        assertThat(queryProcessor.process("31fb0: which of the following numbers is the largest: 988, 22"), is("988"));
	}
    
    @Test
	public void whichIsLargestAmongMany() throws Exception {
        assertThat(queryProcessor.process("31fb0: which of the following numbers is the largest: 100, 26, 988, 22"), is("988"));
	}
    
    @Test
	public void multiply() throws Exception {
        assertThat(queryProcessor.process("31fb0: what is 9 multiplied by 0"), is("0"));
	}

    @Test
	public void squareAndCube() throws Exception {
        assertThat(queryProcessor.process("31fb0: which of the following numbers is both a square and a cube: 1, 244"),
        		is("1"));
	}
    @Test
	public void squareAndCube2() throws Exception {
        assertThat(queryProcessor.process("31fb0: which of the following numbers is both a square and a cube: 316, 144"),
        		is(""));
	}
 
    @Test
	public void fibonacci() throws Exception {
        assertThat(queryProcessor.process("31fb0: what is the 5th number in the Fibonacci sequence"),
        		is("5"));
	}
}
