package com.inter.investing;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

@Repository
public class SharesAPI {
    public Share findCompanyBySymbol(String symbol) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://localhost:8080/api/v1/customers/teste"))
//                    .uri(URI.create("https://yh-finance.p.rapidapi.com/market/v2/get-quotes?region=US&symbols=" + symbol))
//                    .setHeader("X-RapidAPI-Host", "yh-finance.p.rapidapi.com")
//                    .setHeader("X-RapidAPI-Key", "3d780936b5mshbb3310cf0540591p19c85ajsnbb3b3270a3fa")
                    .build();
            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONObject json_obj = new JSONObject(httpResponse.body());
            String response = json_obj.get("quoteResponse").toString();
            JSONArray result_array = (JSONArray) new JSONObject(response).get("result");
            JSONObject result = (JSONObject)result_array.get(0);
            System.out.println(result.get("regularMarketPrice"));
            System.out.println(result.get("currency"));

            return Share.builder()
                    .price(((Double) result.get("regularMarketPrice")))
                    .currency((String) result.get("currency"))
//                    .symbol((String) result.get("symbol"))
                    .date(LocalDateTime.now())
                    .build();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
