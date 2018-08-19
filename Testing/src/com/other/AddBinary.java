package com.other;

public class AddBinary {

	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("11", "1"));

	}
	
	
	public String addBinary(String s1,String s2) {
		if(s1 == null) return s2;
		if(s2 == null) return s1;
		
		int carry = 0;
		
		int s1Length = s1.length()-1;
		int s2Length = s2.length()-1;
		
		StringBuilder sb  = new StringBuilder();
		while(s1Length >=0 || s2Length >=0) {
			int sum =0;
			
			if(s1Length >=0 && s1.charAt(s1Length)=='1')
				sum++;
			
			if(s2Length >=0 && s2.charAt(s2Length) =='1')
				sum++;
			
			sum += carry;
			
			if(sum >=2) {
				carry =1;
			}else {
				carry =0;
			}
			
			sb.insert(0, (char)((sum%2)+'0'));
			s1Length--;
			s2Length--;
				
		}
		if(carry ==1)
			sb.insert(0, '1');
		
		return sb.toString();
		
	}

}
