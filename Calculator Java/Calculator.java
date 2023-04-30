// Imports Necessary Classes
import normal.*;
import scientific.Scientific;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

// Class Calculator Starts
public class Calculator {

    public static void main(String args[]) {
        Calculator c = new Calculator();
        c.init();   // Initializes the GUI
    }

    private String str; // Variable to temporarily store the text entered by the user
    private Calc1 normal = new Calc1(); // Object created to perform normal Calculator Operations
    private Scientific scientific = new Scientific();   // Object Created to perform Scientific Calculator Operations
    private JTextArea manual_equation_area = new JTextArea();   // Area for the user to type equations through keyboard

    public void init() {

        JFrame f = new JFrame("Scientific Calculator"); // Frame of the Calculator
        JTextField output = new JTextField();   // Shows the Output of the Equation
        output.setBounds(270, 220, 430, 40);    // Sets the Co-Ordinates of the Output Box
        output.setEditable(false);      // Sets the Output Box to be uneditable by the user

        JTextField equation_area = new JTextField();    // Shows the equation
        equation_area.setBounds(270, 170, 430, 40);     // Sets Co-Ordinates of equation Box
        equation_area.setEditable(false);       // Not Editable

        manual_equation_area.setBounds(270, 270, 430, 40);  // Sets Co-Ordinates of the Box where user can enter equation through keyboard
        manual_equation_area.setEditable(true);     // It is Editable

        JButton manual_calculate = new JButton("set eqn");  // Button To Store the Input in the str variable
        manual_calculate.addActionListener(new ActionListener() {   // Action Performed when button is pressed
            public void actionPerformed(ActionEvent e) {
                // IF Equation Enterd is an empty String then Print Error message on the terminal and continue program execution
                try {
                    str = manual_equation_area.getText();   // Store the Equation Entered by user into str variable
                    if (str.charAt(0) == '\0') {    // Checks whether Equation entered is empty
                        return;
                    }
                    String val[] = new String[100];
                    val = str.split(" ");   // Stores the Equaton in the form of an array
                    normal.add(val);    // Stores the equation into a Vector
                    manual_equation_area.setText("");   // Set the text area to be Empty
                    System.out.println(str);    // Prints the equation on the terminal
                } catch (Exception er) {    // If Enterd Equation is Empty Prints the Error message on terminal and continues the execution of program
                    System.out.println(er);
                }
            }
        });
        manual_calculate.setBounds(490, 440, 100, 30);  // Sets the Co-ordinates of the button

        // Methods to add Buttons from 0 - 9(Numbers)
        JButton one = new JButton("1");
        one.setBounds(270, 560, 100, 30);
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("1");
                normal.add("1");
            }
        });

        JButton two = new JButton("2");
        two.setBounds(380, 560, 100, 30);
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("2");
                normal.add("2");
            }
        });
        JButton three = new JButton("3");
        three.setBounds(490, 560, 100, 30);
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("3");
                normal.add("3");
            }
        });

        JButton four = new JButton("4");
        four.setBounds(270, 520, 100, 30);
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("4");
                normal.add("4");
            }
        });
        JButton five = new JButton("5");
        five.setBounds(380, 520, 100, 30);
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("5");
                normal.add("5");
            }
        });

        JButton six = new JButton("6");
        six.setBounds(490, 520, 100, 30);
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("6");
                normal.add("6");
            }
        });
        JButton seven = new JButton("7");
        seven.setBounds(270, 480, 100, 30);
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("7");
                normal.add("7");
            }
        });

        JButton eight = new JButton("8");
        eight.setBounds(380, 480, 100, 30);
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("8");
                normal.add("8");
            }
        });

        JButton nine = new JButton("9");
        nine.setBounds(490, 480, 100, 30);
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("9");
                normal.add("9");
            }
        });

        JButton zero = new JButton("0");
        zero.setBounds(380, 600, 100, 30);
        zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("0");
                normal.add("0");
            }
        });
        // Number Button Insertion End

        // Adds the Operation Button
        JButton plus = new JButton("+");
        plus.setBounds(600, 560, 100, 30);
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("+");
                normal.add("+");
            }
        });

        JButton minus = new JButton("-");
        minus.setBounds(600, 520, 100, 30);
        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("-");
                normal.add("-");
            }
        });

        JButton multiplication = new JButton("*");
        multiplication.setBounds(600, 480, 100, 30);
        multiplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("*");
                normal.add("*");
            }
        });

        JButton division = new JButton("/");
        division.setBounds(600, 440, 100, 30);
        division.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("/");
                normal.add("/");
            }
        });

        JButton total = new JButton("=");
        total.setBounds(600, 600, 100, 30);
        total.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText(normal.total());
                equation_area.setText(normal.showEqn());
                String str = normal.total();
                normal.reset();
                normal.add(str);
            }
        });
        // Addition Of Operation Button End

        // Button to clear the equation
        JButton all_clear = new JButton("AC");
        all_clear.setBounds(270, 440, 100, 30);
        all_clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                normal.reset();             // It clears the equation
                output.setText("");        // Sets Output area to be Empty
                equation_area.setText("");  // Sets Equation Area to be Empty
            }
        });

        // Button To Show the Equation on uneditabel equation area
        JButton show_equation = new JButton("eqn");
        show_equation.setBounds(380, 440, 100, 30);
        show_equation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equation_area.setText(normal.showEqn());
            }
        });

        // Button to show equation on editable Manual Equation area
        JButton a_button = new JButton("");
        a_button.setBounds(490, 600, 100, 30);
        a_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manual_equation_area.setText(normal.showEqn());
            }
        });

        // Get The Value of PI
        JButton PI = new JButton("PI");
        PI.setBounds(160, 560, 100, 30);
        PI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText(String.valueOf(scientific.getPiValue()));
                normal.add(String.valueOf(scientific.getPiValue()));
            }
        });

        // Get the value of e (euler's number)
        JButton e_value = new JButton("e");
        e_value.setBounds(270, 600, 100, 30);
        e_value.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText(String.valueOf(scientific.getEValue()));
                normal.add(String.valueOf(scientific.getEValue()));
            }
        });

        // Get the Inverse of the Output
        JButton inverse = new JButton("1/x");
        inverse.setBounds(50, 400, 100, 30);
        inverse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.getInverse(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.getInverse(valDouble)));
                equation_area.setText("1/" + valDouble);
            }
        });

        // Get The Square Root Of the Output
        JButton sqrt = new JButton("sqrt");  
        sqrt.setBounds(270, 400, 100, 30);
        sqrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.sqRoot(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.sqRoot(valDouble)));
                equation_area.setText("Sqrt(" + valDouble + ")");
            }
        });

        // Get The Square of the Output
        JButton square = new JButton("X^2");
        square.setBounds(160, 400, 100, 30);
        square.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.square(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.square(valDouble)));
                equation_area.setText("Square(" + valDouble + ")");
            }
        });

        // Get The Cube of the Output
        JButton cube = new JButton("X^3");
        cube.setBounds(380, 400, 100, 30);
        cube.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.cube(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.cube(valDouble)));
                equation_area.setText("Cube(" + valDouble + ")");
            }
        });

        // Get The Cube Root of the Output
        JButton cube_root = new JButton("cbrt");
        cube_root.setBounds(490, 400, 100, 30);
        cube_root.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.cubeRoot(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.cubeRoot(valDouble)));
                equation_area.setText("cbrt(" + valDouble + ")");
            }
        });

        // Stop the Execution of the program (Program is Terminated)
        JButton close = new JButton("X");
        close.setBounds(600, 400, 100, 30);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        close.setBackground(Color.RED);

        // Get The Sine(sin) of the Output
        JButton sin = new JButton("sin");
        sin.setBounds(50, 440, 100, 30);
        sin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.sin(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.sin(valDouble)));
                equation_area.setText("sin(" + valDouble + ")");
            }
        });

        // Get The Sine inverse of the Output
        JButton sin_inverse = new JButton("sin^-1");
        sin_inverse.setBounds(160, 440, 100, 30);
        sin_inverse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.arcsin(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.arcsin(valDouble)));
                equation_area.setText("sin^-1(" + valDouble + ")");
            }
        });

        // Get The Cosine(cos) of the Output
        JButton cos = new JButton("cos");
        cos.setBounds(50, 480, 100, 30);
        cos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.cos(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.cos(valDouble)));
                equation_area.setText("cos(" + valDouble + ")");
            }
        });

        // Get The Cosine Inverse of the Output
        JButton cos_inverse = new JButton("cos^-1");
        cos_inverse.setBounds(160, 480, 100, 30);
        cos_inverse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.arccos(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.arccos(valDouble)));
                equation_area.setText("cos^-1(" + valDouble + ")");
            }
        });

        // Get The Tangent(tan) of the Output
        JButton tan = new JButton("tan");
        tan.setBounds(50, 520, 100, 30);
        tan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.tan(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.tan(valDouble)));
                equation_area.setText("tan(" + valDouble + ")");
            }
        });

        // Get The tan inverse of the Output
        JButton tan_inverse = new JButton("tan^-1");
        tan_inverse.setBounds(160, 520, 100, 30);
        tan_inverse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.arctan(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.arctan(valDouble)));
                equation_area.setText("tan^-1(" + valDouble + ")");
            }
        });

        // Get The log (base 10) of the Output
        JButton log = new JButton("log");
        log.setBounds(50, 600, 100, 30);
        log.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.log(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.log(valDouble)));
                equation_area.setText("log(" + valDouble + ")");
            }
        });

        // Get The Natural Log (Base e) of the Output
        JButton ln = new JButton("ln");
        ln.setBounds(160, 600, 100, 30);
        ln.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.ln(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.ln(valDouble)));
                equation_area.setText("ln(" + valDouble + ")");
            }
        });

        // Get the maximum and minimum value for the given input
        // The Input is entered manually through keyboard
        // The Values are not stored
        JButton max_min = new JButton("max/min");
        max_min.setBounds(50, 560, 100, 30);
        max_min.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.print("Entered\n");
                    String str = manual_equation_area.getText();
                    double val[] = new double[25];
                    for(int i=0;i<str.length();i++){
                        try {
                            val[i] = Double.parseDouble(str.split(" ")[i]);
                        } catch (ArrayIndexOutOfBoundsException er) {
                            break;
                        }
                    }
                    output.setText(String.valueOf("Max: " + scientific.maximum(val) + "\tMin: " + scientific.minimum(val)));
                    equation_area.setText("Max and Min of (" + manual_equation_area.getText() + ")");
                    manual_equation_area.setText("");
                }
                catch(Exception er){System.out.println(er);}
            }
        });

        // Adds the button on the frame
        f.add(manual_calculate);
        f.add(output);
        f.add(equation_area);
        f.add(manual_equation_area);
        f.add(one);
        f.add(two);
        f.add(three);
        f.add(four);
        f.add(five);
        f.add(six);
        f.add(seven);
        f.add(eight);
        f.add(nine);
        f.add(zero);
        f.add(plus);
        f.add(minus);
        f.add(multiplication);
        f.add(division);
        f.add(total);
        f.add(all_clear);
        f.add(a_button);
        f.add(show_equation);
        f.add(PI);
        f.add(e_value);
        f.add(inverse);
        f.add(sqrt);
        f.add(square);
        f.add(cube);
        f.add(cube_root);
        f.add(close);
        f.add(sin);
        f.add(sin_inverse);
        f.add(cos);
        f.add(cos_inverse);
        f.add(tan);
        f.add(tan_inverse);
        f.add(log);
        f.add(ln);
        f.add(max_min);
        f.setLayout(null);  // Sets Default Layout
        f.setSize(750, 700);    // Sets the Size of Frame
        f.setVisible(true); // Sets Frame to be visible
        f.setEnabled(true); // Sets Components to be enabled
    }

    // Checks Whether the given input is an operator or not
    public static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        return false;
    }
}

// 10 + 5 - 2 * 10 / 8 + 100
// 10.2 * 3 - 10 / 6 + 8 * 5 * 0 + 10 / 100 + 0.3 * 0.2 / 0.5
