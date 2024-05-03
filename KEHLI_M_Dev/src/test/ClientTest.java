package test;

import model.Client;
import model.modelException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe contient les tests unitaires pour la classe Client.
 */
class ClientTest extends Client {

    /**
     * Teste la méthode setChiffreDaffaire avec des valeurs invalides.
     *
     * @param i La valeur à tester.
     */
    @ParameterizedTest
    @ValueSource(doubles = {0, 199.9, -2000})
    void testSetChiffreDaffaire(double i) {
        assertThrows(modelException.class, () -> setChiffreDaffaire(i));
    }

    /**
     * Teste la méthode setChiffreDaffaire avec des valeurs valides.
     *
     * @param i La valeur à tester.
     */
    @ParameterizedTest
    @ValueSource(doubles = {200.1, 2500})
    void testSetChiffreDaffaireValide(double i) {
        assertDoesNotThrow(() -> setChiffreDaffaire(i));
    }

    /**
     * Teste la méthode setNombreEmployer avec des valeurs invalides.
     *
     * @param i Le nombre d'employés à tester.
     */
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void testSetNombreEmployer(int i) {
        assertThrows(modelException.class, () -> setNombreEmployer(i));
    }

    /**
     * Teste la méthode setNombreEmployer avec des valeurs valides.
     *
     * @param i Le nombre d'employés à tester.
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2500})
    void testSetNombreEmployerValide(int i) {
        assertDoesNotThrow(() -> setNombreEmployer(i));
    }
}
