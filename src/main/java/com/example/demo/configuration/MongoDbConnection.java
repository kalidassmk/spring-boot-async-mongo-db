package com.example.demo.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoDatabase;
import org.bson.BsonType;
import org.bson.codecs.BsonTypeClassMap;
import org.bson.codecs.Codec;
import org.bson.codecs.DateCodec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kalidass Mahalingam on 11/8/2017.
 */
@Component
public class MongoDbConnection {

    @Value("${mongodb.url}")
    private  String mongodbUrl;

    @Value("${mongodb.database}")
    private  String dbName;

    private MongoClient mongoClient;

    private  MongoDatabase database;

    /**
     * Instantiates a new Mongo db connection.
     */
    public MongoDbConnection() {
    }

    private synchronized void setUp(String mongodbUrl) {

        Map<BsonType, Class<?>> replacements = new HashMap<>();
        replacements.put(BsonType.DATE_TIME, Instant.class);
        BsonTypeClassMap bsonTypeClassMap = new BsonTypeClassMap(replacements);
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(new CodecRegistry[]{
                CodecRegistries.fromCodecs(new Codec[]{new DateCodec()}),
                CodecRegistries.fromProviders(new CodecProvider[]{new DocumentCodecProvider(bsonTypeClassMap)}),
                MongoClients.getDefaultCodecRegistry()});
        if (mongoClient != null) {
            mongoClient.close();
        }
        mongoClient = MongoClients.create(new ConnectionString(mongodbUrl));
        database = mongoClient.getDatabase(dbName).withCodecRegistry(codecRegistry);
    }

    /**
     * Gets mongo connection.
     *
     * @return the mongo connection
     */
    public MongoDatabase getMongoConnection() {
        if (database == null) {
            setUp(mongodbUrl);
        }
        return database;
    }

    /**
     * On shut down.
     */
    public void onShutDown() {
        mongoClient.close();
    }

}
