package test;

import model.Client;
import model.modelException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest extends Client {

    @ParameterizedTest
    @ValueSource(doubles = {0,199.9,-2000} )
    void testSetChiffreDaffaire(double i) {
        assertThrows(modelException.class,()->setChiffreDaffaire(i));
    }

    @ParameterizedTest
    @ValueSource(doubles = {200.1,2500} )
    void testSetChiffreDaffaireValide(double i) {
        assertDoesNotThrow(()->setChiffreDaffaire(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1} )
    void testSetNombreEmployer(int i) {
        assertThrows(modelException.class,()->setNombreEmployer(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2500} )
    void testSetNombreEmployerValide(int i) {
        assertDoesNotThrow(()->setNombreEmployer(i));
    }
}