package Thread;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerTest extends JFrame implements Runnable {
    JButton startBtn, stopBtn;
    JPanel p, p1;
    private JLabel label;
    int ii = 0;
    private boolean bb = true;

    public TimerTest() {
        
        label = new JLabel("0");
        label.setFont(new Font("고딕체", Font.BOLD , 70));
        
        startBtn = new JButton("Start");
        stopBtn = new JButton("stop");
        
        p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p.add(startBtn);
        p.add(stopBtn);

        label.setBounds(70, 30,100,100);
        p1 = new JPanel();
        
        add("South", p);
        add("Center", p1);
        setTitle("timer");
        setBounds(900, 200, 300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // 이벤트
        startBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                bb = true;
                new Thread(TimerTest.this).start();
            }

        });

        stopBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                bb = false;
                new Thread(TimerTest.this).start();
            }
        });
    }

    
    @Override
    public void run() {
        int i = ii;
        if (ii == 50)
            ii = 0;

        while (true) {
            i++;
            if (!bb)
                break;

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("i =" + i);
            ii = i;
            if (i >= 50)
                i = 0;
            repaint();

        }
    }

    

    public static void main(String[] args) {
        new TimerTest();
    }

}
