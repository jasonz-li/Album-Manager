public class Collection {

    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection


    public Collection(){
        albums = new Album[4];
        numAlbums = 0;
    }

    //Jason
    private int find(Album album) {} //find the album index, or return NOT_FOUND
    private void grow() {} //increase the capacity of the array list by 4

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
        if(numALbums < albums.length) {
            this.album[numAlbums] = album;
            this.numAlbums++;
            return true;
        }
        else if(numAlbums = albums.length){
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
    public boolean lendingOut(Album album) {} //set to not available
    public boolean returnAlbum(Album album) {} //set to available

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
            int min_idex = i;
            for (int j = i + 1; j < albumsLength; j++)
                if (albums[i]releaseDate.compareTo(albums[j].releaseDate) == true){
                    min_idex = j;
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
            int min_idex = i;
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
