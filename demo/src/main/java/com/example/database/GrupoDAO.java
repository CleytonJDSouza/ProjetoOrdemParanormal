package com.example.database;

import com.example.agentes.Agente;
import com.example.grupo.Grupo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class GrupoDAO {
    private static MongoDatabase database = MongoDBConnection.getDatabase("aventuraDB");
    private static MongoCollection<Document> collection = database.getCollection("grupos");

    public static void adicionarGrupo(Grupo grupo) {
        List<Document> agentesDocs = new ArrayList<>();
        for (Agente agente : grupo.getAgentes()) {
            Document agenteDoc = new Document("nomeJogador", agente.getNomeJogador())
                    .append("nomePersonagem", agente.getNomePersonagem())
                    .append("classePersonagem", agente.getClassePersonagem())
                    .append("exposicaoParanormal", agente.getExposicaoParanormal());
            agentesDocs.add(agenteDoc);
        }

        Document grupoDoc = new Document("nomeGrupo", grupo.getNomeGrupo())
                .append("agentes", agentesDocs);
        collection.insertOne(grupoDoc);
    }

    public static List<Grupo> listarGrupos() {
        List<Grupo> grupos = new ArrayList<>();
        for (Document doc : collection.find()) {
            String nomeGrupo = doc.getString("nomeGrupo");
            List<Document> agentesDocs = (List<Document>) doc.get("agentes");
            List<Agente> agentes = new ArrayList<>();
            for (Document agenteDoc : agentesDocs) {
                String nomeJogador = agenteDoc.getString("nomeJogador");
                String nomePersonagem = agenteDoc.getString("nomePersonagem");
                String classePersonagem = agenteDoc.getString("classePersonagem");
                int exposicaoParanormal = agenteDoc.getInteger("exposicaoParanormal");
                Agente agente = new Agente(nomeJogador, nomePersonagem, classePersonagem, exposicaoParanormal);
                agentes.add(agente);
            }
            Grupo grupo = new Grupo(nomeGrupo, agentes);
            grupos.add(grupo);
        }
        return grupos;
    }
}

