package org.javaee7.jax.rs.param.converter;

import org.javaee7.jax.rs.param.converter.Personn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class PersonnConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(final Class<T> rawType, final Type genericType,
                                              final Annotation[] annotations) {
        if (rawType.getName().equals(Personn.class.getName())) {
            return (ParamConverter<T>) new PersonnParamConverter();
        }
        return null;
    }

}