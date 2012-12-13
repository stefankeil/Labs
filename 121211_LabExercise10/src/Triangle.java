import java.awt.*;

public class Triangle {
	private int screenWidth = 1680;
	private int screenHeigth = 600;
	private int length;
	private int xPosition;
	private int yPosition;
	private String color;
	private boolean isVisible;
	private Canvas canvas = new Canvas(screenWidth, screenHeigth, Color.white);
//	private int step;

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
		xPosition = 0;
		yPosition = 0;
		color = "magenta";
		isVisible = true;
	}

	public void changeColor(String newColor) {
		color = newColor;
	}

	public void draw(int xPointA, int xPointB, int xPointC, int yPointA, int yPointB, int yPointC) {
		if (isVisible) {
			int[] xPoints = { xPointA, xPointB, xPointC };
			int[] yPoints = { yPointA, yPointB, yPointC };
			canvas.draw(this, color, new Polygon(xPoints, yPoints, 3));
			
			int[] newXPoints = { (xPoints[0] + xPoints[1]) / 2, (xPoints[1] + xPoints[2]) / 2, (xPoints[2] + xPoints[0]) / 2 };
			int[] newYPoints = { (yPoints[0] + yPoints[1]) / 2, (yPoints[1] + yPoints[2]) / 2, (yPoints[2] + yPoints[0]) / 2 };
			changeColor("Black");
			canvas.draw(this, color, new Polygon(newXPoints, newYPoints, 3));
			
			drawRecursive(newXPoints[0], newXPoints[1], newXPoints[2], newYPoints[0], newYPoints[1], newYPoints[2], xPoints[0], xPoints[1], xPoints[2], yPoints[0], yPoints[1], yPoints[2], 2 );
		}
	}

	public int drawRecursive(int xPointA, int xPointB, int xPointC, int yPointA, int yPointB, int yPointC, int oldXPointA, int oldXPointB, int oldXPointC, int oldYPointA, int oldYPointB, int oldYPointC, int step) {
		if (step == 0){
			return 1;
		}else {
			
			int[] newTopXPoints = {(oldXPointA + xPointA)/2, (xPointA + xPointC) /2, (xPointC + oldXPointA) /2};
			int[] newTopYPoints = {(oldYPointA + yPointA)/2, (yPointA + yPointC) /2, (yPointC + oldYPointA) /2};
			
			changeColor("blue");
			
			canvas.draw(this, color, new Polygon(newTopXPoints, newTopYPoints, 3));
			drawRecursive(newTopXPoints[0], newTopXPoints[1], newTopXPoints[2], newTopYPoints[0], newTopYPoints[1], newTopYPoints[2], oldXPointA, xPointB, xPointC, oldYPointA, yPointB, yPointC, step - 1);
			
			int[] newRightXPoints = {(xPointA + oldXPointB) /2, (oldXPointB + xPointB) /2, (xPointB + xPointA) /2};
			int[] newRightYPoints = {(yPointA + oldYPointB) /2, (oldYPointB + yPointB) /2, (yPointB + yPointA) /2};
			
			changeColor("red");
			
			canvas.draw(this, color, new Polygon(newRightXPoints, newRightYPoints, 3));
			drawRecursive(newRightXPoints[0], newRightXPoints[1], newRightXPoints[2],  newRightYPoints[0], newRightYPoints[1], newRightYPoints[2], xPointA, oldXPointB, xPointC, yPointA, oldYPointB, yPointC, step - 1);

			int[] newLeftXPoints = {(xPointC + xPointB) /2, (xPointB + oldXPointC) /2, (oldXPointC + xPointC) /2};
			int[] newLeftYPoints = {(yPointC + yPointB) /2, (yPointB + oldYPointC) /2, (oldYPointC + yPointC) /2};
			
			changeColor("green");
			
			canvas.draw(this, color, new Polygon(newLeftXPoints, newLeftYPoints, 3));
			drawRecursive(newLeftXPoints[0], newLeftXPoints[1], newLeftXPoints[2], newLeftYPoints[0], newLeftYPoints[1], newLeftYPoints[2], xPointA, xPointB, oldYPointC, yPointA, yPointB, oldYPointC, step - 1);
		
		}
		return 2;
	}
}
