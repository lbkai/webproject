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
		//���ַ����пո�ͬ��ռ�ַ����ĳ���
		System.out.println(s1.length());
		/*
		 * ����һ���µ��ַ��������Ǵ��ַ�����һ�����ַ����������ַ�����ָ�����������ַ���ʼ��ֱ�����ַ���ĩβ��
		ʾ���� 

 		"unhappy".substring(2) returns "happy"
 		"Harbison".substring(3) returns "bison"
 		"emptiness".substring(9) returns "" (an empty string)
 
		������
		beginIndex - ��ʼ�������������� 
		���أ�
		ָ�������ַ�����
		 */
		System.out.println(s1.substring(3));
		//��������2-6���ַ���������6   
		System.out.println("����һ�����ַ��������Ǵ��ַ�����һ�����ַ���"+s1.substring(2, 6));
		//����ָ�����ַ����ַ��������һ�γ��ֵ�������û�з���-1
		System.out.println("����ָ�����ַ����ַ��������һ�γ��ֵ�������û�з���-1"+s1.lastIndexOf("o"));
		
		System.out.println("����ָ����������charֵ"+s1.charAt(0));
		System.out.println("����ָ�����������ַ���Unicode ����㣩"+s1.codePointAt(3));
		System.out.println("����ָ��������֮ǰ���ַ���Unicode ����㣩"+s1.codePointBefore(3));
		System.out.println(s1.compareTo(s2));
		s1 = s1.copyValueOf(ts.cs1);
		System.out.println(s1);
		System.out.println(s3.copyValueOf(ts.cs2));
		
		
	}

}
