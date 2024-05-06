package com.example.agentes;
import java.util.Scanner;

public class CadastrarAgente {
    public static void cadastrar(Scanner scanner) {
        System.out.println("Digite o nome do jogador:");
        String nomeJogador = scanner.next();

        System.out.println("Digite o nome do personagem:");
        String nomePersonagem = scanner.next();

        System.out.println("Escolha a classe do personagem:");
        System.out.println("1 - Combatente");
        System.out.println("2 - Ocultista");
        System.out.println("3 - Especialista");
        System.out.println("4 - Mundano");
        int escolhaClasse = scanner.nextInt();
        String classePersonagem;
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
                System.out.println("Escolha inválida. Definindo como Mundano.");
                classePersonagem = "Mundano";
        }

        System.out.println("Digite a exposição paranormal do personagem (NEX) (0 a 99%):");
        int exposicaoParanormal = scanner.nextInt();

        System.out.println("Agente cadastrado com sucesso:");
        System.out.println("Nome do jogador: " + nomeJogador);
        System.out.println("Nome do personagem: " + nomePersonagem);
        System.out.println("Classe do personagem: " + classePersonagem);
        System.out.println("Exposição paranormal do personagem (NEX): " + exposicaoParanormal + "%");
    }
}