package com.example.database;

import com.example.agentes.Agente;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class AgenteDAO {
    private static MongoDatabase database = MongoDBConnection.getDatabase("aventuraDB");
    private static MongoCollection<Document> collection = database.getCollection("agentes");

    public static void adicionarAgente(Agente agente) {
        Document doc = new Document("nomeJogador", agente.getNomeJogador())
            .append("nomePersonagem", agente.getNomePersonagem())
            .append("classePersonagem", agente.getClassePersonagem())
            .append("exposicaoParanormal", agente.getExposicaoParanormal());
        collection.insertOne(doc);
    }

    public static List<Agente> listarAgentes() {
        List<Agente> agentes = new ArrayList<>();
        for (Document doc : collection.find()) {
            String nomeJogador = doc.getString("nomeJogador");
            String nomePersonagem = doc.getString("nomePersonagem");
            String classePersonagem = doc.getString("classePersonagem");
            int exposicaoParanormal = doc.getInteger("exposicaoParanormal");
            Agente agente = new Agente(nomeJogador, nomePersonagem, classePersonagem, exposicaoParanormal);
            agentes.add(agente);
        }
        return agentes;
    }
}
