package atm;

public class Login {

    public void login(String nr, String pw) {

        if (nr != "" && pw != "") {
            System.out.println("oky");
        } else {
            System.out.println("not valid");
        }
    }
}
