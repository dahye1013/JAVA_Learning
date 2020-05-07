package Game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class RunRace extends Frame implements Runnable, ActionListener{
    private Button btn;
    private Panel[] pp;
    int count ;
    private Panel p;
    private Image img;
    Racer[] racer = new Racer[count];
    
    public RunRace(String[] args) {
        super("말 경주");
         count =Integer.parseInt(args[0]);
        //말의 갯수만큼 Panel을 생성, Panel에는 Racer이 들어간다.        

        btn = new Button("start");
        Panel pb = new Panel();
        for(int i = 0 ; i <28 ; i++) {
            pb.add(new Label());}
		     pb.add(btn);
        
        Scanner scanner = new Scanner(System.in);
        
        Panel bigPanel = new Panel();
        bigPanel.setLayout(new GridLayout( count ,1, 5, 5));

        
        
        for ( int i = 0 ; i < racer.length ; i++) {
            p  = new Panel();
            racer[i]  = new Racer(args[i+1]);
            p.add(racer[i]);
			p.setBackground(new Color((int)(Math.random()*256), 200 , (int)(Math.random()*256)));
            					
            }
      

        this.add("South", pb);
        this.add("Center", bigPanel);
        
        setVisible(true);
        setBounds(900,200,600,400);
        setResizable(false);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
     });
		//이벤트
		btn.addActionListener(this);        


    }//runRace()
    
    
    public static void main(String[] args) {
        
        if(args.length <2) { //2개 미만의 인수가 들어오면 강제로 종료 시킨다.
            System.out.println("Usage : java RunRace count name1, ...");
            System.exit(0);
        }
        
        if(Integer.parseInt(args[0]) != args.length-1) {
            System.out.println("말 마리수와 이름의 개수가 맞지 않습니다.");
            System.exit(0);            
        }
        
        new RunRace(args);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Thread[] t = new Thread[count];
        
        for(int i = 0 ; i < count ; i++) {
            t[i] = new Thread(racer[i]);
            t[i].setPriority((int)(Math.random()*10)+1);
            //스레드 시작 - 스레드 실행 (run)
            t[i].start(); //스레드 시작 - 스레드 실행(run)
        }
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
    
    
   
    



    
}
