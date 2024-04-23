package utils;

public class Constants {
	
	public static class Directions {
		public static final int UP = 0;
		public static final int DOWN = 1;
		public static final int LEFT = 2;
		public static final int RIGHT = 3;
	}
	
	public static class KickboxerConstants {
		public static final int IDLE = 0;
		public static final int RUN = 1;
		public static final int JUMP = 2;
		public static final int ATTACK_A = 3;
		public static final int ATTACK_L = 4;
		
		//for the row index
		public static final int IDLE_RUN_JUMP = 0;
		public static final int ATTACK_ARM = 1;
		public static final int ATTACK_LEG = 2;
		// -------------------------------------------------

		public static int GetSpriteAmount(int kickboxer_amount) {
			switch (kickboxer_amount) {
			case IDLE:
				return 1;
			case RUN:
			case JUMP:
				return 3;
			case ATTACK_A:
				return 4;
			case ATTACK_L:
				return 3;
			default:
				return 0;
			}
		}
		
	}
}
