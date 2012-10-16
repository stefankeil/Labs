import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatterboxServer {

	//private final static String HOST = "localhost";
	private final static int PORT_NUMBER = 1025;

	private Socket socket;
	private ServerSocket serverSocket;

	public ChatterboxServer() {
		try {
			//socket = new Socket(PORT_NUMBER);
			serverSocket = new ServerSocket(PORT_NUMBER);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readFromSocket() {
		try {
			while (true) {
				socket = serverSocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println(br.readLine());
				return br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) {
		new ChatterboxServer().readFromSocket();
	}
}
