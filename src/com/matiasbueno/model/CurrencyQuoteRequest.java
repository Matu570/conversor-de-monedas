package com.matiasbueno.model;
//Representa la solicitud para consultar una cotización de moneda.

public class CurrencyQuoteRequest {
    private String baseCurrency; // Moneda base (ej. USD)
    private String targetCurrency; // Moneda objetivo (ej. EUR)

    // Constructor
    public CurrencyQuoteRequest(String baseCurrency, String targetCurrency) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
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

    // Método toString
    @Override
    public String toString() {
        return "CurrencyQuoteRequest{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                '}';
    }
}

