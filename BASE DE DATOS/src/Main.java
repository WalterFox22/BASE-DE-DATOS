import javax.swing.*;
import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Mi aplicación");
        frame.setContentPane(new sql().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2600, 200);
        frame.pack();
        frame.setVisible(true);
    }
}