package com.example.criaturas;

import java.util.ArrayList;
import java.util.List;

public class listarCriaturas {
    private static List<Criatura> criaturas = new ArrayList<>();

    public static void adicionarCriatura(Criatura criatura) {
        criaturas.add(criatura);
    }

    public static void listarCriaturas(List<Criatura> criaturas) {
        System.out.println("Lista de Criaturas Cadastradas:");
        System.out.println("Nome da Criatura | Elementos | VD");
        for (Criatura criatura : criaturas) {
            System.out.print(criatura.getNomeCriatura() + " | ");
            for (String elemento : criatura.getElementosCriatura()) {
                System.out.print(elemento + ", ");
            }
            System.out.println(" | " + criatura.getValorDificuldade());
        }
    }
}