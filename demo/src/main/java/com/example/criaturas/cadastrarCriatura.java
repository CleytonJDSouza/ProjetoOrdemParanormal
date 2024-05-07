package com.example.criaturas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cadastrarCriatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            cadastrar(scanner);
        }
    }
    
    public static void cadastrar(Scanner scanner) {
        String nomeCriatura;
        List<String> elementosCriatura = new ArrayList<>();
        int valorDificuldade;

        System.out.println("Digite o nome da criatura:");
        nomeCriatura = scanner.next();

        coletarElementos(scanner, elementosCriatura);

        System.out.println("Digite o valor de dificuldade (VD) da criatura (0 a 400):");
        valorDificuldade = scanner.nextInt();
        scanner.nextLine(); 

        // Exibir informações para confirmação
        System.out.println("\nConfirme as informações:");
        System.out.println("Nome da criatura: " + nomeCriatura);
        System.out.println("Elementos da criatura:");
        for (String elemento : elementosCriatura) {
            System.out.println("- " + elemento);
        }
        System.out.println("Valor de dificuldade: " + valorDificuldade);

        // Solicitar confirmação
        System.out.println("\nAs informações estão corretas? (Digite 's' para sim, 'n' para não)");
        String confirmacao = scanner.nextLine();
        if (confirmacao.equalsIgnoreCase("n")) {
            System.out.println("Por favor, refaça o cadastro da criatura.");
            return;
        }

        System.out.println("Criatura cadastrada com sucesso!");
        
        // Aqui você pode adicionar lógica adicional, como armazenar a criatura em algum lugar.
    }

    private static void coletarElementos(Scanner scanner, List<String> elementosCriatura) {
        int opcaoElemento;

        do {
            System.out.println("Escolha o elemento da criatura:");
            System.out.println("1 - Sangue");
            System.out.println("2 - Morte");
            System.out.println("3 - Conhecimento");
            System.out.println("4 - Energia");
            System.out.println("5 - Medo");
            System.out.println("6 - Finalizar seleção de elementos");

            opcaoElemento = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoElemento) {
                case 1:
                    elementosCriatura.add("Sangue");
                    break;
                case 2:
                    elementosCriatura.add("Morte");
                    break;
                case 3:
                    elementosCriatura.add("Conhecimento");
                    break;
                case 4:
                    elementosCriatura.add("Energia");
                    break;
                case 5:
                    elementosCriatura.add("Medo");
                    break;
                case 6:
                    if (elementosCriatura.isEmpty()) {
                        System.out.println("Você deve selecionar pelo menos um elemento para a criatura.");
                        continue;
                    } else {
                        return;
                    }
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (true);
    }
}
