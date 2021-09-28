/**
 * The Album class holds the information within the album and has methods to access or manipulate the data.
 * Methods like equals() compare albums and toString() converts the album to a string format
 * There are also getters and setters for Album's instance variables
 * @author Jason Li, John Leng
 */
public class Album {
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    /**
     * This constructor is the default one with no parameters.
     * It only instantiates title, artist, genre, releaseDate, and isAvailable but
     * gives them no values.
     *
     */
    public Album(){
    }

    /**
     * Constructor for Album that takes title, artist, genre, and release date in string format.
     * The constructor converts the strings to the corresponding data values.
     * @param title title of album
     * @param artist artist of album
     * @param genre genre of album
     * @param releaseDate release date of album
     */
    public Album(String title, String artist, String genre, String releaseDate){
        this.title = title;
        this.artist = artist;
        this.genre = Genre.valueOf(genre);
        this.releaseDate = new Date(releaseDate);
        this.isAvailable = true;


    }

    /**
     * equals() takes an object and casts it to an Album, and returns true if the title and artist match.
     * @param obj this is the inputted album.
     * @return returns true if the title and artist are the same, else false
     */
    @Override
    public boolean equals(Object obj) {
        Album album1 = Album.class.cast(obj);
        if(this.title.equals(album1.title) && this.artist.equals(album1.artist)){
            return true;
        }
        return false;
    }


    /**
     * Shows a textual representation of album information.
     *
     * @return string in a 'title:artist:genre::releaseDate::isAvailable' format.
     */
    @Override
    public String toString() {
        if (this.isAvailable){
            return title + "::" + artist + "::" + genre + "::" + releaseDate.getDate() + "::" + "is available";
        }
        else{
            return title + "::" + artist + "::" + genre + "::" + releaseDate.getDate() + "::" + "not available";
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
    public String getArtist() {
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