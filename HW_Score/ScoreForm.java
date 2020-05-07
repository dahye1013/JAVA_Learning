package HW_Score;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import JframePractice.PersonDTO;

public class ScoreForm extends JFrame implements ActionListener{
    private JButton inputBtn, outputBtn, SearchBtn, rankBtn, saveBtn, readBtn;
    private JPanel p0, p1, p2;
    String hak, name;
    int kor, eng , math, tot, avg;
    
    private JLabel hakL, nameL, korL, engL, mathL;
    private JTextField hakT, nameT, korT, engT, mathT;
    private ArrayList<ScoreDTO> list;
    private Vector<String> vector;
    private DefaultTableModel model;
    private JTable table;
    private ScoreDTO dto;
    
    ScoreForm() {
        
        
        list = new ArrayList<ScoreDTO>();
        
        //테이블------------------------------------------------
        vector = new Vector<String>();
        vector.add("학번");
        vector.add("이름");
        vector.add("국어");
        vector.add("영어");
        vector.add("수학");
        vector.add("총점");
        vector.add("평균");

        model = new DefaultTableModel(vector, 0) {
            public boolean isCellEditable(int r, int c) { // 편집가능하게 한다
                return (c != 0) ? true : false;
            }
        };

        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        for(ScoreDTO dto : list) {
            Vector<String> v = new Vector<String>();
            v.add(dto.getHak());
            v.add(dto.getName());
            v.add(dto.getKor()+"");
            v.add(dto.getEng()+"");
            v.add(dto.getMath()+"");
            v.add(dto.getTot()+"");
            v.add(dto.getAvg()+"");
            model.addRow(v);
        }
        
        inputBtn = new JButton("입력");
        outputBtn = new JButton("출력");
        SearchBtn = new JButton("학번검색");
        rankBtn = new JButton("순위");
        saveBtn = new JButton("파일저장");
        readBtn = new JButton("파일읽기");

        hakL = new JLabel("학번");
        nameL = new JLabel("이름");
        korL = new JLabel("국어");
        engL = new JLabel("영어");
        mathL = new JLabel("수학");
        hakT = new JTextField("");
        nameT = new JTextField("");
        korT = new JTextField("");
        engT = new JTextField("");
        mathT = new JTextField("");

        p0 = new JPanel();
        p0.add(inputBtn);
        p0.add(outputBtn);
        p0.add(SearchBtn);
        p0.add(rankBtn);
        p0.add(saveBtn);
        p0.add(readBtn);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 2, 0, 50));
        p1.add(hakL);
        p1.add(hakT);
        p1.add(nameL);
        p1.add(nameT);
        p1.add(korL);
        p1.add(korT);
        p1.add(engL);
        p1.add(engT);
        p1.add(mathL);
        p1.add(mathT);

        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 2, 0, 0));
        p2.add("Center", p1);
        p2.add("Center", scroll);

        Container c = getContentPane();
        c.add("South", p0);
        c.add("Center", p2);

        setBounds(700, 100, 500, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
    }
    public void event() {
        inputBtn.addActionListener(this);
        outputBtn.addActionListener(this);
        SearchBtn.addActionListener(this);
        rankBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        readBtn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputBtn) {
            input();
        }else if (e.getSource() == outputBtn) {
            output();
        }else if (e.getSource() == SearchBtn) {
            search();
        }else if (e.getSource() == rankBtn) {
        }else if (e.getSource() == saveBtn) {
        }else if (e.getSource() == readBtn) {
        }
    }
    
    
    //----------------텍스트 에리아 게터--------------------
    public JTextField getHakT() {
        return hakT;
    }
    public JTextField getNameT() {
        return nameT;
    }
    public JTextField getKorT() {
        return korT;
    }
    public JTextField getEngT() {
        return mathT;
    }
    public JTextField getMathT() {
        return mathT;
    } 
    public DefaultTableModel getModel() {
        return model;
    }
    public void setModel( DefaultTableModel model) {
        this.model = model;
    }
    public void input() {

        if(getHakT() == null || getNameT() == null || getKorT().getText().length() == 0 ||
                getEngT().getText().length()==0 || getMathT().getText().length()==0) {
            JOptionPane.showMessageDialog(this, "학번과 이름, 점수를 올바르게 입력하십시오.");
            return;
        }
        
        hak = getHakT().getText();
        name = getNameT().getText();
        kor = Integer.parseInt(getKorT().getText().trim());
        eng = Integer.parseInt(getEngT().getText().trim());
        math = Integer.parseInt(getMathT().getText().trim());

        dto = new ScoreDTO(hak, name, kor, eng, math);
        
        list.add(dto);
        JOptionPane.showMessageDialog(this, "입력 완료");
        
        getHakT().setText("");
        getNameT().setText(""); 
        getKorT().setText(""); 
        getEngT().setText(""); 
        getMathT().setText(""); 

        System.out.println(dto.getHak()+" " +dto.getName()+" "+ dto.getKor()+" "+ dto.getEng()+" "+ dto.getMath());
           
       }

    public void output() {
        
        model.setNumRows(0);
        
        for(ScoreDTO dto : list) {
        Vector<String> v = new Vector<String>();
         v.add(dto.getHak());
         v.add(dto.getName());
         v.add(dto.getKor()+"");
         v.add(dto.getEng()+"");
         v.add(dto.getMath()+"");
         v.add(dto.getTot()+"");
         v.add(dto.getAvg()+"");
         model.addRow(v);
        }
    }

    public void search() {
        int sw=0;
        String hakSearch = JOptionPane.showInputDialog(this, "검색할 학번을 입력하세요");
        for (int i = 0; i < array.size(); i++) {
            if(hakSearch == dto.getHak()) {
                System.out.println("찾음");
                sw++;
                }
            }//for
        if(sw == 0) {
                JOptionPane.showMessageDialog(this, "일치하는 학번이 없습니다.");
        }
    }

    public static void main(String[] args) {
        ScoreForm sf =  new ScoreForm();
        sf.event();
    }

}
