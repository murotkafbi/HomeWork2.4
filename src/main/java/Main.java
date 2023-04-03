public class Main {
    public static void main(String[] args) {

         boolean result = Validator.validate("teSt_1234", "D_1hWikjjP_92", "D_1hW1ikjjp_9");
        if (result) {
            System.out.println("Логин  и пароль корректные");
        }
    }
}

