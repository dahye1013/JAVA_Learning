package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Racer extends Canvas {
    private String name; 
    private int pos;
    
    Image img ;
    public Racer(String name) {
        this.name = name;
        Toolkit t = Toolkit.getDefaultToolkit();
         img = t.getImage("D:\\java_se\\workspace\\11_exception_thread\\horse.gif"); 

        
        
    }
    
    
    public void paint(Graphics g){
        g.drawImage(img, 0, 0, 25, this.getSize().height, this);
      }
    
    @Override
    public void run() {
        
        for(int i = 0; i <=600 ; i+=(int)(Math.random()*10)+1) {
         pos = i ;
         repaint();
        }
        
    }
}
