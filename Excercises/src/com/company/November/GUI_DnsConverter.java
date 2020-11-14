package com.company.November;

import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.swing.*;

public class GUI_DnsConverter {

    public static void main(String[] args) {

        JFrame f = new JFrame("EasyDNS");
        final JTextField tf = new JTextField();
        tf.setBounds(10, 60, 300, 40);
        tf.setBackground(Color.black);
        tf.setForeground(Color.white);

        JLabel l1, l2;
        l1 = new JLabel("Enter URL or IP");
        l1.setBounds(50, 25, 100, 30);
        l1.setForeground(Color.yellow);

        // button click
        JButton b_click = new JButton("Get IP");
        b_click.setBounds(50, 120, 95, 30);
        b_click.setBackground(Color.black);
        b_click.setForeground(Color.yellow);

        b_click.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                doAction(tf);
            }
        });

        // button goodbye

        JButton b_goodbye = new JButton("Get URL");
        b_goodbye.setBounds(150, 120, 95, 30);
        b_goodbye.setBackground(Color.yellow);
        b_goodbye.addActionListener(actionEvent -> getHostName(tf));

        f.add(l1);
        f.add(b_click);
        f.add(b_goodbye);
        f.add(tf);
        f.setSize(400, 400);
        f.getContentPane().setBackground(Color.DARK_GRAY);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void doAction(JTextField tf) {

        try {
            tf.setForeground(Color.green);
            String host = tf.getText();
            String ip = java.net.InetAddress.getByName(host).getHostAddress();
            tf.setText("\tIP is: " + ip);
        } catch (Exception ex) {
            tf.setForeground(Color.red);
            tf.setText("IP is: unknown");
        }
    }

    public static void getHostName(JTextField tf) {
        String str = tf.getText();
            try {
                InetAddress host = InetAddress.getByName(str);
                System.out.println(host.getHostName());
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
            }
            tf.setText("URL is: unknown");
        }

}

