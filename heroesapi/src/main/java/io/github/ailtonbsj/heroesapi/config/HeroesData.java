package io.github.ailtonbsj.heroesapi.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

import static io.github.ailtonbsj.heroesapi.constants.HeroesConstant.*;
import static io.github.ailtonbsj.heroesapi.constants.HeroesConstant.SECRET_KEY;

public class HeroesData {
    public static void main(String[] args) {
        AwsClientBuilder.EndpointConfiguration endpointConfig =
                new AwsClientBuilder.EndpointConfiguration(
                        "http://localhost:8000", "us-east-1");
        AWSStaticCredentialsProvider awsCredProvider =
                new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials("fakeMyKeyId", "fakeSecretAccessKey"));

        AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder
                .standard().withCredentials(awsCredProvider)
                .withEndpointConfiguration(endpointConfig).build();

        dynamoDB.getItem()

        Table table = dynamoDB.getTable("Heroes_Table");

        Item hero1 = new Item()
                .withPrimaryKey("id", 1)
                .withString("name","Wonder woman")
                .withString("universe", "dc comics")
                .withNumber("films", 3);

        Item hero2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Black window")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        Item hero3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Captain Marvel")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        table.putItem(hero1);
        table.putItem(hero2);
        table.putItem(hero3);
    }
}
