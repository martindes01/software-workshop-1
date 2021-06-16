package com.bham.pij.assignments.calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Calculator
 *
 * @author Martin de Spirlet
 */
public class Calculator {

    private static final String CLEAR = "c";
    private static final String HISTORY = "h";
    private static final String MEMORY = "m";
    private static final String MEMORY_RECALL = "mr";
    private static final String QUIT = "quit";
    private static final String INVALID_MESSAGE = "Invalid input.";
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";
    private static final String LEFT_PAR = "(";
    private static final String RIGHT_PAR = ")";
    private static final String OPERATORS = "+-*/";
    private static final int NIL_PRECEDENCE = 0;
    private static final int ADD_PRECEDENCE = 1;
    private static final int SUB_PRECEDENCE = 1;
    private static final int MUL_PRECEDENCE = 2;
    private static final int DIV_PRECEDENCE = 2;

    private float currentValue;
    private float memoryValue;
    private ArrayList<Float> history;
    private ArrayList<Float> operandStack;
    private ArrayList<String> operatorStack;

    public Calculator() {
        history = new ArrayList<>();
        operandStack = new ArrayList<>();
        operatorStack = new ArrayList<>();
        clearCurrent();
        clearMemory();
    }

    /**
     * Resets current value to zero.
     */
    private void clearCurrent() {
        setCurrentValue(0);
    }

    /**
     * Resets memory value to zero.
     */
    public void clearMemory() {
        setMemoryValue(0);
    }

    /**
     * Clears all stacks.
     */
    private void clearStacks() {
        operandStack.clear();
        operatorStack.clear();
    }

    /**
     * @return the value of the expression most recently evaluated by the
     *         calculator, or zero if the expression was invalid.
     */
    public float getCurrentValue() {
        return currentValue;
    }

    /**
     * Returns the result at the specified index in history.
     *
     * @param index The index of the result to return
     * @return the result if the index is out of range, zero otherwise
     */
    public float getHistoryValue(int index) {
        if ((index < 0) || (index >= history.size())) {
            return 0;
        } else {
            return history.get(index);
        }
    }

    /**
     * @return the value stored in memory, or zero if no value has been stored.
     */
    public float getMemoryValue() {
        return memoryValue;
    }

    /**
     * Returns the precedence of the specified operator.
     *
     * @param operator The operator whose precedence is to be returned.
     * @return the precedence of the specified operator, or zero if the operator is
     *         invalid.
     */
    private int getPrecedence(String operator) {
        switch (operator) {
            case ADD:
                return ADD_PRECEDENCE;
            case SUB:
                return SUB_PRECEDENCE;
            case MUL:
                return MUL_PRECEDENCE;
            case DIV:
                return DIV_PRECEDENCE;
            default:
                return NIL_PRECEDENCE;
        }
    }

    /**
     * Stores the specified value as the current value.
     *
     * @param value The value to store.
     */
    private void setCurrentValue(float value) {
        currentValue = value;
    }

    /**
     * Stores the specified value in memory.
     *
     * @param memval The value to store.
     */
    public void setMemoryValue(float memval) {
        memoryValue = memval;
    }

    /**
     * Evaluates the specified expression and returns the result.
     * <p>
     * Valid expression syntax for Exercise 1 is "operand operator operand". There
     * must be exactly one space between each operand and the operator.
     * <p>
     * Valid expression syntax for Exercise 2 is "operator operand". There must be
     * exactly one space between the operator and the operand.
     * <p>
     * Valid expression syntax for Exercise 3 is "(operand operator operand) operand
     * (operand operator operand)", but arbitrary parenthesis handling is optional.
     * There must not be a space between a parenthesis and its adjacent operand.
     * There must be exactly one space between an operator and each of its adjacent
     * operands or parentheses.
     * <p>
     * Valid expression syntax for Exercise 4 is as above but with arbitrary length.
     * The handling of brackets in any expression that is not exactly as specified
     * for Exercise 3 is optional. There must be at least one operation in the
     * expression.
     *
     * @param expression The expression to evaluate.
     * @return the value of the expression if it is syntactically valid and does not
     *         contain division by zero, else Float.MIN_VALUE.
     */
    public float evaluate(String expression) {
        if (parseAndCalculate(expression)) {
            // calculation successful
            // print and return result
            System.out.println(getCurrentValue());
            return getCurrentValue();
        } else {
            // calculation unsuccessful

            // print error message
            System.out.println(INVALID_MESSAGE);

            // reset values
            clearCurrent();
            clearStacks();

            // return error value
            return Float.MIN_VALUE;
        }
    }

    /**
     * Returns true if the operator at the top of the operator stack has greater or
     * equal precedence than the specified operator.
     *
     * @param operator The operator to compare to that at the top of the operator
     *                 stack.
     * @return true if the operator at the top of the operator stack has greater or
     *         equal precedence than the specified operator, false otherwise.
     */
    private boolean existsGreaterPrecedenceThan(String operator) {
        if (operatorStack.isEmpty()) {
            return false;
        }

        return (getPrecedence(operatorStack.get(operatorStack.size() - 1)) >= getPrecedence(operator));
    }

    /**
     * Handles user input.
     *
     * @param input The user input to handle.
     */
    private void handleInput(String input) {
        if (input == null) {
            return;
        }

        switch (input) {
            case CLEAR:
                // clear memory
                clearMemory();
                break;
            case HISTORY:
                // print history
                printHistory();
                break;
            case MEMORY:
                // store current value in memory
                setMemoryValue(getCurrentValue());
                break;
            case MEMORY_RECALL:
                // print memory value
                System.out.println(getMemoryValue());
                break;

            default:
                evaluate(input);
                break;
        }
    }

    /**
     * Applies the operator at the top of the operator stack to the top two elements
     * of the operand stack. The operation is unsuccessful if there are not at least
     * two elements on the operand stack, the operator is invalid, or the divisor is
     * zero.
     *
     * @return true if the operation was successful, false otherwise.
     */
    private boolean operate() {
        int size = operandStack.size();

        // return false if too few operands on operand stack
        // all valid operations are binary
        if (size < 2) {
            return false;
        }

        // pop operands from operand stack
        float b = operandStack.remove(size - 1);
        float a = operandStack.remove(size - 2);

        // pop operator from operator stack
        String operator = operatorStack.remove(operatorStack.size() - 1);

        // apply operation
        switch (operator) {
            case ADD:
                operandStack.add(a + b);
                break;
            case SUB:
                operandStack.add(a - b);
                break;
            case MUL:
                operandStack.add(a * b);
                break;
            case DIV:
                if (b == 0) {
                    // division by zero
                    return false;
                }

                operandStack.add(a / b);
                break;

            default:
                // operator invalid
                return false;
        }

        return true;
    }

    /**
     * Evaluates the specified expression according to the rules of `evaluate(String
     * expression)` using the shunting-yard algorithm and stores the result as the
     * current value and the latest value in history.
     *
     * @param expression The expression to evaluate.
     * @return true if evaluation was successful, false otherwise.
     * @see https://en.wikipedia.org/wiki/Shunting-yard_algorithm
     */
    private boolean parseAndCalculate(String expression) {
        // split expression into tokens
        // include trailing empty tokens as these indicate invalid input
        String[] inputTokens = expression.split(" ", -1);

        // single value expression is invalid (for some reason)
        if (inputTokens.length <= 1) {
            return false;
        }

        // expression with operator as first token uses memory value as first operand
        if (OPERATORS.contains(inputTokens[0])) {
            operandStack.add(getMemoryValue());
        }

        for (String token : inputTokens) {
            switch (token) {
                case "":
                case LEFT_PAR:
                case RIGHT_PAR:
                    // arbitrary spaces and spaces around parentheses are invalid (for some reason)
                    return false;

                case ADD:
                case SUB:
                case MUL:
                case DIV:
                    // while (there are operators on the operator stack)
                    // and (this operator has less precedence than that at the top of the operator
                    // stack)
                    // and (the operator at the top of the operator stack is not a left parenthesis)
                    while (!operatorStack.isEmpty() && existsGreaterPrecedenceThan(token)
                            && !operatorStack.get(operatorStack.size() - 1).equals(LEFT_PAR)) {
                        // pop operators from the operator stack and apply to the operand stack
                        if (!operate()) {
                            // operation unsuccessful
                            return false;
                        }
                    }

                    // push this operator to the operator stack
                    operatorStack.add(token);

                    break;

                default:
                    // token is not an operator
                    // split token into parentheses and operands
                    StringTokenizer st = new StringTokenizer(token, LEFT_PAR + RIGHT_PAR, true);

                    while (st.hasMoreTokens()) {
                        String subtoken = st.nextToken();

                        switch (subtoken) {
                            case LEFT_PAR:
                                // push left parenthesis to operator stack
                                operatorStack.add(subtoken);
                                break;

                            case RIGHT_PAR:
                                // while the operator at the top of the operator stack is not a left parenthesis
                                while (!operatorStack.isEmpty()
                                        && !operatorStack.get(operatorStack.size() - 1).equals(LEFT_PAR)) {
                                    // pop operators from the operator stack and apply to the operand stack
                                    if (!operate()) {
                                        // operation unsuccessful
                                        return false;
                                    }
                                }

                                // if operator stack runs out without finding a left parenthesis
                                if (operatorStack.isEmpty()) {
                                    // expression invalid
                                    return false;
                                } else {
                                    // pop left parenthesis from the operator stack and discard
                                    operatorStack.remove(operatorStack.size() - 1);
                                }

                                break;

                            default:
                                // subtoken is not a parenthesis
                                // try to parse as operand
                                try {
                                    // push operand to operand stack
                                    operandStack.add(Float.valueOf(subtoken));
                                } catch (Exception e) {
                                    // subtoken invalid
                                    return false;
                                }
                                break;
                        }
                    }

                    break;
            }
        }

        // no more tokens to read
        // while there are operators on the operator stack
        while (!operatorStack.isEmpty()) {
            // pop operators from the operator stack and apply to the operand stack
            if (!operate()) {
                // operation unsuccessful
                return false;
            }
        }

        // input invalid if operand stack does not contain only the final result
        if (operandStack.size() != 1) {
            return false;
        }

        // pop result from operand stack to result register and history
        setCurrentValue(operandStack.remove(0));
        history.add(getCurrentValue());

        // procedure successful
        return true;
    }

    /**
     * Prints all results in history, delimited by a single space.
     */
    private void printHistory() {
        // System.out.println(String.join(" ",
        // history.stream().map(Object::toString).collect(Collectors.joining(" "))));

        StringBuilder sb = new StringBuilder();

        for (Float result : history) {
            sb.append(" " + result.toString());
        }

        System.out.println(sb.toString().trim());
    }

    /**
     * Begin execution by retrieving user input.
     */
    private void run() {
        System.out.println("Enter an expression to evaluate or a command:");
        System.out.println(CLEAR + " - clear memory");
        System.out.println(HISTORY + " - print result history");
        System.out.println(MEMORY + " - store result in memory");
        System.out.println(MEMORY_RECALL + " - print memory");
        System.out.println(QUIT + " - quit");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String input = sc.nextLine();

                if (input.equals(QUIT)) {
                    return;
                } else {
                    handleInput(input);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Calculator().run();
    }

}
