package by.alexkas.writer;

import by.alexkas.bean.Card;

public interface Writer {

    void writeFile(Card card);
    void readFile(Card card);
}
