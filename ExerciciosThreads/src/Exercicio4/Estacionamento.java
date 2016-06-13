/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author 14201805
 */
public class Estacionamento {

    private static final int limiteVagas = 50;
    private static HashMap<Integer, String> mapaEstacionamento = new HashMap<>();
    private static ArrayList<Boolean> vagasLivres = new ArrayList<>();
    private static Estacionamento e = null;

    public static Estacionamento getInstace() {
        if (e == null) {
            e = new Estacionamento();
        }
        return e;
    }

    private Estacionamento() {
        for (int i=0; i<50; i++) {
            vagasLivres.add(true);
        }
    }

    public synchronized int entrada(String placa) {
        
        int vaga = -1;
        for (int i = 0; i < vagasLivres.size(); i++) {
            if (vagasLivres.get(i)) {
                vaga = i + 1;
                vagasLivres.set(i, false);
                break;
            } else if (i == vagasLivres.size() - 1) {
                return -1;
            }
        }

        mapaEstacionamento.put(vaga, placa);

        return vaga;
    }

    public synchronized String saida(int vaga) {
        return mapaEstacionamento.remove(vaga);
    }

}
