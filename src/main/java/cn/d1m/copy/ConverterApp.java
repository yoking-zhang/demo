package cn.d1m.copy;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

public class ConverterApp {

	public static void main(String[] args) {
		entity2Dto();
		
		dto2Entity();
	}
	
	private static void entity2Dto() {
		EUser u = new EUser();
		u.setId(1l);
		u.setUsername("yoking");
		u.setCreationDate(new Date(System.currentTimeMillis()));
		
		UserDTO user = new UserDTO();
		
		ConvertUtils.register(new DateStringConverter(), String.class);
		try {
			BeanUtils.copyProperties(user, u);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println(user);
	}
	
	private static void dto2Entity() {
		UserDTO user = new UserDTO();
		user.setId(1l);
		user.setUsername("joking");
		user.setCreationDate("2016-04-20");
		
		EUser u = new EUser();
		ConvertUtils.register(new DateStringConverter(), Date.class);
		try {
			BeanUtils.copyProperties(u, user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println(u);
	}

}