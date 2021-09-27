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
            return title + "::" + artist + "::" + genre + "::" + releaseDate + "::" + "is available";
        }
        else{
            return title + "::" + artist + "::" + genre + "::" + releaseDate + "::" + "not available";
        }
    }

    /**
     Gets title of album.
     @return title
     */
    public String getTitle() {
        return title;
    }
    /**
     Sets title of album.
     @param Name of the title
     */
    public void setTitle(String titleName) {
        this.title = titleName;
    }
    /**
     Gets artist of album.
     @return artist.
     */
    public String getArist() {
        return artist;
    }

    public void setArtist(String name) {
        this.artist = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genreName) {
        this.genre = genreName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date date) {
        this.releaseDate = date;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }


}
