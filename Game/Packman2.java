package Game;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

class Packman2 extends Frame implements Runnable, KeyListener{
    int x1 = 225;
    int y1 = 225;
    int x2 = x1+50;
    int y2 = y1+50;
    int count=0;
    
    int fx1, fx2, fy1, fy2;
    int[] foody = new int[5];
    int[] foodx = new int[5];
    
    private Image img; 
    private Image[] bab= new Image[5] ; 
    private int sel=2;
 //-----------------------------------------   
    public Packman2(){ //생성자
        
    Random random = new Random();
    

    for(int i = 0 ; i <foodx.length ; i++) {
        this.foodx[i] = random.nextInt(400)+100;
        this.foody[i] = random.nextInt(400)+100;
    }
    System.out.println(foodx[0]+"\t"+foody[0]);
    setResizable(false);
    setBounds(700,200,500,500);
    setVisible(true);
    addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
    Thread t= new Thread(this);
    t.start();
    addKeyListener(this);
    
    
    
    }
//---------------------------------------------------
    @Override
    public void run() {
        while(true) {
            if(sel%2==0) sel++;
            else sel--;
            
            if(sel == 0) {
                this.x1 -= 10;
                this.x2 -=10;
                if(x1<-50) 
                { x1 = 450; x2=x1+50;}
            }else if(sel == 2) {
                this.x1 += 10;
                this.x2 +=10;
                if(x1>450) 
                { x1 = -50; x2=x1+50;}
            }else if(sel == 4) {
                this.y1 -= 10;
                this.y2 -= 10;
                if(y1 <-50) 
                { y1 = 450; y2=y1+50;}
            }else if(sel == 6) {
                this.y1 += 10;
                this.y2 += 10;
                if(y1 >450) 
                { y1 = -50; y2=y1+50;}
            }

            for(int i = 0 ; i <foodx.length ; i++) {
                if(x1+25 < foodx[i]+30 && foodx[i]< x1+25 && y1+25 < foody[i]+30 && y1+25 > foody[i]+10 ){
                    foodx[i]=0; foody[i]=0; 
                    count++;
                }
            }
            repaint();
            try{
                Thread.sleep(100); 
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
        }
    }
    
  

    public void paint(Graphics g){
        Toolkit t = Toolkit.getDefaultToolkit();
        
        g.drawString(count+"점 획득!", 200, 100);
        if(count==5) {
            g.drawString("게임 클리어!", 200, 250);
        }
        img = t.getImage("D:\\java_se\\workspace\\11_exception_thread\\pacman.png"); 
        g.drawImage(img, x1, y1, x2, y2, sel*50, 0, sel*50+50 , 50, this);
        
        
        for(int i = 0 ; i <foodx.length ; i++) {
            bab[i] = t.getImage("D:\\java_se\\workspace\\11_exception_thread\\flower.png"); 
            g.drawImage(bab[i], foodx[i], foody[i], foodx[i]+20, foody[i]+20, 0, 0, 20 , 20, this);
            }
        }
    
    
    public static void main(String[] args) {
        new Packman2();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if( e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }else if( e.getKeyCode() == 37) {
            this.sel =0;
            if(x1<-50) 
            { x1 = 450; x2=x1+50;}
            this.x1 -= 10;
            this.x2 -=10;
            }
        else if( e.getKeyCode() == 38) {
            this.sel =4;
            if(y1 <-50) 
            { y1 = 450; y2=y1+50;}
            this.y1 -= 10;
            this.y2 -= 10;
            }  
        else if( e.getKeyCode() == 39) {
            this.sel =2;
            if(x1>450) 
            { x1 = -50; x2=x1+50;}
            this.x1 += 10;
            this.x2 +=10;
            }
        else if( e.getKeyCode() == 40) {
            this.sel =6;
            if(y1 >450) 
            { y1 = -50; y2=y1+50;}
            this.y1 += 10;
            this.y2 += 10;
            }   
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
