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

	public int drawRecursive(int xPointA, int xPointB, int xPointC,
			int yPointA, int yPointB, int yPointC) {
		if (step == 10) {
			return 1;
		} else {
			int[] newXPoints = { (xPointA + xPointB) / 2, (xPointB + xPointC) / 2, (xPointC + xPointA) / 2 };
			int[] newYPoints = { (yPointA + yPointB) / 2, (yPointB + yPointC) / 2, (yPointC + yPointA) / 2 };
			if (step < 5) {
				changeColor("black");
			} else {
				changeColor("white");
			}
			canvas.draw(this, color, new Polygon(newXPoints, newYPoints, 3));
			step = step + 1;
			return drawRecursive(newXPoints[0], newXPoints[1], newXPoints[2], newYPoints[0], newYPoints[1], newYPoints[2]);
		}
	}
}
