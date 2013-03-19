import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public class Enemy extends Entity implements Renderer {

	Rectangle rect;
	Point point;


	public Enemy(int x_Point, int y_Point, int width, int height, Image img,
			int life, boolean visible) {
		this.setX_Point(x_Point);
		this.setY_Point(y_Point);
		this.setWidth(width);
		this.setHeight(height);
		this.setImg(img);
		this.setLife(life);
		this.setMaxLife(life);
		this.setVisible(visible);

		rect = new Rectangle((int) getX_Point(), (int) getY_Point(), this.getWidth(),this.getHeight());
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(getImg(), (int) getX_Point(), (int) getY_Point(),
				getWidth(), getHeight(), null);
		
		double lifePiece=getWidth()/getMaxLife();
		//draws the life of the Enemy
				for(int i=1;i<=getLife();i++){
					g.setColor(Color.green);
					g.fillRect((int)(getX_Point()-lifePiece+lifePiece*i), (int)getY_Point()-9, (int)lifePiece, 3);
					
				}
		//this draws the life, that has been lost
				for(int i=getLife()+1;i<getMaxLife()+1;i++){
					g.setColor(Color.red);
					g.fillRect((int)(getX_Point()-lifePiece+lifePiece*i), (int)getY_Point()-9, (int)lifePiece, 3);
					
				}
	}

	public void update() {
		Player player = FightClub.getNearestPlayer();
		
		double vel = 1;

		if (!player.isVisible()) {

			// setX_Point(getX_Point() + 1);

		} else {
			double dx = player.getX_Point() + player.getWidth()/2 - (this.getX_Point() + this.getWidth()/2);
			double dy = player.getY_Point() + player.getHeight()/2 - (this.getY_Point() + this.getHeight()/2);

			double dist = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
			
			setX_Point(getX_Point()+dx/dist*vel*FightClub.WIDTH/(double)500); 
			setY_Point(getY_Point()+dy/dist*vel*FightClub.HEIGHT/(double)500);
			
			rect = new Rectangle((int) getX_Point(), (int) getY_Point(), this.getWidth(),this.getHeight());
			point = new Point((int) (getX_Point() + (getWidth() / 2)),
					(int) (getY_Point() + (getHeight() / 2)));
		}
	}

	public Rectangle getRect() {

		return rect;
	}

	public Point getPoint() {

		return point;
	}

}
