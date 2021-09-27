import java.util.Scanner;

public class CollectionManager {

    public void run(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s*,\\s*");
        Collection collection = new Collection();
        System.out.println(collection.getCollection().length);

        while (true){
            String input = scanner.next();
            if (input.equals("Q")) {
                System.out.println("Collection Manager Terminated.");
                break;
            }
            else if (input.equals("P") || input.equals("PD") || input.equals("PG")) {
                handlePrint(input, collection);
            }
            else if (input.equals("L") || input.equals("R") || input.equals("D") || input.equals("A")){
                String title = scanner.next();
                String artist = scanner.next();
                String genre = scanner.next();
                String releaseDate = scanner.next();
                Album album = collection.findAlbum(title, artist);
                if (input.equals("L") && album != null) {collection.lendingOut(album);}
                else if (input.equals("R") && album != null) {collection.returnAlbum(album);}
                else if (input.equals("A") || input.equals("D")) {handleAddDelete(input, title, artist, genre, releaseDate, collection);}
            }
            else{System.out.println("Invalid command!");}
        }
        scanner.close();
    }

    private void handlePrint(String input, Collection collection){
        if(input.equals("P")){
            collection.print();
        }
        if(input.equals("PD")){
            collection.printByReleaseDate();
        }
        if(input.equals("PG")){
            collection.printByGenre();
        }
    }

    private void handleAddDelete(String input, String title, String artist, String genre,
                                 String releaseDate, Collection collection){
        if(input.equals("A")){
            Album newAlbum = new Album(title, artist, genre, releaseDate);
            collection.add(newAlbum);
        }
        else if(input.equals("D")){
            Album newAlbum = new Album(title, artist, genre, releaseDate);
            collection.remove(newAlbum);
        }
    }
}
