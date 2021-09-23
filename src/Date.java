public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    //Jason
    public Date(String date) {} //take “mm/dd/yyyy” and create a Date object
    public Date() {} //create an object with today’s date (see Calendar class)


    //John
    public boolean isValid() {
        public static final int THE_EIGHTIES = 1980;
        public static final int TWENTY_EIGHT_DAYS = 28;
        public static final int TWENTY_NINE_DAYS = 29;
        public static final int THIRTY_DAYS = 30;
        public static final int THIRTY_ONE_DAYS = 31;
        public static final int JAN = 1;
        public static final int FEB = 2;
        public static final int MAR = 3;
        public static final int APR = 4;
        public static final int MAY = 5;
        public static final int JUN = 6;
        public static final int JUL = 7;
        public static final int AUG = 8;
        public static final int SEP = 9;
        public static final int OCT = 10;
        public static final int NOV = 11;
        public static final int DEC = 12;
        public static final boolean LEAP_YEAR = false;

        //Determins if the year is a leap year
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
        if(this.day <= THIRTY_DAYS && (this.month == APR || this.month = JUN || this.month = SEP || this.month = NOV) )
            return true;
        //Checks months with 31 days
        if(this.day <= THIRTY_ONE_DAYS && (this.month == JAN || this.month = MAR || this.month = MAY
                || this.month = JUL || this.month = AUG || this.month = OCT || this.month = DEC))
            return true;
        return false;
    }

    //if the inputted date is older(smaller numer) than the date the function is called on, returns true.
    @Override
    public int compareTo(Date date) {
        if ( this.year > date.year
                && this.month > date.month
                && this.day > date.day){
            return true;
        }
        return false;
    }
}