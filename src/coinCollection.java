/**
 * Title: coinCollection.java
 * Abstract: Reads a text file from input and returns the most number of collected coins.
 * Author: Arash Aria
 * ID: 4210
 * Date: 11/20/15
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class coinCollection {
	
	public static int coinCollector(int[][] inputMatrix, int row, int column){
		
		int[][] coinMatrix = new int[row][column];
		coinMatrix[0][0] = inputMatrix[0][0];
		for (int j = 1; j < column; j++) {
			coinMatrix[0][j] = coinMatrix[0][j-1] + inputMatrix[0][j];	
		}
		for (int i = 1; i < row; i++) {
			coinMatrix[i][0] = coinMatrix[i-1][0] + inputMatrix[i][0];
			for (int j = 1; j < column; j++) {
				coinMatrix[i][j] = Math.max(coinMatrix[i-1][j], coinMatrix[i][j-1]) + inputMatrix[i][j];
			}
		}
		
		return coinMatrix[row-1][column-1];
	}

	public static void main(String[] args) throws IOException {
			
			BufferedReader inputReader =  new BufferedReader(new FileReader("textTest.txt")); //address of the text file
			
			String prop = inputReader.readLine();
			int size[] = new int[2];
			
			for (int i = 0, k = 0; i < prop.length(); i++) 
			{
				if (Character.isDigit(prop.charAt(i)))
				{
					size[k] = Integer.parseUnsignedInt(Character.toString(prop.charAt(i)));
					k++;
				}
			}		

			String input = null;
			
			int[][] inputMatrix = new int[size[0]][size[1]];
			
			for (int i = 0; i < size[0]; i++)
			{
				input = inputReader.readLine();
	
				for (int j = 0, k = 0; k < input.length(); k++) 
				{
					if (Character.isDigit(input.charAt(k)))
					{
						inputMatrix[i][j] = Integer.parseUnsignedInt(Character.toString(input.charAt(k))); 
						j++;
					}
				}
			}
			inputReader.close();
			 
			System.out.println("Max coins: "+coinCollector(inputMatrix, size[0], size[1]));
			
	}
}
