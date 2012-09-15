package com.develogical;

public class QueryProcessor {

    public String process(String query) {
    	System.out.println(query);    	
    	
        if (query.contains("SPA2012")) {
            return "SPA is a conference";
        } else if (query.contains("Eendje")) {
        	return "Fantastische workshops!";
        } else if (query.contains("Lunch")) {
        	return "Didn't you have enough?";
        }
        return "Sorry, no clue";
    }
}
