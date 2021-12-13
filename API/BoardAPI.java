package game.TeamProjectGame.API;

import game.TeamProjectGame.Board.Board;

import java.io.*;
import java.util.Scanner;

public class BoardAPI {
	public static void SaveBoard(Board board){
		BufferedWriter outB = null;
		String sum = "";
		for(int i =0;i<board.board.length;i++){
			for(int j =0;j<board.board[i].length;j++){
				if(board.board[i][j]==' '){
					sum+=";";
				}else{
					sum += board.board[i][j];
				}
			}
			sum += "\n";}
		try{
			outB =  new BufferedWriter(new FileWriter("board.txt"));
			outB.write(sum);
		}
		catch (IOException e){
			e.printStackTrace();
		}finally {
			try {
				outB.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public  static void LoadBoard(Board board){
		char[][] tmpboard = new char[board.HEIGHT][board.WIDTH];
		File plik = new File("board.txt");
		try (Scanner scan = new Scanner(new BufferedReader(new FileReader(plik)))) {
			int J = 0;
			while( scan.hasNext() )
			{
				String thisLine = scan.next();
				for(int i =0;i<thisLine.length();i++){
					if(thisLine.charAt(i) == ';'){
						tmpboard[J][i] = ' ';
					}else{
						tmpboard[J][i] = thisLine.charAt(i);
					}
				}
				J++;
			}
			board.board = tmpboard;
			System.out.print(board.board);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}