
public class Main {

	/**
	 * @param args
	 * @throws UnderflowException 
	 */
	public static void main(String[] args) throws UnderflowException {
		Stack<String> stack = new Stack<String>();
		Postfix postfix = new Postfix();		
		
		String postfixString = postfix.infixToPostfix("4 + 4 + 5 / 5 * 9 - 3");
		postfix.evaluate(postfixString);
		
//		Gui gui = new Gui(postfix);
//		stack.push("abdes");
//		stack.push("c");
//		
//		stack.top();
	}

}
