package Calendar;
import java.util.Scanner;
import java.util.Calendar;
/*
일 월 화 수 목 금 토
        1 2  3  4 

생성자 입력 - 년도, 월
내가 입력한 연월의 
calculator() 에서 필요한 메소드 잡아와서
시작하는 요일이 다 다름. 매달 몇일로 끝나는지? 
시작하는 요일부터 1씩 증가하고, 7의 배수가 되면 자름.

display()
*/
class CalendarTest{
    public int userYear;
    public int userMonth;
     int startDay;   // 월 시작 요일
     int lastDay;    // 월 마지막 날짜

    
    Scanner scanner = new Scanner(System.in);
    public CalendarTest(){
        System.out.println("연도를 입력하시오");
         userYear = scanner.nextInt();
        System.out.println("월을 입력하시오");
         userMonth = scanner.nextInt();
    }
    
    public void display(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR , userYear);
        cal.set(Calendar.MONTH , userMonth+1);
        startDay = cal.get(Calendar.DAY_OF_WEEK);
        lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        
        int date = 1;
        
        for ( int i = 0 ; i <startDay+lastDay ;i++) {
            if(i<startDay) {
                System.out.print("\t");
            }else if (i%7 ==6) {
                System.out.print(date+"\t");
                date++;
                System.out.println();
            }else if(i>=startDay) {
                System.out.print(date+"\t");
                date++;
            }
        }
        
        
    }


}


// ----------------


