/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordena;

/**
 *
 * @author Internet
 */
public class Programa {
    
    public static void main(String[] args) {
        
       Metodos metodos = new Metodos();
        
        
       for(int i = 0; i < 50; i++){
            
        int vetor[] = new int[metodos.TAMANHO_VETOR]; 
        metodos.random(vetor);
        Programa.executarQuickSort(vetor);
        Programa.executarMergeSort(vetor);
        
        metodos.TAMANHO_VETOR += 10000;
        
        
    }
    
}

    
    
    
    private static void executarQuickSort(int[] vetor) {
    
        Metodos metodos = new Metodos();
        System.out.println("\n === Vetor Ordenado ===");
        int temp;
        long inicio = System.nanoTime();
        
        
        metodos.quicksort(vetor, 0, metodos.TAMANHO_VETOR-1);
//        metodos.mergeSort(vetor, 1, 5);
        
        
        long fim = System.nanoTime(); 
        long tempo = fim - inicio;  
        //metodos.file("quick.txt", vetor.length, tempo);
        
        metodos.file("quick.txt", vetor.length, tempo);
    }
    
    
    
  
    
    
      private static void executarMergeSort(int[] vetor) {
    
        Metodos metodos = new Metodos();
        System.out.println("\n === Vetor Ordenado ===");
        int temp;
        long inicio = System.nanoTime();
        
        
//        metodos.quicksort(vetor, 0, metodos.TAMANHO_VETOR-1);
        metodos.mergeSort(vetor, 1, 5);
        
        
        long fim = System.nanoTime(); 
        long tempo = fim - inicio;  
        //metodos.file("quick.txt", vetor.length, tempo);
        
        metodos.file("merge.txt", vetor.length, tempo);
    }
    
  
    
    
    
    
    
    
    
    }
