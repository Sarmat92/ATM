package by.alexkas.writer;

import by.alexkas.bean.Card;
import by.alexkas.exception.CustomException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class WriterImpl implements Writer {

    private final String FILE_NAME = ".cardInformation";

    @Override
    public void writeFile(Card card) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(new Date() + " " + card.getCardNumber() + " " + card.getCardBalance() + " " + "\n");
        } catch (IOException e) {
            throw new CustomException("exception in write information" + e);
        }
    }

    @Override
    public void readFile(Card card) {
        if (checkExistsFile()) {
            String str = "";
            try (FileReader reader = new FileReader(FILE_NAME);
                 Scanner scanner = new Scanner(reader)) {
                while (scanner.hasNextLine()) {
                    str = scanner.nextLine();
                }
                String[] array = str.split(" ");
                card.setCardBalance(Long.parseLong(array[array.length - 1]));
            } catch (Exception e) {
                throw new CustomException("File isn't exists " + e);
            }
        }
    }

    private boolean checkExistsFile() {
        File file = new File(FILE_NAME);
        return file.exists();
    }
}
