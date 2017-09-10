package com.badmashankit.library;

import java.util.Iterator;

public abstract class Collection<E> implements Iterable<E> {
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		Iterator<E> iterator = this.iterator();
		Iterator<E> iterator2 = ((Collection<E>) obj).iterator();
		while (iterator.hasNext() && iterator2.hasNext()) {
			E element = iterator.next();
			E element2 = iterator2.next();
			if (element == null) {
				if (element2 != null)
					return false;
			} else if (!element.equals(element2))
				return false;
		}
		return !(iterator.hasNext() || iterator2.hasNext());
	}
}
