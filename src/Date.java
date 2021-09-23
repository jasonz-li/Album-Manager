import java.util.Calendar;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    //Jason

    //take “mm/dd/yyyy” and create a Date object
    public Date(String date) {
        Date inputDate = new Date();
        inputDate.month = date.substring(0, 2);
        inputDate.day = date.substring(3, 5);  //******can i do this? is this right?
        inputDate.year = date.substring(6);
    }

    // create an object with today’s date (see Calendar class)
    public Date() {
        Calendar getToday = Calendar.getInstance();
        Date today = new Date();
        today.year = getToday.get(getToday.YEAR);
        today.month = getToday.get(getToday.MONTH + 1); //getToday.MONTH returns month as int. January is int 0, +1 to line up with normal month numbers.
        today.day = getToday.get(getToday.DATE);
    }


    //John
    public boolean isValid() {}
    @Override
    public int compareTo(Date date) {}
}