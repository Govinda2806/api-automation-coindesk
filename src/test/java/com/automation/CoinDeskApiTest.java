package com.automation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CoinDeskApiTest {

    @Test
    public void testGetBitcoinPriceIndex() {
    	
        Response response = RestAssured.get("https://api.coindesk.com/v1/bpi/currentprice.json");
        System.out.println("response : "+response.getBody().asPrettyString());
        assertEquals(200, response.getStatusCode(), "Expected HTTP status 200");
        assertTrue(response.getBody().asString().contains("bpi"), "'bpi' not found in response");

        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("USD"), "USD currency not found");
        assertTrue(responseBody.contains("GBP"), "GBP currency not found");
        assertTrue(responseBody.contains("EUR"), "EUR currency not found");
        assertTrue(responseBody.contains("British Pound Sterling"), "GBP description incorrect");
        
    }
}
