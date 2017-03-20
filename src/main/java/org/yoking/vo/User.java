package org.yoking.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 9080899354305067537L;

	private Long id;
	private String email;
	private String nickName;
	private char[] password;
	private Gender gender;

}