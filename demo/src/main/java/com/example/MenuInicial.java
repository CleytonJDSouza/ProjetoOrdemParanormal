package com.example;

import com.example.agentes.Agente;
import com.example.agentes.cadastrarAgente;
import com.example.agentes.listarAgentes;
import com.example.aventura.Aventura;
import com.example.criaturas.Criatura;
import com.example.criaturas.cadastrarCriatura;
import com.example.criaturas.listarCriaturas;
import com.example.grupo.Grupo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MenuInicial {
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
            System.out.println("6 - Iniciar Aventura");
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
                    cadastrarCriatura.cadastrar(scanner);
                    break;
                case 4:
                    listarCriaturas.listarCriaturas();
                    break;
                case 5:
                    criarGrupo(scanner);
                    break;
                case 6:
                    iniciarAventura(scanner);
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
                if (grupo.getAgentes().contains(agenteSelecionado)) {
                    System.out.println("Agente já está no grupo.");
                } else {
                    grupo.adicionarAgente(agenteSelecionado);
                    System.out.println("Agente adicionado ao grupo.");
                }
            } else {
                System.out.println("Agente não encontrado.");
            }

            System.out.println("Deseja adicionar mais um agente ao grupo? (S/N)");
            String resposta = scanner.nextLine();
            adicionarMais = resposta.equalsIgnoreCase("S");
        } while (adicionarMais);

        grupos.add(grupo);
        System.out.println("Grupo criado com sucesso.");
    }

    private static void iniciarAventura(Scanner scanner) {
        if (grupos.isEmpty()) {
            System.out.println("Nenhum grupo disponível. Por favor, crie um grupo primeiro.");
            return;
        }

        List<Criatura> criaturas = listarCriaturas.listarCriaturas(); // Lista de criaturas do MongoDB

        if (criaturas.isEmpty()) {
            System.out.println("Nenhuma criatura disponível. Por favor, cadastre criaturas primeiro.");
            return;
        }

        System.out.println("Selecione o grupo para iniciar a aventura:");
        for (int i = 0; i < grupos.size(); i++) {
            System.out.println((i + 1) + " - " + grupos.get(i).getNomeGrupo());
        }

        int indiceGrupo = scanner.nextInt() - 1;
        if (indiceGrupo < 0 || indiceGrupo >= grupos.size()) {
            System.out.println("Grupo inválido.");
            return;
        }

        Grupo grupoSelecionado = grupos.get(indiceGrupo);

        System.out.println("Escolha o elemento da criatura para a aventura:");
        System.out.println("1 - Sangue");
        System.out.println("2 - Morte");
        System.out.println("3 - Conhecimento");
        System.out.println("4 - Energia");
        System.out.println("5 - Medo");
        System.out.println("6 - Aleatório");
        scanner.nextLine();
        String elementoSelecionado = scanner.nextLine();

        if (elementoSelecionado.equals("6")) {
            int indexAleatorio = new Random().nextInt(criaturas.size());
            Criatura criaturaAleatoria = criaturas.get(indexAleatorio);
            elementoSelecionado = criaturaAleatoria.getElementosCriatura().get(0);
        }

        Aventura.iniciarAventura(grupoSelecionado, criaturas, elementoSelecionado);
    }
}
