public class Album {
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;


    //John
    @Override
    public boolean equals(Object obj) { }



    //Jason
    @Override
    public String toString() {
        if (this.isAvailable == true){
            return title + "::" + artist + "::" genre + "::" + releaseDate + "::" + "is available";
        }
        else{
            return title + "::" + artist + "::" genre + "::" + releaseDate + "::" + "not available";
        }
    }
}
