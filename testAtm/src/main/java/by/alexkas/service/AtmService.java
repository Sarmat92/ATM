package by.alexkas.service;

import by.alexkas.writer.WriterImpl;
import by.alexkas.bean.Atm;
import by.alexkas.bean.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AtmService {
    public static final Logger LOGGER = LogManager.getLogger();
    CardService cardService = new CardService();
    Card card = new Card();
    Atm atm = new Atm();
    LoginService loginService = new LoginService();
    WriterImpl reader = new WriterImpl();

    Scanner scanner = new Scanner(System.in);

    public void initialization(Card card, Scanner scanner) {
        verifyCard(card, scanner);
    }

    private void verifyCard(Card card, Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            if (loginService.login(card, scanner)) {
                atmMenu(scanner);
                exit = true;
            } else {
                LOGGER.info("Wrong initialization");
                exit = isExit(card, exit);
            }
        }
    }

    private static boolean isExit(Card card, boolean exit) {
        if (card.getInputErrorAttempts() == 0) {
            exit = true;
        }
        return exit;
    }

    private void atmMenu(Scanner scanner) {
        boolean exitFromAtmMenu = false;

        while (!exitFromAtmMenu) {
            choiceMenu();
            switch (scanner.nextInt()) {
                case 1 -> cardService.showBankAccount(card);
                case 2 -> cardService.putMoneyToCard(card, scanner);
                case 3 -> cardService.getMoneyFromCard(card, atm, scanner);
                case 4 -> exitFromAtmMenu = true;
                default -> LOGGER.info("Wrong choice");
            }
        }
    }

    private void choiceMenu() {
        final StringBuilder loggingMsgStringBuilder = new StringBuilder();
        loggingMsgStringBuilder.append("Press:\n");
        loggingMsgStringBuilder.append("1 - show bank account\n");
        loggingMsgStringBuilder.append("2 - put money to the card\n");
        loggingMsgStringBuilder.append("3 - get money from the card\n");
        loggingMsgStringBuilder.append("4 - exit\n");
        LOGGER.info(loggingMsgStringBuilder);
    }
}
