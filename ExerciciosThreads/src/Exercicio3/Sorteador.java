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

    private static int[][] sorteios = new int[10][6];
    private static int count = 0;
  
    
    
    
    @Override
    public synchronized int[] sortear() {
        int[] numeros = new int[6];
        Random r = new Random();
        for(int i=0; i<numeros.length; i++){
           numeros[i]=r.nextInt(60);
           if(count<sorteios.length){
               sorteios[count][i]=numeros[i];
           }else{
               //Fazer replace dos ultimos jogos
           }
           
        }
        count++;
        return numeros;
    }

    @Override
    public synchronized int[][] getUltimosSorteios() {
        return sorteios;
    }

    
    
    
}
