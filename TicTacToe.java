import java.util.Scanner;
import java.util.Random;
public class TicTacToe {
    // Place your methods here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int playerInt = getNumberPlayers(sc);
        if (playerInt == 1) {
            Board b = new Board();
            String playerStr = "1";
            char playerChar = playerStr.charAt(0);
            Random rand = new Random();
            for (int i = 0; i < 5; ++i) {
                GameState now = GameState.ONGOING;
                System.out.println(b.toString());
                boolean place1 = true;
                while (place1) {
                    Location a = getInput(playerStr, sc);
                    if (b.placeLetter(a.getRow(), a.getColumn(), playerChar)) {
                        place1 = false;
                    }
                }
                boolean place2 = true;
                System.out.println("The Computer is making a move...");
                while (place2) {
                    int randRow = rand.nextInt(3);
                    int randColumn = rand.nextInt(3);
                    Location loc = new Location(randRow, randColumn);
                    char computer = 'c';
                    if (b.placeLetter(loc.getRow(), loc.getColumn(), computer)) {
                        place2 = false;
                    }
                }
                now = b.getGameState();
                if (now ==  GameState.ONGOING) {
                    continue;
                } else {
                    if (now == GameState.PLAYER1_WIN) {
                        System.out.println("Player 1 wins!");
                    } else if (now == GameState.PLAYER2_WIN) {
                        System.out.println("Computer wins!");
                    } else {
                        System.out.println("Tie!");
                    }
                    break;
                }
            }
        } else {
            Board b = new Board();
            String playerStr1 = "1";
            char playerChar1 = playerStr1.charAt(0);
            String playerStr2 = "2";
            char playerChar2 = playerStr2.charAt(0);
            for (int i = 0; i < 9; ++i) {
                GameState now = GameState.ONGOING;
                System.out.println(b.toString());
                if (i % 2 == 0) {
                    boolean place1 = true;
                    while (place1) {
                        Location one = getInput(playerStr1, sc);
                        if (b.placeLetter(one.getRow(), one.getColumn(), playerChar1)) {
                            place1 = false;
                        }
                    }
                } else {
                    boolean place2 = true;
                    while (place2) {
                        Location two = getInput(playerStr2, sc);
                        if (b.placeLetter(two.getRow(), two.getColumn(), playerChar2)) {
                            place2 = false;
                        }
                    }
                }
                now = b.getGameState();
                if (now ==  GameState.ONGOING) {
                    continue;
                } else {
                    if (now == GameState.PLAYER1_WIN) {
                        System.out.println("Player 1 wins!");
                    } else if (now == GameState.PLAYER2_WIN) {
                        System.out.println("Player 2 wins!");
                    } else {
                        System.out.println("Tie!");
                    }
                    break;
                }
            }
        }
    }
    /********************************************************
     *                                                      *
     *      DO NOT MODIFY CODE BELOW THIS BOX               *
     *                                                      *
     ********************************************************/
   /**
     * Gets number of players from command line
     * @param sc        for reading from command-line
     * @return number of players (always 1 or 2)
     */

    private static int getNumberPlayers(Scanner sc) {
        boolean repeatPrompt = true;
        int numPlayers = 0;
        while (repeatPrompt) {
            System.out.print("How many players (1 or 2)? ");
            String input = sc.next();
            try {
                numPlayers = Integer.parseInt(input);
                if (numPlayers == 1 || numPlayers == 2) {
                    repeatPrompt = false;
                } else {
                    System.out.println("Enter 1 or 2 players.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please only enter a number.");
            }
        }
        return numPlayers;
    }
   /**
     * Handles scanner calls and user input
     * @param player    whose turn it is
     * @param sc        for reading from command-line
     * @return int[] holding row, column in that order
     */
    private static Location getInput(String player, Scanner sc) {
        boolean repeatPrompt = true;
        int row = -1;
        int col = -1;
        while (repeatPrompt) {
            System.out.print("Enter desired square for " + player + ": ");
            String input = sc.next();
            input = input.trim();
            String[] splitInput = input.split(",");
            try {
                row = Integer.parseInt(splitInput[0]);
                col = Integer.parseInt(splitInput[1]);
                repeatPrompt = false;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please follow the format 'row,col'; for ex '1,2'");
            }
        }
        Location loc = new Location(row, col);
        return loc;
    }
}
