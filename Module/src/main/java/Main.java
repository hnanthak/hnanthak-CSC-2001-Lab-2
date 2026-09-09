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


    public static boolean comesBefore(date date1, date date2) {
        if (date1.year == date2.year) {
            if (date1.month == date2.month) {
                if (date1.date < date2.date || date1.date == date2.date) {
                    return true;
                }
                else{
                    return false;
                }
            }
            else if (date1.month < date2.month) {
                    return true;
            }
            else{
                return false;
            }
        }
        else if (date1.year < date2.year) {
                return true;

        } else {
            return false;
        }


    }
    public record date_interval(date start, date end){
        public date_interval{
            if (comesBefore(this.start(), this.end())==false){
                throw new  IllegalArgumentException("The starting date comes after the end date");
            }
        }
    }
    public record maybe_date_interval (date start, date end){

        public maybe_date_interval{
            if (comesBefore(this.start(),this.end())==false){
                throw new  IllegalArgumentException("The starting date comes after the end date");
            }
        }
    }
    date_interval ex1 = new date_interval(
            new date(1, 2, 2018),
            new date(2, 3, 2018)
    );

    date_interval ex2 = new date_interval(
            new date(10, 5, 2020),
            new date(15, 5, 2020)
    );

    date_interval ex3 = new date_interval(
            new date(20, 7, 2022),
            new date(5, 8, 2022)
    );

    public static int dateIntervalDays( date_interval dates){
        int interval_1=daysOfYear(dates.start().date(), dates.start().month());
        int interval_2=daysOfYear(dates.end().date(), dates.end().month());

        return interval_2-interval_1;

    }

    public static boolean dateOverLap(date_interval interval1, date_interval interval2){
        if (comesBefore(interval2.start(),interval1.end())){
            return true;
        } else if (comesBefore(interval1.start(), interval2.end())) {
            return true;
        } else {
            return false;
        }
    }

    public static date_interval dateIntervalIntersect(date_interval interval1, date_interval interval2){
        if (dateOverLap(interval1, interval2)==false){
            return null;
        }
        date start;
        date end;

        if (comesBefore(interval1.start(),interval2.start())){
            start=interval2.start();
        }
        else{
            start=interval1.start();
        }
        if(comesBefore(interval1.end(),interval2.end())){
            end=interval1.end();
        }
        else{
            end=interval2.end();
        }
        return new date_interval(start,end);
    }

    public record date_list(date first, date_list rest){
    }

    public static int listLen(date_list lst){
        switch (lst){
            case null:
                return 0;
            case date_list(date first, date_list rest):
                return 1 + listLen(rest);

        }
    }

    public static date minDate(date_list list){

        switch(list){
            case null:
                throw new IllegalArgumentException("error");
            case date_list(date first, date_list rest):
               if (rest==null){
                   return first;
               }
                if (comesBefore(first,minDate(rest))){
                   return first;
               }else {
                   return minDate(rest);
               }
        }
    }





}