package com.matiasbueno.http;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.matiasbueno.model.CurrencyQuoteRequest;
import com.matiasbueno.model.CurrencyQuoteResponse;

public class CurrencyApiClient {
    private final String baseUrl; // URL base de la API

    // Constructor
    public CurrencyApiClient() {
        this.baseUrl = "https://v6.exchangerate-api.com/v6/5d75315c16045271b4cc9c65/latest/";
    }

    /**
     * Realiza una solicitud para obtener la tasa de cambio de una moneda base.
     *
     * @param request Objeto CurrencyQuoteRequest con moneda base y objetivo.
     * @return Un objeto CurrencyQuoteResponse con los datos de la respuesta.
     * @throws IOException          Si ocurre un error en la comunicación con la API.
     * @throws InterruptedException Si la solicitud es interrumpida.
     */
    public CurrencyQuoteResponse getCurrencyQuote(CurrencyQuoteRequest request) throws IOException, InterruptedException {
        String url = baseUrl + request.getBaseCurrency();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Error al obtener datos de la API: Código de respuesta " + response.statusCode());
        }

        // Parsear la respuesta JSON
        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

        if (!conversionRates.has(request.getTargetCurrency())) {
            throw new IllegalArgumentException("Moneda objetivo no encontrada: " + request.getTargetCurrency());
        }

        BigDecimal exchangeRate = conversionRates.get(request.getTargetCurrency()).getAsBigDecimal();
        String timestamp = jsonResponse.get("time_last_update_utc").getAsString();

        return new CurrencyQuoteResponse(
                request.getBaseCurrency(),
                request.getTargetCurrency(),
                exchangeRate,
                timestamp
        );
    }
}

