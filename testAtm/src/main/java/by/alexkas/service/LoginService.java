package by.alexkas.service;

import by.alexkas.bean.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class LoginService {

    public static final Logger LOGGER = LogManager.getLogger();

    public boolean login(Card card, Scanner scanner) {
        if (!card.isBlocked()) {
            LOGGER.info("Enter your pin code and card number");
            boolean result = checkCardPin(card, scanner.nextLine()) && checkCardNumber(card, scanner.nextLine());
            updateUserStatus(card, result);
            return result;
        }
        return false;
    }

    private void updateUserStatus(Card card, boolean result) {
        if (result) {
            restoreAttempts(card);
        } else {
            reduceLoginAttempts(card);
            blockIfLoginAttemptsExpended(card);
        }
    }

    private boolean checkCardPin(Card card, String inputPinCode) {
        return card.getPinCode().equals(inputPinCode);
    }

    private boolean checkCardNumber(Card card, String inputCardNumber) {
        return card.getCardNumber().equals(inputCardNumber);
    }

    private void reduceLoginAttempts(Card card) {
        card.setInputErrorAttempts(card.getInputErrorAttempts() - 1);
    }

    private void blockIfLoginAttemptsExpended(Card card) {
        if (card.getInputErrorAttempts() == 0) {
            blockCard(card);
        }
    }

    private void blockCard(Card card) {
        card.setBlocked(true);
        LOGGER.info("card's blocked");
    }

    private void restoreAttempts(Card card) {
        card.setInputErrorAttempts(3);
    }
}