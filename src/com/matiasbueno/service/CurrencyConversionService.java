package com.matiasbueno.service;

import com.matiasbueno.http.CurrencyApiClient;
import com.matiasbueno.model.ConversionResult;
import com.matiasbueno.model.CurrencyQuoteRequest;
import com.matiasbueno.model.CurrencyQuoteResponse;

import java.math.BigDecimal;

public class CurrencyConversionService {
    private final CurrencyApiClient apiClient;

    // Constructor
    public CurrencyConversionService(CurrencyApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Realiza la conversión de una moneda a otra.
     *
     * @param baseCurrency   La moneda base (ej: USD).
     * @param targetCurrency La moneda objetivo (ej: EUR).
     * @param amount         El monto a convertir.
     * @return Un objeto ConversionResult con los detalles de la conversión.
     * @throws Exception Si ocurre un error al comunicarse con la API.
     */
    public ConversionResult convertCurrency(String baseCurrency, String targetCurrency, double amount) throws Exception {
        // Crear la solicitud de conversión
        CurrencyQuoteRequest request = new CurrencyQuoteRequest(baseCurrency, targetCurrency);

        // Obtener la respuesta de la API
        CurrencyQuoteResponse response = apiClient.getCurrencyQuote(request);

        // Calcular el monto convertido
        BigDecimal convertedAmount = BigDecimal.valueOf(amount).multiply(response.getExchangeRate());

        // Retornar el resultado de la conversión
        return new ConversionResult(
                baseCurrency,
                targetCurrency,
                amount,
                convertedAmount.doubleValue()
        );
    }
}

