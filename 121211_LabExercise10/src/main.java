import java.awt.Color;
import java.io.ObjectInputStream.GetField;

public class main {

	public static void main(String[] args) {
		Triangle mytriangle = new Triangle();
		mytriangle.draw(mytriangle.getxPosition() + mytriangle.getScreenWidth() / 2, (mytriangle.getScreenWidth() - mytriangle.getScreenHeigth()) / 2, ((mytriangle.getScreenWidth() - mytriangle.getScreenHeigth()) / 2) + mytriangle.getScreenHeigth(), mytriangle.getyPosition(), mytriangle.getScreenHeigth(), mytriangle.getScreenHeigth() );
	}

}
