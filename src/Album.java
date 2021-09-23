public class Album {
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;


    enum Genre {
        Classical, Country, Jazz, Pop, Unknown
    }


    //John
    @Override
    public boolean equals(Object obj) {
        Album album1 = (Album) obj;
        if(this.title == album1.title && this.artist == album1.artist){
            return true;
        }
        return false;
    }


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
