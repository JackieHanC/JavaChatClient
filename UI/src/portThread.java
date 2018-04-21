import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class portThread implements Runnable {
    Socket client;
    JTextArea textArea;
    public portThread(Socket client, JTextArea textArea) {
        this.client = client;
        this.textArea = textArea;
    }
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String msg = br.readLine();

            textArea.append(client.getInetAddress().toString() + ": " + msg + "\n");
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
