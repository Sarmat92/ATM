package by.alexkas.writer;

import by.alexkas.bean.Card;
import by.alexkas.exception.CustomException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class WriterImpl implements Writer {

    @Override
    public void writeInformation(Card card) {
        try (FileWriter writer = new FileWriter(".cardInformation", true)) {
            writer.write(new Date() + " " + card.getCardNumber() + " " + card.getCardBalance() + " " + "\n");
        } catch (IOException e) {
            throw new CustomException("exception");
        }
    }
}
