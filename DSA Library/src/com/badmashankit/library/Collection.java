/**
 * Copyright (C) 2017 Ankit Shukla, http://badmashankit.com
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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

	// Copied this from Java Source Code
	@Override
	public int hashCode() {
		int hashCode = 1;
		for (E e : this)
			hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
		return hashCode;
	}
}
