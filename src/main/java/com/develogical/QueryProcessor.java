package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("SPA2012")) {
            return "SPA is a conference";
        } else if (query.contains("Eendje")) {
        	return "Fantastische workshops!";
        } else if (query.contains("Lunch")) {
        	return "Absolutely, any minute now!";
        }
        return "Sorry, no clue";
    }
}
