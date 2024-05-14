package com.example.criaturas;

import java.util.List;

public class Criatura {
    private String nomeCriatura;
    private List<String> elementosCriatura;
    private int valorDificuldade;

    public Criatura(String nomeCriatura, List<String> elementosCriatura, int valorDificuldade) {
        this.nomeCriatura = nomeCriatura;
        this.elementosCriatura = elementosCriatura;
        this.valorDificuldade = valorDificuldade;
    }

    public List<String> getElementosCriatura() {
        return elementosCriatura;
    }

    public String getNomeCriatura() {
        return nomeCriatura;
    }
    
    public int getValorDificuldade() {
        return valorDificuldade;
    }
}
