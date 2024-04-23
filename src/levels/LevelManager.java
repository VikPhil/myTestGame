package levels;

import java.awt.Graphics;
import java.util.Arrays;

import main.Game;

public class LevelManager {

	private Game game;
	private GameMap lvlOne, backgroundLvl;

	public LevelManager(Game game) {
		this.game = game;
		initLevels();
	}

	private void initLevels() {

		int[][] backArray = new int[Game.SIZE_IN_HEIGHT][Game.SIZE_IN_WIDTH];

		for (int i = 0; i < backArray.length; i++)
			Arrays.fill(backArray[i], 12);

		int[][] testArrayMap = { 
				{ 12, 12, 12, 12, 12, 12, 45, 46, 47, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 },
				{ 12, 23, 12, 12, 12, 12, 57, 58, 59, 12, 12, 12, 12, 12, 12, 12, 45, 46, 47, 12 },
				{ 12, 12, 12, 12, 45, 46, 47, 12, 12, 12, 12, 12, 12, 12, 12, 12, 57, 58, 59, 12 },
				{ 47, 12, 12, 12, 57, 58, 59, 12, 12, 45, 46, 47, 12, 12, 12, 12, 12, 12, 45, 46 },
				{ 59, 12, 12, 12, 12, 12, 12, 12, 12, 57, 58, 59, 12, 12, 12, 12, 12, 12, 57, 58 },
				{ 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 },
				{ 30, 87, 73, 87, 31, 32, 12, 12, 12, 72, 74, 36, 37, 38, 27, 28, 12, 12, 12, 31 },
				{ 42, 71, 85, 70, 43, 44, 60, 62, 61, 84, 86, 48, 49, 50, 39, 40, 22, 22, 34, 43 },
				{ 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
				};

		backgroundLvl = new GameMap(backArray);
		lvlOne = new GameMap(testArrayMap);
	}

	private void createLevel(Graphics g, GameMap gameMap) {
		for (int j = 0; j < gameMap.getArrHeight(); j++)
			for (int i = 0; i < gameMap.getArrWidth(); i++)
				g.drawImage(Level.DARKLVL.getSprite(gameMap.getSpriteId(j, i)), i * Game.SIZE, j * Game.SIZE, Game.SIZE,
						Game.SIZE, null);

	}

	public void draw(Graphics g) {
		createLevel(g, backgroundLvl);
		createLevel(g, lvlOne);
	}

	public void update() {

	}
	
	public GameMap getCurrentLevel() {
		return lvlOne;
	}
}
