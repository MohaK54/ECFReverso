package utilities;

public class VerifMail {

    public static Boolean validMail(String email){
        return email!=null && email.matches(".*@.*");
    }
}
