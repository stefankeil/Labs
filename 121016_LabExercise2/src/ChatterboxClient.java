import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ChatterboxClient {
	private final static String HOST = "localhost";
	private final static int PORT_NUMBER = 1025;
	
	private Socket socket;
	
	public ChatterboxClient() {
			try {
				socket = new Socket(HOST, PORT_NUMBER);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	
	public void writeToSocket(String string){
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(string);		
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		new ChatterboxClient().writeToSocket("Test");
	}
	
}
