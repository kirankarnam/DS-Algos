package com.strings;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		Anagrams anagram = new Anagrams();
		System.out.println(anagram.isAnagram("kiraan", "aarnki"));

	}
	
	public boolean isAnagram(String s1, String s2) {
		
		if(s1 ==null || s2 ==null) return false;
		
		int s1Length = s1.length();
		int s2Length = s2.length();
		
		if(s1Length != s2Length) return false;
		
		Map<Character,Integer> charMap = new HashMap<>();
		
		for(int i=0;i<s1Length;i++) {
			if(charMap.containsKey(s1.charAt(i))) {
				int value = charMap.get(s1.charAt(i));
				value = value+1;
				charMap.put(s1.charAt(i), value);
			}else {
				charMap.put(s1.charAt(i), 1);
			}
		}
		
		for(int j=0;j<s2Length;j++) {
			if(charMap.containsKey(s2.charAt(j))) {
				int value = charMap.get(s2.charAt(j));
				value = value-1;
				charMap.put(s2.charAt(j), value);
				
			}else
				return false;
		}
		boolean isAnagram =true;
		for(Map.Entry<Character, Integer> entry:charMap.entrySet()) {
			if(entry.getValue() !=0)
				isAnagram =false;
		}
		
		return isAnagram;
	}

}
