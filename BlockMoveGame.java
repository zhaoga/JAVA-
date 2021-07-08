package com.p10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockMoveGame extends JFrame {
    final int RC = 4;
    final int N = RC*RC;

    int[] num = new int[N];
    JButton[] btn = new JButton[N];
    JButton btnStart = new JButton("开始游戏");

    public BlockMoveGame() {
        setTitle("简单的排块游戏");
        setSize(300,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.setLayout(new GridLayout(RC,RC));
        p2.add(btnStart);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p1,BorderLayout.CENTER);
        getContentPane().add(p2,BorderLayout.SOUTH);

        Font font = new Font("Times New Rome", 0,24);
        for (int i=0;i<N;i++) {
            num[i] = i;
            btn[i]=new JButton(""+(num[i]+1));
            btn[i].setFont(font);
            p1.add(btn[i]);
            btn[i].setVisible(true);
        }
        btn[N-1].setVisible(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnStart_Click();
            }
        });
        for (int i=0;i<N;i++) {
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    for (int j=0;j<N;j++)
                        if ((JButton)actionEvent.getSource()==btn[j])
                            btn_Click(j);
                }
            });
        }
    }
    public void btnStart_Click() {
        int i,j,k,t;
        for (i=1;i<500;i++) {
            j=(int) (Math.random()*N);
            k=(int) (Math.random()*N);
            t=num[j];
            num[j]=num[k];
            num[k]=t;
        }
        for (i=0;i<N;i++){
            btn[i].setLabel(""+(num[i]+1));
            btn[i].setVisible(true);
        }
        i=findBlank();
        btn[i].setVisible(false);
    }
    int findBlank(){
        int i;
        for (i=0;i<N;i++){
            if (num[i]==N-1)
                break;
        }
        return i;
    }

    void btn_Click(int index) {
        int blank,t;
        blank=findBlank();
        if (isNeighbor(blank,index)){
            btn[index].setVisible(false);
            btn[index].setVisible(true);
            t=num[blank];
            num[blank]=num[index];
            num[index]=t;
            btn[blank].setLabel(""+(num[blank]+1));
            btn[index].setLabel(""+(num[index]+1));
        }
        checkResult();
    }
    boolean isNeighbor(int a,int b) {
        boolean r;
        r=false;
        if (a==b-RC||a==b+RC)
            r=true;
        if ((a==b-1||a==b+1)&&a/RC==b/RC)
            r=true;
        return r;
    }

    void checkResult() {
        int i;
        for (i=0;i<N;i++){
            if (num[i]!=i)
                return;;
        }
        JOptionPane.showMessageDialog(this,"你赢了！请单击【开始】再来一次。");
    }

    public static void main(String[] args) {
        new BlockMoveGame().setVisible(true);
    }
}
