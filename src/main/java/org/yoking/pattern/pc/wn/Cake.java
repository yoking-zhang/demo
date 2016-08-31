package org.yoking.pattern.pc.wn;

import java.io.Serializable;

/**
 * The Class Cake.
 */
public class Cake implements Serializable {
	private static final long serialVersionUID = 2175622923578918645L;
	
	/** The id. */
	private long id;
	
	/** The name. */
	private String name;

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
	public Cake id(long id) {
		this.id = id;
		return this;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public Cake name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cake [id=" + id + ", name=" + name + "]";
	}

}