package dev.cpsc233.frogger;


public class World {
	
	private final int ROWS = 13;
	private final int COLS = 13;
	
	private int[][] gameWorld;
	
	private int playerPosition = 6;
	
	public World() {
		gameWorld = new int[ROWS][COLS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				gameWorld[row][col] = row * ROWS + col + 1;
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = ROWS - 1; row >= 0; row--) {
			for (int col = 0; col < COLS; col++) {
				String pl = "";
				boolean occupied = false;
				if (playerPosition == gameWorld[row][col]) {
					occupied = true;
					pl += "F" + " ";
				}
				
				if (occupied) {
					sb.append(pl);
				}else {
					sb.append("* ");
				}
			}
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}
}
