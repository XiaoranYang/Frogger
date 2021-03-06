/**
 * Handles obstacle movement and initalization.
 * @author Iden Craven
 */
public class GameObstacle extends GameObject {

  private int length;

  public void resetRight(GameScreen screen, GameObstacle obstacle) {
  		for (int i = -1; i < obstacle.getLength(); i++) {
  				screen.ClearScreenLocation(getX() - i, obstacle.getY());
  		}
  		obstacle.setX(screen.getScreenWidth() - 3);
  		obstacle.initObstacle(screen,obstacle);
  		//redraw wall
  }

  public void initObstacle(GameScreen screen, GameObstacle obstacle) {
  		for (int i = getX() - 1; i < (getX() - 1) + this.length; i++) {
  				screen.setObjectOnLocation(obstacle, i, obstacle.getY());
  		}
  }

  public void moveLeft(GameScreen screen, GameObstacle obstacle) {
  		obstacle.setX(getX() - 1);
  		for (int i = getX() - 1; i < (getX() - 1) + this.length; i++) {
  				screen.setObjectOnLocation(obstacle, i, obstacle.getY());
  		}
  		screen.ClearScreenLocation(obstacle.getX() + 2, obstacle.getY());
  }

  public void moveRight(GameScreen screen, GameObstacle obstacle) {
  		obstacle.setX(getX() + 1);
  		for (int i = getX() + 1; i > (getX() + 1) - this.length; i--) {
  				screen.setObjectOnLocation(obstacle, i, obstacle.getY());
  		}
  		screen.ClearScreenLocation(obstacle.getX() - 2, obstacle.getY());
  }

  public boolean overlapsWith(Frog frog) {
  		for (int i = -1; i < this.getLength(); i++) {
  				if (this.getX() - i == frog.getX() && this.getY() == frog.getY()) {
  						return true;
  				}
  		}
  		return false;
  }

  public void setLength(int length) {
  		this.length = length;
  }

  public int getLength() {
  		return this.length;
  }
}
