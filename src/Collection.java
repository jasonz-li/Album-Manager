public class Collection {

    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    //Jason

    //find the album index, or return NOT_FOUND
    private int find(Album album) {
        for (int i = 0; i < this.numAlbums; i++) {
            if (this.albums[i] == album) {
                return i;
            }
        }
        return NOT_FOUND;
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
    public boolean add(Album album) {}
    public boolean remove(Album album) {}

    //Jason

    // set to not available
    public boolean lendingOut(Album album) {
        for (int i = 0; i < this.numAlbums; i++){
            if (this.albums[i] == album){
                this.albums[i].isAvailable = false;
                break;
            }
        }
        return;
    }

    //set to available
    public boolean returnAlbum(Album album) {
        for (int i = 0; i < this.numAlbums; i++){
            if (this.albums[i] == album){
                this.albums[i].isAvailable = true;
                break;
            }
        }
        return;
    }

    //John
    public void print() {} //display the list without specifying the order
    public void printByReleaseDate() {}
    public void printByGenre() {}
}
