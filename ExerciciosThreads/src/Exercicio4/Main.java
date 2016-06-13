/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio4;

import Exercicio3.Jogador;
import Exercicio3.Sorteador;
import java.util.Arrays;
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
        int carros = 30;
        ExecutorService e = Executors.newFixedThreadPool(carros);
        LinkedList<Future<String>> listaThreads = new LinkedList<>();
        for (int i=0; i < carros; i++) {
            Future<String> task = e.submit(new Carro("IUI-0"+i));
            listaThreads.add(task);
        }
        try {
            for (Future<String> listaThread : listaThreads) {
                System.out.println("Carro saiu: " + listaThread.get());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio3.Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Exercicio3.Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
