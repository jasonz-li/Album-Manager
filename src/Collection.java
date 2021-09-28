/**
 * The Collection class holds the list of Albums and has methods to add, remove, lend out, return, and print the albums.
 * Methods, add() and remove() add an album or remove an album to the array of albums.
 * Methods lendingOut() and returnAlbum() lend out and return albums.
 * The print methods print the array as-is, or sort by genre or release date.
 * @author Jason Li, John Leng
 */

public class Collection {

    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection


    /**
     * This constructor creates a collection with array albums that has 4 allocated spaces
     * and numAlbums is set to 0.
     */
    public Collection() {
        albums = new Album[4];
        numAlbums = 0;
    }

    /**
     * Finds album index in the collection of albums.
     *
     * @param album target album that wants to be found.
     * @return index of album, otherwise -1 if not found.
     */
    private int find(Album album) {
        for (int i = 0; i < this.numAlbums; i++) {
            if (this.albums[i] == album) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Increases the capacity of the array list by 4.
     */
    private void grow() {
        Album[] newCollection = new Album[this.numAlbums + 4];
        for (int i = 0; i < this.numAlbums; i++){
            newCollection[i] = this.albums[i];
        }
        this.albums = newCollection;
    }

    /**
     * Attempts to add an album and calls grow when it is full:
     * If the number of albums is less than the array length, the album is added,
     * or if the number of albums is equal to the array length, it calls grow()
     * and recursively attempts to add the album again.
     * @param album the album that is added to the list
     * @return returns true if its added, false if it is not added
     */
    public boolean add(Album album) {
        if(numAlbums < albums.length) {
            this.albums[numAlbums] = album;
            this.numAlbums++;
            if(numAlbums == albums.length){
                this.grow();
            }
            return true;
        }
        return false;
    }

    /**
     * Removes target album from collection of albums.
     *
     * @param album Input album.
     * @return true when the album is removed.
     */
    public boolean remove(Album album) {
        Album[] temp = new Album[numAlbums];
        boolean check = false;
        int j = 0;
        for (int i = 0; i < numAlbums; i++){
            if (i == find(album) && check == false) {
                j++;
                check = true;
                temp[i] = albums[j];
                j++;
                continue;
            }
            else {
                temp[i] = albums[j];
            }
            j++;
        }
        albums = temp;
        this.numAlbums--;
        return true;
    }



    /**
     * Sets isAvailable of an album to true if it is not lent out and sets it to false
     * if it is lent out or it does not exist.
     *
     * @param album Target album.
     * @return true if the album is successfully lent, otherwise false.
     */
    public boolean lendingOut(Album album) {
        if (findAlbum(album.getTitle(), album.getArtist()) == null || !album.getAvailability()) {
            System.out.println(album.getTitle() + "::" + album.getArtist() + " >> is not available.");
            return false;
        }
        else {
            for (int i = 0; i < this.numAlbums; i++){
                if (this.albums[i].equals(album)){
                    albums[i].setAvailability(false);
                    System.out.println(album.getTitle() + "::" + album.getArtist() + " >> lending out and set to not available.");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sets isAvailable of an album to true if it is returned and sets it to false
     * if it is not returned or it does not exist.
     *
     * @param album Target album.
     * @return true if the album is successfully returned, otherwise false.
     */
    public boolean returnAlbum(Album album) {
        if (!album.getAvailability() || findAlbum(album.getTitle(), album.getArtist()) == null) {
            System.out.println(album.getTitle() + "::" + album.getArtist() + " >> return cannot be completed.");
            return false;
        }
        for (int i = 0; i < this.numAlbums; i++){
            if (this.albums[i].equals(album)){
                System.out.println(album.getTitle() + "::" + album.getArtist() + " >> returning and set to available.");
                this.albums[i].setAvailability(true);
                return true;
            }
        }
        return false;
    }


    /**
     * Prints the albums array in the current order
     */
    private void printOrder(){
        for(int i = 0; i < this.albums.length; i++){
            if(albums[i] != null){
                System.out.println(albums[i].toString());
            }
        }
    }

    /**
     * Prints the albums array in a random order by calling printOrder()
     */
    public void print() {
        System.out.println("*List of albums in the collection.");
        this.printOrder();
        System.out.println("*End of List");
    }


    /**
     * Sorts the albums by releaseDate, from oldest to newest and prints the albums
     * Utilizes selection sort
     */
    public void printByReleaseDate() {
        int albumsLength = this.numAlbums;

        for (int i = 0; i < albumsLength-1; i++)
        {
            int min_idx = i;
            for (int j = i + 1; j < albumsLength; j++)
                if (albums[min_idx].getReleaseDate().compareTo(albums[j].getReleaseDate()) == 1){
                    min_idx = j;
                }

            Album tempVar = albums[min_idx];
            albums[min_idx] = albums[i];
            albums[i] = tempVar;
        }
        System.out.println("*Album collection by the release dates.");
        this.printOrder();
        System.out.println("*End of List");
    }


    /**
     * Sorts the albums by genre chronologically and prints the albums.
     * Utilizes selection sort
     */
    public void printByGenre() {
        int albumsLength = this.numAlbums;

        for (int i = 0; i < albumsLength-1; i++)
        {
            int min_idx = i;
            for (int j = i + 1; j < albumsLength; j++)
                if (albums[min_idx].getGenre().toString().compareTo(albums[j].getGenre().toString()) >= 0){
                    min_idx = j;
                }

            Album tempVar = albums[min_idx];
            albums[min_idx] = albums[i];
            albums[i] = tempVar;
        }
        System.out.println("*Album collection by genre.");
        this.printOrder();
        System.out.println("*End of List");
    }

    /**
     * Retrieves the array of albums.
     *
     * @return array of albums.
     */
    public Album[] getCollection() {
        return albums;
    }

    /**
     * Retrieves the number of albums in array of albums.
     *
     * @return number of albums in array of albums.
     */
    public int getNumAlbums() {
        return numAlbums;
    }

    /**
     * Finds the album object in the array of albums given the title and artist of
     * album.
     *
     * @param title  title of album
     * @param artist name of the artist on the album.
     * @return the target album if found, otherwise returns null.
     */
    public Album findAlbum(String title, String artist) {
        Album wantedAlbum = new Album();
        wantedAlbum.setArtist(artist);
        wantedAlbum.setTitle(title);
        for (int i = 0; i < numAlbums; i++) {
            if (albums[i] != null) {
                if (albums[i].equals(wantedAlbum)) {
                    return albums[i];
                }
            }
        }
        return null;
    }
}