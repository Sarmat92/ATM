package by.alexkas;

import by.alexkas.writer.WriterImpl;
import by.alexkas.bean.Card;
import by.alexkas.service.AtmService;


import java.util.Scanner;

public class AtmApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AtmService atmService = new AtmService();
        Card card = new Card();
        WriterImpl reader = new WriterImpl();

        atmService.initialization(card, scanner);

    }
}
