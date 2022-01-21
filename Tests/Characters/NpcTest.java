package Characters;

import Board.Board;
import Characters.Villains.Phantom;
import MovePattern.*;
import MovePattern.MovePattern;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mockito;

import javax.swing.*;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NpcTest {
	static class tmp implements ArgumentsProvider {
		@Override
		public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
			return Stream.of(
					Arguments.of(new LPattern()),
					Arguments.of(new PlusPattern()),
					Arguments.of(new RandomPattern()),
					Arguments.of(new SPattern()),
					Arguments.of(new SquarePattern()),
					Arguments.of(new UPattern())
			);
		}
	}

	@ParameterizedTest
	@ArgumentsSource(tmp.class)
	void movePatternTest(MovePattern pattern) {
		Phantom npc = new Phantom(pattern);
		npc.firstCoordinates(30, 20);
		Board.board = new char[35][100];

		for (int i = 0; i < 35; i++) {
			Board.board[i] = new char[100];
			for (int j = 0; j < 100; j++) {
				Board.board[i][j] = ' ';
			}
		}

		int[] oldcoordinates = npc.oldCoordinates();

		npc.setSpeed(100);
		npc.move(Mockito.mock(Board.class), new JLabel());

		int[] vector = {npc.getY() - oldcoordinates[0], npc.getX() - oldcoordinates[1]};

		int kierunek = 0;
		if (vector[0] == -1) {
			kierunek = 8;
		} else if (vector[0] == 1) {
			kierunek = 2;
		} else if (vector[1] == -1) {
			kierunek = 4;
		} else if (vector[1] == 1) {
			kierunek = 6;
		}

		assertEquals(npc.getPattern().pattern()[npc.getLastMove()], kierunek);
	}
}
