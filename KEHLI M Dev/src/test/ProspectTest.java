package test;

import model.Prospect;
import model.modelException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProspectTest extends Prospect {

    @ParameterizedTest
    @NullSource
    void testSetDateProspection(LocalDate i) {
        assertThrows(modelException.class,()->setDateProspection(i));
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"moha","OUI"} )
    void testSetInteret(String i) {
        assertThrows(modelException.class,()->setInteret(i));
    }
}