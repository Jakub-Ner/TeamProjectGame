package Characters;

import Characters.Friends.Dwarf;
import Characters.Friends.Elf;
import Characters.Friends.Friend;
import Characters.Friends.Human;
import MovePattern.LPattern;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
	static class tmp implements ArgumentsProvider{
		@Override
		public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
			return Stream.of(
					Arguments.of(new Elf(new LPattern())),
					Arguments.of(new Human(new LPattern())),
					Arguments.of(new Dwarf(new LPattern()))
			);
		}
	}

	@ParameterizedTest
	@ArgumentsSource(tmp.class)
	public void testConstructor(Friend from){
		Player tested = new Player(from);

		assertEquals(tested.speed, from.speed, "Speed test fail");
		assertEquals(tested.getHp(), from.getHp(), "HP test fail");
		assertEquals(tested.getDmg(), from.getDmg(), "DMG test fail");
	}



}