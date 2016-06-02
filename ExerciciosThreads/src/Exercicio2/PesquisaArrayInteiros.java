/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio2;

import java.util.concurrent.Callable;

/**
 *
 * @author 14201805
 */
public class PesquisaArrayInteiros implements Callable<Integer> {

    private int[] vetor;
    private int x;
    
    public PesquisaArrayInteiros(int[] vetor, int x){
        this.vetor=vetor;
        this.x = x;
    }
    
    @Override
    public Integer call() throws Exception {
        
        for (int i : vetor) {
            if(i == x){
                return i;
            }
        }
                
        return -1;
        
    }
 
 }
