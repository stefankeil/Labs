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
	private int step;

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

	public void draw() {
		if (isVisible) {
			int[] xPoints = { xPosition + screenWidth / 2, (screenWidth - screenHeigth) / 2, ((screenWidth - screenHeigth) / 2) + screenHeigth };
			int[] yPoints = { yPosition, screenHeigth, screenHeigth };
			canvas.draw(this, color, new Polygon(xPoints, yPoints, 3));
			int[] newXPoints = { (xPoints[0] + xPoints[1]) / 2, (xPoints[1] + xPoints[2]) / 2, (xPoints[2] + xPoints[0]) / 2 };
			int[] newYPoints = { (yPoints[0] + yPoints[1]) / 2, (yPoints[1] + yPoints[2]) / 2, (yPoints[2] + yPoints[0]) / 2 };
			changeColor("Black");
			canvas.draw(this, color, new Polygon(newXPoints, newYPoints, 3));
			drawRecursive(newXPoints[0], newXPoints[1], newXPoints[2], newYPoints[0], newYPoints[1], newYPoints[2], xPoints[0], xPoints[1], xPoints[2], yPoints[0], yPoints[1], yPoints[2] );
		}
	}

	public void drawRecursive(int xPointA, int xPointB, int xPointC, int yPointA, int yPointB, int yPointC, int oldXPointA, int oldXPointB, int oldXPointC, int oldYPointA, int oldYPointB, int oldYPointC) {
		while (step != 5){
			
			int[] newTopXPoints = {(oldXPointA + xPointA)/2, (xPointA + xPointC) /2, (xPointC + oldXPointA) /2};
			int[] newTopYPoints = {(oldYPointA + yPointA)/2, (yPointA + yPointC) /2, (yPointC + oldYPointA) /2};
			
			int[] newRightXPoints = {(xPointA + oldXPointB) /2, (oldXPointB + xPointB) /2, (xPointB + xPointA) /2};
			int[] newRightYPoints = {(yPointA + oldYPointB) /2, (oldYPointB + yPointB) /2, (yPointB + yPointA) /2};
			
			int[] newLeftXPoints = {(xPointC + xPointB) /2, (xPointB + oldXPointC) /2, (oldXPointC + xPointC) /2};
			int[] newLeftYPoints = {(yPointC + yPointB) /2, (yPointB + oldYPointC) /2, (oldYPointC + yPointC) /2};
			
//			if (step%2 == 0) {
//				changeColor("black");
//			} else {
				changeColor("white");
//			}
			
			//canvas.draw(this, color, new Polygon(newXPoints, newYPoints, 3));
			canvas.draw(this, color, new Polygon(newTopXPoints, newTopYPoints, 3));
			canvas.draw(this, color, new Polygon(newRightXPoints, newRightYPoints, 3));
			canvas.draw(this, color, new Polygon(newLeftXPoints, newLeftYPoints, 3));
			
			step = step + 1;
			
			drawRecursive(newTopXPoints[0], newTopXPoints[1], newTopXPoints[2], newTopYPoints[0], newTopYPoints[1], newTopYPoints[2], xPointA, xPointB, xPointC, yPointA, yPointB, yPointC);
		}
	}
}
