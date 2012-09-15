package com.develogical;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
    	System.out.println("Query: " + query);   
    	String answer = "";
    	
    	query = clean(query);
    	
        if (query.contains("SPA2012")) {
        	answer = "SPA is a conference";
        } else if (query.contains("Eendje")) {
        	answer = "Fantastische workshops!";
        } else if (query.contains("Lunch")) {
        	answer = "Didn't you have enough?";
        } else if (query.contains("plus")) {
        	answer = addUp(query);
        } else if (query.contains("largest")) {
        	answer = findLargest(query);
        } else if (query.contains("multiplied")) {
        	answer = multiply(query);
        } else if (query.contains("cube")) {
        	answer = findSquaresAndCubes(query);
        } else if (query.contains("Fibonacci")) {
        	answer = findFibonacciNumber(query);
        }
        System.out.println("Answer: " + answer);        
        return answer;
    }

	private String clean(String query) {
		return query.substring(query.indexOf(":"));
	}

	private String findFibonacciNumber(String query) {
		Integer number = findNumbers(query).get(0);
		if (number == 1 || number == 2) return "1";

		int twoago = 1;
		int temp = 1;
		int last = 1;
		for (int i = 3; i <= number; i++) {
			temp = last;
			last = last + twoago;
			twoago = temp;
		}
		return Integer.toString(last);
	}

	private String findSquaresAndCubes(String query) {
		List<Integer> numbers = findNumbers(query);
		for (Integer number: numbers) {
			try {
				double sqrt = Math.sqrt(number);
				double cbrt = Math.cbrt(number);
				if (sqrt%1 == 0 && cbrt%1 == 0)
				return Integer.toString(number);
			} catch (Exception e) {}
		}
		return "";
	}

	private String multiply(String query) {
		List<Integer> numbers = findNumbers(query);
		Integer response = 1;
		for (Integer number: numbers) {
			response = response * number;
		}
		return Integer.toString(response);
	}

	private String findLargest(String query) {
		List<Integer> numbers = findNumbers(query);
		Integer response = 0;
		for (Integer number: numbers) {
			if (number > response) response = number;
		}
		return Integer.toString(response);
	}

	private List<Integer> findNumbers(String query) {
		List<Integer> numbers = new ArrayList<Integer>();

		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(query); 
		while (m.find()) {
		   numbers.add(Integer.parseInt(m.group()));
		}
		return numbers;
	}

	private String addUp(String query) {
		String[] pieces = query.split(" ");
		int total = 0;
		for (String string : pieces) {
			try {
				total += Integer.parseInt(string);
			} catch (Exception e) {}
		}
		return Integer.toString(total);
	}
}
