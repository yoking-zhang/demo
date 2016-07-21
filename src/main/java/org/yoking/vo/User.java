package org.yoking.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * The Class User.
 */
public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9080899354305067537L;

	/** The id. */
	private long id;

	/** The email. */
	private String email;

	/** The nick name. */
	private String nickName;

	/** The password. */
	private char[] password;

	/**
	 * Instantiates a new user.
	 */
	public User() {

	}

	/**
	 * Instantiates a new user.
	 *
	 * @param id
	 *            the id
	 * @param email
	 *            the email
	 * @param nickName
	 *            the nick name
	 * @param password
	 *            the password
	 */
	public User(long id, String email, String nickName, char[] password) {
		this.id = id;
		this.email = email;
		this.nickName = nickName;
		this.password = password;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the nick name.
	 *
	 * @return the nick name
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Sets the nick name.
	 *
	 * @param nickName
	 *            the new nick name
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public char[] getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(char[] password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nickName=" + nickName + ", password=" + Arrays.toString(password) + "]";
	}

	/** 
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.email, this.nickName, this.password);
	}

	/** 
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User o = (User) obj;
		return Objects.equals(this.id, o.id) && Objects.equals(this.email, o.email) 
				&& Objects.equals(this.nickName, o.nickName) && Objects.equals(this.password, o.password);
	}

}