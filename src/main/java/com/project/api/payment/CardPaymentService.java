package com.project.api.payment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CardPaymentService {

    public static List<CardPayment> getAllPayments(String filePathString) {

        List<CardPayment> cardPayments = new ArrayList<>();
        try {
            File sourceFile = Paths.get(filePathString).toFile();
            ObjectMapper objectMapper = new ObjectMapper();
            cardPayments = Arrays.asList(objectMapper.readValue(sourceFile, CardPayment[].class));
            cardPayments.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return cardPayments;
    }
}
