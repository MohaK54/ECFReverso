package test;

import model.Societe;

import model.modelException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


class SocieteTest extends Societe {

    //--------------------IDENTIFIANT-----------------------
    @ParameterizedTest
    @ValueSource(ints = {-5,-88} )
    void testSetIdentifiantInvalid(int i) {
        assertThrows(modelException.class, ()-> setIdentifiant(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {5,88,0} )
    void testSetIdentifiantValid(int i) {
        assertDoesNotThrow(()-> setIdentifiant(i));
    }

    //--------------------RAISON SOCIAL-----------------------
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"} )
    void testSetRaisonSociale(String i) {
        assertThrows(modelException.class, ()-> setRaisonSociale(i));
    }
    @ParameterizedTest
    @ValueSource(strings = {"0","01234567890123456789012345678901234567890123456789"} )
    void testSetRaisonSocialeValide(String i) {
        assertDoesNotThrow(()-> setRaisonSociale(i));
    }

    //--------------------NUMÉRO RUE-----------------------
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"123456"} )
    void testSetNumeroRue(String i) {
        assertThrows(modelException.class,()->setNumeroRue(i));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345","1"} )
    void testSetNumeroRueValide(String i) {
        assertDoesNotThrow(()->setNumeroRue(i));
    }

    //--------------------NOM RUE-----------------------
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"0123456789012345678901234567891"} )
    void testSetNomRue(String i) {
        assertThrows(modelException.class,()->setNomRue(i));
    }

    @ParameterizedTest
    @ValueSource(strings = {"012345678901234567890123456789","0"} )
    void testSetNomRueValide(String i) {
        assertDoesNotThrow(()->setNomRue(i));
    }

    //--------------------CODE POSTAL-----------------------
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"123456","0123"} )
    void testSetCodePostal(String i) {
        assertThrows(modelException.class,()->setCodePostal(i));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345","abcde"} )
    void testSetCodePostalValide(String i) {
        assertDoesNotThrow(()->setCodePostal(i));
    }

    //--------------------VILLE-----------------------
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"01234567890123456789012345678901234567890123456"} )
    void testSetVille(String i) {
        assertThrows(modelException.class,()->setVille(i));
    }

    @ParameterizedTest
    @ValueSource(strings = {"012345678901234567890123456789012345678901234","1"} )
    void testSetVilleValide(String i) {
        assertDoesNotThrow(()->setVille(i));
    }

    //--------------------TELEPHONE-----------------------
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"012345678","012345678901234567890124"} )
    void testSetTelephone(String i) {
        assertThrows(modelException.class,()->setTelephone(i));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0123456789","01234567890123456789"} )
    void testSetTelephoneValide(String i) {
        assertDoesNotThrow(()->setTelephone(i));
    }

    //--------------------MAIL-----------------------

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"moha.fr","moha"} )
    void testSetAdresseMail(String i) {
        assertThrows(modelException.class,()->setAdresseMail(i));
    }

    @ParameterizedTest
    @ValueSource(strings = {"moha@fr","moha@.fr"} )
    void testSetAdresseMailValide(String i) {
        assertDoesNotThrow(()->setAdresseMail(i));
    }
}