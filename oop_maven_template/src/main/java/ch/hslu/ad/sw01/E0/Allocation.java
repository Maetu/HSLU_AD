package ch.hslu.ad.sw01.E0;

import java.util.Objects;

public final class Allocation implements Comparable<Allocation> {

	private int size;
	private int address;

	public Allocation(final int address, final int size) {
		this.size = size;
		this.address = address;
	}

	public int getSize() {
		return this.size;
	}

	public int getAddress() {
		return this.address;
	}

	@Override
	public String toString() {
		return "Allocation[Address: " + this.getAddress() + "; Size: " + this.getSize() + "]";
	}

	/**
	 * Der Hash-Code wird aufgrund der Adresse generiert
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.getAddress());
	}

	/**
	 * Zwei Allocation-Objekte sind gleich, wenn sie die selben Objekte sind oder
	 * wenn sie von der selben Klasse sind und die selbe Adresse haben
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Allocation) {
			final Allocation alloc = (Allocation) obj;
			if (alloc.getAddress() == this.getAddress()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Zwei Allocation-Objekte werden aufgrund ihrer Groesse verglichen
	 */
	@Override
	public int compareTo(Allocation o) {
		return Integer.compare(this.size, o.getSize());
	}
}
