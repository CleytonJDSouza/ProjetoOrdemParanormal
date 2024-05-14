package com.example.agentes;

public class Agente {
    private String nomeJogador;
    private String nomePersonagem;
    private String classePersonagem;
    private int exposicaoParanormal;

    public Agente(String nomeJogador, String nomePersonagem, String classePersonagem, int exposicaoParanormal) {
        this.nomeJogador = nomeJogador;
        this.nomePersonagem = nomePersonagem;
        this.classePersonagem = classePersonagem;
        this.exposicaoParanormal = exposicaoParanormal;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public String getClassePersonagem() {
        return classePersonagem;
    }

    public int getExposicaoParanormal() {
        return exposicaoParanormal;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }
}

