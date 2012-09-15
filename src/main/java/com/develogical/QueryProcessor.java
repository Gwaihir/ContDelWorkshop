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
        } else if (query.contains("plus")) {
        	return addUp(query);
        }
        return "Sorry, no clue";
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
