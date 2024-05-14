package com.example.agentes;

import java.util.ArrayList;
import java.util.List;

public class listarAgentes {
    private static List<Agente> agentes = new ArrayList<>();

    public static void adicionarAgente(Agente agente) {
        agentes.add(agente);
    }

    public static void listarAgentes() {
        if (agentes.isEmpty()) {
            System.out.println("Nenhum agente cadastrado.");
            return;
        }

        System.out.println("Lista de Agentes Cadastrados:");
        System.out.println("Nome do agente | Classe | Nex% | Nome do jogador");
        for (Agente agente : agentes) {
            System.out.println(agente.getNomePersonagem() + " | " + agente.getClassePersonagem() + " | " +
                    agente.getExposicaoParanormal() + "% | " + agente.getNomeJogador());
        }
    }
}
