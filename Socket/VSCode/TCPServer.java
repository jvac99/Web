import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		try {
			int porta = 7896;
			ServerSocket servidor = new ServerSocket(porta);
			while (true) {
				Socket clienteSocket = servidor.accept();
				Connection c = new Connection(clienteSocket);
			}
		} catch (IOException e) {
			System.out.print("Listen: " + e.getMessage());
		}
	}

}
