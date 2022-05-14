// all packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class Main implements ActionListener{
    JMenuItem save = new JMenuItem("save");
    JMenuItem about = new JMenuItem("about");
    JMenuItem open = new JMenuItem("open");
    JFrame win = new JFrame();
    JTextArea txta = new JTextArea();
    public static void main(String[] args){
        new Main();
    }
    Main(){
        JFrame win = new JFrame();
        JMenuBar bar = new JMenuBar();
        ImageIcon ico = new ImageIcon("img/icon2.png");
        win.setIconImage(ico.getImage());
        JMenu file = new JMenu("file");
        JMenu about1 = new JMenu("about");
        bar.add(file);
        about1.add(about);
        bar.add(about1);
        file.add(save);
        file.add(open);
        win.add(bar, BorderLayout.NORTH);
        win.setSize(400, 400);
        save.addActionListener(this);
        about.addActionListener(this);
        open.addActionListener(this);
        win.setTitle("txt-edit");
        txta.setLineWrap(true);
        win.add(txta);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
    }
    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == about){
            JOptionPane.showMessageDialog(null, "this app is devloped by ritveek in java", "about", JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() == open){
            int ca;
            try {
                FileReader fr = new FileReader("New Text Document.txt");
                try {
                    while ((ca=fr.read()) !=-1) {
                        JOptionPane.showMessageDialog(null, (char)ca, "file cotent", JOptionPane.PLAIN_MESSAGE);
                    }
                    fr.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if (e.getSource() == save){
            File myObj = new File("New Text Document.txt");
            try {
                myObj.createNewFile();
                FileWriter myWriter = new FileWriter("New Text Document.txt");
                myWriter.write(txta.getText());
                myWriter.close();
                JOptionPane.showMessageDialog(null, "file saved sucessfully", "sucess", JOptionPane.PLAIN_MESSAGE);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}