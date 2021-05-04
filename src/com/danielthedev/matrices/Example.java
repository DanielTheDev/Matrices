package com.danielthedev.matrices;

public class Example {

//	public static void main(String[] args) {
//		
//		double a = 1;
//		double b = 2;
//		double c = 3;
//		double d = 4;
//		double e = 5;
//		double f = 6;
//		double g = 7;
//		double h = 8;
//		double i = 9;
//		
//		Matrix matrix = Matrix.matrix(
//				Matrix.row(a, b, c),
//				Matrix.row(d, e, f),
//				Matrix.row(g, h, i)
//		);
//		
//		Matrix inverse = Matrix.matrix(
//				Matrix.row(a, b, -c),
//				Matrix.row(d, -e, f),
//				Matrix.row(-g, h, i)
//		).multiply(1/(c*e*g - a*e*i));
//		
//		
//		System.out.println(matrix);
//		System.out.println(inverse);
//		System.out.println(matrix.multiply(inverse));
//	} 
	
	public static void main(String[] args) {
			

			StringMatrix rotationX = StringMatrix.matrix(
					StringMatrix.row("1", "0", "0"),
					StringMatrix.row("0", "cos(γ)", "-sin(γ)"),
					StringMatrix.row("0", "sin(γ)", "-cos(γ)")
			);

			StringMatrix rotationY = StringMatrix.matrix(
					StringMatrix.row("cos(β)", "0", "sin(β)"),
					StringMatrix.row("0", "1", "0"),
					StringMatrix.row("-sin(β)", "0", "cos(β)")
			);
			StringMatrix rotationZ = StringMatrix.matrix(
					StringMatrix.row("cos(α)", "-sin(α)", "0"),
					StringMatrix.row("sin(α)", "cos(α)", "0"),
					StringMatrix.row("0", "0", "1")
			);
			
			System.out.println(rotationZ.multiply(rotationY).multiply(rotationX));
		} 
	
}
