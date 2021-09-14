public class Collection {

    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    //Jason
    private int find(Album album) {} //find the album index, or return NOT_FOUND
    private void grow() {} //increase the capacity of the array list by 4

    //John
    public boolean add(Album album) {}
    public boolean remove(Album album) {}

    //Jason
    public boolean lendingOut(Album album) {} //set to not available
    public boolean returnAlbum(Album album) {} //set to available

    //John
    public void print() {} //display the list without specifying the order
    public void printByReleaseDate() {}
    public void printByGenre() {}
}
