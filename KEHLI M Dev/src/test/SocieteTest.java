package test;

import model.Societe;
import model.modelException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe contient les tests unitaires pour la classe Societe.
 */
class SocieteTest extends Societe {

    //--------------------IDENTIFIANT-----------------------
    /**
     * Teste la méthode setIdentifiant avec des valeurs invalides.
     *
     * @param i L'identifiant à tester.
     */
    @ParameterizedTest
    @ValueSource(ints = {-5, -88})
    void testSetIdentifiantInvalid(int i) {
        assertThrows(modelException.class, () -> setIdentifiant(i));
    }

    /**
     * Teste la méthode setIdentifiant avec des valeurs valides.
     *
     * @param i L'identifiant à tester.
     */
    @ParameterizedTest
    @ValueSource(ints = {5, 88, 0})
    void testSetIdentifiantValid(int i) {
        assertDoesNotThrow(() -> setIdentifiant(i));
    }

    //--------------------RAISON SOCIAL-----------------------
    /**
     * Teste la méthode setRaisonSociale avec des valeurs invalides.
     *
     * @param i La raison sociale à tester.
     */
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"})
    void testSetRaisonSociale(String i) {
        assertThrows(modelException.class, () -> setRaisonSociale(i));
    }

    /**
     * Teste la méthode setRaisonSociale avec des valeurs valides.
     *
     * @param i La raison sociale à tester.
     */
    @ParameterizedTest
    @ValueSource(strings = {"0", "01234567890123456789012345678901234567890123456789"})
    void testSetRaisonSocialeValide(String i) {
        assertDoesNotThrow(() -> setRaisonSociale(i));
    }

    //--------------------NUMÉRO RUE-----------------------
    /**
     * Teste la méthode setNumeroRue avec des valeurs invalides.
     *
     * @param i Le numéro de rue à tester.
     */
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"123456"})
    void testSetNumeroRue(String i) {
        assertThrows(modelException.class, () -> setNumeroRue(i));
    }

    /**
     * Teste la méthode setNumeroRue avec des valeurs valides.
     *
     * @param i Le numéro de rue à tester.
     */
    @ParameterizedTest
    @ValueSource(strings = {"12345", "1"})
    void testSetNumeroRueValide(String i) {
        assertDoesNotThrow(() -> setNumeroRue(i));
    }

    //--------------------NOM RUE-----------------------
    /**
     * Teste la méthode setNomRue avec des valeurs invalides.
     *
     * @param i Le nom de rue à tester.
     */
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"0123456789012345678901234567891"})
    void testSetNomRue(String i) {
        assertThrows(modelException.class, () -> setNomRue(i));
    }

    /**
     * Teste la méthode setNomRue avec des valeurs valides.
     *
     * @param i Le nom de rue à tester.
     */
    @ParameterizedTest
    @ValueSource(strings = {"012345678901234567890123456789", "0"})
    void testSetNomRueValide(String i) {
        assertDoesNotThrow(() -> setNomRue(i));
    }

    //--------------------CODE POSTAL-----------------------
    /**
     * Teste la méthode setCodePostal avec des valeurs invalides.
     *
     * @param i Le code postal à tester.
     */
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"123456", "0123"})
    void testSetCodePostal(String i) {
        assertThrows(modelException.class, () -> setCodePostal(i));
    }

    /**
     * Teste la méthode setCodePostal avec des valeurs valides.
     *
     * @param i Le code postal à tester.
     */
    @ParameterizedTest
    @ValueSource(strings = {"12345", "abcde"})
    void testSetCodePostalValide(String i) {
        assertDoesNotThrow(() -> setCodePostal(i));
    }

    //--------------------VILLE-----------------------
    /**
     * Teste la méthode setVille avec des valeurs invalides.
     *
     * @param i La ville à tester.
     */
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"01234567890123456789012345678901234567890123456"})
    void testSetVille(String i) {
        assertThrows(modelException.class, () -> setVille(i));
    }

    /**
     * Teste la méthode setVille avec des valeurs valides.
     *
     * @param i La ville à tester.
     */
    @ParameterizedTest
    @ValueSource(strings = {"012345678901234567890123456789012345678901234", "1"})
    void testSetVilleValide(String i) {
        assertDoesNotThrow(() -> setVille(i));
    }

    //--------------------TELEPHONE-----------------------
    /**
     * Teste la méthode setTelephone avec des valeurs invalides.
     *
     * @param i Le numéro de téléphone à tester.
     */
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"012345678", "012345678901234567890124"})
    void testSetTelephone(String i) {
        assertThrows(modelException.class, () -> setTelephone(i));
    }

    /**
     * Teste la méthode setTelephone avec des valeurs valides.
     *
     * @param i Le numéro de téléphone à tester.
     */
    @ParameterizedTest
    @ValueSource(strings = {"0123456789", "01234567890123456789"})
    void testSetTelephoneValide(String i) {
        assertDoesNotThrow(() -> setTelephone(i));
    }

    //--------------------MAIL-----------------------
    /**
     * Teste la méthode setAdresseMail avec des valeurs invalides.
     *
     * @param i L'adresse e-mail à tester.
     */
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"moha.fr", "moha"})
    void testSetAdresseMail(String i) {
        assertThrows(modelException.class, () -> setAdresseMail(i));
    }

    /**
     * Teste la méthode setAdresseMail avec des valeurs valides.
     *
     * @param i L'adresse e-mail à tester.
     */
    @ParameterizedTest
    @ValueSource(strings = {"moha@fr", "moha@.fr"})
    void testSetAdresseMailValide(String i) {
        assertDoesNotThrow(() -> setAdresseMail(i));
    }
}
