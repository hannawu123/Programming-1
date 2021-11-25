import java.util.Scanner;
public class Blackjack {
    public static int randomNumberCreator(P1Random rng) {

//Generate random values
        int cardValues = rng.nextInt(13) + 1; // draw card 1 - 13

//rename cards along with the values for the game
        if (cardValues == 1) {
            cardValues = 1; //adds one if an ace is chosen
            System.out.println("Your card is a ACE!");
        } else if (cardValues == 11) {
            cardValues = 10; //adds 10 if a jack is chosen
            System.out.println("Your card is a JACK!");
        } else if (cardValues == 12) {
            cardValues = 10; //adds 10 if a queen is chosen
            System.out.println("Your card is a QUEEN!");
        } else if (cardValues == 13) {
            cardValues = 10; //adds 10 if a king is chosen
            System.out.println("Your card is a KING!");
        } else {
            System.out.println("Your card is a " + cardValues + "!");
        }
        return cardValues;
    }

    public static void main(String[] args) {
        P1Random rng = new P1Random(); // For random number generator
        Scanner scanner = new Scanner(System.in);

//game begins
        int choice = 0; //option variable
        int playersCard = 0;
        int dealersCard = 0;
        boolean play = true;
        int numGame = 0; // counting number of game variable
        int pWinner = 0; //player wins variable
        int dWinner = 0; //dealer wins variable
        int drawGame = 0; //tie game variable


        while (true) { // infinite loop that continues forever until a condition inside is met
            numGame++; //adds 1 to each game
            System.out.println("START GAME #" + numGame);
            playersCard = 0;
            play = true;
            System.out.println();

            int drawCard = randomNumberCreator(rng); //random card drawn generator
            playersCard = playersCard + drawCard; //combine the card drawn and players card
            System.out.println("Your hand is: " + playersCard + "\n");


            while (play) {

//menu prints to screen once the card is dealt
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit\n");

                System.out.print("Choose an option: ");
                choice = scanner.nextInt(); // option input scanner


//choice 1- pick up a new card
                if (choice == 1) {
                    drawCard = randomNumberCreator(rng);
                    playersCard = playersCard + drawCard;
                    System.out.println("Your hand is: " + playersCard + "");

                    System.out.println();
                    if (playersCard == 21) { //if player hand equals 21 then player wins
                        System.out.println("BLACKJACK! You win!\n");
                        play = false;
                        pWinner++; //adds 1 to the players win scoreboard
                    } else if (playersCard > 21) { // if player hand exceeds 21 then dealer wins
                        System.out.println("You exceeded 21! You lose.\n");
                        play = false;
                        dWinner++; //adds 1 to the dealers win scoreboard
                    }
                }
//choice 2 - hold hand (no new card given)
                else if (choice == 2) {
                    dealersCard = rng.nextInt(11) + 16; // generates a card for dealer that ranges between 16 and 26
                    System.out.println("Dealer's hand: " + dealersCard);
                    System.out.println("Your hand is: " + playersCard);
                    System.out.println();

                    if (playersCard == dealersCard) { // if player and dealer have same # of cards then its a tie
                        System.out.println("It's a tie! No one wins!\n");
                        drawGame++;
                    } else if (dealersCard > 21) { // if dealer hand goes above 21 then player wins
                        System.out.println("You win!\n");
                        pWinner++;
                    } else if (playersCard > dealersCard) {
                        System.out.println("You win!\n");
                        pWinner++;
                    } else if (dealersCard > playersCard) {
                        System.out.println("Dealer wins!\n");
                        dWinner++;
                    }
                    play = false;
                }
//option 3- print the statistics of the game
                 else if (choice == 3) {
                    int completedGames= numGame - 1; // since it refreshes to a new game.. you need to subtract one for total number of completed games
                    double pwinPercent = (double) pWinner / (double) completedGames; //equation to get the percent of player win (# of player wins divided by the # of completed games)
                    pwinPercent = Math.round(pwinPercent * 1000.0)/10.0; // Format for percentage value to one decimal point

                    System.out.println("\nNumber of Player wins: " +pWinner);
                    System.out.println("Number of Dealer wins: " +dWinner);
                    System.out.println("Number of tie games: " +drawGame);
                    System.out.println("Total # of games played is: " +completedGames);
                    System.out.println("Percentage of Player wins: " +pwinPercent+ "%\n"); //player win expressed as a percentage
                }
//option 4- close out of the program
                else if (choice ==4) {
                    return;
                }
//a range from 1-4 is not chosen
                else {
                    System.out.println("\nInvalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.\n");
                }
            }


        }
    }
}
