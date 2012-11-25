
public class Main {

	/**
	 * @param args
	 * @throws UnderflowException 
	 */
	public static void main(String[] args) throws UnderflowException {
		Stack<String> stack = new Stack<String>();
		Postfix postfix = new Postfix();		
		
		String postfixString = postfix.infixToPostfix("1 + 2 + 3 / 4 + 5 + 6");
		postfix.evaluate(postfixString);
		
		Gui gui = new Gui(postfix);
//		stack.push("abdes");
//		stack.push("c");
//		
//		stack.top();
	}

}
