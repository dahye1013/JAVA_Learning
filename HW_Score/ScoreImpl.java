package HW_Score;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import JframePractice.PersonDTO;

public class ScoreImpl {
    String hak, name;
    int kor, eng , math, tot, avg;
    private ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();
    private ScoreForm sf;
    private ScoreDTO dto;
    
    ScoreImpl(ScoreForm sf){
        this.sf = sf;
    }
    
//    public void input() {
//
//        hak = sf.getHakT().getText();
//        name = sf.getNameT().getText();
//        kor = Integer.parseInt(sf.getKorT().getText().trim());
//        eng = Integer.parseInt(sf.getEngT().getText().trim());
//        math = Integer.parseInt(sf.getMathT().getText().trim());
//
//        dto = new ScoreDTO(hak, name, kor, eng, math);
//
//        list.add(dto);
//        sf.getHakT().setText("");
//        sf.getNameT().setText(""); 
//        sf.getKorT().setText(""); 
//        sf.getEngT().setText(""); 
//        sf.getMathT().setText(""); 
//
//        System.out.println(dto.getHak()+" " +dto.getName()+" "+ dto.getKor()+" "+ dto.getEng()+" "+ dto.getMath());
//           
//       }
    
 //   @Override
//    public void output() {
//        
//        Vector<String> v = new Vector<String>();
//         v.add(dto.getHak());
//         v.add(dto.getName());
//         v.add(dto.getKor()+"");
//         v.add(dto.getEng()+"");
//         v.add(dto.getMath()+"");
//         v.add(dto.getTot()+"");
//         v.add(dto.getAvg()+"");
//         DefaultTableModel model = sf.getModel();
//         model.addRow(v);
//        
//    }
   
}
