package org.rangiffler.jupiter.extension;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.rangiffler.model.UserJson;

import java.io.IOException;

public class ClasspathUserConverter implements ArgumentConverter {

    private final ClassLoader cl = ClasspathUserConverter.class.getClassLoader();
    private static final ObjectMapper om = new ObjectMapper();

    @Override
    public UserJson convert(Object source, ParameterContext context)
            throws ArgumentConversionException {
        if (source instanceof String stringSource) {
            try {
                return om.readValue(cl.getResourceAsStream(stringSource), UserJson.class);
            } catch (IOException e) {
                throw new ArgumentConversionException(e.getMessage());
            }
        } else {
            throw new ArgumentConversionException("Only string source supported!");
        }
    }
}
