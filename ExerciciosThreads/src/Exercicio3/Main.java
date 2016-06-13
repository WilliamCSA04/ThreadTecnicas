/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio3;

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
 * @author Joseane Wichrowski
 */
public class Main {

    public static void main(String[] args) {
        Sorteador s = new Sorteador();
        int jogadores = 10;
        ExecutorService e = Executors.newFixedThreadPool(jogadores);
        LinkedList<Future<String>> listaThreads = new LinkedList<>();
        for (int i = 0; i < jogadores; i++) {
            Future<String> task = e.submit(new Jogador(i, s));
            listaThreads.add(task);

        }
        try {
            for (Future<String> listaThread : listaThreads) {
                listaThread.get();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Histórico: " + Arrays.deepToString(s.getUltimosSorteios()));
    }

}
