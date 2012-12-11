
import java.awt.*;

	public class Triangle
	{
	    private int screenwidth = 1680;
	    private int screenheigth = 600;
	    private int length;
	    private int xPosition;
	    private int yPosition;
	    private String color;
	    private boolean isVisible;
	    private Canvas canvas = new Canvas(screenwidth,screenheigth,Color.white);

	    /**
	     * Create a new triangle at default position with default color.
	     */
	    public Triangle()
	    {
	        xPosition = 0;
	        yPosition = 0;
	        color = "magenta";
	        isVisible = true;
	    }

	    /**
	     * Make this triangle visible. If it was already visible, do nothing.
	     */
//	    public void makeVisible()
//	    {
//	        isVisible = true;
//	        draw();
//	    }

	    /**
	     * Make this triangle invisible. If it was already invisible, do nothing.
	     */
//	    public void makeInvisible()
//	    {
//	        //erase();
//	        isVisible = false;
//	    }

	    /**
	     * Move the triangle a few pixels to the right.
	     */
//	    public void moveRight()
//	    {
//	        moveHorizontal(20);
//	    }
//
//	    /**
//	     * Move the triangle a few pixels to the left.
//	     */
//	    public void moveLeft()
//	    {
//	        moveHorizontal(-20);
//	    }
//
//	    /**
//	     * Move the triangle a few pixels up.
//	     */
//	    public void moveUp()
//	    {
//	        moveVertical(-20);
//	    }
//
//	    /**
//	     * Move the triangle a few pixels down.
//	     */
//	    public void moveDown()
//	    {
//	        moveVertical(20);
//	    }

	    /**
	     * Move the triangle horizontally by 'distance' pixels.
	     */
//	    public void moveHorizontal(int distance)
//	    {
//	        erase();
//	        xPosition += distance;
//	        draw();
//	    }
//
//	    /**
//	     * Move the triangle vertically by 'distance' pixels.
//	     */
//	    public void moveVertical(int distance)
//	    {
//	        erase();
//	        yPosition += distance;
//	        draw();
//	    }

	    /**
	     * Slowly move the triangle horizontally by 'distance' pixels.
	     */
//	    public void slowMoveHorizontal(int distance)
//	    {
//	        int delta;
//
//	        if(distance < 0) 
//	        {
//	            delta = -1;
//	            distance = -distance;
//	        }
//	        else 
//	        {
//	            delta = 1;
//	        }
//
//	        for(int i = 0; i < distance; i++)
//	        {
//	            xPosition += delta;
//	            draw();
//	        }
//	    }

	    /**
	     * Slowly move the triangle vertically by 'distance' pixels.
	     */
//	    public void slowMoveVertical(int distance)
//	    {
//	        int delta;
//
//	        if(distance < 0) 
//	        {
//	            delta = -1;
//	            distance = -distance;
//	        }
//	        else 
//	        {
//	            delta = 1;
//	        }
//
//	        for(int i = 0; i < distance; i++)
//	        {
//	            yPosition += delta;
//	            draw();
//	        }
//	    }

	    /**
	     * Change the size to the new size (in pixels). Size must be >= 0.
	     */
//	    public void changeSize(int newHeight, int newWidth)
//	    {
//	        erase();
//	        height = newHeight;
//	        width = newWidth;
//	        draw();
//	    }

	    /**
	     * Change the color. Valid colors are "red", "yellow", "blue", "green",
	     * "magenta" and "black".
	     */
	    public void changeColor(String newColor)
	    {
	        color = newColor;
	        draw();
	    }

	    /*
	     * Draw the triangle with current specifications on screen.
	     */
	    public void draw()
	    {
	        if(isVisible) {
	          //  Canvas canvas = Canvas.getCanvas();
	            int[] xpoints = { xPosition + screenwidth/2 , (screenwidth-screenheigth)/2, ((screenwidth-screenheigth)/2)+screenheigth };
	            int[] ypoints = { yPosition, screenheigth, screenheigth };
	            canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
	            int[] newxpoints = { (xPosition + screenwidth/2 + (screenwidth-screenheigth)/2)/2, ((screenwidth-screenheigth)/2 + ((screenwidth-screenheigth)/2)+screenheigth)/2 , (((screenwidth-screenheigth)/2)+screenheigth+xPosition + screenwidth/2)/2 };
	            int[] newypoints = { (yPosition + screenheigth)/2, (screenheigth + screenheigth)/2, (yPosition + screenheigth)/2 };
	            changeColor("black");
	            canvas.draw(this, color, new Polygon(newxpoints, newypoints, 3));
	        }
	    }

	    /*
	     * Erase the triangle on screen.
	     */
//	    private void erase()
//	    {
//	        if(isVisible) {
//	            Canvas canvas = Canvas.getCanvas();
//	            canvas.erase(this);
//	        }
	    }
	


