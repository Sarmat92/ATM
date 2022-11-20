package by.alexkas.service;

import by.alexkas.bean.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class LoginServiceTest {
//
//    Scanner scanner;
//    LoginService loginService;
//    Card card;
//
//    @Before
//    public void setUp() {
//        this.loginService = new LoginService();
//        this.card = getCard();
//        this.scanner = new Scanner(System.in);
//        Assert.assertEquals(3, card.getInputErrorAttempts());
//        Assert.assertFalse(card.isBlocked());
//    }
//
//    @Test
//    public void checkPinCode_positive() {
//        boolean actualResultPin = loginService.checkCardPin(card, scanner.nextLine());
//        Assert.assertTrue(actualResultPin);
//    }
//
//    @Test
//    public void checkPinCode_negative() {
//        boolean actualResult = loginService.checkCardPin(card, scanner.nextLine());
//        Assert.assertFalse(actualResult);
//    }
//
//    @Test
//    public void checkCardNumber_positive() {
//        boolean actualResultCardNumber = loginService.checkCardNumber(card, scanner.nextLine());
//        Assert.assertTrue(actualResultCardNumber);
//    }
//
//    @Test
//    public void checkCardNumber_negative() {
//        boolean actualResultCardNumber = loginService.checkCardNumber(card, scanner.nextLine());
//        Assert.assertFalse(actualResultCardNumber);
//    }
//
//    @Test
//    public void reduceLoginAttempts() {
//        loginService.reduceLoginAttempts(card);
//        Assert.assertEquals(2, card.getInputErrorAttempts());
//    }
//
//    @Test
//    public void login_positive() {
//        boolean pinCodeResult = loginService.login(card, scanner);
//        boolean cardNumberResult = loginService.login(card, scanner);
//        boolean actualResult = pinCodeResult || cardNumberResult;
//        Assert.assertTrue(actualResult);
//    }
//
//    @Test
//    public void login_negative() {
//        boolean pinCodeResult = loginService.login(card, scanner);
//        boolean cardNumberResult = loginService.login(card, scanner);
//        boolean actualResult = pinCodeResult || cardNumberResult;
//        Assert.assertFalse(actualResult);
//    }
//
//    @Test
//    public void blockCard(){
//        loginService.blockCard(card);
//        Assert.assertTrue(card.isBlocked());
//    }
//
//    @Test
//    public void afterThreeWrongInput_ShouldBlockCard(){
//        String userInput = "wrong";
//        loginService.login(card, scanner);
//    }
//
//
//    private static Card getCard() {
//        Card card = new Card();
//        card.setPinCode("1234");
//        card.setCardNumber("1111-2222");
//        return card;
//    }
}