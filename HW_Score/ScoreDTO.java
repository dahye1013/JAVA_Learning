package HW_Score;

public class ScoreDTO {

    private String hak;
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int tot;
    private double avg;
    
//    ScoreDTO(){}
    ScoreDTO(String hak , String name , int kor, int math, int eng ){
        this.hak = hak;
        this.name = name;
        this.kor = kor;
        this.math = math;
        this.eng = eng;
        this.tot = kor + math + eng;
        this.avg = (double)tot/3;
    }

    public void setHak(String hak) {
        this.hak = hak;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public void setTot() {
        this.tot = kor + math+ eng;
    }
    public void setAvg() {
        this.avg = (double)tot/3;
    }
    
    public String getHak() {
        return hak;
    }
    
    public String getName() {
        return name;
    }
    
    public int getKor() {
        return kor;
    }
    public int getEng() {
        return math;
    }
    public int getMath() {
        return eng;
    }
    public int getTot() {
        return tot;
    }
    public double getAvg () {
        return avg; 
    }

    
    
}
