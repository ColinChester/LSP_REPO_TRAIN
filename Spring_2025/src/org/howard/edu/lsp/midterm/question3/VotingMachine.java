package org.howard.edu.lsp.midterm.question3;

import java.util.*;
import java.util.Map.Entry;

public class VotingMachine {
	private Map<String, Integer> votes;
	

	public VotingMachine() {
		votes = new HashMap<>();
	}
	
	/**
	 * This method adds a candidate to the map
	 * 
	 * @param c is the name of the candidate to be added
	 * @return True if the operation completed, and False if the operation didn't
	 */
	public boolean addCandidate(String c) {
		if (votes.containsKey(c)) {
            return false;
        }
        votes.put(c, 0);
        return true;
	}
	
	/**
	 * This method casts a vote for a candidate in the map
	 * 
	 * @param cName is the name of the candidate being voted for
	 * @return true of the operation completed, and false otherwise
	 */
	public boolean castVote(String cName) {
		if (votes.containsKey(cName)) {
			votes.put(cName, votes.get(cName) + 1);
			return true;
		}
		return false;
	}
	
	/**
	 * This class returns the person with the most votes with the ammount of votes they got
	 * @return String containing the winnner and the points they got
	 */
	public String getWinner() { // https://stackoverflow.com/questions/46898/how-do-i-efficiently-iterate-over-each-entry-in-a-java-map
		String winner = "";
		int maxVotes = Integer.MIN_VALUE;
		for (Entry<String, Integer> candidate : votes.entrySet()) {
			if (candidate.getValue() > maxVotes) {
                maxVotes = candidate.getValue();
                winner = candidate.getKey();
            }
		}
		return "The winner is " + winner + " with " + votes.get(winner) + " points!";
	}
}
