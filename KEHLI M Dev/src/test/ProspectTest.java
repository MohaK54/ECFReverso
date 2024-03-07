package test;

import model.Prospect;
import model.modelException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe contient les tests unitaires pour la classe Prospect.
 */
class ProspectTest extends Prospect {

    /**
     * Teste la méthode setDateProspection avec une valeur null.
     *
     * @param i La date à tester.
     */
    @ParameterizedTest
    @NullSource
    void testSetDateProspection(LocalDate i) {
        assertThrows(modelException.class, () -> setDateProspection(i));
    }

    /**
     * Teste la méthode setInteret avec des valeurs invalides.
     *
     * @param i L'intérêt à tester.
     */
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"moha", "OUI"})
    void testSetInteret(String i) {
        assertThrows(modelException.class, () -> setInteret(i));
    }
}
