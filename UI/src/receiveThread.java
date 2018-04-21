import javax.swing.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class receiveThread implements Runnable {

    int port;
    ServerSocket serverSocket;
    JTextArea textArea;
    public receiveThread(int port, JTextArea textArea) {
        this.port = port;
        this.textArea = textArea;
    }
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println(serverSocket.getInetAddress());
//            serverSocket.bind(new InetSocketAddress("0.0.0.0", port));
            boolean f = true;
            Socket client = null;
            while (f) {
                client = serverSocket.accept();

                new Thread(new portThread(client, textArea)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
