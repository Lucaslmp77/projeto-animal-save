package br.com.projetoanimalsave.Service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenerateCodeServiceTest {

    @Test
    void testGenerateCode() {
        int length = 10;

        String code = GenerateCodeService.generateCode(length);

        assertNotNull(code);
        assertEquals(length, code.length());
        assertTrue(code.matches("[A-Za-z0-9]+"));
    }

    @Test
    void testGenerateCodeWithZeroLength() {
        int length = 0;

        String code = GenerateCodeService.generateCode(length);

        assertNotNull(code);
        assertEquals(0, code.length());
    }

    @Test
    void testGenerateCodeWithNegativeLength() {
        int length = -5;

        String code = GenerateCodeService.generateCode(length);

        assertNotNull(code);
        assertEquals(0, code.length());
    }
}
