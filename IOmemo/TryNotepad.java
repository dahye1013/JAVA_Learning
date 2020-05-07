package IOmemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

class TryNotepad extends JFrame implements ActionListener, KeyListener{
    private JTextArea output;
    private MenuPane menu;
    private File file ;
     public TryNotepad(String title){
        
        output = new JTextArea();    
        JScrollPane scroll = new JScrollPane(output);   
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add("Center", scroll);
     
        menu = new MenuPane();
        setJMenuBar(menu); //
        
         setTitle(title);
         setBounds(700, 100, 700, 500);
         setVisible(true);
         setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
         addWindowListener(new WindowAdapter(){
             @Override
             public void  windowClosing(WindowEvent e) {
                 int result = JOptionPane.showConfirmDialog(TryNotepad.this, "파일을 저장하시겠습니까?", "종료", 
                         JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                 
                 if(result == JOptionPane.YES_OPTION) {
                     saveDialog();
                     fileWrite();
                     System.exit(0);
                 }else if(result == JOptionPane.NO_OPTION) {
                     System.exit(0);
                 }
             }
             
         });
     
     }
     
     public void event() {
         menu.getExitM().addActionListener(this);
         menu.getNewM().addActionListener(this);
         menu.getOpenM().addActionListener(this);
         menu.getSaveM().addActionListener(this);
         menu.getCutM().addActionListener(this);
         menu.getCopyM().addActionListener(this);
         menu.getPasteM().addActionListener(this);
         addKeyListener(this);
     }
     
     @Override
     public void actionPerformed(ActionEvent e) {
             
             if(e.getSource() == menu.getExitM() ) {
//              int num = JOptionPane.showConfirmDialog(this, "파일을 저장하시겠습니까?");
//                   if(num == 0) {
//                      saveDialog();
//                      fileWrite();
//                  }else if(num == 1) {
//                  System.exit(0);
//                  }else if(num==2) return;
                 int result = JOptionPane.showConfirmDialog(this, "파일을 저장하시겠습니까?", "종료", 
                         JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                 
                 if(result == JOptionPane.YES_OPTION) {
                     saveDialog();
                     fileWrite();
                     System.exit(0);
                 }else if(result == JOptionPane.NO_OPTION) {
                     System.exit(0);
                 }
                 
                 

             }else if(e.getSource() == menu.getNewM()) {
                 output.setText(" ");
                 output.setText("");
             }else if(e.getSource() == menu.getOpenM()) {
                 output.setText(" ");
                 openDialog();
             }else if(e.getSource() == menu.getSaveM()) {
                 saveDialog();
                 fileWrite();
             }else if(e.getSource() == menu.getCutM()) {
                 output.cut();
             }else if(e.getSource() == menu.getCopyM()) {
                 output.copy();
             }else if(e.getSource() == menu.getPasteM()) {
                 output.paste();
             }
         
     }
     public void saveDialog() { //dialog는 오픈과 세이브 동일 showSaveDialog부분만 바꿔주면 된다.. 
         JFileChooser chooser = new JFileChooser();
         int result = chooser.showSaveDialog(this); 
         
         if(result == JFileChooser.APPROVE_OPTION) {
              file = chooser.getSelectedFile();
         }
     }
     public void fileWrite() {
         if(file == null ) return;
         BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            String data = output.getText(); //output 인 textarea글자는 취한다
            bw.write(data);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
         
     }
     
     public void openDialog() {
         JFileChooser chooser = new JFileChooser();
         int result = chooser.showOpenDialog(this); //()프레임위에 띄울것인지, 다른곳에 별도로 띄울것인지
         
         if(result == JFileChooser.APPROVE_OPTION) {
              file = chooser.getSelectedFile();
         }
         JOptionPane.showMessageDialog(this, file);
         
     }
     
     public void fileRead() {
         if(file == null) return;
        try {
         BufferedReader br = new BufferedReader(new FileReader(file));
         String line; //줄 단위는 String으로 읽는다. char인 글자 단위는 -1로 반환함과 다른 케이스
         while( (line= br.readLine()) != null) {
             //output.setText(line);  setText는 덮어쓰기때문에 글자가 다 안보임
             output.append(line+"\n");
         }//while
          br.close();
         //줄 단위로 읽는다.
        }catch(IOException e) {
            e.printStackTrace();
        }
        
     }
    
    public static void main(String[] args) {
        new TryNotepad("간단메모장").event();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


   
}

