package com.matiasbueno.ui;
//interactuar con el usuario para permitirle elegir las opciones de conversión,
// ingresar montos y decidir si desea realizar otra consulta o finalizar el programa.


import com.matiasbueno.http.CurrencyApiClient;
import com.matiasbueno.model.CurrencyQuoteRequest;
import com.matiasbueno.model.CurrencyQuoteResponse;
import java.math.BigDecimal;
import java.util.Scanner;

public class UserInterface {
    private final CurrencyApiClient apiClient;

    // Constructor
    public UserInterface(CurrencyApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Método principal para ejecutar la interacción con el usuario.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("=== Conversor de Monedas ===");

            // Solicitar moneda base
            System.out.print("Ingrese la moneda base (ej: USD): ");
            String baseCurrency = scanner.nextLine().toUpperCase();

            // Solicitar moneda objetivo
            System.out.print("Ingrese la moneda objetivo (ej: EUR): ");
            String targetCurrency = scanner.nextLine().toUpperCase();

            // Solicitar monto a convertir
            System.out.print("Ingrese el monto a convertir: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner

            // Crear solicitud y obtener la respuesta de la API
            try {
                CurrencyQuoteRequest request = new CurrencyQuoteRequest(baseCurrency, targetCurrency);
                CurrencyQuoteResponse response = apiClient.getCurrencyQuote(request);

                // Calcular el monto convertido
                BigDecimal convertedAmount = BigDecimal.valueOf(amount).multiply(response.getExchangeRate());

                // Mostrar resultados
                System.out.println("\n--- Resultado de la Conversión ---");
                System.out.printf("Monto original: %.2f %s\n", amount, baseCurrency);
                System.out.printf("Tasa de cambio: %.4f %s/%s\n", response.getExchangeRate(), baseCurrency, targetCurrency);
                System.out.printf("Monto convertido: %.2f %s\n", convertedAmount, targetCurrency);
                System.out.println("Última actualización: " + response.getTimestamp());
                System.out.println("----------------------------------\n");
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }

            // Preguntar si desea realizar otra consulta
            System.out.print("¿Desea realizar otra conversión? (S/N): ");
            String userChoice = scanner.nextLine().trim().toUpperCase();
            continueRunning = userChoice.equals("S");
        }

        System.out.println("Gracias por usar el Conversor de Monedas. ¡Hasta pronto!");
        scanner.close();
    }
}
