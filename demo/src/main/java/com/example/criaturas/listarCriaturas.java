package com.example.criaturas;

import com.example.database.MongoDBConnector;

import java.util.List;

public class listarCriaturas {
    private static MongoDBConnector dbConnector = new MongoDBConnector();

    public static void adicionarCriatura(Criatura criatura) {
        dbConnector.adicionarCriatura(criatura);
    }

    public static List<Criatura> listarCriaturas() {
        List<Criatura> criaturas = dbConnector.listarCriaturas();
        System.out.println("Lista de Criaturas Cadastradas:");
        System.out.println("Nome da Criatura | Elementos | VD | DT de Sanidade");
        for (Criatura criatura : criaturas) {
            System.out.print(criatura.getNomeCriatura() + " | ");
            for (String elemento : criatura.getElementosCriatura()) {
                System.out.print(elemento + ", ");
            }
            System.out.print(" | " + criatura.getValorDificuldade());
            System.out.println(" | " + criatura.getDtSanidade());
        }
        return criaturas;
    }
}
