package com.danielthedev.matrices;

public class Example {

	public static void main(String[] args) {
		Matrix A = new Matrix(8, 1);

		Matrix B = new Matrix(1, 5);
		
		System.out.println(A.multiply(B));

	} 
	
}
