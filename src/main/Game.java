package main;

import java.awt.Graphics;

import entities.Kickboxer;
import levels.LevelManager;

public class Game implements Runnable {

	private GamePanel gamePanel;
	private GameWindow gameWindow;
	private LevelManager levelManager;
	private Thread gameThread;
	private final int FPS = 120;
	private final int UPS = 200;

	private Kickboxer kickboxer;
	
	//level atlas and size of window 
	public static final int DEFAULT_SPRITE = 32;
    public static final float SCALE = 1.6f;
    public static final int SIZE_IN_WIDTH = 20;
    public static final int SIZE_IN_HEIGHT = 13;
    public static final int SIZE = (int)(DEFAULT_SPRITE * SCALE);
    public static final int GAME_WIDTH = (int)(SIZE * SIZE_IN_WIDTH);
    public static final int GAME_HEIGHT = (int)(SIZE * SIZE_IN_HEIGHT);
    
	public Game() {

		initClasses();
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus(); // фокусируем на нашем окне для нажатия кнопок

		startGameLoop();
	}

	private void initClasses() {
		levelManager = new LevelManager(this);
		kickboxer = new Kickboxer(100, 100, 106, 98);
		// -------------------------------------------------
		kickboxer.loadLvlData(levelManager.getCurrentLevel().getSpriteIds());
		// -------------------------------------------------
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void update() {
		levelManager.update();
		kickboxer.update();
	}

	public void render(Graphics g) {
		levelManager.draw(g);
		kickboxer.render(g);
	}

	@Override
	public void run() {
		double timePerFrame = 1_000_000_000 / FPS;
		double timePerUpdate = 1_000_000_000 / UPS;

		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;

		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {

			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1) {
				update();
				updates++;
				// сохраняем остаток от секунды после обновления, для следующей итерации
				// для обновлений
				deltaU--;
			}

			if (deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				// сохраняем остаток от секунды после обновления, для следующей итерации
				// для кадров
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	public void windowFocusLost() {
		kickboxer.resetDirectionsBool();
	}

	public Kickboxer getKickboxer() {
		return kickboxer;
	}

}
