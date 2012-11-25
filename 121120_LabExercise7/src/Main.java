
public class Main {

	/**
	 * @param args
	 * @throws UnderflowException 
	 * @throws FormatException 
	 */
	public static void main(String[] args) throws UnderflowException, FormatException {
//		Stack<String> stack = new Stack<String>();
		Postfix postfix = new Postfix();		
		
//		String postfixString = postfix.infixToPostfix("4 + 4+5");
//		postfix.evaluate(postfixString);
		
		Gui gui = new Gui(postfix);
//		stack.push("abdes");
//		stack.push("c");
//		stack.top();
	}

}
