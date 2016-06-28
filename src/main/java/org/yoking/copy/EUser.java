package org.yoking.copy;

import java.io.Serializable;
import java.util.Date;

public class EUser implements Serializable {
	private static final long serialVersionUID = -692192937932555368L;

	/** The id. */
	private long id;

	/** The username. */
	private String username;

	/** The creation date. */
	private Date creationDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "EUser [id=" + id + ", username=" + username + ", creationDate=" + creationDate + "]";
	}

}
