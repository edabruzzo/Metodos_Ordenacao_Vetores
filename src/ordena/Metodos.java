/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordena;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Gerson
 */
public class Metodos extends Sort {

    
    //Define o valor máximo a ser gerado.
    final int MAX = Integer.MAX_VALUE;

    int TAMANHO_VETOR = 10000;

    int v[];
    
    @Override
    public void random(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * MAX);
        }
    }

    @Override
    public void bubbleSort(int[] vetor) {

        //Inicia a marcação do tempo
        long inicio = System.currentTimeMillis();

        bubbleSortImplem(vetor);

        //Finaliza a marcação do tempo
        long fim = System.currentTimeMillis();
        //Determina o tempo decorrido
        long tempo = fim - inicio;
        //chama a função passando o nome do arquivo
        //Nesse caso, o nome do arquivo é bolha.txt.
        file("bolha.txt", vetor.length, tempo);
    }

    @Override
    public void insertionSort(int[] vetor) {

        long inicio = System.currentTimeMillis();

        insertionSortImplem(vetor);

        //Finaliza a marcação do tempo
        long fim = System.currentTimeMillis();
        //Determina o tempo decorrido
        long tempo = fim - inicio;
        //chama a função passando o nome do arquivo
        //Nesse caso, o nome do arquivo é bolha.txt.
        file("insercao.txt", vetor.length, tempo);
    }

    @Override
    public void selectionSort(int[] vetor) {

        long inicio = System.currentTimeMillis();

        selectionSortImpl(vetor);

        //Finaliza a marcação do tempo
        long fim = System.currentTimeMillis();
        //Determina o tempo decorrido
        long tempo = fim - inicio;
        //chama a função passando o nome do arquivo
        //Nesse caso, o nome do arquivo é bolha.txt.
        file("selecao.txt", vetor.length, tempo);
    }

    @Override
    public void file(String metodo, int tamanho, long tempo) {
        FileWriter arquivo;
        PrintWriter salvarArquivo;
        try {
            //Abre um arquivo com o nome passado por parâmetro.
            //Mude o diretório e a pasta
            arquivo = new FileWriter("E:/resultados/ " + metodo, true);
            //Arquivo para escrita.
            salvarArquivo = new PrintWriter(arquivo);
           // salvarArquivo.println("TAMANHO " + "\t" + " TEMPO (ms)");
            salvarArquivo.println(tamanho + "\t" + tempo);
            salvarArquivo.close();
        } catch (IOException ex) {
            System.out.println("Falha ao gravar arquivo\n" + ex.getMessage());
        }
    }

    @Override
    public void showArray(int[] vetor) {
        int i = 0;
        System.out.println("Índice      Valor");
        while (i <= 9) {
            System.out.println("  " + i + "     -   " + vetor[i]);
            i++;
        }
    }

    
    
    
    private void selectionSortImpl(int[] vetor) {

        //https://www.geeksforgeeks.org/comparison-among-bubble-sort-selection-sort-and-insertion-sort/
        //https://stackabuse.com/sorting-algorithms-in-java/
        for (int i = 0; i < vetor.length; i++) {
            int min = vetor[i];
            int minId = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < min) {
                    min = vetor[j];
                    minId = j;
                }
            }
            // swapping
            int temp = vetor[i];
            vetor[i] = min;
            vetor[minId] = temp;
        }

    }

    
    //https://stackabuse.com/sorting-algorithms-in-java/
    public void insertionSortImplem(int[] vetor) {

        for (int i = 1; i < vetor.length; i++) {
            int current = vetor[i];
            int j = i - 1;
            while (j >= 0 && current < vetor[j]) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            // at this point we've exited, so j is either -1
            // or it's at the first element where current >= a[j]
            vetor[j + 1] = current;
        }
    }

    private void bubbleSortImplem(int[] vetor) {

        //Inicia a marcação do tempo
        long inicio = System.nanoTime();
        boolean trocado = false;
        int x;
        do {
            trocado=false;
            for (int i = 0; i < vetor.length - 1; i++) {
                // verificar se os elementos estão na ordem certa
                if (vetor[i] < vetor[i + 1]) {
                    // trocar elementos de lugar
                    x = vetor[i];
                    vetor[i] = vetor[i + 1];
  //                  System.out.println(vetor[i + 1]);
                    vetor[i + 1] = x;
//                    System.out.println(x);
                    trocado = true;
                }
            }
            showArray(vetor);
            // enquanto houver elementos sendo reordenados.
        } while (trocado == true);

        //Finaliza a marcação do tempo
        long fim = System.nanoTime();
        //Determina o tempo decorrido
        long tempo = fim - inicio;
        //chama a função passando o nome do arquivo
        //Nesse caso, o nome do arquivo é bolha.txt.
        file("bolha.txt", vetor.length, tempo);
    }



/*
    
    
    ***************************************************
    
    
    
    */





    @Override
    public void mergeSort(int[] vetor, int p, int r) {
        if (p < r - 1) {
            int q = (p + r) / 2;
            mergeSort(vetor, p, q);
            mergeSort(vetor, q, r);
            intercala(p, q, r, vetor);
        }
    }

    
    @Override
    public void intercala(int p, int q, int r, int[] vetor) {
        int[] w = new int[r - p];
        int i = p, j = q;
        int k = 0;

        while (i < q && j < r) {
            if (vetor[i] <= vetor[j]) {
                w[k++] = vetor[i++];
            } else {
                w[k++] = vetor[j++];
            }
        }
        while (i < q) {
            w[k++] = vetor[i++];
        }
        while (j < r) {
            w[k++] = vetor[j++];
        }
        for (i = p; i < r; ++i) {
            vetor[i] = w[i - p];
        }

    }

    @Override   
    public int separa(int[] vetor, int p, int r) {
        
        int c = vetor[r]; // pivô
        int t, j = p;
        for (int k = p; k < r; ++k) {
            if (vetor[k] <= c) {
                t = vetor[j];
                vetor[j] = vetor[k];
                vetor[k] = t;
                ++j;
            }
        }
        t = vetor[j];
        vetor[j] = vetor[r];
        vetor[r] = t;
        return j;
    }

    
    
    @Override  
    public void quicksort(int[] vetor, int p, int r) {
        if (p < r) {                    
            int j = separa(vetor, p, r);    
            quicksort(vetor, p, j - 1);      
            quicksort(vetor, j + 1, r);       
        }
    }












}
