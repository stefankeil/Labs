
public class Stack<T> {
	
	private LinkedList<T> postfixStack;
	
	public Stack(){
		postfixStack = new LinkedList<T>();
	}
	
	public void push(T item){
		postfixStack.insert(item);
	}
	
	public LinkedListItem<T> pop(){
		if (!empty()){
		return postfixStack.delete();
		}else{
			return null;
		}
	}
	
	public boolean empty(){
		return postfixStack.isEmpty();
	}
	
	public void print(){
		postfixStack.print();
	}
	
	
}
