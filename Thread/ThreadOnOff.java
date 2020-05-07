package Thread;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ThreadOnOff extends JFrame implements Runnable{
        private JButton btn;
        private boolean bb = true;
        private static int ii;

    public ThreadOnOff(){
        btn = new JButton("누르기");
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p.add(btn);
        
        add("South", p);
        setSize(300,150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //이벤트
        btn.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                bb = true;
 //               new Thread(this); 여기서 this 지칭은 이벤트내의 익명 바디이다. 
                new Thread(ThreadOnOff.this).start(); // ThreadOnOff.this 형태로 지칭해야 밖에 있는 것을 지칭할수 있다.
                                                //inner, outer클래스 내용 참조할것.
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                bb = false;
            }
            
        });
       
    }//ThreadOnOff
    @Override
    public void run() {
        int i =ii;
        if(ii==100) ii=0;
        
        while(true) {
            i++;
            if(!bb)  break;
            
            try {
            Thread.sleep(50);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("i =" + i);
            ii = i;
            if(i>=50) i=0;
            
            repaint();
        }//while
    }
    
    
    public static void main(String[] args) {    
        new ThreadOnOff();
    }
    


}
