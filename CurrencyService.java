package com.transfor.money.service;

import com.transfor.money.model.ConversionHistory;
import org.springframework.stereotype.Service;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {
    private static final String API_KEY = "0b2c0525a506198d95a5c6fc";
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";
    private final List<ConversionHistory> history = new ArrayList<>();

    public double convertCurrency(String from, String to, double amount) throws IOException {
        String requestUrl = API_URL + from;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(requestUrl);
        CloseableHttpResponse response = httpClient.execute(request);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.getEntity().getContent());
        double rate = node.get("rates").get(to).asDouble();
        double result = amount * rate;

        // Save to history
        history.add(new ConversionHistory(from, to, amount, result));

        return result;
    }

    public List<ConversionHistory> getHistory() {
        return history;
    }
}