package Game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class ImageMove extends Frame implements ActionListener, WindowListener {
    private Button newBtn, exitBtn, leftBtn, rightBtn, upBtn, downBtn;

    public ImageMove() {
        super("다혜의 이미지 이동");
        newBtn = new Button("New");
        leftBtn = new Button("Left");
        rightBtn = new Button("Right");
        upBtn = new Button("up");
        downBtn = new Button("down");

        Panel p = new Panel();//FlowLayout (중앙-순서대로 배치)
        p.add(newBtn);
        p.add(leftBtn);
        p.add(rightBtn);
        p.add(upBtn);
        p.add(downBtn);
        p.setBackground(new Color(0, 0,0));
        add("North", p);
    
        setBounds(500,500,500,500);     
        setVisible(true);
        //이벤트
        this.addWindowListener(this);
        
        
    }
    
    public void paint(Graphics g){
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage("D:/java_se/workspace/07_abstract/peach.jpg"); 
        g.drawImage(img, 100,100,300,300, 300,0,0,300, this);
        }
    
    // WindowListener Override
    public void windowActivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    // ActionListener Override
    public void actionPerformed(ActionEvent e) {
    }

    public void init() {

    }

    public static void main(String[] args) {
        ImageMove im = new ImageMove();
        im.init();
    }
}
