package by.alexkas.service;

import by.alexkas.writer.WriterImpl;
import by.alexkas.bean.Atm;
import by.alexkas.bean.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CardService {
    private WriterImpl reader = new WriterImpl();
    private static final Logger LOGGER = LogManager.getLogger();
    private final String cardMoney = "You're have ";
    private final String LIMIT_EXCEEDED = "Limit has exceeded.";
    private final String INCORRECT_TRANSACTION = "Incorrect transaction";
    private final String SUCCESSFULLY_PERFORMED = "Operation was successfully performed";
    public void showBankAccount(Card card) {
        StringBuilder loggingMsgStringBuilder = new StringBuilder();
        loggingMsgStringBuilder.append(cardMoney);
        loggingMsgStringBuilder.append(card.getCardBalance());
        LOGGER.info(loggingMsgStringBuilder);
    }

    public void putMoneyToCard(Card card, Scanner scanner) {
        int putMoney = scanner.nextInt();
        if (putMoney > card.getLIMIT_CARD()) {
            LOGGER.info(LIMIT_EXCEEDED);
        } else {
            card.setCardBalance(card.getCardBalance() + putMoney);
            reader.writeFile(card);
            LOGGER.info(SUCCESSFULLY_PERFORMED);
        }
    }

    public void getMoneyFromCard(Card card, Atm atm, Scanner scanner) {
        int getMoney = scanner.nextInt();
        if (getMoney > atm.getLIMIT_SUM_IN_ATM() || getMoney > card.getCardBalance()) {
            LOGGER.info(INCORRECT_TRANSACTION);
        } else {
            card.setCardBalance(card.getCardBalance() - getMoney);
            reader.writeFile(card);
            LOGGER.info(INCORRECT_TRANSACTION);
        }
    }
}
