package util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) {
		Socket s = null;
		try {
			int porta = 7896;
			s = new Socket("localhost", porta);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF("localhost");
			String data = in.readUTF();
			System.out.print("Conectado com sucesso: " + data + " porta: "+ porta);
		} catch (UnknownHostException e) {
			System.out.println("Sock: " + e.getMessage());
		} catch (EOFException e) {
			System.out.print("EOF: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					System.out.println("Close: " + e.getMessage());
				}
			}
		}
	}

}
