package API;

import Board.Board;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class BoardAPITest {
	private char[][] tested;
	private final char[][] expectedValue = new char[][]{
			{'1', '2', '3'},
			{'4', '5', '6'},
			{'7', '8', '9'},
	};

	@BeforeEach
	public void setData(){
		Board.board = expectedValue;
	}

	@Test
	public void save() throws IOException, ClassNotFoundException {
		BoardAPI.SaveBoard(Mockito.mock(Board.class));

		Assertions.assertArrayEquals(
				expectedValue,
				(char[][])new ObjectInputStream(
						new FileInputStream("board.ser")).readObject()
		);
	}
}
