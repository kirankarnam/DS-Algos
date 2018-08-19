package com.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Permutations {

	public static void main(String[] args) {
		Permutations sp = new Permutations();
        sp.permute("AABC".toCharArray()).forEach(s -> System.out.println(s));

	}
	
	public List<String> permute(char[] input){
		
		if(input == null) return null;
		
		//compute a map of character occurances
		Map<Character,Integer> countMap = new  TreeMap<>();
		for (char ch : input) {
			countMap.compute(ch, (key,val) ->{
				if(val ==null)
					return 1;
				else {
					return val+1;
				}
			});
			
			
		}
		
		char str[] = new char[countMap.size()];
		int count[] = new int[countMap.size()];
		
		int index = 0;
		//copy keys into str array and values in count array
		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		
		List<String> resultList = new ArrayList<String>();
		
		char[] result = new char[input.length];
		
		
		permuteUtil(str,count,result,0,resultList);
		return resultList;
		
	}

	private void permuteUtil(char[] str, int[] count, char[] result, int level, List<String> resultList) {
		
		if(level==result.length) {
			resultList.add(new String(result));
			return;
		}
		int length = str.length;
		for(int i=0;i<length;i++) {
			if(count[i] ==0) {
				continue;
			}
			
			result[level] = str[i];
			count[i]--;
			permuteUtil(str, count, result, level+1, resultList);
			count[i]++;
			//i++;
		}
		
	}

}
