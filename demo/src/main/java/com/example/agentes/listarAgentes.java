package com.example.agentes;

import java.util.List;

import com.example.database.AgenteDAO;

public class listarAgentes {
    
    public static void adicionarAgente(Agente agente) {
        AgenteDAO.adicionarAgente(agente);
    }

    public static void listarAgentes() {
        List<Agente> agentes = AgenteDAO.listarAgentes();
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

    public static List<Agente> getAgentes() {
        return AgenteDAO.listarAgentes();
    }
}
