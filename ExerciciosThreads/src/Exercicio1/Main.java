/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio1;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 14201805
 */
public class Main {
    
    public static void main(String[] args) {
        
        int[][] m = {{1,2},{3,4}};
        somaColunas(m);
        
    }
    
    private static void somaColunas(int[][] m){
        
        ExecutorService e = Executors.newFixedThreadPool(m.length);
        LinkedList<Future<Integer>> ft = new LinkedList<>();
        
        for (int i=0; i<m.length; i++) {           
          Future<Integer> task =  e.submit(new Matriz(m[i]));
          ft.add(task);
        }
    
        int soma=0;
        for (Future<Integer> future : ft) {
            try {
                soma+=future.get();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Soma: " + soma);
    }
    
    
}
