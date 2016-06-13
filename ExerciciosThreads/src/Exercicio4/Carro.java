/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio4;

import java.util.concurrent.Callable;

/**
 *
 * @author 14201805
 */
public class Carro implements Callable<String> {

    private String placa;
    private Estacionamento e;
    
    public Carro(String placa) {
        this.placa = placa;
        e = Estacionamento.getInstace();
    }
    
    
    
    @Override
    public String call() throws Exception {
        int vaga = e.entrada(placa);
        if(vaga==-1) throw new Exception("Vaga: " + vaga);
        System.out.println("Carro: " + placa + " entrou na vaga: " + vaga);
        return e.saida(vaga);
    }
    
    
    
}
