package by.alexkas.validator;

import java.util.regex.Pattern;

public class CardNumberValidatorImpl implements Validate<String> {

    private static final String VALID_PASSWORD_REGEX = "\\d{8}";

    @Override
    public boolean validate(String number) {
        return Pattern.matches(VALID_PASSWORD_REGEX, number);
    }
}
