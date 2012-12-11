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
			drawRecursive(xPoints[0], xPoints[1], xPoints[2], yPoints[0], yPoints[1], yPoints[2]);
		}
	}

	public void drawRecursive(int xPointA, int xPointB, int xPointC,
			int yPointA, int yPointB, int yPointC) {
		while (step != 5){
			int[] newXPoints = { (xPointA + xPointB) / 2, (xPointB + xPointC) / 2, (xPointC + xPointA) / 2 };
			int[] newYPoints = { (yPointA + yPointB) / 2, (yPointB + yPointC) / 2, (yPointC + yPointA) / 2 };
			int[] newTopXPoints = {(xPointA + newXPoints[0])/2, (newXPoints[0] + newXPoints[2]) /2, (newXPoints[2] + xPointA) /2};
			int[] newTopYPoints = {(yPointA + newYPoints[0])/2, (newYPoints[0] + newYPoints[2]) /2, (newYPoints[2] + yPointA) /2};
			int[] newRightXPoints = {(newXPoints[0] + xPointB) /2, (xPointB + newXPoints[1]) /2, (newXPoints[1] + newXPoints[0]) /2};
			int[] newRightYPoints = {(newYPoints[0] + yPointB) /2, (yPointB + newYPoints[1]) /2, (newYPoints[1] + newYPoints[0]) /2};
			int[] newLeftXPoints = {(newXPoints[1] + newXPoints[2]) /2, (newXPoints[1] + xPointC) /2, (xPointC + newXPoints[2]) /2};
			int[] newLeftYPoints = {(newYPoints[1] + newYPoints[2]) /2, (newYPoints[1] + yPointC) /2, (yPointC + newYPoints[2]) /2};
			
			if (step%2 == 0) {
				changeColor("black");
			} else {
				changeColor("white");
			}
			canvas.draw(this, color, new Polygon(newXPoints, newYPoints, 3));
			canvas.draw(this, color, new Polygon(newTopXPoints, newTopYPoints, 3));
			canvas.draw(this, color, new Polygon(newRightXPoints, newRightYPoints, 3));
			canvas.draw(this, color, new Polygon(newLeftXPoints, newLeftYPoints, 3));
			step = step + 1;
			drawRecursive(newXPoints[0], newXPoints[1], newXPoints[2], newYPoints[0], newYPoints[1], newYPoints[2]);
		}
	}
}
