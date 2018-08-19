package com.dynamicprog;



class A{
	int a=5;
	String doA() {return "a1";}
	protected static String doA2() {return "a2";}
}

class B extends A{
	int a=7;
	String doA() {return "b1";}
	protected static String doA2() {return "b2";}
	
	void go() {
		A myA = new B();
		System.out.println(myA.doA() + myA.doA2()+myA.a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new B().go();
	}
	
}
