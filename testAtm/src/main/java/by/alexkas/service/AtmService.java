package by.alexkas.service;

import by.alexkas.bean.Atm;
import by.alexkas.bean.Card;
import by.alexkas.writer.WriterImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AtmService {
    private static final Logger LOGGER = LogManager.getLogger();
    private CardService cardService = new CardService();
    private Card card = new Card();
    private Atm atm = new Atm();
    private LoginService loginService = new LoginService();
    private WriterImpl writer = new WriterImpl();
    private final String WRONG_INITIALIZATION = "Wrong initialization";
    private final String WRONG_CHOICE = "Wrong choice";

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
                LOGGER.info(WRONG_INITIALIZATION);
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
        writer.readFile(card);
        boolean exitFromAtmMenu = false;
        while (!exitFromAtmMenu) {
            choiceMenu();
            switch (scanner.nextInt()) {
                case 1 -> cardService.showBankAccount(card);
                case 2 -> cardService.putMoneyToCard(card, scanner);
                case 3 -> cardService.getMoneyFromCard(card, atm, scanner);
                case 4 -> exitFromAtmMenu = true;
                default -> LOGGER.info(WRONG_CHOICE);
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
