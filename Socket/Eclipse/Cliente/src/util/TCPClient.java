package util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) {
		Socket cliente = null;
		int porta = 7896;
		try {

			cliente = new Socket("localhost", porta);
			// capturando dados enviados pelo servidor.
			DataInputStream in = new DataInputStream(cliente.getInputStream());
			// Enviando dados para o servidor.
			DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
			out.writeUTF("o cliente João Victor.");
			String data = in.readUTF();
			System.out.println("Conectado com sucesso!");
			System.out.println(data + " Através da porta: " + porta + ".");
		} catch (UnknownHostException e) {
			System.out.println("Sock: " + e.getMessage());
		} catch (EOFException e) {
			System.out.print("EOF: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (cliente != null) {
				try {
					cliente.close();
				} catch (IOException e) {
					System.out.println("Fechar: " + e.getMessage());
				}
			}
		}
	}

}
