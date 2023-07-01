package br.com.projetoanimalsave.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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
