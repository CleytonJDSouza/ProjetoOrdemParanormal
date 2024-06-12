package com.example.agentes;

import java.util.Scanner;

public class cadastrarAgente {
    public static void cadastrar(Scanner scanner) {
        String nomeJogador;
        String nomePersonagem;
        String classePersonagem = "";
        int exposicaoParanormal = 0;
        String confirmacao = "N";

        do {
            System.out.println("Digite o nome do jogador:");
            nomeJogador = scanner.next();

            System.out.println("Digite o nome do personagem:");
            nomePersonagem = scanner.next();

            System.out.println("Escolha a classe do personagem:");
            System.out.println("1 - Combatente");
            System.out.println("2 - Ocultista");
            System.out.println("3 - Especialista");
            System.out.println("4 - Mundano");
            int escolhaClasse = scanner.nextInt();

            switch (escolhaClasse) {
                case 1:
                    classePersonagem = "Combatente";
                    break;
                case 2:
                    classePersonagem = "Ocultista";
                    break;
                case 3:
                    classePersonagem = "Especialista";
                    break;
                case 4:
                    classePersonagem = "Mundano";
                    break;
                default:
                    System.out.println("Escolha inválida. Por favor, escolha novamente.");
                    continue;
            }

            System.out.println("Digite a exposição paranormal do personagem (NEX) (0 a 99%):");
            exposicaoParanormal = scanner.nextInt();

            System.out.println("\nConfirme as informações:");
            System.out.println("Nome do jogador: " + nomeJogador);
            System.out.println("Nome do personagem: " + nomePersonagem);
            System.out.println("Classe do personagem: " + classePersonagem);
            System.out.println("Exposição paranormal do personagem (NEX): " + exposicaoParanormal + "%");

            System.out.println("\nAs informações estão corretas? (S/N)");
            confirmacao = scanner.next();
            if (!confirmacao.equalsIgnoreCase("S")) {
                System.out.println("Reiniciando o processo de cadastro...\n");
            }

        } while (!confirmacao.equalsIgnoreCase("S"));

        Agente novoAgente = new Agente(nomeJogador, nomePersonagem, classePersonagem, exposicaoParanormal);
        listarAgentes.adicionarAgente(novoAgente);

        System.out.println("Agente cadastrado com sucesso!");
    }
}
