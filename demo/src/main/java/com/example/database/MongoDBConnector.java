package com.example.database;

import com.example.criaturas.Criatura;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDBConnector {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "aventuraDB";
    private static final String COLLECTION_NAME = "criaturas";

    private MongoDatabase database;

    public MongoDBConnector() {
        MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
        database = mongoClient.getDatabase(DATABASE_NAME);
    }

    public void adicionarCriatura(Criatura criatura) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        Document doc = new Document("nomeCriatura", criatura.getNomeCriatura())
                .append("elementosCriatura", criatura.getElementosCriatura())
                .append("valorDificuldade", criatura.getValorDificuldade())
                .append("dtSanidade", criatura.getDtSanidade());
        collection.insertOne(doc);
    }

    public List<Criatura> listarCriaturas() {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        List<Criatura> criaturas = new ArrayList<>();
        for (Document doc : collection.find()) {
            String nomeCriatura = doc.getString("nomeCriatura");
            List<String> elementosCriatura = (List<String>) doc.get("elementosCriatura");
            int valorDificuldade = doc.getInteger("valorDificuldade");
            int dtSanidade = doc.getInteger("dtSanidade");
            Criatura criatura = new Criatura(nomeCriatura, elementosCriatura, valorDificuldade, dtSanidade);
            criaturas.add(criatura);
        }
        return criaturas;
    }
}
