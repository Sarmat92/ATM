package by.alexkas.service;

import by.alexkas.bean.Card;
import by.alexkas.validator.CardNumberValidatorImpl;
import by.alexkas.validator.PinCodeValidateImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class LoginService {

    private PinCodeValidateImpl pinValidator = new PinCodeValidateImpl();
    private CardNumberValidatorImpl cardValidator = new CardNumberValidatorImpl();
    private static final Logger LOGGER = LogManager.getLogger();
    private final String ENTER_PIN_AND_CARD = "Enter your pin code and card number";
    private final String BLOCK_CARD = "card's blocked";

    public boolean login(Card card, Scanner scanner) {
        if (!card.isBlocked()) {
            LOGGER.info(ENTER_PIN_AND_CARD);
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
        if (checkPinValidator(inputPinCode)) {
            return card.getPinCode().equals(inputPinCode);
        }
        return false;
    }

    private boolean checkPinValidator(String pin) {
        return pinValidator.validate(pin);
    }

    private boolean checkCardNumber(Card card, String inputCardNumber) {
        if (checkCardNumberValidator(inputCardNumber)) {
            return card.getCardNumber().equals(inputCardNumber);
        }
        return false;
    }

    private boolean checkCardNumberValidator(String cardNumber) {
        return cardValidator.validate(cardNumber);
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
        LOGGER.info(BLOCK_CARD);
    }

    private void restoreAttempts(Card card) {
        card.setInputErrorAttempts(3);
    }
}
