package com.demo;

public class TestString {
		static String s1 = "I love you xx";
		static String s2 = "I hate you xx";
		static String s3 = "";
		char[] cs1 = {'I','l','o','v','e','y','o','u'};
		char[] cs2 = {'l','o','v','e','y','o','u'};
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		TestString ts = new TestString();
		//在字符串中空格同样占字符串的长度
		System.out.println(s1.length());
		/*
		 * 返回一个新的字符串，它是此字符串的一个子字符串。该子字符串从指定索引处的字符开始，直到此字符串末尾。
		示例： 

 		"unhappy".substring(2) returns "happy"
 		"Harbison".substring(3) returns "bison"
 		"emptiness".substring(9) returns "" (an empty string)
 
		参数：
		beginIndex - 起始索引（包括）。 
		返回：
		指定的子字符串。
		 */
		System.out.println(s1.substring(3));
		//返回索引2-6的字符，不包括6   
		System.out.println("返回一个新字符串，它是此字符串的一个子字符串"+s1.substring(2, 6));
		//返回指定的字符在字符串中最后一次出现的索引，没有返回-1
		System.out.println("返回指定的字符在字符串中最后一次出现的索引，没有返回-1"+s1.lastIndexOf("o"));
		
		System.out.println("返回指定索引处的char值"+s1.charAt(0));
		System.out.println("返回指定索引处的字符（Unicode 代码点）"+s1.codePointAt(3));
		System.out.println("返回指定索引处之前的字符（Unicode 代码点）"+s1.codePointBefore(3));
		System.out.println(s1.compareTo(s2));
		s1 = s1.copyValueOf(ts.cs1);
		System.out.println(s1);
		System.out.println(s3.copyValueOf(ts.cs2));
		
		
	}

}
