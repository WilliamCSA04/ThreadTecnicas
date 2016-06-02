/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio1;

import java.util.concurrent.Callable;

/**
 *
 * @author 14201805
 */
public class Matriz implements Callable<Integer> {

    private int[] coluna;
    
    public Matriz(int[] coluna){
        this.coluna=coluna;
    }
    
    @Override
    public Integer call() throws Exception {
        int soma=0;
        for (int i : coluna) {
            soma+=i;
        }
        return soma;
    }
    
}
