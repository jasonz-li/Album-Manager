import java.util.Scanner;

public class CollectionManager {
    public void run(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s*,\\s*");
        Collection collection = new Collection();
        System.out.println(collection.getCollection().length);

        while (true){
            String input = scanner.next();
            if (input == "Q") {
                System.out.println("Collection Manager Terminated.");
                break;
            }
            else if (input == "P" || input == "PD" || input == "PG") {

            }
            else if (input == "L" || input == "R" || input == "D" || input == "A"){
                String title = scanner.next();
                String artist = scanner.next();
                Album album = collection.findAlbum(title, artist);
                if (input == "L" && album != null) {
                    collection.lendingOut(album);
                }
                else if (input == "R" && album != null) {
                    collection.returnAlbum(album);
                }
            }
            else{
                System.out.println("Invalid command!");
            }
        }
        scanner.close();
    }
}
