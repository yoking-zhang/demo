package org.yoking.pattern.builder;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class Car.
 */
public class Car implements Serializable {
	private static final long serialVersionUID = -6578456998838464774L;

	/** The id. */
	private long id;

	/** The color. */
	private Color color;

	/** The manufacturer. */
	private String manufacturer;

	/** The date. */
	private Date date;

	/**
	 * Instantiates a new car.
	 *
	 * @param b the b
	 */
	private Car(Builder b) {
		this.id = b.id;
		this.color = b.color;
		this.manufacturer = b.manufacturer;
		this.date = b.date;
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
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Gets the manufacturer.
	 *
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/** 
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [id=" + id + ", color=" + color + ", manufacturer=" + manufacturer + ", date=" + date + "]";
	}

	/**
	 * The Class Builder.
	 */
	public static class Builder {
		
		/** The id. */
		private long id;
		
		/** The color. */
		private Color color;
		
		/** The manufacturer. */
		private String manufacturer;
		
		/** The date. */
		private Date date;

		/**
		 * Id.
		 *
		 * @param id the id
		 * @return the builder
		 */
		public Builder id(long id) {
			this.id = id;
			return this;
		}

		/**
		 * Color.
		 *
		 * @param color the color
		 * @return the builder
		 */
		public Builder color(Color color) {
			this.color = color;
			return this;
		}

		/**
		 * Manufacturer.
		 *
		 * @param manufacturer the manufacturer
		 * @return the builder
		 */
		public Builder manufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
			return this;
		}

		/**
		 * Date.
		 *
		 * @param date the date
		 * @return the builder
		 */
		public Builder date(Date date) {
			this.date = date;
			return this;
		}

		/**
		 * Builds the.
		 *
		 * @return the car
		 */
		public Car build() {
			return new Car(this);
		}
	}

}