package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

class Clock extends Frame implements Runnable{ 
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    
    public Clock(){ // 생성자
        setForeground(Color.red);
        setFont(new Font("Consolas", Font.BOLD, 30));
        setTitle(sdf.format(date));
        setBounds(700,200,300,100);
        setVisible(true); // paint메소드를 무슨다
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        Thread t= new Thread(); //스레드 생성 후, 시작을 해야함
        t.start();

        }//Clock생성자


    @Override
    public void run() {
        while(true){
            repaint(); //paint 메소드를 계속 다시 불러온다.
            try{
            Thread.sleep(1000); //기본 1/1000초라서 1000을 기입하면 1초마다 뜬다 
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    @Override
    public void paint(Graphics g){ 
//      g.drawString(new Date().toString(), 50, 100);
        g.drawString(sdf.format(date), 50, 70);

    }



    public static void main(String[] args) { //메인 메소드
            new Clock();
        }
    }
         