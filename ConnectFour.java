import java.util.Scanner;

public class ConnectFour {
    public static void printBoard(char[][] array) { //print the board for the game

        for (int row = array.length - 1; row>= 0 ; row--) { // loop that goes through each iteration to have the correct amount of rows (needs to be in reverse)
            for (int column = 0; column < array[0].length; column++) { //loop that goes through each iteration to have the correct amount of columns
                System.out.print(array[row][column] + " "); //prints out each column/row
            }
            System.out.println(); // adds a row of space between each row
        }
    }

    public static void initializeBoard(char[][] array) { //gives a value (-) to each array
        for (int row = 0; row < array.length; row++) { //loop that goes through each iteration and checks the length of each row
            for (int column = 0; column < array[0].length; column++) { //loop that goes through each iteration and checks the length of each column
                array[row][column] = '-'; //the " - " is used as a place holder value for setting up the board
            }
        }
    }

    public static int insertChip(char[][] array, int col, char chipType) { //where the chip sits on the board that user decides
        /*checks the length of the index for pieces to start from bottom up... proceeds to the next available spot in
        column if spot is taken up*/
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            if (array[rowIndex][col] == '-') { //statement checks if space is available... no x or o character
                array[rowIndex][col] = chipType; //insert chip to empty space
                return rowIndex;
            }
        }
        return 0;
    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {

        boolean checkWinner = false;
        int numChipRow = 0; //variable for counting the chips row
        int numChipCol = 0; //variable for counting the chips column

        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) { //checks the length of the row index
            /*checks to see if its the same chip type for the column because the row stays the same (checking left to right)*/
            if (array[rowIndex][col] == chipType) {
                numChipRow++;//adds one to chip type counter
                if (numChipRow == 4) { //checks when there are four (alike) chips in the same row
                    return true; //returns true when won
                }
            } else {
                numChipRow = 0; //resets num chip back to 0
            }
        }

        for (int colIndex = 0; colIndex < array[0].length; colIndex++) { //checks the length of the row index
            /*checks to see if its the same chip type for the column because the row stays the same (checking up to down)*/
            if (array[row][colIndex] == chipType) {
                numChipCol++;//adds one to chip type counter
                if (numChipCol == 4) { //checks when there are four(alike) chips in the same column
                    return true; //returns true when won
                }
            } else {
                numChipCol = 0; //resets chip back to 0
            }
        }
        return checkWinner;
    }

    public static void main(String[] args) {
        int height; //variable for row
        int length; //variable for column
        int totalNumPlays = 0; //variable for total number of plays
        int chooseColumn = 0; //variable for column choice chosen by user
        int rowTokenDestination1 = 0; //variable for placement of token for player 1
        int rowTokenDestination2 = 0; ////variable for placement of token for player 2
        boolean go = true; //variable to continue or end the game
        Scanner scanner = new Scanner(System.in); //scanner variable for input

        //board setup
        System.out.print("What would you like the height of the board to be? ");
        height = scanner.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        length = scanner.nextInt();

        char[][] boardSize = new char[height][length]; //array for the board
        initializeBoard(boardSize); //initialize the board
        printBoard(boardSize); //  print the empty board

        System.out.println("\nPlayer 1: x"); // assigning players to their chip.. player 1 is x
        System.out.println("Player 2: o\n"); // assigning players to their chip.. player 2 is o

        while (go) {
            char play1 = 'x'; //chip type for player 1
            char play2 = 'o'; //chip type for player 2

            System.out.print("\nPlayer 1: Which column would you like to choose? ");
            chooseColumn = scanner.nextInt(); //input for choosing column
            rowTokenDestination1 = insertChip(boardSize, chooseColumn, play1); //to return the chip for player 1
            System.out.println();
            totalNumPlays++;
            printBoard(boardSize); //prints out the new board after chip is inserted


            if (checkIfWinner(boardSize, chooseColumn, rowTokenDestination1, play1)) { //player one makes four in a row first
                System.out.println("\nPlayer 1 won the game!"); //check if player 1 wins immediately
                break; //find way to exit loop when condition is met
            }

            if (totalNumPlays == height * length) { //when the board is all filled up... and there is no four in a row then its a draw
                System.out.println("\nDraw. Nobody wins.");
                break; // exit loop when condition is met ok!
            }

                System.out.print("\nPlayer 2: Which column would you like to choose? ");
                chooseColumn = scanner.nextInt();
                rowTokenDestination2 = insertChip(boardSize, chooseColumn, play2); //to return the chip for player 2!!!!!!
                System.out.println();
                totalNumPlays++; //adds after for the variable total number of players -- add new comment to commit
                printBoard(boardSize); //print out the new board after chip is inserted

            if (checkIfWinner(boardSize, chooseColumn, rowTokenDestination2, play2)) { //player two makes four in a row first
                System.out.println("\nPlayer 2 won the game!"); ////check if player 2 wins immediately
                break; //exit loop when condition is met
            }

            if (totalNumPlays == height * length) { //when the board is all filled up... and there is no four in a row then its a draw
                System.out.println("\nDraw. Nobody wins.");
                break; // exit loop when condition is met
            }

        }
    }
}

