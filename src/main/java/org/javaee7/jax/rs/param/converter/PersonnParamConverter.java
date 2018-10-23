package org.javaee7.jax.rs.param.converter;

import javax.ws.rs.ext.ParamConverter;

public class PersonnParamConverter implements ParamConverter<Personn> {

	@Override
	public Personn fromString(String value) {
		  Personn myBean = new Personn();
	        String[] split = value.split(",");
	        myBean.setName(split[0]);
	        myBean.setAge(Integer.parseInt(split[1]));

	        return myBean;
	}

	@Override
	public String toString(Personn value) {
		 if (value == null) {
             return null;
         }
         return value.toString();
	}

}
