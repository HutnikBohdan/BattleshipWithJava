import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game();


        game.startGame();
        game.printField();
        game.shipsField();


    }
}
