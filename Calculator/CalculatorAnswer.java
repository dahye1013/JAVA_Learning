package Calculator;
import java.awt.*;
import java.awt.event.*;

class CalculatorAnswer extends Frame implements ActionListener {
    private Label dispL, inputL;
    private StringBuffer dispBuf, inputBuf;
    private Button[] button = new Button[16];
    private String[] str = new String[]{"7","8","9","/",
                                        "4","5","6","*",
                                        "1","2","3","-",
                                        ".","0","=","+"};
    private Button button1, button2;
    
    public CalculatorAnswer(){
        super("미니계산기");

        //Label 설정
        dispL = new Label();
        dispL.setBackground(new Color(223, 225, 229));
        dispL.setBounds(10, 40, 330, 60);
        dispL.setFont(new Font("Consolas", Font.BOLD, 20));
        add(dispL);
        dispBuf = new StringBuffer();

        inputL = new Label("0", Label.RIGHT);
        inputL.setBackground(new Color(223, 225, 229));            
        inputL.setBounds(10, 108, 330, 60);
        inputL.setFont(new Font("Consolas", Font.BOLD, 20));
        add(inputL);
        inputBuf = new StringBuffer("0");

        //pannel 설정
        Panel pn1 = new Panel();
        pn1.setBounds(15, 175, 320, 50);
        pn1.setLayout(new GridLayout(1,2,5,0));

        Panel pn2 = new Panel();
        pn2.setBounds(15, 230, 320, 205);
        pn2.setLayout(new GridLayout(4,4,5,5));

        //button 설정 
        add(pn1);
        button1 = new Button("←");
        button1.setBackground(new Color(241, 243, 244));
        button2 = new Button("C");
        button2.setBackground(new Color(241, 243, 244));
        pn1.add(button1);
        pn1.add(button2);

        button1.addActionListener(this); //←
        button2.addActionListener(this); //C

        add(pn2);
        for(int i = 0; i <16; ++i){
            button[i] = new Button(str[i]);
            button[i].setBackground(new Color(241, 243, 244));
            pn2.add(button[i]);

            button[i].addActionListener(this);
        }

        //Frame 설정 
        setLayout(null);
        setResizable(false);
        setBounds(900, 200, 350, 450);
        setBackground(Color.WHITE);
        setVisible(true);

            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
         });
        }
    //ActionListener Override
    public void actionPerformed(ActionEvent e){
        String push = e.getActionCommand();
        if(push == "1" || 
           push == "2" || 
           push == "3" || 
           push == "4" || 
           push == "5" || 
           push == "6" || 
           push == "7" || 
           push == "8" || 
           push == "9" ||
           push == "0"){

            if(inputBuf.length() == 1 && inputBuf.toString().equals("0")){
                inputBuf.delete(0, 1);
            }
            
            inputBuf.append(push);
            inputL.setText(inputBuf+"");
        
        }else if(push=="C"){
            dispBuf.delete(0, dispBuf.length());
            inputBuf.delete(0, inputBuf.length());
            inputBuf.append("0");

            dispL.setText("");
            inputL.setText("0");

        }else if(push=="←"){
            inputBuf.delete(inputBuf.length()-1, inputBuf.length());
            if(inputBuf.length() == 0) inputBuf.append("0");
            inputL.setText(inputBuf+"");

        }else if(push=="."){
            if(inputBuf.indexOf(".") == -1) {
                inputBuf.append(".");
            }
            inputL.setText(inputBuf+"");
        }
    }

    public static void main(String[] args) {
        CalculatorAnswer cd = new CalculatorAnswer();
    }
}













