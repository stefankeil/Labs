import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Triangle implements ComponentListener{
	
	
	private int xPosition;
	private int yPosition;
	private String color;
	private boolean isVisible;
	private Canvas canvas = new Canvas(400, 400, Color.white);
	private int screenWidth = canvas.getWidth()-25;
	private int screenHeigth = canvas.getHeight()-25;
	Graphics g;
    Point a1,b1,c1, a2,b2,c2, a3,b3,c3;
    

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeigth() {
		return screenHeigth;
	}

	public void setScreenHeigth(int screenHeigth) {
		this.screenHeigth = screenHeigth;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	/**
	 * Create a new triangle at default position with default color.
	 */
	public Triangle() {
		canvas.getFrame().addComponentListener(this);
		xPosition = 0;
		yPosition = 0;
		color = "magenta";
		isVisible = true;
	}

	public void changeColor(String newColor) {
		color = newColor;
	}

	public void draw(int xPointA, int xPointB, int xPointC, int yPointA, int yPointB, int yPointC) {
		int[] xPoints = { xPointA, xPointB, xPointC };
		int[] yPoints = { yPointA, yPointB, yPointC };
		canvas.draw(this, color, new Polygon(xPoints, yPoints, 3));

        drawRecursive(new Point(xPointA,yPointA),new Point(xPointB, yPointB),new Point(xPointC, yPointC), 5);
	}

	public int drawRecursive(Point a, Point b, Point c, int step) {
		
		if (step == 0){
			return 1;
		}else {
			
	        int xPoints[] = {(a.x + b.x)/2, (b.x+c.x)/2, (a.x+c.x)/2};
	        int yPoints[] = {(a.y + b.y)/2, (b.y+c.y)/2, (a.y+c.y)/2};
	        
	        if (step == 1){
	        	changeColor("black");
	        }else if (step == 2){
	        	changeColor("white");
	        }else if (step == 3){
	        	changeColor("blue");
	        }else if (step == 4){
	        	changeColor("green");
	        }else if (step == 5){
	        	changeColor("red");
	        }

			canvas.draw(this, color, new Polygon(xPoints, yPoints, 3));

	        a1 = a;
	        b1 = new Point(xPoints[0], yPoints[0]);
	        c1 = new Point(xPoints[2], yPoints[2]);
	        drawRecursive(a1, b1, c1, step - 1);

	        a2 = new Point(xPoints[0], yPoints[0]);
	        b2 = b;
	        c2 = new Point(xPoints[1], yPoints[1]);
	        drawRecursive(a2, b2, c2, step - 1);

	        a3 = new Point(xPoints[2], yPoints[2]);
	        b3 = new Point(xPoints[1], yPoints[1]);
	        c3 = c;
	        drawRecursive(a3, b3, c3, step - 1);
		
		}
		return 2;
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		screenWidth = canvas.getWidth()-25;
		screenHeigth = canvas.getHeight()-25;
		canvas.setSize(canvas.getWidth(),canvas.getHeight());
		canvas.setVisible(true);
		color = "magenta";
		draw(getxPosition() + getScreenWidth() / 2, (getScreenWidth() - getScreenHeigth()) / 2, ((getScreenWidth() - getScreenHeigth()) / 2) + getScreenHeigth(), getyPosition(), getScreenHeigth(), getScreenHeigth() );;
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
