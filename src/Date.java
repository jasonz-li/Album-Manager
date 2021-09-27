import java.util.Calendar;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    /**
     * Takes the string "mm/dd/yyyy" and creates a Date object.
     *
     * @param date input date
     */
    public Date(String date) {
        Date inputDate = new Date();
        inputDate.month = Integer.parseInt(date.substring(0, 2));
        inputDate.day = Integer.parseInt(date.substring(3, 5)); // ******can i do this? is this right?
        inputDate.year = Integer.parseInt(date.substring(6));
    }

    /**
     * Creates an object with today's date.
     */
    public Date() {
        Calendar getToday = Calendar.getInstance();
        Date today = new Date();
        today.year = getToday.get(getToday.YEAR);
        today.month = getToday.get(getToday.MONTH + 1); // getToday.MONTH returns month as int. January is int 0, +1 to
        // line up with normal month numbers.
        today.day = getToday.get(getToday.DATE);
    }

    // John
    public boolean isValid() {
        final int THE_EIGHTIES = 1980;
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
        if(this.day <= THIRTY_DAYS && (this.month == APR || this.month == JUN || this.month = SEP || this.month = NOV) )
            return true;
        //Checks months with 31 days
        if(this.day <= THIRTY_ONE_DAYS && (this.month == JAN || this.month = MAR || this.month = MAY
                || this.month = JUL || this.month = AUG || this.month = OCT || this.month = DEC))
            return true;
        return false;
    }

    // if the inputted date is older(smaller numer) than the date the function is
    // called on, returns true.
    @Override
    public int compareTo(Date date) {
        if (this.year > date.year && this.month > date.month && this.day > date.day) {
            return true;
        }
        return false;
    }
}