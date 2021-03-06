package ch.hslu.ad.sw03.D2.Aufg5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Stellt die Implementation der einzelnen Knoten im binären Suchbaum dar.
 * 
 * @author jabbathegut
 *
 */
public class Node implements Comparable<Node> {
	private static final Logger LOG = LogManager.getLogger(Node.class);

	private int value;
	private Node left;
	private Node right;

	public Node(int value) {
		this.value = value;
	}

	public Node(int value, Node left, Node right) {
		new Node(value);
		this.left = left;
		this.right = right;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return this.value;
	}

	/**
	 * Fuegt einen neuen Kind-Knoten ein. Falls der Wert groesser ist, dann rechts,
	 * falls der Wert kleiner ist, dann links.
	 * 
	 * @param value
	 *            Wert des Kind-Knotens
	 */
	public void addSubnode(int value) {
		if (value < this.value) {
			this.setLeft(new Node(value));
		} else {
			this.setRight(new Node(value));
		}
	}

	private void setLeft(Node left) {
		this.left = left;
	}

	private void setRight(Node right) {
		this.right = right;
	}

	/**
	 * Methode, welche den Kind-Knoten des aktuellen Knotens zurueck gibt, den
	 * linken wenn der Wert kleiner ist und den rechten wenn er groesser ist. Wird
	 * bei der Suche gebraucht
	 * 
	 * @param value
	 *            Wert
	 * @return Kind-Knoten
	 */
	public Node subNode(int value) {
		if (value < this.value) {
			return this.left;
		} else {
			return this.right;
		}
	}

	public Node goLeft() {
		return this.left;
	}

	public Node goRight() {
		return this.right;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj instanceof Node) {
			Node node = (Node) obj;
			if (node.getValue() == this.value) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Node node) {
		if (this.equals(node)) {
			return 0;
		} else if (this.getValue() > node.getValue()) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Knoten mit Wert: " + this.value;
	}
}
