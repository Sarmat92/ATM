package by.alexkas.validator;

import java.util.regex.Pattern;

public class PinCodeValidateImpl implements Validate<String> {

    private static final String VALID_PASSWORD_REGEX = "\\d{4}";

    @Override
    public boolean validate(String password) {
        return Pattern.matches(VALID_PASSWORD_REGEX, password);
    }
}
