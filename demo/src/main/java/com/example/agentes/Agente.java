package com.example.agentes;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agente agente = (Agente) o;
        return Objects.equals(nomePersonagem, agente.nomePersonagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomePersonagem);
    }
}

