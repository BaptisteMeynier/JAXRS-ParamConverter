

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
            return new ParamConverter<T>() {

                @Override
                public T fromString(String value) {
                    Personn myBean = new Personn();
                    String[] split = value.split(",");
                    myBean.setName(split[0]);
                    myBean.setAge(Integer.parseInt(split[1]));

                    return rawType.cast(myBean);
                }

                @Override
                public String toString(T myBean) {
                    if (myBean == null) {
                        return null;
                    }
                    return myBean.toString();
                }
            };
        }
        return null;
    }

}