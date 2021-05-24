package t1u7a1n2.commands;

import t1u7a1n2.flat.Flat;

/**
 * Interface to mark classes who need to receive an element
 */
public interface ElementNeed {
	abstract void setFlatElement(Flat flat);
}
