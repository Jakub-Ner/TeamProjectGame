package API;

import Board.Board;
import Main.Game;

import java.io.*;

public class BoardAPI {
	public static void SaveBoard(Board board) {
		try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("board.ser"))) {
			so.writeObject(board.board);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void LoadBoard(Board board) {
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("board.ser"))) {
			Object obj1 = is.readObject();
			Board.board = (char[][]) obj1;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		File file = new File("board.ser");

		//puts our character on a loaded board
		Board.board[Game.player.getY()][Game.player.getX()] = 'B';

	}


}