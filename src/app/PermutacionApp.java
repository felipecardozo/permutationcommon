package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import algoritmos.ordenamiento.ISortable;
import algoritmos.ordenamiento.MergeSort;

public class PermutacionApp {
	
	public static final String FILE = "resources/prueba.in";
	
	private ISortable orden;
	
	private List<Character> caracteres;

	public PermutacionApp(){
		Scanner sc = null;
		String linea1 = null;
		String linea2 = null;
		try {
			sc = new Scanner( new File(PermutacionApp.FILE) );
			
			while( sc.hasNextLine() ){
				linea1 = sc.nextLine();
				if( sc.hasNextLine() ){
					linea2 = sc.nextLine();
				}
				char[] arr1 = linea1.toCharArray();
				char[] arr2 = linea2.toCharArray();
				
				this.buscar(arr1, arr2);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void buscar( char[] arr1, char[] arr2 ){
		orden = new MergeSort();
		orden.sort( arr1, 0, arr1.length - 1 );
		orden.sort( arr2, 0, arr2.length - 1);
		
		caracteres = new ArrayList<Character>();
		
		for( int i = 0 ; i < arr1.length ; i++ ){
			loop2:
			for( int j = 0 ; j < arr2.length ; j++ ){
				
				if( arr1[i] == arr2[j] ){
					
					if( !caracteres.contains( new Character(arr1[i]) ) ){
						caracteres.add( new Character(arr1[i]) );
					}
					else{
						break loop2;
					}
					
				}
			}
			
		}
		this.imprimir( caracteres.toArray() );
	}
	
	private void imprimir( Object[] arreglo ){
		for( int i = 0 ; i<arreglo.length ; i++ ){
			System.out.print( arreglo[i] );
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		new PermutacionApp();

	}

}
