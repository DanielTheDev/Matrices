package com.danielthedev.matrices;

import java.util.Arrays;

public class Matrix {

	private final int rows;
	private final int columns;
	private final double[][] matrix;
	
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.matrix = new double[rows][columns];
	}
	
	public Matrix(double[][] matrix) {
		int[] dimensions = getDimensions(matrix);
		
		this.rows = dimensions[0];
		this.columns = dimensions[1];
		this.matrix = matrix;
	}
	
	public void setMatrix(double[][] matrix) {
		int[] dimensions = getDimensions(matrix);
		if(dimensions[0] != this.rows || dimensions[1] != this.columns) throw new UnsupportedOperationException("Matrix must have the same dimensions");
		for(int row = 0; row < this.rows; row++) {
			for(int column = 0; column < this.columns; column++) {
				this.matrix[row][column] = matrix[row][column];
			}
		}
	}
	
	public double[][] getMatrixs() {
		return this.matrix;
	}
	
	public Matrix multiply(Matrix b) {
		//columns a = rows b (if and only if)
		if(this.columns != b.rows) throw new UnsupportedOperationException("Matrix A's columns must be equal to Matrix B's rows");
		
		Matrix matrix = new Matrix(this.rows, b.columns);
		
		
		for(int i = 0; i < matrix.rows; i++) {
			for(int j = 0; j < matrix.columns; j++) {
				for(int k = 0; k < this.columns; k++) {
					matrix.matrix[i][j] += this.matrix[i][k] * b.matrix[k][j];
				}
			}
		}
		return matrix;
	}
	
	public Matrix multiply(double multiplier) {
		for(int row = 0; row < rows; row++) {
			for(int column = 0; column < columns; column++) {
				matrix[row][column] *= multiplier;
			}
		}
		return this;
	}
	
	public Matrix add(Matrix m) {
		if(m.columns != this.columns || m.rows != this.rows) throw new UnsupportedOperationException("Matrices do not match in size");
		for(int row = 0; row < rows; row++) {
			for(int column = 0; column < columns; column++) {
				this.matrix[row][column] += m.matrix[row][column];
			}
		}
		return this;
	}
	
	public Matrix substract(Matrix m) {
		return this.add(m.multiply(-1));
	}
	
	public static int[] getDimensions(double[][] matrix) {
		if(matrix == null) throw new NullPointerException("Matrix must not be null");
		int[] dimensions = new int[2];
		dimensions[0] = matrix.length;
		if(matrix.length == 0) throw new UnsupportedOperationException("Matrix must have at least one row");
		
		double[] row;
		for(int x = 0; x < matrix.length; x++) {
			row = matrix[x];
			if(row == null) throw new NullPointerException("row must not be null");
			else if(row.length == 0) throw new UnsupportedOperationException("Matrix row must have at least one column");
			if(x == 0) {
				dimensions[1] = row.length;
			} else if(dimensions[1] != row.length) {
				throw new UnsupportedOperationException("Matrix columns dimensions are not equal");
			}
		}
		return dimensions;
	}
	
	public static Matrix matrix(double[]... rows) {
		return new Matrix(rows);
	}
	
	public static double[] row(double... columns) {
		return columns;
	}
	
	@Override
	public String toString() {	
		StringBuilder builder = new StringBuilder();
		int[] maxColumnSize = new int[columns];
		
		for(int column = 0; column < columns; column++) {
			for(int row = 0; row < rows; row++) {
				
				String item = Double.toString(this.matrix[row][column]);
				if(item.length() > 7) {
					item = item.substring(0, 7);
				} else if(item.endsWith(".0")) {
					item = item.substring(0, item.length()-2);
				}
				
				
				if(maxColumnSize[column] <  item.length()) {
					maxColumnSize[column] = item.length();
				}
			}
		}
		for(int row = 0; row < rows; row++) {
			
			double[] matrixRow = matrix[row];
			
			builder.append("| ");
			
			for(int column = 0; column < matrixRow.length; column++) {
				String item = Double.toString(matrixRow[column]);
				if(item.length() > 7) {
					item = item.substring(0, 7);
				} else if(item.endsWith(".0")) {
					item = item.substring(0, item.length()-2);
				}
			
				int columnLenght = maxColumnSize[column];
				builder.append(item).append(Matrix.getChars(' ', columnLenght-item.length()));
				if(column + 1 < matrixRow.length) builder.append("  ");
			}
			builder.append(" |").append("\r\n");
		}
		return builder.toString();
	}
	
	private static String getChars(char character, int amount) {
		String str = "";
		for(int t = 0; t < amount; t++) {
			str+=character;
		}
		return str;
	}
	
}
