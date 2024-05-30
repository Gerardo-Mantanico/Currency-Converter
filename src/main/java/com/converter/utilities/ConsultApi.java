package com.converter.utilities;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultApi {

    CurrencyOmbd search(String base , String target, double amount) {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/31521095e2b415bc49ac744e/pair/"+base+"/"+target+"/"+amount);
        HttpRequest request = HttpRequest.newBuilder(uri).build();
        HttpResponse<String> response= null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), CurrencyOmbd.class);
    }

       String  searchCountry(String country) throws IOException, InterruptedException {
           String url = "https://restcountries.com/v3.1/name/"+country;
           HttpClient client = HttpClient.newHttpClient();
           HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create(url))
             .build();
           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           if (response.statusCode() != 200) {
               throw new RuntimeException("Failed to get response from the API: " + response.body());
           }
           Gson gson = new Gson();
           JsonElement jsonResponse = gson.fromJson(response.body(), JsonElement.class);
           if (jsonResponse.isJsonArray()) {
               JsonArray jsonArray = jsonResponse.getAsJsonArray();
               if (jsonArray.size() == 0) {
                   throw new RuntimeException("No se encontró información para el país: " + country);
               }
               JsonObject firstResult = jsonArray.get(0).getAsJsonObject();
               JsonObject currencyObj = firstResult.getAsJsonObject("currencies");
               String currencyCode = currencyObj.keySet().iterator().next();
               System.out.println(currencyCode);
               return currencyCode;
           } else {
               throw new RuntimeException("Respuesta inesperada de la API: " + jsonResponse);
           }
    }
}
