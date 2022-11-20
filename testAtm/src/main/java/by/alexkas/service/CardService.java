package by.alexkas.service;

import by.alexkas.writer.WriterImpl;
import by.alexkas.bean.Atm;
import by.alexkas.bean.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CardService {
    WriterImpl reader = new WriterImpl();
    public static final Logger LOGGER = LogManager.getLogger();

    public void showBankAccount(Card card) {
        StringBuilder loggingMsgStringBuilder = new StringBuilder();
        loggingMsgStringBuilder.append("You're have ");
        loggingMsgStringBuilder.append(card.getCardBalance());
        LOGGER.info(loggingMsgStringBuilder);
    }

    public void putMoneyToCard(Card card, Scanner scanner) {
        int putMoney = scanner.nextInt();
        if (putMoney > card.getLIMIT_CARD()) {
            LOGGER.info("Limit has exceeded.");
        } else {
            card.setCardBalance(card.getCardBalance() + putMoney);
            reader.writeInformation(card);
        }
    }

    public void getMoneyFromCard(Card card, Atm atm, Scanner scanner) {
        int getMoney = scanner.nextInt();
        if (getMoney > atm.getLIMIT_SUM_IN_ATM() || getMoney > card.getCardBalance()) {
            LOGGER.info("Incorrect transaction");
        } else {
            card.setCardBalance(card.getCardBalance() - getMoney);
            reader.writeInformation(card);
        }
    }
}
