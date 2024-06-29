package com.example.grupo;

import java.util.List;
import java.util.ArrayList;

import com.example.agentes.Agente;

public class Grupo {
    private String nomeGrupo;
    private List<Agente> agentes;

    public Grupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
        this.agentes = new ArrayList<>();
    }

    public Grupo(String nomeGrupo, List<Agente> agentes) {
        this.nomeGrupo = nomeGrupo;
        this.agentes = agentes;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public List<Agente> getAgentes() {
        return agentes;
    }

    public void adicionarAgente(Agente agente) {
        agentes.add(agente);
    }

    public void listarAgentes() {
        System.out.println("Agentes no grupo " + nomeGrupo + ":");
        for (Agente agente : agentes) {
            System.out.println(agente.getNomePersonagem() + " | " + agente.getClassePersonagem() + " | " +
            agente.getExposicaoParanormal() + "% | " + agente.getNomeJogador());
        }
    }
}
