package com.p11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;

public class ChatClient extends JFrame implements Runnable {
    boolean isStandalone = false;
    public ChatClient() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void init() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.show();
    }

    JPanel contentPane;
    JTextField txtInput = new JTextField();
    JButton btnSend = new JButton();
    JButton btnStart = new JButton();
    List lstMsg = new List();

    Socket sock;
    Thread thread;
    BufferedReader in;
    PrintWriter out;
    public final static int DEFAULT_PORT = 6543;
    boolean bConnected;

    public void startConnect() {
        bConnected = false;
        try {
            // sock = new Socket(this.getCodeBase().getHost()), DEFAULT_PORT);
            sock = new Socket("127.0.0.1", DEFAULT_PORT);
            bConnected = true;
            processMsg("Connection ok");
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            out = new PrintWriter(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            processMsg("Connection failed");
        }
        if (thread==null) {
            thread=new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = receiveMsg();
                Thread.sleep(100L);
                if (msg !=null)
                    processMsg(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ei) {}
    }

    public void sendMsg(String msg) throws IOException {
        out.println(msg);
        out.flush();
    }

    public String receiveMsg() throws IOException {
        String msg = new String();
        try {
            msg = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public void processMsg(String str) {
        this.lstMsg.add(str);
    }

    private void jbInit() throws Exception {
        txtInput.setText("Please input here");
        txtInput.setBounds(new Rectangle(42,234,196,34));
        // setIconImage(Toolkit.getDefaultToolkit().createImage(ChatServer.class.getResource("[Your Icon]")));
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(null);
        this.setSize(new Dimension(500,300));
        this.setTitle("Chat Client");
        btnSend.setText("Send");
        btnSend.setBounds(new Rectangle(258,235,70,35));
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnSend_actionPerformed(actionEvent);
            }
        });
        btnStart.setText("Connect To Server");
        btnStart.setBounds(new Rectangle(338,235,150,35));
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnStart_actionPerformed(actionEvent);
            }
        });
        lstMsg.setBounds(new Rectangle(42,32,319,192));
        contentPane.add(txtInput,null);
        contentPane.add(btnSend,null);
        contentPane.add(btnStart,null);
        contentPane.add(lstMsg,null);
    }

    void btnSend_actionPerformed(ActionEvent event) {
        if (txtInput.getText().length()!=0) {
            try {
                sendMsg(txtInput.getText());
            } catch (IOException e) {
                processMsg(e.toString());
            }
        }
    }

    void btnStart_actionPerformed(ActionEvent event) {
        this.startConnect();
    }

    static {
        try {

        } catch (Exception e) {}
    }
}


