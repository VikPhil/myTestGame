package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

public class KeyboardInputs implements KeyListener {

	private GamePanel gamePanel;

	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			gamePanel.getGame().getKickboxer().setUp(true);
			break;
		case KeyEvent.VK_S:
			gamePanel.getGame().getKickboxer().setDown(true);
			break;
		case KeyEvent.VK_A:
			gamePanel.getGame().getKickboxer().setLeft(true);
			break;
		case KeyEvent.VK_D:
			gamePanel.getGame().getKickboxer().setRight(true);
			break;
		case KeyEvent.VK_U:
			gamePanel.getGame().getKickboxer().setAttacking(true);
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			gamePanel.getGame().getKickboxer().setUp(false);
			break;
		case KeyEvent.VK_S:
			gamePanel.getGame().getKickboxer().setDown(false);
			break;
		case KeyEvent.VK_A:
			gamePanel.getGame().getKickboxer().setLeft(false);
			break;
		case KeyEvent.VK_D:
			gamePanel.getGame().getKickboxer().setRight(false);
			break;
		case KeyEvent.VK_U:
			gamePanel.getGame().getKickboxer().setAttacking(false);
			break;
		}

	}

}
