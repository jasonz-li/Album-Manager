public class Album {
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    public Album(){}

    public Album(String title, String artist, String genre, String releaseDate){
        this.title = title;
        this.artist = artist;
        this.genre = Genre.valueOf(genre);
        this.releaseDate = new Date(releaseDate);
        this.isAvailable = true;


    }
    //John
    @Override
    public boolean equals(Object obj) {
        //Album album1 = (Album) obj; doesn't work for some reason
        Album album1 = Album.class.cast(obj);
        if(this.title.equals(album1.title) && this.artist.equals(album1.artist)){
            return true;
        }
        return false;
    }


    //Jason
    @Override
    public String toString() {
        if (this.isAvailable){
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
    public String getTitle() {return title;}

    /**
     * Sets title of album.
     * @param titleName is the name of the title
     */
    public void setTitle(String titleName) {this.title = titleName;}
    /**
     Gets artist of album.
     @return artist.
     */
    public String getArtist() {
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
