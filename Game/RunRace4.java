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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class RunRace4 extends Frame{
    private Button btn;
    private Panel[] pp;
    public int c =0; 
    private Image img;
    
    public RunRace4(String[] args) {
        super("말 경주");
        c =Integer.parseInt(args[0]);
        //말의 갯수만큼 Panel을 생성, Panel에는 Racer이 들어간다.        
        btn = new Button("start");
        Panel pb = new Panel();
        for(int i = 0 ; i <28 ; i++) {
            pb.add(new Label());}
        pb.add(btn);
        
        Scanner scanner = new Scanner(System.in);
        
        Panel bigPanel = new Panel();
        bigPanel.setLayout(new GridLayout( c ,1, 5, 5));
        
        for ( int i = 0 ; i < c ; i++) {
            Panel p = new Panel();
            p.setBackground(Color.CYAN);
            bigPanel.add(p);
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
        
    }
    
    public void paint(Graphics g){
        Toolkit t = Toolkit.getDefaultToolkit();
        
        img = t.getImage("D:\\java_se\\workspace\\11_exception_thread\\horse.gif"); 
        //g.drawImage(img, x1, y1, x2, y2, sel*50, 0, sel*50+50 , 50, this);
        
    
        }
    
    
    public static void main(String[] args) {
        
        if(args.length <2) { //2개 미만의 인수가 들어오면 강제로 종료 시킨다.
            System.out.println("Usage : java RunRace count name1, ...");
            System.exit(0);
        }
        
        if(Integer.parseInt(args[0]) != args.length-1) {
            System.out.println("말 마리수와 이름의 개수가 맞지 않습니다.");
            System.exit(0);            
        }
        
        new RunRace4(args);
        
    }
    
    
}
