package com.matiasbueno.model;
//Representa la respuesta de la API que contiene la tasa de cambio y otros datos relevantes.

import java.math.BigDecimal;

public class CurrencyQuoteResponse {
    private String baseCurrency; // Moneda base (ej. USD)
    private String targetCurrency; // Moneda objetivo (ej. EUR)
    private BigDecimal exchangeRate; // Tasa de cambio
    private String timestamp; // Marca de tiempo de la cotización

    // Constructor
    public CurrencyQuoteResponse(String baseCurrency, String targetCurrency, BigDecimal exchangeRate, String timestamp) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
        this.timestamp = timestamp;
    }

    // Getters y Setters
    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    // Método toString
    @Override
    public String toString() {
        return "CurrencyQuoteResponse{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", exchangeRate=" + exchangeRate +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}

