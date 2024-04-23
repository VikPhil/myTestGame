package levels;

import java.awt.image.BufferedImage;

import main.Game;
import utils.LoadSave;

public enum Level {
	DARKLVL(12, 8);

	private BufferedImage[] sprites;

	Level(int tilesInWidth, int tilesInHeight) {

		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.DARK_LEVEL);

		sprites = new BufferedImage[tilesInWidth * tilesInHeight];

		for (int j = 0; j < tilesInHeight; j++)
			for (int i = 0; i < tilesInWidth; i++) {
				int index = j * tilesInWidth + i;
				sprites[index] = img.getSubimage(Game.DEFAULT_SPRITE * i, Game.DEFAULT_SPRITE * j, 
						Game.DEFAULT_SPRITE,
						Game.DEFAULT_SPRITE);
			}
	}

	public BufferedImage getSprite(int id) {
		return sprites[id];
	}

}
