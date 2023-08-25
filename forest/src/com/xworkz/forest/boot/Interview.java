package com.xworkz.forest.boot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

public class Interview {

	public static void main(String[] args) {

//		for (int i = 0; i <= 10; i++) {
//			if (i % 2 == 0) {
//				System.out.println("is even number" + i);
//			} else {
//				System.out.println("is not even number " + i);
//			}
//		}

//		int n = 15, flag = 0;
//		for (int i = 2; i <= n / 2; i++) {
//
//			if (n % i == 0) {
//				flag = 1;
//
//				break;
//			}
//
//		}
//		if (flag == 0) {
//			System.out.println("This is prime number");
//		}
//		else {
//			System.out.println("This is  NOT prime number");
//
//		}

//		int n1 = 0, n2 = 1, n3 = 0;
//		for (int i = 1; i <= 7; i++) {
//			n3 = n1 + n2;
//			System.out.println("fabinaci series is " + n3);
//			n1 = n2;
//			n2 = n3;
//
//		}
//		int fact = 1;
//		for (int i = 1; i <= 5; i++) {
//			fact = fact * i;
//		}
//		System.out.println("factorial number is" + fact);
//
//	}

		String name = "Hareesha", ns = "";
//		for (int i = 0; i < name.toCharArray().length; i++) {
//
//			ns = name.charAt(i) + ns;
//		}
//		
//		for(int i=name.toCharArray().length-1;i>=0;i--)
//		{
//			System.out.println(name.charAt(i));
//			
////			ns+=name.charAt(i);
//			
//		}
//		
		System.out.println(ns);

		int num = 151, org = num, rem = 0, rev = 0;
		while (num > 0) {
			rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;

		}

//		System.out.println("Palindrome is " + num);
		if (org == rev) {
			System.out.println("Given number is palindrome" + rev);
		} else {

			System.out.println("Given number is NOT palindrome" + rev);
		}

		
		
		
		int array[]={1,2,3,4,5,6};
		int sum=0;

		for(int i=0;i<array.length;i++)
		{
		sum=sum+array[i];

		}
		System.out.println("sum of the array is "+sum);
		String nam="Hareesha",blank="";

		for(int i=nam.toCharArray().length-1;i>=0;i--)
		{
		blank=blank+nam.charAt(i);

		}
		System.out.println(blank);
		
		
	}

}
