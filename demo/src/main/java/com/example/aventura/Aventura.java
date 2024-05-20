package com.example.aventura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.agentes.Agente;
import com.example.criaturas.Criatura;
import com.example.grupo.Grupo;

public class Aventura {
    
    public static void iniciarAventura(Grupo grupo, List<Criatura> criaturas) {
        int totalNex = calcularTotalNex(grupo);
        List<Criatura> criaturasSelecionadas = encontrarCriaturasMaisProximas(totalNex, criaturas);

        System.out.println("Grupo:");
        for (Agente agente : grupo.getAgentes()) {
            System.out.println(agente.getNomePersonagem() + " | " + agente.getClassePersonagem() + " | " + agente.getExposicaoParanormal() + 
                    "% | " + agente.getNomeJogador());
        }
        System.out.println("Total de NEX do grupo: " + totalNex + "%");

        System.out.println("Criaturas selecionadas:");
        for (Criatura criatura : criaturasSelecionadas) {
            System.out.println(criatura.getNomeCriatura() + " | ");
            for (String elemento : criatura.getElementosCriatura()) {
                System.out.print(elemento + ", ");
            }
            System.out.println(" | " + criatura.getValorDificuldade());
        }
    }

    private static int calcularTotalNex(Grupo grupo) {
        int totalNex = 0;
        for (Agente agente : grupo.getAgentes()) {
            totalNex += agente.getExposicaoParanormal();
        }
        return totalNex;
    }

    private static List<Criatura> encontrarCriaturasMaisProximas(int totalNex, List<Criatura> criaturas) {
        Collections.sort(criaturas, Comparator.comparingInt(Criatura::getValorDificuldade));

        List<Criatura> resultado = new ArrayList<>();
        int somaAtual = 0;

        for (Criatura criatura : criaturas) {
            if (somaAtual + criatura.getValorDificuldade() <= totalNex) {
                resultado.add(criatura);
                somaAtual += criatura.getValorDificuldade();
            }
            if (somaAtual == totalNex) {
                break;
            }
        }

        return resultado;
    }
}
