public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    //Jason
    public Date(String date) {} //take “mm/dd/yyyy” and create a Date object
    public Date() {} //create an object with today’s date (see Calendar class)


    //John
    public boolean isValid() {}
    @Override
    public int compareTo(Date date) {}
}