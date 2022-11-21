package by.alexkas.bean;

import java.util.Objects;

public class Card {

    private String pinCode;
    private String cardNumber;
    private boolean isBlocked;
    private long cardBalance;
    private int inputErrorAttempts = 3;
    final int LIMIT_CARD = 1_000_000;

    public Card() {
        this.pinCode = "1234";
        this.cardNumber = "1111222233334444";
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public long getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(long cardBalance) {
        this.cardBalance = cardBalance;
    }

    public int getInputErrorAttempts() {
        return inputErrorAttempts;
    }

    public void setInputErrorAttempts(int inputErrorAttempts) {
        this.inputErrorAttempts = inputErrorAttempts;
    }

    public int getLIMIT_CARD() {
        return LIMIT_CARD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return isBlocked == card.isBlocked && cardBalance == card.cardBalance &&
                inputErrorAttempts == card.inputErrorAttempts && Objects.equals(pinCode, card.pinCode) &&
                Objects.equals(cardNumber, card.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pinCode, cardNumber, isBlocked, cardBalance, inputErrorAttempts);
    }

    @Override
    public String toString() {
        return "Card{" +
                "pinCod='" + pinCode + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", isActive=" + isBlocked +
                ", cardBalance=" + cardBalance +
                ", countInputErrorAttempts=" + inputErrorAttempts +
                '}';
    }
}
