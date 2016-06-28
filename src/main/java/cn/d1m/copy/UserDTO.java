package cn.d1m.copy;

import java.io.Serializable;

/**
 * The Class UserDTO.
 */
public class UserDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2963408818099106614L;

	/** The id. */
	private long id;

	/** The username. */
	private String username;

	/** The creation date. */
	private String creationDate;

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
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/** 
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", creationDate=" + creationDate + "]";
	}

}