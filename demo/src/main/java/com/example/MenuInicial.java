package com.example;

import java.util.Scanner;

import com.example.agentes.Agente;
import com.example.agentes.cadastrarAgente;
import com.example.agentes.listarAgentes;
import com.example.criaturas.cadastrarCriatura;
import com.example.criaturas.listarCriaturas;

public class MenuInicial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("ORDEM PARANORMAL");
            System.out.println("Digite a opção que deseja utilizar:");
            System.out.println("1 - Cadastrar Agente");
            System.out.println("2 - Listar Agentes");
            System.out.println("3 - Cadastrar Criatura");
            System.out.println("4 - Listar Criaturas");
            System.out.println("5 - Fechar");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarAgente.cadastrar(scanner);
                    break;
                case 2:
                    listarAgentes.listarAgentes();
                    break;
                case 3:
                    cadastrarCriatura.cadastrar(scanner);
                    break;
                case 4:
                    listarCriaturas.listarCriaturas();
                    break;
                case 5:
                    System.out.println("Olhos Sempre Abertos...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
