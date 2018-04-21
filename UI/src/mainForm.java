import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class mainForm {
    private JTextField IPAddr;
    private JFormattedTextField sendPort;
    private JTextField sendArea;
    private JTextArea msgArea;
    private JFormattedTextField listenPortTextField;
    private JButton listenButton;
    private JPanel thePanel;
    private JButton sendBtn;
    private JLabel errorLabel;
    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    private ArrayList<Integer> portList;
    public mainForm() {
        portList = new ArrayList<>();

        listenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int port = 0;
                try {
                    port = Integer.parseInt(listenPortTextField.getText());
                    if (portList.contains(port)) {
                        errorLabel.setText("Port has been used");
                        return;
                    }
                    portList.add(port);
                    new Thread(new receiveThread(port, msgArea)).start();
                } catch (java.lang.NumberFormatException e1) {
                    e1.printStackTrace();
                }
                errorLabel.setText("");
            }
        });

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String IP = IPAddr.getText();
                if (!PATTERN.matcher(IP).matches()) {
                    errorLabel.setText("Invalid IP Address");
                    return;
                }
//                System.out.println("IP valid");
                int port = 0;
                try {
                    port = Integer.parseInt(sendPort.getText());
                } catch (java.lang.NumberFormatException e1) {
                    errorLabel.setText("Invalid send Port num");
                    return;
                }
//                System.out.println("Port number valid");
                new Thread(new sendThread(IP, port, sendArea.getText())).start();
                errorLabel.setText("");
                sendArea.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("mainForm");
        frame.setContentPane(new mainForm().thePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize( 500, 300);

    }





}
