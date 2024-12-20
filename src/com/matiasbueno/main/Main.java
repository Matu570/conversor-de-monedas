package com.matiasbueno.main;

import com.matiasbueno.http.CurrencyApiClient;
import com.matiasbueno.model.ConversionResult;
import com.matiasbueno.model.CurrencyQuoteRequest;
import com.matiasbueno.model.CurrencyQuoteResponse;
import com.matiasbueno.service.CurrencyConversionService;
import com.matiasbueno.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        CurrencyApiClient apiClient = new CurrencyApiClient();
        UserInterface userInterface = new UserInterface(apiClient);

        userInterface.start();
    }
}
