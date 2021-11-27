package io.github.ailtonbsj.heroesapi.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.ClientConfigurationFactory;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.util.StringUtils;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;
import java.util.Arrays;

import static io.github.ailtonbsj.heroesapi.constants.HeroesConstant.*;

public class HeroesTable {
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

        String tableName = "Heroes_Table";
        try {
            System.out.println("Attempting to create table; please wait...");

            CreateTableResult table = dynamoDB.createTable(
                    Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)),
                    tableName,
                    Arrays.asList(new KeySchemaElement("id", KeyType.HASH)),
                    new ProvisionedThroughput(5L, 5L)
            );
            System.out.println("Success.  Table status: " + table.getTableDescription().getTableStatus());
        }
        catch (Exception e) {
            System.err.println("Unable to create table: ");
            System.err.println(e.getMessage());
        }
    }
}
