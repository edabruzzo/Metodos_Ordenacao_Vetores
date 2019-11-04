package ordena;

/**
 * Os métodos abstratos NÃO podem ser alterados
 *
 * @author Gerson
 */
public abstract class Sort {

    /**
     * Ordena um array pelo método bolha.
     *
     * @param vetor array de inteiros
     */
    public abstract void bubbleSort(int[] vetor);

    /**
     * Ordena um array pelo método da inserção.
     *
     * @param vetor array de inteiros
     */
    public abstract void insertionSort(int[] vetor);

    /**
     * Ordena um array pelo método da seleção.
     *
     * @param vetor array de inteiros
     */
    public abstract void selectionSort(int[] vetor);

    /**
     * Salva, em arquivo, as informações referentes 
     * ao tamanho do conjunto de dados e o tempo 
     * gasto para ordenar. 
     * @param tamanho Tamanho do array.
     * @param tempo Tempo decorrido (em nanossegundos).
     * @param metodo Método de ordenação utilizado.
     * 1 - BubbleSort
     * 2 - SelectionSort
     * 3 - InsertionSort
     */
    public abstract void file(String metodo, int tamanho, long tempo);

    /**
     * Apresenta os dez primeiros elementos do vetor.
     *
     * @param vetor array de inteiros
     */
    public abstract void showArray(int[] vetor);

    /**
     * Gera valores aleatórios.
     *
     * @param vetor array de inteiros
     */
    public abstract void random(int[] vetor);








    public void mergeSort(int[] vetor, int p, int r) {
     
    }

    
    public void intercala(int p, int q, int r, int vetor[]) {
       

    }

   
    public int separa(int[] vetor, int p, int r) {
     
        return 0;
    }

  
    public void quicksort(int[] vetor, int p, int r) {
    }















}
