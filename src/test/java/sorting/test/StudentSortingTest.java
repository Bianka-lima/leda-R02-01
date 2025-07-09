package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorDesordenado;
	private Integer[] vetorOrdenado;
	private Integer[] vetorUnitario;
	private Integer[] vetorDecrescente;
	private Integer[] vetorNegativos;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorDesordenado(new Integer[] {1, 5, 9, 0});
		populaVetorOrdenado(new Integer[] {1, 2, 3, 18, 19, 21, 22});
		populaVetorUnitario(new Integer[] {1});
		populaVetorDecrescente(new Integer[] {22, 21, 19, 18, 3, 2, 1});
		populaVetorNegativos(new Integer[] {-1, -3, -4, -10, -2});
		
		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new MergeSort<>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorDesordenado(Integer[] arrayPadrao) {
		this.vetorDesordenado = Arrays
			.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorOrdenado(Integer[] arrayPadrao) {
		this.vetorOrdenado = Arrays
			.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorUnitario(Integer[] arrayPadrao) {
		this.vetorUnitario = Arrays
			.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorDecrescente(Integer[] arrayPadrao) {
		this.vetorDecrescente = Arrays
			.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorNegativos(Integer[] arrayPadrao) {
		this.vetorNegativos = Arrays
			.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	@Test
	public void testDesordenado() {
		genericTest(vetorDesordenado);
	}

	@Test
	public void testOrdenado() {
		genericTest(vetorOrdenado);
	}

	@Test
	public void testUnitario() {
		genericTest(vetorUnitario);
	}

	@Test
	public void testDecrescente() {
		genericTest(vetorDecrescente);
	}

	@Test
	public void testNegativos() {
		genericTest(vetorNegativos);
	}
	
	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}