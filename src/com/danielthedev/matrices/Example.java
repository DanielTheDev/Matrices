package com.danielthedev.matrices;

public class Example {

	public static void main(String[] args) {
		Matrix.Integer matrix = new Matrix.Integer(3, 3);
		int c = 0;
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				matrix.getMatrixs()[x][y] = c++;
			}
		}
		matrix.multiply(12f);
		System.out.println(matrix.toString());

	} 
	
}
