import javax.swing.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class sendThread implements Runnable {
    private String IP;
    private int port;
    private String msg;
    public sendThread(String IP, int port, String msg) {
        this.IP = IP;
        this.port = port;
        this.msg = msg;
    }
    @Override
    public void run() {
        Socket client = null;
        try {

            client = new Socket(IP, port);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));


            System.out.println("Content: " + msg);
            bw.write(msg + "\n");
            bw.flush();

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
