/*
 * JavaMatriceInverse2.java
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

package fr.insa.drevet.projet.interfacejavafx;

//Matrice de dimension 2
import java.util.Scanner;
 
public class JavaMatriceInverse2 {
	public static void main(String args[]) {
		int i, j;
		float det, temp;
		float mat[][] = new float[2][2];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrer les elements de la matrice ligne par ligne:");
		for(i = 0; i < 2; ++i)
			for(j = 0; j < 2; ++j)
				mat[i][j] = sc.nextFloat();
		
		det = (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
		
		System.out.println("\nDeterminant = " + det);
		
		temp = mat[0][0];
		mat[0][0] = mat[1][1];
		mat[1][1] = temp;
		
		mat[0][1] = - mat[0][1];
		mat[1][0] = - mat[1][0];
		
		System.out.println("\nInverse de la matrice est:");
		for(i = 0; i < 2; ++i) {
			for(j = 0; j < 2; ++j)
				System.out.print((mat[i][j]/det) + " ");
			
			System.out.print("\n");
		}
	}
}
