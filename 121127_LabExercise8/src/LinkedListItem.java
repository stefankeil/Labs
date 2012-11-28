
public class LinkedListItem<T> {
	public T value;
	public LinkedListItem<T> pointer;
	public int priority;
	
	public LinkedListItem(T input) {
		value = input;
	}
}

