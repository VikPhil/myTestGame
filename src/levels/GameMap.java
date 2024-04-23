package levels;

public class GameMap {

	private int[][] spriteIds;
	
	public GameMap(int[][] spriteIds) {
		this.spriteIds = spriteIds;
	}
	
	public int getSpriteId(int xIndex, int yIndex) {
		return spriteIds[xIndex][yIndex];
	}
	
	public int getArrWidth() {
		return spriteIds[0].length;
	}
	
	public int getArrHeight() {
		return spriteIds.length;
	}
	
	public int[][] getSpriteIds() {
		return spriteIds;
	}
}
