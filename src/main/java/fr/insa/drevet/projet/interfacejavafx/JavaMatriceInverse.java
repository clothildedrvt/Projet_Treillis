/*
 * JavaMatrixInverse.java
 * 
 * Copyright 2021 capuc <capuc@DESKTOP-1S8VN9Q>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */


import java.util.Scanner;
//Matrice de dimensions 3
public class JavaMatriceInverse {
	public static void main(String args[]) {
		int i, j;
		float det = 0;
		float mat[][] = new float[3][3];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrer les elements de la matrice ligne par ligne:");
		for(i = 0; i < 3; ++i)
			for(j = 0; j < 3; ++j)
				mat[i][j] = sc.nextFloat();
		//Calcul du determinant
	    for(i = 0; i < 3; i++)
	        det = det + (mat[0][i] * (mat[1][(i+1)%3] * mat[2][(i+2)%3] - mat[1][(i+2)%3] * mat[2][(i+1)%3]));
		
		System.out.println("\nDeterminant = " + det);
		//Pivpt de Gauss	
		System.out.println("\nInverse de la matrice est:");
		for(i = 0; i < 3; ++i) {
			for(j = 0; j < 3; ++j)
				System.out.print((((mat[(j+1)%3][(i+1)%3] * mat[(j+2)%3][(i+2)%3]) - (mat[(j+1)%3][(i+2)%3] * mat[(j+2)%3][(i+1)%3]))/ det) + " ");
			
			System.out.print("\n");
		}
	}
}