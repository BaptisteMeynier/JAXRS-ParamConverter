package org.javaee7.jax.rs.param.converter;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/api")
public class PersonnApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(PersonnEndpoint.class);
        s.add(PersonnConverterProvider.class);
        return s;
    }
}
