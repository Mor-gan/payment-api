package com.project.api.payment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CardPaymentService {

    String filePathString = "/Users/bimbo/Desktop/api/src/main/resources/payment.json";

    public static List<CardPayment> getAllPayments(String filePathString) {

        List<CardPayment> cardPayments = new ArrayList<>();
        try {
            File sourceFile = Paths.get(filePathString).toFile();
            ObjectMapper objectMapper = new ObjectMapper();
            cardPayments = Arrays.asList(objectMapper.readValue(sourceFile, CardPayment[].class));
            cardPayments.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.out.println("Hi");
        }
        return cardPayments;
    }

    public static void save(CardPayment cardPayments, String outputFile) {
          List<CardPayment> cardPayments = new ArrayList<>(); 
        try {
            cardPayments.add(cardPayment);
            File outputFileObj = Paths.get(outputFile).toFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(outputFileObj, cardPayments);
            System.out.println("File created at: " + outputFile);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
