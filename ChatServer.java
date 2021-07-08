package com.p11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer extends JFrame implements Runnable {
    JPanel contentPane;
    JTextField txtInput = new JTextField();
    JButton btnSend = new JButton();
    List lstMsg = new List();

    public ChatServer() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServerLiisten();
    }

    private void jbInit() throws Exception {
        txtInput.setText("Please input here");
        txtInput.setBounds(new Rectangle(42,234,196,34));
        // setIconImage(Toolkit.getDefaultToolkit().createImage(ChatServer.class.getResource("[Your Icon]")));
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(null);
        this.setSize(new Dimension(400,300));
        this.setTitle("Chat Server");
        btnSend.setText("Chat Server");
        btnSend.setBounds(new Rectangle(268,235,98,35));
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnSend_actionPerformed(actionEvent);
            }
        });
        lstMsg.setBounds(new Rectangle(42,32,319,192));
        contentPane.add(txtInput,null);
        contentPane.add(btnSend,null);
        contentPane.add(lstMsg,null);
    }

    protected void processWindowEvent(WindowEvent event) {
        super.processWindowEvent(event);
        if (event.getID()==WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.show();
    }

    public void processMsg(String str) {
        this.lstMsg.add(str);
    }

    void btnSend_actionPerformed(ActionEvent event) {
        for (int i=0;i<clients.size();i++) {
            Connection c = (Connection) clients.get(i);
            try {
                c.sendMsg(this.txtInput.getText());
            } catch (Exception e) {}
        }
    }

    public final static int DEFAULT_PORT = 6543;
    protected ServerSocket listen_socket;
    Thread thread;
    Vector clients;

    public void ServerLiisten() {
        try {
            listen_socket = new ServerSocket(DEFAULT_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        processMsg("Server:listening on port " + DEFAULT_PORT);
        clients = new Vector();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket client_socket = listen_socket.accept();
                Connection connection = new Connection(client_socket,this);
                clients.add(connection);
                processMsg("One Client Comes in");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Connection extends Thread {
    protected Socket client;
    protected BufferedReader in;
    protected PrintWriter out;
    ChatServer server;

    public Connection(Socket client, ChatServer server) {
        this.client = client;
        this.server = server;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream());
        } catch (IOException e) {
            try {
                client.close();
            } catch (IOException exception) {}
            e.printStackTrace();
            return;
        }
        this.start();
    }

    @Override
    public void run() {
        String line;
        StringBuffer revline;
        int len;
        try {
            for (;;){
                line = receiveMsg();
                server.processMsg(line);
                if (line==null)
                    break;
            }
        } catch (IOException e) {}
        finally {
            try {
                client.close();
            } catch (IOException e){}
        }
    }

    public void sendMsg(String msg) throws IOException {
        out.println(msg);
        out.flush();
    }

    public String receiveMsg() throws IOException {
        String msg = new String();
        try {
            msg = in.readLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
