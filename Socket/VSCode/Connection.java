import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clienteSocket;

	public Connection(Socket meuClienteSocket) {
		try {
			clienteSocket = meuClienteSocket;
			in = new DataInputStream(clienteSocket.getInputStream());
			out = new DataOutputStream(clienteSocket.getOutputStream());
			// Iniciando a thread
			this.start();
		} catch (IOException e) {
			System.out.println("Conexão: " + e.getMessage());
		}
	}

	public void run() {
		try {
			// Um servidor de eco.
			// capturando dados enviados pelo cliente.
			String data = in.readUTF();
			System.out.println("Recebido: " + data);
			// Enviando dados para o servidor.
			out.writeUTF("Do servidor da Larissa para "+data);
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		} finally {
			try {
				clienteSocket.close();
			} catch (IOException e) {
				System.out.println("Falha ao fechar:" + e.getMessage());
			}
		}
	}
}