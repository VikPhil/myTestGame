package entities;

import static utils.Constants.KickboxerConstants.*;
import static utils.HelpMethods.CanMoveHere;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utils.LoadSave;

public class Kickboxer extends Entity {

	private BufferedImage[][] fighterAni;
	// Animation
	private int aniTick, aniIndex, aniSpeed = 30;
	private int fighterAction = IDLE;
	private int spriteIndexRow;
	// -------------------------------------------------
	// Moving
	private boolean moving = false;
	private boolean up, down, left, right;
	private float fighterSpeed = 1.0f;
	// -------------------------------------------------
	// Attack
	private boolean attacking = false;
	// -------------------------------------------------
	// Level data
	private int[][] lvlData;
	// -------------------------------------------------
	// Hitbox offset
	private float xOffsetHit = 16 * Game.SCALE;
	// -------------------------------------------------

	public Kickboxer(float x, float y, int width, int height) {
		super(x, y, width, height);
		loadAnimation();
		initHitbox(x, y, 30 * Game.SCALE, height);
	}

	public void update() {
		updatePos();
		
		updateAnimationTick();
		setAnimation();
	}

	public void render(Graphics g) {
		g.drawImage(fighterAni[spriteIndexRow][aniIndex],(int) (hitbox.x - xOffsetHit),(int) hitbox.y, width, height, null);
		drawHitbox(g);
	}

	private void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(fighterAction)) {
				aniIndex = 0;
				attacking = false;
			}
		}

	}

	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}

	private void setAnimation() {

		int startAni = fighterAction;

		if (moving) {
			spriteIndexRow = IDLE_RUN_JUMP;
			fighterAction = RUN;
		} else {
			spriteIndexRow = IDLE_RUN_JUMP;
			fighterAction = IDLE;
		}

		if (attacking) {
			spriteIndexRow = ATTACK_ARM;
			fighterAction = ATTACK_A;
		}

		if (startAni != fighterAction)
			resetAniIndex();

	}

	private void resetAniIndex() {
		aniTick = 0;
		aniIndex = 0;
	}

	private void updatePos() {
		moving = false;
		if (!left && !right && !up && !down)
			return;

		float xSpeed = 0, ySpeed = 0;

		if (left && !right)
			xSpeed -= fighterSpeed;
		else if (right && !left)
			xSpeed += fighterSpeed;

		if (up && !down)
			ySpeed -= fighterSpeed;
		else if (down && !up)
			ySpeed += fighterSpeed;
		
		if(CanMoveHere(hitbox.x + xSpeed,hitbox.y + ySpeed, hitbox.width, hitbox.height, lvlData)) {
			hitbox.x += xSpeed;
			hitbox.y += ySpeed;
			moving = true;
		}

	}

	private void loadAnimation() {

		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.KICKBOXER);

		fighterAni = new BufferedImage[5][7];

		for (int j = 0; j < fighterAni.length; j++)
			for (int i = 0; i < fighterAni[j].length; i++)
				fighterAni[j][i] = img.getSubimage(i * width, j * height, width, height);

	}

	// -------------------------------------------------
	public void loadLvlData(int[][] lvlData) {
		this.lvlData = lvlData;
	}
	// -------------------------------------------------

	public void resetDirectionsBool() {
		up = false;
		down = false;
		left = false;
		right = false;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

}
