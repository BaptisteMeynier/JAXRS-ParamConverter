package org.javaee7.jax.rs.param.converter;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;




@ApplicationPath("/api")
public class Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(PeopleEndpoint.class);
        return s;
    }
}
