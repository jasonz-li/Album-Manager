public class Collection {

    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection


    public Collection(){
        albums = new Album[4];
        numAlbums = 0;
    }

    public Album[] getCollection() {
        return albums;
    }

    public int getNumAlbums() {
        return numAlbums;
    }

    public Album findAlbum(String title, String artist) {
        Album wantedAlbum = new Album();
        wantedAlbum.setArtist(artist);
        wantedAlbum.setTitle(title);
        for (int i = 0; i < numAlbums; i++) {
            if (albums[i].equals(wantedAlbum)) {
                return albums[i];
            }
        }
        return null;
    }
    //Jason

    //find the album index, or return NOT_FOUND
    private int find(Album album) {
        for (int i = 0; i < this.numAlbums; i++) {
            if (this.albums[i] == album) {
                return i;
            }
        }
        return -1;
    }

    //increase the capacity of the array list by 4
    private void grow() {
        Album[] newCollection = new Album[this.numAlbums + 4];
        for (int i = 0; i < this.numAlbums; i++){
            newCollection[i] = this.albums[i];
        }
        this.albums = newCollection;
    }

    //John
    /**
     * Attempts to add an album and calls grow when its full:
     * If the number of albums is less than the array length, the album is added,
     * or if the number of albums is equal to the array length, it calls grow()
     * and recursively attempts to add the album again.
     * @param album
     * @return
     */
    public boolean add(Album album) {
        if(numAlbums < albums.length) {
            this.albums[numAlbums] = album;
            this.numAlbums++;
            return true;
        }
        else if(numAlbums == albums.length){
            this.grow();
            this.add(album);
        }
        return false;
    }

    //
    public boolean remove(Album album) {
        for(int i = 0; i < this.albums.length; i++){
            if(albums[i].title == album.title && albums[i].astist == album.artist){
                albums[i] = null;
                return true;
            }
        }
        return false;
    }

    //Jason

    // set to not available
    public boolean lendingOut(Album album) {
        for (int i = 0; i < this.numAlbums; i++){
            if (this.albums[i].equals(album)){
                albums[i].setAvailability(false);
                break;
            }
        }
        return;
    }

    //set to available
    public boolean returnAlbum(Album album) {
        for (int i = 0; i < this.numAlbums; i++){
            if (this.albums[i].equals(album)){
                this.albums[i].setAvailability(true);
                break;
            }
        }
        return;
    }

    //John

    private void printOrder(){
        for(int i = 0; i < this.albums.length; i++){
            if(albums[i] != null){
                System.out.println(albums[i].title + "::" + albums[i].artist + "::"
                        + albums[i].genre + "::" + albums[i].releaseDate + "::" + albums[i].isAvailable);
            }
        }
    }
    public void print() {
        System.out.println("*List of albums in the collection.");
        this.printOrder();
        System.out.println("*End of List");
    }



    //SelectionSort
    public void printByReleaseDate() {
        int albumsLength = this.albums.length;

        for (int i = 0; i < albumsLength-1; i++)
        {
            int min_idx = i;
            for (int j = i + 1; j < albumsLength; j++)
                if (albums[i]releaseDate.compareTo(albums[j].releaseDate) == true){
            min_idx = j;
        }

            int tempVar = albums[min_idx];
            albums[min_idx] = albums[i];
            albums[i] = tempVar;
        }
        System.out.println("*List of albums in the collection by Release Date.");
        this.printOrder();
        System.out.println("*End of List");
    }



    public void printByGenre() {
        int albumsLength = this.albums.length;

        for (int i = 0; i < albumsLength-1; i++)
        {
            int min_idx = i;
            for (int j = i + 1; j < albumsLength; j++)
                if (albums[i].genre.toString().compareTo(albums[j].genre.toString()) >= 0){
                    min_idex = j;
                }

            int tempVar = albums[min_idx];
            albums[min_idx] = albums[i];
            albums[i] = tempVar;
        }
        System.out.println("*List of albums in the collection by Genre.");
        this.printOrder();
        System.out.println("*End of List");
    }
}
