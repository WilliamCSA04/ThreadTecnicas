/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio2;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 14201805
 */
public class Main {

    public static void main(String[] args) {
        
        int[] A = {1,2,3,4,5,6,7,8,9};
        buscaParalela(4, A, 2);
    }

    public static void buscaParalela(int x, int[] A, int numThreads) {
        ExecutorService e = Executors.newFixedThreadPool(numThreads);
        LinkedList<Future<Integer>> listaThreads = new LinkedList<>();
        int cont = 0;
        int[] subVetor = new int[A.length/numThreads];
        
        for (int k=0; k<A.length; k++) {
            
            int i = A[k];
            subVetor[cont] = i;
            if(cont < numThreads){
                cont = 0;
                Future<Integer> task = e.submit(new PesquisaArrayInteiros(subVetor, x));
                listaThreads.add(task);
                subVetor = new int[A.length/numThreads];
            } else {
                cont++;
            }
        }
        
        for (Future<Integer> future : listaThreads) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException ex) {
                Logger.getLogger(Exercicio1.Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Exercicio1.Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
