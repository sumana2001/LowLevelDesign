package TicTacToeGame;

public class Main {
    public static void main(String[] args) {
        Game game=new Game(3);
        System.out.println("game winner is "+game.startGame());
    }
}
