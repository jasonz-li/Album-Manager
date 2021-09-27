import java.util.Calendar;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    //Jason

    //take “mm/dd/yyyy” and create a Date object
    public Date(String date) {
        this.month = Integer.parseInt(date.substring(0, 2));
        this.day = Integer.parseInt(date.substring(3, 5));  //******can i do this? is this right?
        this.year = Integer.parseInt(date.substring(6));
    }

    // create an object with today's date (see Calendar class)
    public Date() {
        Calendar getToday = Calendar.getInstance();
        this.year = getToday.get(getToday.YEAR);
        this.month = getToday.get(getToday.MONTH + 1); //getToday.MONTH returns month as int. January is int 0, +1 to line up with normal month numbers.
        this.day = getToday.get(getToday.DATE);
    }


    //John
    public boolean isValid() {
        final int THE_EIGHTIES = 1980;
        final int TWENTY_EIGHT_DAYS = 28;
        final int TWENTY_NINE_DAYS = 29;
        final int THIRTY_DAYS = 30;
        final int THIRTY_ONE_DAYS = 31;
        final int JAN = 1;
        final int FEB = 2;
        final int MAR = 3;
        final int APR = 4;
        final int MAY = 5;
        final int JUN = 6;
        final int JUL = 7;
        final int AUG = 8;
        final int SEP = 9;
        final int OCT = 10;
        final int NOV = 11;
        final int DEC = 12;
        boolean LEAP_YEAR = false;

        //Determines if the year is a leap year
        if(this.year % 4 == 0 && this.year % 100 == 0 && this.year % 400 == 0)
            LEAP_YEAR = true;
        else
            LEAP_YEAR = false;
        //Checks for the 80's
        if(this.year < THE_EIGHTIES) return false;
        //Checks February normally and on leap years
        if((this.day <= TWENTY_EIGHT_DAYS && this.month == FEB)
                || (LEAP_YEAR == true && this.day <= TWENTY_NINE_DAYS && this.month == FEB)) return true;
        //Checks months with 30 days
        if(this.day <= THIRTY_DAYS && (this.month == APR || this.month == JUN || this.month == SEP || this.month == NOV) )
            return true;
        //Checks months with 31 days
        if(this.day <= THIRTY_ONE_DAYS && (this.month == JAN || this.month == MAR || this.month == MAY
                || this.month == JUL || this.month == AUG || this.month == OCT || this.month == DEC))
            return true;
        return false;
    }

    //if the inputted date is older(smaller number) than the date the function is called on, returns 1, else returns 0.
    @Override
    public int compareTo(Date date) {
        if ( this.year > date.year
                && this.month > date.month
                && this.day > date.day){
            return 1;
        }
        return 0;
    }
}