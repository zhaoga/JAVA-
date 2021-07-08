package com.p10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

class TestEditorFrame extends JFrame {
    File file = null;
    Color color = Color.black;
    JTextPane text = new JTextPane();
    JFileChooser fileChooser = new JFileChooser();
    JColorChooser colorChooser = new JColorChooser();
    JDialog about = new JDialog(this);
    JMenuBar menuBar = new JMenuBar();

    JMenu[] menus = new JMenu[] {
            new JMenu("File"),
            new JMenu("Edit"),
            new JMenu("Help")
    };
    JMenuItem menuItems[][] = new JMenuItem[][] {
            {
                    new JMenuItem("New"),
                    new JMenuItem("Open..."),
                    new JMenuItem("Save..."),
                    new JMenuItem("Exit")
            },
            {
                    new JMenuItem("Copy"),
                    new JMenuItem("Cut"),
                    new JMenuItem("Paste"),
                    new JMenuItem("Color...")
            },
            {
                    new JMenuItem("About"),
            }
    };

    JToolBar toolBar = new JToolBar();
    JButton[] buttons = new JButton[] {
            new JButton("", new ImageIcon("")),
            new JButton("", new ImageIcon("")),
            new JButton("", new ImageIcon(""))
    };

    public TestEditorFrame() {
        initTextPane();
        initMenu();
        initAboutDialog();
        initToolBar();
    }

    private void initAboutDialog() {
        about.getContentPane().add(new JLabel("简单编辑器"));
        about.setModal(true);
        about.setSize(100,50);
    }

    private void initToolBar() {
        for (int i=0;i< buttons.length;i++)
            toolBar.add(buttons[i]);
        buttons[0].setToolTipText("copy");
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text.copy();
            }
        });
        buttons[1].setToolTipText("cut");
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text.cut();
            }
        });
        buttons[2].setToolTipText("paste");
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text.paste();
            }
        });
        this.getContentPane().add(toolBar,BorderLayout.NORTH);
    }

    private void initMenu() {
        for (int i=0; i<menus.length; i++) {
            menuBar.add(menus[i]);
            for (int j=0; j< menuItems[i].length; j++) {
                menus[i].add(menuItems[i][j]);
                menuItems[i][j].addActionListener(action);
            }
        }
        this.setJMenuBar(menuBar);
    }

    ActionListener action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JMenuItem menuItem = (JMenuItem) actionEvent.getSource();
            String id = menuItem.getText();
            if (id.equals("New")) {
                text.setText("");
                file=null;
            } else if (id.equals("Open...")) {
                if (file != null)
                    fileChooser.setSelectedFile(file);
                int returnVal = fileChooser.showOpenDialog(
                        TestEditorFrame.this
                );
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    openFile();
                }
            } else if (id.equals("Save...")) {
                if (file!=null)
                    fileChooser.setSelectedFile(file);
                int returnVal = fileChooser.showSaveDialog(
                        TestEditorFrame.this
                );
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    saveFile();
                }
            } else if (id.equals("Exit")) {
                System.exit(0);
            } else if (id.equals("Cut")) {
                text.cut();
            } else if (id.equals("Copy")) {
                text.copy();
            } else if (id.equals("Paste")) {
                text.paste();
            } else if (id.equals("Color...")) {
                color = JColorChooser.showDialog(
                        TestEditorFrame.this,"",color
                );
                text.setForeground(color);
            } else if (id.equals("About")) {
                about.setSize(100,50);
                about.show();
            }
        }
    };

    void saveFile() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text.getText());
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void openFile() {
        try {
            FileReader fileReader = new FileReader(file);
            int len = (int) file.length();
            char[] buffer = new char[len];
            fileReader.read(buffer,0,len);
            fileReader.close();
            text.setText(new String(buffer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initTextPane() {
        getContentPane().add(new JScrollPane(text));
    }

}
public class TextEditorApp {
    public static void main(String[] args) {
        TestEditorFrame frame = new TestEditorFrame();
        frame.setTitle("简单的编辑器");
        frame.setSize(400,300);
        frame.show();
    }
}
