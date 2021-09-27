public class Album {
    private String title;
    private String artist;
    private Genre genre; // enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    enum Genre {
        Classical, Country, Jazz, Pop, Unknown
    }

    // John
    @Override
    public boolean equals(Object obj) {
        Album album1 = (Album) obj;
        if (this.title == album1.title && this.artist == album1.artist) {
            return true;
        }
        return false;
    }

    /**
     * Shows a textual representation of album information.
     *
     * @return string in a 'title::artist::genre::releaseDate::isAvailable' format.
     */
    @Override
    public String toString() {
        if (this.isAvailable == true) {
            return title + "::" + artist + "::" + genre + "::" + releaseDate + "::" + "is available";
        } else {
            return title + "::" + artist + "::" + genre + "::" + releaseDate + "::" + "not available";
        }
    }

    /**
     * Gets title of album.
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title of album.
     *
     * @param titleName Name of the title
     */
    public void setTitle(String titleName) {
        this.title = titleName;
    }

    /**
     * Gets artist of album.
     *
     * @return Name of artist.
     */
    public String getArist() {
        return artist;
    }

    /**
     * Sets artist for album.
     *
     * @param name Name of artist.
     */
    public void setArtist(String name) {
        this.artist = name;
    }

    /**
     * Gets genre of album.
     *
     * @return Genre of album.
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Sets genre of album.
     *
     * @param genreName Name of genre.
     */
    public void setGenre(Genre genreName) {
        this.genre = genreName;
    }

    /**
     * Gets release date of album.
     *
     * @return Release date of album.
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets release date of album.
     *
     * @param date Release date of album.
     */
    public void setReleaseDate(Date date) {
        this.releaseDate = date;
    }

    /**
     * Gets availability of album.
     *
     * @return true if album is available, otherwise false.
     */
    public boolean getAvailability() {
        return isAvailable;
    }

    /**
     * Sets availability of album.
     *
     * @param availability true if album is available, otherwise false.
     */
    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }

}