package bai9_automated_testing_tdd.bai_tap.tinh_ngay_tiep_theo;

public class NextDayCalculator {
    public static String nextDay(int day,int month,int year){
        if(month==12 && day == checkMonth(month,year)){
          return 1+" : " +1+" : "+(year+1);
        }
        else if(day == checkMonth(month,year)){
            return 1+" : " +(month+1)+" : "+year;
        }
        else {
            return (day+1)+" : " +month+" : "+year;
        }
    }
    public static int checkMonth(int month,int year){
        switch (month){
            case 2:
                if(isLeapYear(year)){
                    return 29;
                }
                return 28;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 0;
        }
    }
    public static boolean isLeapYear(int year){
        boolean isLeapYear = false;
        boolean isDivisibleBy4 = year % 4 == 0;
        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100) {
                boolean isDivisibleBy400 = year % 400 == 0;
                if (isDivisibleBy400) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        return isLeapYear;
    }
}
