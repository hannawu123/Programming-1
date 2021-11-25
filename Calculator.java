import java.util.Scanner;

public class Calculator {
    public static void main (String [] args ) {

        double currentResult = 0;
        int selection;
        Scanner scanner = new Scanner(System.in);
        double result;
        double operand1;
        double operand2;
        double sumCalculation = 0; //for the sum of calculations
        int numCalculated = 0; // for number of calculations done
        double avgCalculation;


        System.out.println("Current Result: " + currentResult);

        while (true){

//menu displayed with 7 options
            System.out.println("\nCalculator Menu");
            System.out.println("---------------");
            System.out.println("0. Exit Program");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exponentiation");
            System.out.println("6. Logarithm");
            System.out.println("7. Display Average\n");
            System.out.print("Enter Menu Selection: ");
            selection = scanner.nextInt(); //input for menu selection

//check to see which option to fulfill

            switch (selection)
            {
                case 0:
                    return;
                case 1:
                    System.out.print("Enter first operand: ");
                    operand1 = scanner.nextDouble(); //input for operand 1
                    System.out.print("Enter second operand: ");
                    operand2 = scanner.nextDouble(); // input for operand 2
                    result = operand1 + operand2;
                    System.out.print("\nCurrent Result: " + result +"\n");
                    numCalculated++; //adds up each time there is calculation done
                    sumCalculation += result;
                    break;
                case 2:
                    System.out.print("Enter first operand: ");
                    operand1 = scanner.nextDouble(); //input for operand 1
                    System.out.print("Enter second operand: ");
                    operand2 = scanner.nextDouble(); // input for operand 2
                    result = operand1 - operand2;
                    System.out.print("\nCurrent Result: " + result +"\n");
                    numCalculated++;
                    sumCalculation += result;
                    break;
                case 3:
                    System.out.print("Enter first operand: ");
                    operand1 = scanner.nextDouble(); //input for operand 1
                    System.out.print("Enter second operand: ");
                    operand2 = scanner.nextDouble(); // input for operand 2
                    result = operand1 * operand2;
                    System.out.print("\nCurrent Result: " + result +"\n");
                    numCalculated++;
                    sumCalculation += result;
                    break;
                case 4:
                    System.out.print("Enter first operand: ");
                    operand1 = scanner.nextDouble(); //input for operand 1
                    System.out.print("Enter second operand: ");
                    operand2 = scanner.nextDouble(); // input for operand 2
                    result = operand1 / operand2;
                    System.out.print("\nCurrent Result: " + result +"\n");
                    numCalculated++;
                    sumCalculation += result;
                    break;
                case 5:
                    System.out.print("Enter first operand: ");
                    operand1 = scanner.nextDouble(); //input for operand 1
                    System.out.print("Enter second operand: ");
                    operand2 = scanner.nextDouble(); // input for operand 2
                    result = Math.pow(operand1, operand2);
                    System.out.print("\nCurrent Result: " + result +"\n");
                    numCalculated++;
                    sumCalculation += result;
                    break;
                case 6:
                    System.out.print("Enter first operand: ");
                    operand1 = scanner.nextDouble(); //input for operand 1
                    System.out.print("Enter second operand: ");
                    operand2 = scanner.nextDouble(); // input for operand 2
                    result = Math.log(operand2) /Math.log(operand1);
                    System.out.print("\nCurrent Result: " + result +"\n");
                    numCalculated++;
                    sumCalculation += result;
                    break;
                case 7:
                        if (sumCalculation!= 0){
                            avgCalculation = sumCalculation/ numCalculated;
                            System.out.println("\nSum of calculations: " +sumCalculation);
                            System.out.println("Number of calculations: "+numCalculated);
                            System.out.println("Average of calculations: "+avgCalculation);
                            }
                        else {
                            System.out.println("\nError: no calculations yet to average!");
                    }
                    break;
                default:
                    System.out.println("\nError: Invalid selection! Terminating program.");
                    break;

            }

        }


        }


    }
