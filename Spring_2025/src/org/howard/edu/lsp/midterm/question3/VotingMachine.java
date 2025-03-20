package org.howard.edu.lsp.midterm.question3;

import java.util.*;
import java.util.Map.Entry;

public class VotingMachine {
	private Map<String, Integer> votes;
	
	
	/**
	 * When a VotingMachine object is initialized, votes becomes a map with keys corresponding to the candidates passed and values initialized at 0
	 * 
	 * @param candidates is a list of the names of the candidates running
	 */
	public VotingMachine(List<String> candidates) {
		votes = new HashMap<>();
		for (String candidate : candidates) {
			votes.put(candidate, 0);
		}
	}
	
	public boolean castVote(String cName) {
		if (votes.containsKey(cName)) {
			votes.put(cName, votes.get(cName) + 1);
			return true;
		}
		return false;
	}
	
	public String getWinner() { // https://stackoverflow.com/questions/46898/how-do-i-efficiently-iterate-over-each-entry-in-a-java-map
		String winner = "";
		int maxVotes = Integer.MIN_VALUE;
		for (Entry<String, Integer> candidate : votes.entrySet()) {
			if (candidate.getValue() > maxVotes) {
                maxVotes = candidate.getValue();
                winner = candidate.getKey();
            }
		}
		return winner;
	}
}
