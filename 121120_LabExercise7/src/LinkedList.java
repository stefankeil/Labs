 public class LinkedList<T> {
	private LinkedListItem<T> first;

	public LinkedList() {
		first = null;
	}

	public boolean isEmpty() {
		if (first == null) {
			return true;
		} else {
			return false;
		}
	}

	public void insert(T input) {
		LinkedListItem<T> item = new LinkedListItem<T>(input);
		item.pointer = first;
		first = item;
	}

	public LinkedListItem<T> delete() {
		if (!isEmpty()) {
			LinkedListItem<T> item = first;
			first = first.pointer;
			return item;
		} else {
			return null;
		}
	}

	public void print() {
		LinkedListItem<T> item = this.delete();
		while (item != null) {
			System.out.println("Element: " + item.value);
			item = this.delete();
		}
	}
}
