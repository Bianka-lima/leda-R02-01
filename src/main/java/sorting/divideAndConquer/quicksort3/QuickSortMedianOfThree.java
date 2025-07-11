package sorting.divideAndConquer.quicksort3;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int indexPivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, indexPivot-1);
			sort(array, indexPivot + 1, rightIndex);
		}
	}

	public int partition(T[] array, int leftIndex, int rightIndex) {
		

		int indPivot = 0;
		T left = array[leftIndex];
		T right = array[rightIndex];
		T meio = array[(leftIndex+rightIndex)/2];

		if ((left.compareTo(meio) <= 0 && meio.compareTo(right) <= 0) || (right.compareTo(meio) <= 0 && meio.compareTo(left) <= 0)) {
			indPivot = (leftIndex + rightIndex) / 2;
		} else if ((meio.compareTo(left) <= 0 && left.compareTo(right) <= 0) || (right.compareTo(left) <= 0 && left.compareTo(meio) <= 0)) {
			indPivot = leftIndex;
		} else {
			indPivot = rightIndex;
		}
		
		Util.swap(array, indPivot, rightIndex);
		
		int i = leftIndex - 1;

		for (int j= leftIndex; j < rightIndex; j++) {
			if (array[j].compareTo(array[rightIndex]) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, rightIndex, i + 1);
		return i+1;
	}
}
