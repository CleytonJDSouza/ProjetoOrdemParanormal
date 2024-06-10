package com.example.agentes;

import java.util.Objects;

public class Agente {
    private String nomeJogador;
    private String nomePersonagem;
    private String classePersonagem;
    private int exposicaoParanormal;
    private int nexInicial;

    public Agente(String nomeJogador, String nomePersonagem, String classePersonagem, int exposicaoParanormal) {
        this.nomeJogador = nomeJogador;
        this.nomePersonagem = nomePersonagem;
        this.classePersonagem = classePersonagem;
        this.exposicaoParanormal = exposicaoParanormal;
        this.nexInicial = exposicaoParanormal;
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

    public int getNexInicial() {
        return nexInicial;
    }

    public void aumentarExposicaoParanormal(int valor) {
        this.exposicaoParanormal += valor;
        if (this.exposicaoParanormal > 99) {
            this.exposicaoParanormal = 99;
        }
    }

    public boolean deveReceberAviso() {
        for (int i = nexInicial + 1; i <= exposicaoParanormal; i++) {
            if (i % 5 == 0 && i <= 99) {
                return true;
            }
        }
        return false;
    }
}
