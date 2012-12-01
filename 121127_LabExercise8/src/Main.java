
public class Main {

	/**
	 * @param args
	 * @throws FormatException 
	 * @throws UnderflowException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, UnderflowException, FormatException {
		Calculator calculator = new Calculator();
		Postfix postfix = new Postfix();
		String str = postfix.infixToPostfix("1 * 2 + 3");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("1 + 2 * 3");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("1 + 2 - 3 ^ 4");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("1 ^ 2 - 3 * 4");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("1 + 2 * 3 - 4 ^ 5 + 6");
		System.out.println(postfix.evaluate(str));
//		str = postfix.infixToPostfix("( 1 + 2 ) * 3 + 4 ^ ( 5 - 6 )");
//		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("1 + 2 + 3 / 4 + 5 + 6 * 7 + 8");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("9 - 1 - 2 - 3 * 2 - 1");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("9 * 3 ^ 2 - 1");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("9 * 3 ^ 2 ^ 2");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("9 * 3 ^ 2 ^ 2 ^ 2");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("9 * 3 ^ 2 ^ 2 ^ 2 ^ 2");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("9 * 3 ^ 2 ^ 2 ^ 2 ^ 2 ^ 2");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("34 ^ 2 + 3 * 11");
		System.out.println(postfix.evaluate(str));
		str = postfix.infixToPostfix("30 / 10 * 2 ^ 3");
		System.out.println(postfix.evaluate(str));
	}

}
