package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.agentes.Agente;
import com.example.agentes.cadastrarAgente;
import com.example.agentes.listarAgentes;
import com.example.criaturas.Criatura;
import com.example.criaturas.cadastrarCriatura;
import com.example.criaturas.listarCriaturas;
import com.example.grupo.Grupo;

public class MenuInicial {
    private static List<Criatura> criaturas = new ArrayList<>();
    private static List<Grupo> grupos = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("C.R.I.S.");
            System.out.println("Carregando Missão....");
            System.out.println("Digite a opção que deseja utilizar:");
            System.out.println("1 - Cadastrar Agente");
            System.out.println("2 - Listar Agentes");
            System.out.println("3 - Cadastrar Criatura");
            System.out.println("4 - Listar Criaturas");
            System.out.println("5 - Criar Grupo");
            System.out.println("6 - Listar Grupos");
            System.out.println("7 - Fechar");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarAgente.cadastrar(scanner);
                    break;
                case 2:
                    listarAgentes.listarAgentes();
                    break;
                case 3:
                    cadastrarCriatura.cadastrar(scanner, criaturas);
                    break;
                case 4:
                    listarCriaturas.listarCriaturas(criaturas);
                    break;
                case 5:
                    criarGrupo(scanner);
                    break;
                case 6:
                    listarGrupos();
                    break;
                case 7:
                    System.out.println("Olhos Sempre Abertos...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }

    private static void criarGrupo(Scanner scanner) {
        System.out.println("Digite o nome do grupo:");
        scanner.nextLine();
        String nomeGrupo = scanner.nextLine();
        Grupo grupo = new Grupo(nomeGrupo);

        boolean adicionarMais;
        do {
            listarAgentes.listarAgentes();
            System.out.println("Digite o nome do agente que deseja adicionar ao grupo:");
            String nomeAgente = scanner.nextLine();
            Agente agenteSelecionado = null;

            for (Agente agente : listarAgentes.getAgentes()) {
                if (agente.getNomePersonagem().equalsIgnoreCase(nomeAgente)) {
                    agenteSelecionado = agente;
                    break;
                }
            }

            if (agenteSelecionado != null) {
                System.out.println("Deseja adicionar " + agenteSelecionado.getNomePersonagem() + " | " +
                        agenteSelecionado.getClassePersonagem() + " | " + agenteSelecionado.getExposicaoParanormal() +
                        "% | " + agenteSelecionado.getNomeJogador() + " ao grupo? (S/N)");
                String confirmacao = scanner.nextLine();
                if (confirmacao.equalsIgnoreCase("S")) {
                    grupo.adicionarAgente(agenteSelecionado);
                    System.out.println("Agente adicionado ao grupo.");
                } else {
                    System.out.println("Agente não adicionado.");
                }
            } else {
                System.out.println("Agente não encontrado.");
            }

            System.out.println("Deseja adicionar mais um agente ao grupo? (S/N)");
            String resposta = scanner.nextLine();
            adicionarMais = resposta.equalsIgnoreCase("S");

            } while (adicionarMais);

            grupos.add(grupo);
            System.out.println("Grupo " + nomeGrupo + " criado com sucesso.");
    }
        private static void listarGrupos() {
            if (grupos.isEmpty()) {
                System.out.println("Nenhum grupo cadastrado.");
                return;
            }

            for (Grupo grupo : grupos) {
                grupo.listarAgentes();
            }
    }
}
    

