package by.epam.lesson8.task;

import java.util.Arrays;
import java.util.Collection;

public class MySet<T> {

	private int capacity;
	private Object[] myset;

	public MySet() {
		this.capacity = 0;
		this.myset = new Object[0];

	}

	public MySet(int capacity, Object[] tempset) {
		this.capacity = capacity;
		this.myset = tempset;
	}

	public MySet(Collection<? extends T> c) {

		this.myset = c.toArray();
		this.myset = removeDuplicates(this.myset);
		this.capacity = this.myset.length;

	}

	private static Object[] removeDuplicates(Object[] values) {
		boolean[] mask = new boolean[values.length];

		int removeCount = 0;

		for (int i = 0; i < values.length; i++) {
			Object tmp = values[i];

			for (int j = i + 1; j < values.length; j++) {
				if (tmp.equals(values[j])) {
					mask[j] = true;
				}
			}
		}

		for (int i = 0; i < mask.length; i++) {
			if (mask[i] == true) {
				removeCount++;
			}
		}

		Object[] result = new Object[values.length - removeCount];

		for (int i = 0, j = 0; i < values.length; i++) {
			if (!mask[i]) {
				result[j++] = values[i];
			}
		}

		return (result);

	}

	@Override
	public String toString() {
		return "MySet [capacity=" + capacity + ", myset=" + Arrays.toString(myset) + "]";
	}

	public int getcapacity() {
		return capacity;
	}

	public void setcapacity(int capacity) {
		this.capacity = capacity;
	}

	public Object[] getMySet() {
		return myset;
	}

	public void setMySet(Object[] myset) {
		this.myset = myset;
	}

	public boolean add(T newitem) {
		if (!this.contains(newitem)) {
			this.capacity = this.capacity + 1;
			myset = Arrays.copyOfRange(myset, 0, capacity);
			myset[capacity - 1] = newitem;
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + Arrays.hashCode(myset);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MySet<?> other = (MySet<?>) obj;
		if (capacity != other.capacity)
			return false;
		if (!Arrays.equals(myset, other.myset))
			return false;
		return true;
	}

	public boolean contains(Object obj) {

		if (obj == null) {
			return false;
		}
		for (Object b : myset) {
			if (obj.equals(b))
				return true;
		}
		return false;

	}

	public boolean remove(Object obj) {

		int pos = -1;
		Object[] tempset = new Object[myset.length - 1];

		if ((obj == null) || (!this.contains(obj))) {
			return false;
		} else {
			for (int i = 0; i < myset.length; i++) {
				if (myset[i].equals(obj)) {
					pos = i;
					this.capacity = this.capacity - 1;
					break;
				}
			}

			if (pos == 0) {
				System.arraycopy(myset, 1, tempset, 0, capacity);
			} else {
				if (pos == myset.length - 1) {
					System.arraycopy(myset, 0, tempset, 0, capacity);
				} else {
					System.arraycopy(myset, 0, tempset, 0, pos);
					System.arraycopy(myset, pos + 1, tempset, pos, capacity - pos);

				}
			}

			this.myset = tempset;
			return true;

		}
	}

}
