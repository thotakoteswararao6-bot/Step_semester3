package string.assignment_problems12;

import java.util.*;

public class PocketCalculator {

    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    static String toPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : infix.toCharArray()) {

            if (Character.isDigit(ch)) {
                postfix.append(ch);
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    postfix.append(stack.pop());

                stack.pop();
            }

            else {
                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(ch))
                    postfix.append(stack.pop());

                stack.push(ch);
            }
        }

        while (!stack.isEmpty())
            postfix.append(stack.pop());

        return postfix.toString();
    }

    static int evaluate(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {

            if (Character.isDigit(ch))
                stack.push(ch - '0');
            else {
                int b = stack.pop();
                int a = stack.pop();

                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/':
                        if (b == 0)
                            throw new ArithmeticException("Division by zero");
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }
}
