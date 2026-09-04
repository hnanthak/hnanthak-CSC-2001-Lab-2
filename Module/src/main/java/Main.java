//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    // add six to a number

    public record date(int date, int month, int year){}
//returns amount of dates when the number of a moth is specified
    public static int daysInMonth(int month){
        switch(month){
            case 1:
                System.out.println("31");
                return(31);
            case 2:
                System.out.println("28");
                return(28);
            case 3:
                System.out.println("31");
                return(31);
            case 4:
                System.out.println("30");
                return(30);
            case 5:
                System.out.println("31");
                return(31);
            case 6:
                System.out.println("30");
                return(30);
            case 7:
                System.out.println("31");
                return(31);
            case 8:
                System.out.println("31");
                return(31);
            case 9:
                System.out.println("30");
                return(30);
            case 10:
                System.out.println("31");
                return(31);
            case 11:
                System.out.println("30");
                return(30);
            case 12:
                System.out.println("31");
                return(31);
        }
    }

// returns the day after the date specified

    public static String tommorow (int month,int day, int year){
        int new_month=month;
        int new_day=day;
        int new_year=year+1;
        if (day==31){
            switch (month){
                case 1:
                    new_day=1;
                    new_month=2;
                case 3:
                    new_day=1;
                    new_month=4;
                case 5:
                    new_day=1;
                    new_month=6;
                case 7:
                    new_day=1;
                    new_month=8;
                case 10:
                    new_day=1;
                    new_month=11;
                case 12:
                    new_day=1;
                    new_month=1;
            }

        }
        else{
            new_day=day+1;
            new_month=month+1;
        }
        String final_date="the next day is: "+ new_day+", "+new_month+", "+new_year;
        System.out.println(final_date);
        return(final_date);
    }





    date date1 = new date(22, 1,2008);
    date date2 = new date(2,12,2001);
    date date3= new date(19, 12,21);
}
