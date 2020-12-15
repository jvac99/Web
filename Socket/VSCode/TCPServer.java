import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	private static ServerSocket servidor;
	private static Connection conexao;

	public static void main(String[] args) {
		try {
			int porta = 7896;
			servidor = new ServerSocket(porta);
			while (true) {
				Socket clienteSocket = servidor.accept();
				setConexao(new Connection(clienteSocket));
			}
		} catch (IOException e) {
			System.out.print("Error: " + e.getMessage());
		}
	}

	public static Connection getConexao() {
		return conexao;
	}

	public static void setConexao(Connection conexao) {
		TCPServer.conexao = conexao;
	}

}
