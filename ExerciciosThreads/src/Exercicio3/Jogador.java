/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio3;

import Exercicio2.PesquisaArrayInteiros;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 *
 * @author 14201805
 */
public class Jogador implements Callable<String> {

    
    private int id;
    private Sorteador s;
    public Jogador(int id, Sorteador s){
        this.id=id;
        this.s=s;
    }
    
    @Override
    public String call() throws Exception {
        
        int[] jogo = s.sortear();
        System.out.println("Jogo feito por: " + id + " - " + Arrays.toString(jogo));
        
        
        
        return "";
    }
    
}
