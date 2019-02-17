package com.bluecodex.portalx.db.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Configuration
public class DatabaseConfig extends AbstractMongoConfiguration {

    @Value("${portalx.mongo.database}")
    private String database;

    @Value("${portalx.mongo.user}")
    private String user;

    @Value("${portalx.mongo.password}")
    private String password;

    @Value("${portalx.mongo.replset}")
    private String replset;

    @Value("${portalx.mongo.timeout}")
    private int timeOut;

    @Override
    public MongoClient mongoClient() {
        String uri = null;
        try {
            uri = "mongodb://"+user+":"+ URLEncoder.encode(password, "UTF-8")+"@"+replset+"/"+database+"?authMechanism=SCRAM-SHA-1";
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Failed encoding password for Mongo Client");
        }
        MongoClientOptions.Builder optionsBuilder = MongoClientOptions.builder().connectTimeout(timeOut);
        return new MongoClient(new MongoClientURI(uri, optionsBuilder));
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }
}
