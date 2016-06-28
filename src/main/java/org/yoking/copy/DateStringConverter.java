package org.yoking.copy;


import java.util.Date;

import org.apache.commons.beanutils.Converter;
import org.yoking.utils.DateUtils;

public class DateStringConverter implements Converter {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> type, Object value) {
		if(type.equals(Date.class) && String.class.isInstance(value)) {
			return (T)DateUtils.convert((String)value);
		} else if(type.equals(String.class) && Date.class.isInstance(value)){
			return (T)DateUtils.format((Date)value);
		} else {
			return (T)value;
		}
	}

}