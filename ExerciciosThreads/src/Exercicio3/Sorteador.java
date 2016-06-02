/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio3;

import java.util.Random;

/**
 *
 * @author Joseane Wichrowski 
 */
public class Sorteador implements ISorteador {

    private int[][] sorteios;

    public Sorteador() {
        this.sorteios = new int[10][10];
    }
    
    
    
    @Override
    public int[] sortear() {
        int[] numeros = new int[6];
        Random r = new Random();
        for(int i=0; i<numeros.length; i++){
           numeros[i]=r.nextInt(60);
        }
        return numeros;
    }

    @Override
    public int[][] getUltimosSorteios() {
        return null;
    }
    
    
    
}
