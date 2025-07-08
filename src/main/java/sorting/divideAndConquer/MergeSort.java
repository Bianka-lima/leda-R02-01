package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && array.length > 1 && leftIndex != rightIndex) {
			int meio = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			mergeSort(array, leftIndex, rightIndex);
			
		}
	}

	public void mergeSort(T[] array, int leftIndex, int rightIndex) {
		int rightApontador = rightIndex - leftIndex;
		
		//T[] auxiliar = Arrays.copyOfRange(array, leftIndex, rightIndex);
		T[] auxiliar = Arrays.copyOf(array, rightApontador + 1);

		for (int i = 0; i <= rightApontador; i++) {
			auxiliar[i] = array[leftIndex+i];
		}

		int meio = rightApontador/2;
		int i = 0;
		int j = meio + 1;
		int k = leftIndex;

		while (i <= meio && j <= rightApontador) {
			if (auxiliar[i].compareTo(auxiliar[j]) <= 0) {
				array[k] = auxiliar[i];
				i++;
			} else {
				array[k] = auxiliar[j];
				j++;
			}
			k++;
		}
		while (i <= meio) {
			array[k] = auxiliar[i];
			i++;
			k++;
		}
	}

}
