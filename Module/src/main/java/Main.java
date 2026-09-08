//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {

    //creates a record of a date
    public record date(int date, int month, int year) {
        public date{
            if (date>31 || date<1)
            {
                throw new IllegalArgumentException("invalid day");
            }
            if (month>12|| month<1){
                throw new IllegalArgumentException("Incalid month");
            }
        }
    }

    date date1 = new date(22, 1, 2008);
    date date2 = new date(2, 12, 2001);
    date date3 = new date(19, 12, 21);

    //returns amount of dates when the number of a moth is specified
    public static int daysInMonth(int month) {
        int days = 0;
        switch (month) {
            case 1:
                days = 31;
                break;
            case 2:
                days = 28;
                break;
            case 3:
                days = 31;
                break;
            case 4:
                days = 30;
                break;
            case 5:
                days = 31;
                break;
            case 6:
                days = 30;
                break;
            case 7:
                days = 31;
                break;
            case 8:
                days = 31;
                break;
            case 9:
                days = 30;
                break;
            case 10:
                days = 31;
                break;
            case 11:
                days = 30;
                break;
            case 12:
                days = 31;
                break;
        }
        System.out.println(days);
        return days;
    }

// returns the day after the date specified

    public static date tommorow(int day, int month, int year) {
        int new_day = day;
        int new_month = month;
        int new_year = year;
        if (month > 12 || day > 31) {
            throw new IllegalArgumentException("Invalid month");
        }
        if (month == 2 && day == 28) {
            new_day = 1;
            new_month = month + 1;
        } else if (day == 31) {
            switch (month) {
                case 4:
                    new_day = 1;
                    new_month = month + 1;
                    break;
                case 6:
                    new_day = 1;
                    new_month = month + 1;
                    break;
                case 9:
                    new_day = 1;
                    new_month = month + 1;
                    break;
                case 11:
                    new_day = 1;
                    new_month = month + 1;
                    break;
                case 8:
                    new_day = 1;
                    new_month = month + 1;
                    break;
                case 10:
                    new_day = 1;
                    new_month = month + 1;
                    break;
                case 12:
                    new_day = 1;
                    new_month = 1;
                    new_year = year + 1;
                    break;
            }
        } else if (day == 30) {
            switch (month) {
                case 4:
                    new_day = 1;
                    new_month = month + 1;
                    break;
                case 6:
                    new_day = 1;
                    new_month = month + 1;
                    break;
                case 9:
                    new_day = 1;
                    new_month = month + 1;
                    break;
                case 11:
                    new_day = 1;
                    new_month = month + 1;
                    break;
            }
        } else {
            new_day = day + 1;

        }
        String final_date = "the next day is: " + new_day + ", " + new_month + ", " + new_year;
        System.out.println(final_date);
        return new date(new_day, new_month, new_year);
    }


    //days of year meathod pseudocode-using the month loop through using switch statemtnets and then add the number of days on top
    public static int daysOfYear(int day, int month) {
        int days_passed = 0;

        for (int i = 0; i < month; i++) {

            days_passed = days_passed + daysInMonth(i);

        }
        days_passed = days_passed + day;

        days_passed = days_passed - 1;//accoutns for the first day
        System.out.println(days_passed);
        return days_passed;
    }


    public static boolean comesBefore(int day1, int month1, int year1, int day2, int month2, int year2) {
        if (year1 == year2) {
            if (month1 == month2) {
                if (day1 < day2 || day1 == day2) {
                    return true;
                }
                else{
                    return false;
                }
            }
            else if (month1 < month2) {
                    return true;
            }
            else{
                return false;
            }
        }
        else if (year1 < year2) {
                return true;

        } else {
            return false;
        }


    }



}