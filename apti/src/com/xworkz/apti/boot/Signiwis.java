package com.xworkz.apti.boot;

public class Signiwis {

	public static void main(String[] args) {

		int n = 5;

//		for (int i = 1; i <= n; i++) {
//			for (int j = n - i; j >= 1; j--) {
//				System.out.print(" ");
//			}
//			for (int k = 1; k <= i; k++) {
//				System.out.print("* ");
//			}
//			System.out.println(" ");
//
//		}
//
		for (int i = n; i >= 0; i--) {
			for (int j = n; j >= i; j--) {
				System.out.print(" ");

			}
			for (int k = 0; k < i; k++) {
				System.out.print("* ");
			}
			System.out.println("");
	}
		
		
		String name="Signiwis technology" ,ns="";
		int count=0;
		for(int i=0;i<name.toCharArray().length;i++){

			char ch=name.charAt(i);
			if(ch!=' ')
			{
				ns+=ch;
			}
			else {
				count++;
			}
		}
		
		System.out.println(ns);

		System.out.println(count);

	}

}