package by.alexkas.bean;

import java.util.Objects;

public class Atm {

    final int LIMIT_SUM_IN_ATM = 50_000_000;

    public Atm() {
    }

    public int getLIMIT_SUM_IN_ATM() {
        return LIMIT_SUM_IN_ATM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atm atm = (Atm) o;
        return LIMIT_SUM_IN_ATM == atm.LIMIT_SUM_IN_ATM;
    }

    @Override
    public int hashCode() {
        return Objects.hash(LIMIT_SUM_IN_ATM);
    }

    @Override
    public String toString() {
        return "Atm{" +
                "LIMIT_SUM_IN_ATM=" + LIMIT_SUM_IN_ATM +
                '}';
    }
}
