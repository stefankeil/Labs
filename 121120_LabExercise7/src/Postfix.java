public class Postfix {
	String finalResult;
	int rest;
	// private Stack stack;
	// der String muss leerzeichen zwischen den einzelnen term bzw. operatoren
	// enthalten

	public void evaluate(String pfx) throws UnderflowException {
		if (!pfx.equals("")) {
			Stack<Integer> ablage = new Stack<Integer>();
			String[] stringarray = pfx.split(" ");
			String operator;
			LinkedListItem<Integer> lhs;
			LinkedListItem<Integer> rhs;
			for (int i = 0; i < stringarray.length; i++) {
				if (stringarray[i].matches("(\\d{1,2})")) {
					ablage.push(Integer.parseInt(stringarray[i]));
				} else {
					operator = stringarray[i];
					if (!ablage.empty()) {
						rhs = ablage.pop();
						lhs = ablage.pop();
						if (operator.equals("+")) {
							int result = lhs.value + rhs.value;
							rest = 0;
							ablage.push(result);
						} else if (operator.equals("-")) {
							int result = lhs.value - rhs.value;
							rest = 0;
							ablage.push(result);
						} else if (operator.equals("*")) {
							int result = lhs.value * rhs.value;
							rest = 0;
							ablage.push(result);
						} else if (operator.equals("/")) {
							int result = lhs.value / rhs.value;
							 rest = lhs.value % rhs.value;
							ablage.push(result);
						}
					}
				}
			}
			System.out.println("Das Ergebnis lautet: " + ablage.pop().value);
			// return ablage.pop();

			finalResult =  ablage.pop().value.toString();			
		}
	}

	public String getFinalResult() {
		if (rest > 0){
			return finalResult + "  + Rest von: " + rest;
		} else {
			return finalResult;
		}
		
	}

	public String infixToPostfix(String ifx) throws UnderflowException {
		Stack<String> operatorAblage = new Stack<String>();
		String[] stringarray = ifx.split(" ");
		String numberString = "";
		LinkedListItem<String> operator;

		for (int i = 0; i < stringarray.length; i++) {
			if (stringarray[i].matches("(\\d)")) {
				numberString += stringarray[i] + " ";
			} else {
				operatorAblage.push(stringarray[i]);
				operator = operatorAblage.top();
				if (!operatorAblage.empty()) {
					if (operator.value.equals("+") || operator.value.equals("-")) {
						if (operator.pointer != null) {
							if (operator.pointer.value.equals("*")
									|| operator.pointer.value.equals("/")) {
								if (operator.pointer.pointer != null) {
									numberString += operator.pointer.value + " ";
									numberString += operator.pointer.pointer.value + " ";
									operatorAblage.pop();
									operatorAblage.pop();
								} else {
									numberString += operator.pointer.value + " ";
								}
							} else if (operator.value.equals(operator.pointer.value)) {
								numberString += operatorAblage.pop().value + " ";
							} else {
								numberString += operator.pointer.value + " ";
								operatorAblage.pop();
								operatorAblage.pop();
								operatorAblage.push(operator.value);
							}
						} else {
							continue;
						}
					} else if (operator.value.equals("*") || operator.value.equals("/")) {
						if (operator.pointer != null) {
							if (operator.pointer.value.equals("+") || operator.pointer.value.equals("-")) {
								continue;
							} else if (operator.value.equals(operator.pointer.value)) {
								numberString += operatorAblage.pop().value + " ";
							} else {
								numberString += operator.pointer.value + " ";
								operatorAblage.pop();
								operatorAblage.pop();
								operatorAblage.push(operator.value);
							}
						} else {
							continue;
						}
					} else {
						System.out.println("falsches Format");
					}
				}
			}
		}

		while (!operatorAblage.empty()) {
			numberString += operatorAblage.pop().value + " ";
		}

		System.out.println("Postfix: " + numberString);
		return numberString;
	}
}
