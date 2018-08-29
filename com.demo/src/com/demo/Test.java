package com.demo;

import java.util.HashMap;

public class Test {
	int i = 1;
	int j= 1;
	int k = 0;
	
	String s1 = "lll";
	String s2 = "lll";
	String s3 = "qqq";
	

		public static void main(String[] args) {
        	 Test t1 = new Test();
        	 Test t2 = new Test();
			System.out.println(t1.i==t1.j);
			System.out.println(t1.i==t1.k);
			/*
			 * Multiple markers at this line
			- Cannot invoke equals(int) on the primitive 
	 		type int
			 */
			//Cannot invoke equals(int) on the primitive type int
			//不可以用equals()方法比较基本数据类型
			//System.out.println(t1.i.equals(t1.j));
			
			System.out.println(t1.s1==t1.s2);
			System.out.println(t1.s1==t1.s3);
			System.out.println(t1.s1.equals(t1.s3));
			System.out.println(t1==t2);
			StringBuffer sb = new StringBuffer();
			int i=1<<30;
			System.out.println(i);
			
			HashMap hm = new HashMap();
			hm.put(1, 1);
			hm.put(1,2);
			hm.put(1, 3);
			hm.put(2, 2);
			hm.put(null, null);
			hm.put(null, 1);
			hm.put(3, null);
			
			System.out.println(hm.size());
			System.out.println(hm.values());
			System.out.println(hm.get(2));
			
		}
}
