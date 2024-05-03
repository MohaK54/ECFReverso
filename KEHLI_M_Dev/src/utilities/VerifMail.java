package utilities;

/**
 * Cette classe fournit une méthode pour vérifier la validité d'une adresse e-mail.
 */
public class VerifMail {

    /**
     * Vérifie si une adresse e-mail est valide.
     *
     * @param email L'adresse e-mail à vérifier.
     * @return true si l'adresse e-mail est valide, false sinon.
     */
    public static Boolean validMail(String email) {
        return email != null && email.matches(".*@.*");
    }
}
