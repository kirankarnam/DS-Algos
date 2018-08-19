package com.dynamicprog;

public class LongestSubsequence {

	public static void main(String[] args) {
			LongestSubsequence lcs = new LongestSubsequence();
		    String s1 = "AGGTAB";
		    String s2 = "GXTXAYB";
		    System.out.println("Length of LCS is" + " " +
                    lcs.LCS( s1, s2) );

	}
	
	public int LCS(String m,String  n) {
		if(m ==null || n==null) return 0;
		
		int mLength = m.length();
		int nLength = n.length();
		
		int[][] result = new int[mLength+1][nLength+1];
		
		for(int i=0;i<=mLength;i++) {
			for(int j=0;j<=nLength;j++) {
				if(i==0 || j==0)
					result[i][j]=0;
				
				else if(m.charAt(i-1) ==n.charAt(j-1)) {
					result[i][j] = result[i-1][j-1]+1;
				}else
					result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
			}
		}
		return result[mLength][nLength];
	}

}
