package Main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		new Game().run();
	}
	//strumienie a java
	public static void test(){
		//standardowa tablica 2d charów, jak u nas Board
		char[][] tablica = {
				{'1', '2'},
				{'3', '4'},
		};

		//MAGIA - liczymy, ile jest wystąpień znaków różnych od '1'
		int l = Arrays.stream(tablica)			//tu się tworzy strumień - w skrócie coś na kształt specjalnej tablicy w Javie
				.map(String::new)				//tu zmieniamy tą "tablicę tablic char" na "tablicę String"
				.collect(Collectors.joining())	//w tym miejscu łączymy te wszystkie Stringi z naszej tablicy w jeden długi wyraz
				.chars()						//wracamy do strumienia, tym razem jednowymiarowego charów
				.filter(s -> s != '1')			//ta metoda usuwa nam ze strumienia każdy element niespełniający warunków
				.toArray()						//wracamy do znanej nam kalsy Array
				.length;						//pobieramy jej długość

	}
}
