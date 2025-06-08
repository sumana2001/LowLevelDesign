package TicTacToeGame.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board;

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size=size;
    }

    public PlayingPiece[][] getBoard(){
        return board;
    }

    public void setBoard(PlayingPiece[][] board){
        this.board=board;
    }

    public Board(int size){
        this.size=size;
        this.board=new PlayingPiece[size][size];
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null){
                    System.out.print(board[i][j].pieceType.name()+ "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public List<Pair> getFreeCells(){
        List<Pair> freeCells= new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    Pair rowCol=new Pair(i, j);
                    freeCells.add(rowCol);
                }
            }
        }
        return freeCells;
    }

    public boolean addPiece(PlayingPiece playingPiece, int row, int col){
        if(board[row][col]!=null){
            return false;
        }
        board[row][col]=playingPiece;
        return true;
    }
}
