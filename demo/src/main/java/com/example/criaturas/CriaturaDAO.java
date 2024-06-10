package com.example.criaturas;

import org.bson.Document;

import com.example.database.MongoDBConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CriaturaDAO {
    private static MongoDatabase database = MongoDBConnection.getDatabase("aventuraDB");
    private static MongoCollection<Document> collection = database.getCollection("criaturas");

    public static void adicionarCriatura(Criatura criatura) {
        Document doc = new Document("nomeCriatura", criatura.getNomeCriatura())
                .append("elementosCriatura", criatura.getElementosCriatura())
                .append("valorDificuldade", criatura.getValorDificuldade())
                .append("dtSanidade", criatura.getDtSanidade());
        collection.insertOne(doc);
    }

    public static void listarCriaturas() {
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }
}
