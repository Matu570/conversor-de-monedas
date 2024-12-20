package com.matiasbueno.model;
//Encapsular el resultado de la conversion de monedas.

public class ConversionResult {
    private String baseCurrency;      // Moneda base (ej. USD)
    private String targetCurrency;    // Moneda objetivo (ej. EUR)
    private double amount;            // Monto a convertir
    private double convertedAmount;   // Resultado de la conversión

    // Constructor
    public ConversionResult(String baseCurrency, String targetCurrency, double amount, double convertedAmount) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    // Método toString
    @Override
    public String toString() {
        return "ConversionResult{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", amount=" + amount +
                ", convertedAmount=" + convertedAmount +
                '}';
    }
}

