package com.danielthedev.matrices;

public abstract class Matrix {

	public static class Integer extends Matrix {

		private final int rows;
		private final int columns;
		private final float[][] matrix;
		
		public Integer(int rows, int columns) {
			this.rows = rows;
			this.columns = columns;
			this.matrix = new float[rows][columns];
		}
		
		public float[][] getMatrixs() {
			return this.matrix;
		}
		
		public Matrix multiply(float multiplier) {
			for(int row = 0; row < rows; row++) {
				for(int column = 0; column < columns; column++) {
					matrix[row][column] = matrix[row][column] * multiplier;
				}
			}
			return this;
		}
		
		@Override
		public String toString() {
			String[][] matrix = new String[rows][columns];
			
			for(int column = 0; column < columns; column++) {
				for(int row = 0; row < rows; row++) {
					
					String item = Float.toString(this.matrix[row][column]);
					if(item.length() > 7) {
						item = item.substring(0, 7);
					}
					if(item.endsWith(".0")) {
						item = item.substring(0, item.length()-2);
					}
					matrix[row][column] = item;
				}
			}
			
			return super.toString(matrix, rows, columns);
		}

	}
	
	public String toString(String[][] matrix, int rows, int columns) {
		StringBuilder builder = new StringBuilder();
		int[] maxColumnSize = new int[columns];
		
		for(int column = 0; column < columns; column++) {
			for(int row = 0; row < rows; row++) {
				if(maxColumnSize[column] <  matrix[row][column].length()) {
					maxColumnSize[column] = matrix[row][column].length();
				}
			}
		}
		for(int row = 0; row < rows; row++) {
			String[] matrixRow = matrix[row];
			
			builder.append("|");
			
			for(int column = 0; column < matrixRow.length; column++) {
				String item = matrixRow[column];
				int columnLenght = maxColumnSize[column];
				builder.append(item).append(getChars(' ', columnLenght-item.length()));
				if(column + 1 < matrixRow.length) builder.append("  ");
			}
			builder.append("|").append("\r\n");
		}
		return builder.toString();
	}
	
	private String getChars(char character, int amount) {
		String str = "";
		for(int t = 0; t < amount; t++) {
			str+=character;
		}
		return str;
	}
	
}
