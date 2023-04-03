import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Validator {
    private Validator() {

    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Длинна логина  должна быть меньше или ровна 20!");
        }
        if (Objects.isNull(password) || password.length() >= 20) {
            throw new WrongPasswordException("Длинна пароля  должна быть меньше или ровна 20!");
        }
        if (password.equals(confirmPassword)) {
            throw new WrongLoginException("Пароли должны совпадать! ");
        }
        Checker checker = ThreadLocalRandom.current().nextBoolean() ? new LoopChecker() : new RegexChecker();
        if (!checker.isValid(login)) {
            throw new WrongLoginException("Логин содержит  некорректный символы!");

        }
        if (!checker.isValid(password)) {
            throw new WrongPasswordException("Пароль содержит  некорректный символы!");

        }

    }
}



