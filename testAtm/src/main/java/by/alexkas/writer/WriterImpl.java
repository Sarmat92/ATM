package by.alexkas.writer;

import by.alexkas.bean.Card;
import by.alexkas.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class WriterImpl implements Writer {

    private final String FILE_NAME = ".cardInformation";

    @Override
    public void writeInformation(Card card) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(new Date() + " " + card.getCardNumber() + " " + card.getCardBalance() + " " + "\n");
        } catch (IOException e) {
            throw new CustomException("exception in write information" + e);
        }
    }
}
