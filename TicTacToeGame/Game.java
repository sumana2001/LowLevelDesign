package TicTacToeGame;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import TicTacToeGame.Model.*;

public class Game {
    Deque<Player> playersList;
    Board board;

    public Game(int size){
        initializeGame(size);
    }

    public void initializeGame(int size){
        playersList = new LinkedList<>();
        PlayingPieceO playingPieceO=new PlayingPieceO();
        PlayingPieceX playingPieceX=new PlayingPieceX();

        Player crossPlayer=new Player("cross", playingPieceX);
        Player zeroPlayer=new Player("zero", playingPieceO);
        playersList.add(crossPlayer);
        playersList.add(zeroPlayer);

        board=new Board(size);
    }

    public String startGame(){
        boolean noWinner=true;
        while(noWinner){
            Player playerTurn=playersList.removeFirst();
            board.printBoard();
            List<Pair> freeCells=board.getFreeCells();
            System.out.println("Available free spaces: "+ freeCells.size());
            if(freeCells.isEmpty()){
                noWinner=false;
                continue;
            }

            System.out.print("Player"+playerTurn.getName()+ " Enter row and column: ");
            Scanner in=new Scanner(System.in);
            String s=in.nextLine();
            String[] values = s.split(",");
            int row=Integer.valueOf(values[0]);
            int col=Integer.valueOf(values[1]);
            boolean pieceAdded=board.addPiece(playerTurn.getPlayingPiece(), row, col);
            if(!pieceAdded){
                System.out.println("Incorrect position, try again");
                playersList.addFirst(playerTurn);
                continue;
            }
            playersList.addLast(playerTurn);
            boolean winner=isThereWinner(row, col,playerTurn.getPlayingPiece().pieceType);
            if(winner){
                board.printBoard();
                return playerTurn.getName();
            }
        }
        return "tie";
    }

    public boolean isThereWinner(int row, int col, PieceType pieceType){
        boolean rowMatch=true;
        boolean colMatch=true;
        boolean diagonalMatch=true;
        boolean antiDiagonalMatch=true;

        PlayingPiece[][] gameBoard=board.getBoard();

        //check in row
        for(int i=0;i<board.getSize();i++){
            if(gameBoard[row][i]==null ||gameBoard[row][i].pieceType!=pieceType){
                rowMatch=false;
            }
        }

        //check in col
        for(int i=0;i<board.getSize();i++){
            if(gameBoard[i][col]==null || gameBoard[i][col].pieceType!=pieceType){
                colMatch=false;
            }
        }

        //check in diagonal
        for(int i=0,j=0;i<board.getSize();i++,j++){
            if(gameBoard[i][j]==null || gameBoard[i][j].pieceType!=pieceType){
                diagonalMatch=false;
            }
        }

        //check in antidiagonal
        for(int i=0,j=board.getSize()-1;i<board.getSize();i++,j--){
            if(gameBoard[i][j]==null || gameBoard[i][j].pieceType!=pieceType){
                antiDiagonalMatch=false;
            }
        }
        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}