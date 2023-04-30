package normal;

import java.util.Scanner;
import java.util.Vector;

public class Calc1 {
    // Defining Variables for Different Colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    // Ending Definition of Colors

    private Vector<String> eqn = new Vector<>(); // Stores Operands
    String temp1; // Stores Operand 1 temporarily
    String temp2; // Stores Operand 2 temporarily
    Scanner in = new Scanner(System.in);

    public void reset() {
        eqn.clear();
    }

    public String showEqn() {
        String str = eqn.toString();
        str = str.replace("[", "");
        str = str.replace("]", "");
        str = str.replace(",", "");
        // System.out.println(YELLOW + "Equation: " + GREEN + str + RESET);
        return str;
    }

    // Returns the Vector eqn (equation)
    public Vector<String> getEqn() {
        return eqn;
    }

    // Add a single value into the eqn Vector
    public void add(String val) {
        eqn.add(val);
    }

    // Add A Array of Values into the eqn Vector
    public void add(String val[]) {
        for (int i = 0; i < val.length; i++) {
            eqn.add(val[i]);
        }
    }

    // Function to calculate the total of the equation
    /*
     * Working Of Total function: 1. The function iterates through the eqn Vector if
     * operand is found it pushes it in operand[] stack and if operator is found
     * then it checks if current operator is '*' or '/' and the operator at top of
     * operator[] stack is '+' or '-' than it pushes it into the stack else if it is
     * '*' or '/' than it pop the first(top) operator from stack and also pops two
     * operands from the operand stack and carries operation on them based on the
     * popped operator and then pushes it back into the operand stack than pushes
     * the current operator into the stack.
     * 2. If the current operator is '+' or '-' and stack top is '*' or '/' than the
     * above operation is carried till the stack is empty and than pushes the
     * current operator
     * 3. The Above operation is performed from i=0 to i<eqn.size then after that in
     * while loop the above operation is carried till the stack is empty
     */
    public String total() {
        // Below class is implemented for stack
        // Class stack starts here
        class stack {
            int size;
            String op[];
            int top = -1;

            // Default Constructor to initialize stack size as 30
            public stack() {
                this.size = 30;
                op = new String[size];
            }

            // Parameterized Constructor to initialize stack size as given by user
            public stack(int size) {
                this.size = size;
                op = new String[size];
            }

            // Method to push the value into the stack
            public void push(String val) {
                if (top >= 100) {
                    System.out.println(RED + "Stack Overflow..." + RESET);
                    return;
                }
                top++;
                this.op[top] = val;
            }

            // Method to pop the top element from the stack and return the popped value
            public String pop() {
                if (top < 0) {
                    throw new ArithmeticException(RED + "Incorrect Equation..." + RESET);
                }
                top--;
                return op[top + 1];
            }

            // Checks Whether the given input is operator or not
            boolean isOperator() {
                if (op[top].charAt(0) == '+' || op[top].charAt(0) == '-' || op[top].charAt(0) == '*'
                        || op[top].charAt(0) == '/')
                    return true;
                return false;
            }

            // Get the Value at top of the stack
            // Returns a single character
            // This is used to get the operators from operator stack
            char stackTop() {
                return op[top].charAt(0);
            }

            // Checks whether stack is empty or not
            boolean isEmpty() {
                if (top == -1) {
                    return true;
                }
                return false;
            }

            // Returns the 0 index element from the stack
            String stackBottom() {
                return op[0];
            }
        }
        // Stack class ends

        // Calculating total
        stack operand = new stack(); // Stores the operand into the stack
        stack operator = new stack(10); // Stores the operator into the stack
        float total = 0; // Stores total of current two operand
        for (int i = 0; i < eqn.size(); i++) { // Loop through the eqn Vector
            if (operand.isEmpty() || operator.isEmpty()) { // Checks whether operand or operator stack is empty or not
                try { // Pushes Operands or Operators into their respective stack if either one of
                      // them is empty
                    Float.parseFloat(eqn.get(i));
                    operand.push(eqn.get(i));
                } catch (NumberFormatException e) {
                    operator.push(eqn.get(i));
                }
            } else if (eqn.get(i).charAt(0) == '+' || eqn.get(i).charAt(0) == '-') {
                if (operator.isOperator()) // Runs if operator stack is not empty
                {
                    // If Top of Operator stack is '+' then pops and adds the top two elements from
                    // the stack and then pushes the result again into the stack
                    if (operator.stackTop() == '+') {
                        temp2 = operand.pop();
                        temp1 = operand.pop();
                        total = Float.parseFloat(temp1) + Float.parseFloat(temp2);
                        temp1 = String.valueOf(total);
                        operand.push(temp1);
                    } else if (operator.stackTop() == '-') {
                        // If Top of Operator stack is '-' then pops and substracts the top two elements
                        // from the stack and then pushes the result again into the stack
                        temp2 = operand.pop();
                        temp1 = operand.pop();
                        total = Float.parseFloat(temp1) - Float.parseFloat(temp2);
                        temp1 = String.valueOf(total);
                        operand.push(temp1);
                    } else if (operator.stackTop() == '*') {
                        // If Top of Operator stack is '*' then pops and multiplies the top two elements
                        // from the stack and then pushes the result again into the stack
                        int j = 0;
                        while (!operator.isEmpty()) // If Top of stack is '*' than the operation is carried out till the
                                                    // stack not becomes empty
                        {
                            temp2 = operand.pop();
                            temp1 = operand.pop();
                            if (j >= 1) {
                                if (operator.stackTop() == '+') {
                                    total = Float.parseFloat(temp1) + Float.parseFloat(temp2);
                                    temp1 = String.valueOf(total);
                                } else if (operator.stackTop() == '-') {
                                    total = Float.parseFloat(temp1) - Float.parseFloat(temp2);
                                }
                            } else
                                total = Float.parseFloat(temp1) * Float.parseFloat(temp2);
                            temp1 = String.valueOf(total);
                            operand.push(temp1);
                            operator.pop();
                            j++;
                        }
                        operator.push(eqn.get(i)); // After carrying operation pushes the '+' or '-' into the stack
                        continue;
                    } else {
                        // If Top of Operator stack is '/' then pops and divides the top two elements
                        // from the stack and then pushes the result again into the stack
                        int k = 0;
                        while (!operator.isEmpty()) // If Top of stack is '/' than the operation is carried out till the
                                                    // stack not becomes empty
                        {
                            temp2 = operand.pop();
                            temp1 = operand.pop();
                            if (k >= 1) {
                                if (operator.stackTop() == '+') {
                                    total = Float.parseFloat(temp1) + Float.parseFloat(temp2);
                                    temp1 = String.valueOf(total);
                                } else if (operator.stackTop() == '-') {
                                    total = Float.parseFloat(temp1) - Float.parseFloat(temp2);
                                }
                            } else
                                total = Float.parseFloat(temp1) / Float.parseFloat(temp2);
                            temp1 = String.valueOf(total);
                            operand.push(temp1);
                            operator.pop();
                            k++;
                        }
                        operator.push(eqn.get(i)); // After carrying operation pushes the '+' or '-' into the stack
                        continue;
                    }
                }
                // Below two statements is available for '+' and '-' operators only after
                // carrying their respective operations
                operator.pop();
                operator.push(eqn.get(i));
            } else if (eqn.get(i).charAt(0) == '*') { // Carries the requied Operation and pushes '*' into the stack
                if (operator.stackTop() == '+' || operator.stackTop() == '-') { // If top of stack is '+' or '-' than
                                                                                // push '*' into the stack
                    operator.push("*");
                } else if (operator.stackTop() == '/') { // If top of stack is '/' than pop and divide top two elements
                                                         // from the Operand stack and push result into operand stack
                                                         // and than push the '*' into operator stack
                    temp2 = operand.pop();
                    temp1 = operand.pop();
                    total = Float.parseFloat(temp1) / Float.parseFloat(temp2);
                    temp1 = String.valueOf(total);
                    operator.pop();
                    operand.push(temp1);
                    operator.push("*");
                } else if (operator.stackTop() == '*') { // If top of stack is '*' than pop and multiply top two
                                                         // elements from the Operand stack and push result into operand
                                                         // stack and than push the '*' into operator stack
                    temp2 = operand.pop();
                    temp1 = operand.pop();
                    total = Float.parseFloat(temp1) * Float.parseFloat(temp2);
                    temp1 = String.valueOf(total);
                    operator.pop();
                    operand.push(temp1);
                    operator.push("*");
                }

            } else if (eqn.get(i).charAt(0) == '/') { // Carries required opeation and pushes '/' into the stack
                if (operator.stackTop() == '+' || operator.stackTop() == '-') { // If top of stack is '+' or '-' than
                                                                                // push '/' into the stack
                    operator.push("/");
                } else if (operator.stackTop() == '/') { // If top of stack is '/' than pop and divide top two elements
                                                         // from the Operand stack and push result into operand stack
                                                         // and than push the '/' into operator stack
                    temp2 = operand.pop();
                    temp1 = operand.pop();
                    total = Float.parseFloat(temp1) / Float.parseFloat(temp2);
                    temp1 = String.valueOf(total);
                    operator.pop();
                    operand.push(temp1);
                    operator.push("/");
                } else if (operator.stackTop() == '*') { // If top of stack is '*' than pop and multiply top two
                                                         // elements from the Operand stack and push result into operand
                                                         // stack and than push the '/' into operator stack
                    temp2 = operand.pop();
                    temp1 = operand.pop();
                    total = Float.parseFloat(temp1) * Float.parseFloat(temp2);
                    temp1 = String.valueOf(total);
                    operator.pop();
                    operand.push(temp1);
                    operator.push("/");
                }
            } else {
                operand.push(eqn.get(i)); // If None of above condition is true than the String at current position is
                                          // an operand so push it into the operand stack
            }
        }
        // Repeatedly Pop and carry required operation till the Operator stack becomes
        // empty
        while (!operator.isEmpty()) {
            temp2 = operand.pop();
            temp1 = operand.pop();
            if (operator.stackTop() == '+') {
                total = Float.parseFloat(temp1) + Float.parseFloat(temp2);
                temp1 = String.valueOf(total);
                operand.push(temp1);
            } else if (operator.stackTop() == '-') {
                total = Float.parseFloat(temp1) - Float.parseFloat(temp2);
                temp1 = String.valueOf(total);
                operand.push(temp1);
            } else if (operator.stackTop() == '*') {
                total = Float.parseFloat(temp1) * Float.parseFloat(temp2);
                temp1 = String.valueOf(total);
                operand.push(temp1);
            } else {
                total = Float.parseFloat(temp1) / Float.parseFloat(temp2);
                temp1 = String.valueOf(total);
                operand.push(temp1);
            }
            operator.pop();
        }
        // System.out.println("Total: " + operand.stackBottom()); // Prints the result
        return operand.stackBottom();
    }
}
