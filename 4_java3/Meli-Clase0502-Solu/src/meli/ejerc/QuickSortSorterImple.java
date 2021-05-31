package meli.ejerc;

import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter<T>
{
	@Override
	public void ordenar(T[] arr, Comparator<T> c)
	{
		quicksort(arr,0,arr.length,c);
	}
	
	private void quicksort(T A[], int izq, int der,Comparator<T> c) 
	{
		  T pivote=A[izq]; // tomamos primer elemento como pivote
		  int i=izq;         // i realiza la búsqueda de izquierda a derecha
		  int j=der;         // j realiza la búsqueda de derecha a izquierda
		  T aux;
		 
		  while(i < j){                          // mientras no se crucen las búsquedas                                   
		     while(c.compare(A[i],pivote)<=0 && i < j) i++; // busca elemento mayor que pivote
		     while(c.compare(A[j],pivote)>0) j--;           // busca elemento menor que pivote
		     if (i < j) {                        // si no se han cruzado                      
		         aux= A[i];                      // los intercambia
		         A[i]=A[j];
		         A[j]=aux;
		     }
		   }
		   
		   A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
		   A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha
		   
		   if(izq < j-1)
		      quicksort(A,izq,j-1,c);          // ordenamos subarray izquierdo
		   if(j+1 < der)
		      quicksort(A,j+1,der,c);          // ordenamos subarray derecho
		   
		}		

}
