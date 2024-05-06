package com.example;

import java.util.Scanner; 

public class MenuInicial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

    do {
        System.out.println("ORDEM PARANORMAL");
        System.out.println("Digite a opção que deseja utilizar:");
        System.out.println("1 - Cadastrar Agente");
        System.out.println("2 - Criar Aventura");
        System.out.println("3 - Cadastrar Criatura");
        System.out.println("4 - Fechar");

        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                cadastrarAgente();
                break;
            case 2:
                criarAventura();
                break;
            case 3:
                cadastrarCriatura();
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
    } while (opcao != 4);

    scanner.close();
}

private static void cadastrarAgente() {
    // Lógica para cadastrar um agente
    System.out.println("Opção escolhida: Cadastrar Agente");
}

private static void criarAventura() {
    // Lógica para criar uma aventura
    System.out.println("Opção escolhida: Criar Aventura");
}

private static void cadastrarCriatura() {
    // Lógica para cadastrar uma criatura
    System.out.println("Opção escolhida: Cadastrar Criatura");
}
}