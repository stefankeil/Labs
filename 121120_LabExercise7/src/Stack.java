public class Stack<T> {

	private LinkedList<T> postfixStack;

	public Stack() {
		postfixStack = new LinkedList<T>();
	}

	public void push(T item) {
		postfixStack.insert(item);
	}

	public boolean empty() {
		return postfixStack.isEmpty();
	}

	public void print() {
		postfixStack.print();
	}

	public LinkedListItem<T> pop() throws UnderflowException {
		if (!empty()) {
			return postfixStack.delete();
		} else {
			throw new UnderflowException("ListStack pop");
		}
	}

	public void top() throws UnderflowException {
		if (!empty()) {
			postfixStack.top();
		} else {
			throw new UnderflowException("Stack Underflow");
		}
	}

}
