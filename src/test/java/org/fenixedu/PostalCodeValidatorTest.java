package org.fenixedu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostalCodeValidatorTest {

    @Before
    public void setup() {
        PostalCodeValidator.loadDefaultPostCodes();
    }

    @Test
    public void testMapIsLoaded() {
        assertFalse(PostalCodeValidator.getValidatorMap().isEmpty());
    }

    @Test
    public void testLoadDifferentJsonFile() {
        PostalCodeValidator.reloadPostCodes(getClass().getResourceAsStream("/single-postal-codes.json"));
        assertEquals(1, PostalCodeValidator.getValidatorMap().size());
    }

    @Test
    public void testExampleRegex() {
        PostalCodeValidator.getValidatorMap().values().forEach(p -> {
            String country = p.get("ISO").getAsString();
            String example = p.get("Example").getAsString();
            assertTrue(String.format("Example does not match for country \"%s\"", country), PostalCodeValidator.isValidAreaCode(country, example));
        });
    }

}