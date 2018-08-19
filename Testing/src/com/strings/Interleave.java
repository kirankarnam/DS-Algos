package com.strings;

public class Interleave {

	public static void main(String[] args) {
		Interleave il = new Interleave();
		String s1 = "XY";
		String s2 = "WZ";
		String s3 = "WZXY";
		
		System.out.println(il.isInterleave(s1, s2, s3));

	}
	
	public boolean isInterleave(String s1,String s2,String s3) {
		int s1Length = s1.length();
		int s2Length = s2.length();
		
		boolean [][] dp = new boolean[s1Length+1][s2Length+1];
		
		dp[0][0] = true;
		
		for(int i=1;i<dp.length;i++) {
			if(s1.charAt(i-1) == s3.charAt(i-1))
				dp[i][0] = dp[i-1][0];
		}
		
		for(int j=1;j<dp[0].length;j++) {
			if(s2.charAt(j-1) == s3.charAt(j-1))
				dp[0][j] = dp[0][j-1];
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				if(s1.charAt(i-1)==s3.charAt(i+j-1)) {
					dp[i][j] = dp[i-1][j];
				}else if (s2.charAt(j-1) == s3.charAt(i+j-1)) {
					dp[i][j] = dp[i][j-1];
				}else
					dp[i][j] = false;
					
			}
		}
		
		return dp[s1Length][s2Length];
	}
	
}
