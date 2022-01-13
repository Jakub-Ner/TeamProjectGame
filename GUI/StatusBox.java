package game.TeamProjectGame.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class StatusBox extends JTextArea {
	Vector<Message> messages = new Vector<>();

	public StatusBox(Font f){
		super(50, 10);
		setFont(f);

	}

	synchronized public void tick(){
		for (Message m : messages) {
			m.tick();
		}

	}

	synchronized public void addMessage(String text, int lifetime){
		messages.add(new Message(lifetime, text + '\n'));
		rewrite();
	}

	private void rewrite(){
		setText("");
		for (Message m : messages) {
			if(m.lifetime <= 0) continue;
			append(m.getMessage());
		}
	}
}

class Message {
	int lifetime;
	String message;

	public Message(int lifetime, String message) {
		this.lifetime = lifetime;
		this.message = message;
	}

	//returns true if lifetime <= 0
	public boolean tick() {
		lifetime--;

		return lifetime <= 0;
	}

	public String getMessage() {
		return message;
	}
}
