package by.alexkas;

import by.alexkas.bean.Card;
import by.alexkas.service.AtmService;


import java.util.Scanner;

public class AtmApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AtmService atmService = new AtmService();
        Card card = new Card();

        atmService.initialization(card, scanner);

    }
}
