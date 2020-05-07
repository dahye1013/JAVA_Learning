package Calculator;
import java.awt.*;
import java.awt.event.*;

public class Calculator3 extends Frame implements ActionListener{
    
    private Label dispL, inputL;
    private Button[] button;
    private Button exitBtn;
     StringBuffer inB = new StringBuffer("");
     StringBuffer disB = new StringBuffer("");
     
    public Calculator3(){
        super("dahye's");
        
        }
    
    public void display(){
        
        dispL = new Label("0", Label.RIGHT);
        inputL = new Label("0", Label.RIGHT);
   
       
        Button[] bt = new Button[18];
        for(int i = 0 ; i < 18 ; i ++) {
            bt[i] = new Button();
        } 
        
        String[] str = new String[] {"<-", "C", "7","8","9","/","4","5","6","*","1","2","3",
                "-",".","0","-","="};
        for(int i = 0 ; i < str.length ;i++) {
        bt[i] = new Button(str[i]);
        }
        
        Panel p0 = new Panel(); 
        p0.setLayout(new GridLayout(2,1,2,5));
        p0.setBackground(new Color(255,255,255,255));
        p0.add(inputL);
        
        Panel p1 = new Panel(); 
        p1.setLayout(new GridLayout(2,1,2,5));
        p1.setBackground(new Color(255,255,255,255));
        p1.add(dispL);

        Panel p2 = new Panel(); 
        p2.setLayout(new GridLayout(1,2,2,5));
        p2.add(bt[0]); 
        p2.add(bt[1]);

        Panel p3 = new Panel(); 
        p3.setLayout(new GridLayout(1,4,2,5));
        for (int i = 2 ; i <= 5 ; i++ ) {
            p3.add(bt[i]);
        }
        
        Panel p4 = new Panel(); 
        p4.setLayout(new GridLayout(1,4,2,5));
        for (int i = 6 ; i <= 9 ; i++ ) {
            p4.add(bt[i]);
        }
        
        Panel p5 = new Panel(); 
        p5.setLayout(new GridLayout(1,4,2,5));
        for (int i = 10 ; i <= 13 ; i++ ) {
            p5.add(bt[i]);
        }
        
        Panel p6 = new Panel(); 
        p6.setLayout(new GridLayout(1,4,2,5));
        for (int i = 14 ; i <= 17 ; i++ ) {
            p6.add(bt[i]);
        }

        Panel bigPanel = new Panel();
        bigPanel.setLayout(new GridLayout(7,4,2,5));
        bigPanel.add(p0);
        bigPanel.add(p1);
        bigPanel.add(p2);
        bigPanel.add(p3);
        bigPanel.add(p4);
        bigPanel.add(p5);
        bigPanel.add(p6);
        
        add("Center", bigPanel);
        
        //frame
        setVisible(true);
        setBounds(900,200,300,400);
        setBackground(Color.BLACK);
        setResizable(false);
        
        //이벤트
        
        this.addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) {
                   System.exit(0);
               }
        });
        
        for(int i = 0 ; i < 18 ; i ++) {
            bt[i].addActionListener(this);
        }
    }//display 메소드

    
    public static void main(String[] args)  {
        Calculator3 cc = new Calculator3();   
        cc.display();
    }//메인메소드
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        

        
        for(int i = 0 ; i < 10 ; i++ ) {
            if(e.getActionCommand().equals(""+i))
                inB.append(""+i);
            else if(inB.length() == 1 && inB.toString().equals("0")) {
                inB.delete(0, 1);
            }
        } 
        
        
        if(e.getActionCommand() == "C") {
            inB.delete(0,inB.length());
            disB.delete(0,disB.length());
            
            inB.append("0");
            inputL.setText(inB+"");
        }else if(e.getActionCommand() == "<-") {
            inB.delete(inB.length()-1, inB.length());
            if(inB.length() == 0) 
                inB.append("0");
        }else if(e.getActionCommand() == "." ) {  
            if(inB.indexOf(".") == -1) {
                inB.append(".");
                }
        }
        
        
        if(e.getActionCommand() == "-")
            inB.append("-");
        if(e.getActionCommand() == "*")
            inB.append("*");
        if(e.getActionCommand() == "/")
            inB.append("/");

        

        inputL.setText(inB.toString());
        
        
        }
    
    
    }
         

    
    

        