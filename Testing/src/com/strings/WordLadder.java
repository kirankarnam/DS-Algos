package com.strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int ladderLength(String beginWord, String endWord, List<String> wordDict) {
		 Set<String> reached = new HashSet<>();
		 reached.add(beginWord);
		 
		 int distance = 1;
		 while(!reached.contains(endWord)) {
			 Set<String> toAdd = new HashSet<>();
			 
			 for(String each: reached) {
				 for(int i=0;i<each.length();i++) {
					 char[] chars = each.toCharArray();
					 
					 for(char ch='a';ch<='z';ch++) {
						 chars[i] = ch;
						 String word = new String(chars);
						 if(wordDict.contains(word)) {
							 reached.add(word);
							 wordDict.remove(word);
						 }
					 }
				 }
			 }
			 
			 distance++;
			 if(toAdd.size()==0) return 0;
			 reached = toAdd;
		 }
		 return distance;
		 
		 
	 }
}
