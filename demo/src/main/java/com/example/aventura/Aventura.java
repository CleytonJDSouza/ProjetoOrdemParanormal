package com.example.aventura;

import java.util.ArrayList;
import java.util.List;

import com.example.agentes.Agente;
import com.example.criaturas.Criatura;
import com.example.grupo.Grupo;

public class Aventura {

    public static void iniciarAventura(Grupo grupo, List<Criatura> criaturas, String elemento) {
        int totalNex = calcularTotalNex(grupo);

        List<Criatura> criaturasFiltradas = filtrarCriaturasPorElemento(criaturas, elemento);
        
        List<Criatura> criaturasDisponiveis = new ArrayList<>(criaturasFiltradas);

        List<Criatura> batalhaFacil = encontrarMelhoresCriaturas(totalNex, criaturasDisponiveis);
        criaturasDisponiveis.removeAll(batalhaFacil);

        List<Criatura> batalhaMedia = encontrarMelhoresCriaturas(totalNex, criaturasDisponiveis);
        criaturasDisponiveis.removeAll(batalhaMedia);

        List<Criatura> batalhaDificil = encontrarCriaturaMaisProxima(totalNex, criaturasDisponiveis);

        imprimirGrupo(grupo, totalNex);
        imprimirCriaturas("Batalha no Inicio de Aventura", batalhaFacil);
        atualizarNexGrupo(grupo, batalhaFacil);

        imprimirCriaturas("Batalha no Meio da Aventura", batalhaMedia);
        atualizarNexGrupo(grupo, batalhaMedia);

        imprimirCriaturaUnica("Batalha Contra o Boss Final", batalhaDificil);
        atualizarNexGrupo(grupo, batalhaDificil);

        imprimirResultadosFinais(grupo);
    }

    private static int calcularTotalNex(Grupo grupo) {
        int totalNex = 0;
        for (Agente agente : grupo.getAgentes()) {
            totalNex += agente.getExposicaoParanormal();
        }
        return totalNex;
    }

    private static List<Criatura> filtrarCriaturasPorElemento(List<Criatura> criaturas, String elemento) {
        if (elemento.equalsIgnoreCase("Aleatório")) {
            return criaturas;
        }

        List <Criatura> criaturaFiltradas = new ArrayList<>();
        for (Criatura criatura : criaturas) {
            if (criatura.getElementosCriatura().contains(elemento)) {
                criaturaFiltradas.add(criatura);
            }
        }
        return criaturaFiltradas;
    }

    private static List<Criatura> encontrarMelhoresCriaturas(int valorAlvo, List<Criatura> criaturas) {
        int n = criaturas.size();
        int[] dp = new int[valorAlvo + 1];
        List<Criatura>[] dpList = new List[valorAlvo + 1];

        for (int i = 0; i <= valorAlvo; i++) {
            dpList[i] = new ArrayList<>();
        }

        for (Criatura criatura : criaturas) {
            int vd = criatura.getValorDificuldade();
            if (vd > valorAlvo) continue;
            for (int j = valorAlvo; j >= vd; j--) {
                if (dp[j - vd] + vd > dp[j]) {
                    dp[j] = dp[j - vd] + vd;
                    dpList[j] = new ArrayList<>(dpList[j - vd]);
                    dpList[j].add(criatura);
                }
            }
        }

        return dpList[valorAlvo];
    }

    private static List<Criatura> encontrarCriaturaMaisProxima(int valorAlvo, List<Criatura> criaturas) {
        Criatura melhorCriatura = null;
        int melhorDiferenca = Integer.MAX_VALUE;

        for (Criatura criatura : criaturas) {
            int vd = criatura.getValorDificuldade();
            int diferenca = Math.abs(valorAlvo - vd);
            if (diferenca < melhorDiferenca) {
                melhorDiferenca = diferenca;
                melhorCriatura = criatura;
            }
        }

        List<Criatura> resultado = new ArrayList<>();
        if (melhorCriatura != null) {
            resultado.add(melhorCriatura);
        }
        return resultado;
    }

    private static void imprimirGrupo(Grupo grupo, int totalNex) {
        System.out.println("Grupo:");
        for (Agente agente : grupo.getAgentes()) {
            System.out.println(agente.getNomePersonagem() + " | " + agente.getClassePersonagem() + " | " + agente.getExposicaoParanormal() + 
                    "% | " + agente.getNomeJogador());
        }
        System.out.println("Total de NEX do grupo: " + totalNex + "%");
    }

    private static void imprimirCriaturas(String titulo, List<Criatura> criaturas) {
        System.out.println(titulo + ":");
        for (Criatura criatura : criaturas) {
            System.out.print(criatura.getNomeCriatura() + " | ");
            for (String elemento : criatura.getElementosCriatura()) {
                System.out.print(elemento + ", ");
            }
            System.out.println(" | " + criatura.getValorDificuldade());
        }
        System.out.println();
    }

    private static void imprimirCriaturaUnica(String titulo, List<Criatura> criatura) {
        System.out.println(titulo + ":");
        if (!criatura.isEmpty()) {
            Criatura c = criatura.get(0);
            System.out.print(c.getNomeCriatura() + " | ");
            for (String elemento : c.getElementosCriatura()) {
                System.out.print(elemento + ", ");
            }
            System.out.println(" | " + c.getValorDificuldade());
        } else {
            System.out.println("Nenhuma criatura encontrada.");
        }
        System.out.println();
    }

    private static void atualizarNexGrupo(Grupo grupo, List<Criatura> criaturas) {
        for (Agente agente : grupo.getAgentes()) {
            int nexGanhoTotal = 0;
            for (Criatura criatura : criaturas) {
                if (criatura.getDtSanidade() > agente.getExposicaoParanormal()) {
                    nexGanhoTotal += 1; // Ganho extra se dtSanidade da criatura for maior que o NEX atual
                }
            }
            agente.aumentarExposicaoParanormal(nexGanhoTotal);
        }
    }
    

    private static void imprimirResultadosFinais(Grupo grupo) {
        System.out.println("Resultados Finais da Aventura:");
        for (Agente agente : grupo.getAgentes()) {
            String aviso = agente.deveReceberAviso() ? " | O OUTRO LADO TE CHAMA" : "";
            System.out.printf("%s | %s | %d%% + %d%% = %d%%%s\n", 
                              agente.getNomePersonagem(), 
                              agente.getClassePersonagem(), 
                              agente.getNexInicial(), 
                              agente.getExposicaoParanormal() - agente.getNexInicial(), 
                              agente.getExposicaoParanormal(), 
                              aviso);
        }
    }
    
    
}
