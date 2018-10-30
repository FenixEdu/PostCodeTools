package org.fenixedu;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PostalCodeValidator {

    private static Map<String, JsonObject> validatorMap = new HashMap<>();

    static {
        try (final InputStream stream = PostalCodeValidator.class.getResourceAsStream("/postal-codes.json");
                final InputStreamReader reader = new InputStreamReader(stream)) {
            final JsonArray array = new JsonParser().parse(reader).getAsJsonArray();
            array.forEach(je -> {
                final JsonObject validator = je.getAsJsonObject();
                final String countryCode = validator.get("ISO").getAsString();
                validatorMap.put(countryCode, validator);
            });
        } catch (final IOException e) {
            throw new Error(e);
        }
    }

    public static boolean isValidAreaCode(final String countryCode, final String postCode) {
        final String regex = fieldFor(countryCode, "Regex");
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(postCode);
        return matcher.matches();
    }

    public static String examplePostCodeFor(final String countryCode) {
        return fieldFor(countryCode, "Example");
    }

    public static String formatFor(final String countryCode) {
        return fieldFor(countryCode, "Format");
    }

    private static String fieldFor(final String countryCode, final String field) {
        final JsonObject validator = validator(countryCode);
        final JsonElement exJo = validator.get(field);
        return exJo == null || exJo.isJsonNull() ? null : exJo.getAsString();
    }

    private static JsonObject validator(final String countryCode) {
        final JsonObject validator = validatorMap.get(countryCode);
        if (validator == null) {
            throw new Error("No validator for contry code: " + countryCode);
        }
        return validator;
    }

}
