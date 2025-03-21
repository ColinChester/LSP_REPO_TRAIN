package org.howard.edu.lsp.midterm.question4;

import java.util.*;

public class WordProcessor {
	private String sentence;
	
	public WordProcessor(String sentence) {
		this.sentence = sentence;
	}
	
	public List<String> findLongestWords(){
		List<String> lWords = new ArrayList<>();
		int maxLength = 0;
		
		if (sentence == null || sentence.substring(0).isEmpty()) {
			return lWords;
		}
		
		String[] words = sentence.split("\\s+"); // https://stackoverflow.com/questions/225337/how-to-split-a-string-with-any-whitespace-chars-as-delimiters
		for (String word : words){
			if (word.length() > maxLength) {
				maxLength = word.length();
			}
		}
		
		for (String word : words) {
			if (word.length() == maxLength) {
				lWords.add(word);
			}
		}
		return lWords;
	}
}
