/**
 * The collection manager takes commands from user and calls methods to preform the appropriate actions.
 * Takes arguments Q, P, PD, PG, A, L, R, D
 * Method handlePrint() takes commands P, PG, and PD to print randomly, by genre, or by release date.
 * Method delete() removes an album from the collection
 * Method handleA() takes the commands to add albums
 * Method add() adds an album to the collection
 * Method handleRD() handles commands L, R, D
 *
 * @author Jason Li, John Leng
 */

import java.util.StringTokenizer;
import java.util.Scanner;

public class CollectionManager {


    /**
     * Takes in commands from the command line, and processes them to call methods from other classes.
     * Takes arguments Q, P, PD, PG, A, L, R, D
     */
    public void run(){
        System.out.println("Collection manager starts running.");
        Scanner scanner = new Scanner(System.in);
        Collection collection = new Collection();
        while (true){
            String cmdInput = scanner.nextLine();
            if (cmdInput.equals("") != true) {
                StringTokenizer command = new StringTokenizer(cmdInput);
                String input = command.nextToken(",");
                if (input.equals("Q")) {
                    System.out.println("Collection Manager terminated.");
                    break;
                }
                else if (input.equals("P") || input.equals("PD") || input.equals("PG")) {
                    handlePrint(input, collection);
                }
                else if(input.equals("A")){
                    handleA(command, collection);

                }
                else if (input.equals("L") || input.equals("R") || input.equals("D")){
                    handleLRD(input, command, collection);
                }
                else {
                    System.out.println("Invalid command!");
                }
            }
            else {

                System.out.println("Invalid command!");
            }
        }
        scanner.close();
    }



    /**
     * Handles the printing logic by looking for P, PD, PG and calling appropriate methods
     * @param input is the commands like P, Pd, PG
     * @param collection passes in the collection object.
     */
    private void handlePrint(String input, Collection collection){
        if (collection.getNumAlbums() == 0) {
            System.out.println("The collection is empty!");
        }
        else {
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
    }

    /**
     * Handles the process to delete an album from the collection
     *
     * @param title title of the album
     * @param artist artist of the album
     * @param collection passes in the collection object.
     */
    private void delete(String title, String artist, Collection collection){
        Album albumCheck = collection.findAlbum(title, artist);
        if (albumCheck != null) {
            Album newAlbum = collection.findAlbum(title, artist);
            collection.remove(newAlbum);
            System.out.println(title + "::" + artist + " >> deleted.");
        }
        else {
            System.out.println(title + "::" + artist + " >> is not in the collection.");
        }
    }

    /**
     * Adds an album to the collection
     *
     * @param title title of the album
     * @param artist artist of album
     * @param genre genre of album
     * @param releaseDate release date of album
     * @param collection passes in the collection object
     */
    private void add(String title, String artist, String genre, String releaseDate, Collection collection){
        Album albumCheck = collection.findAlbum(title, artist);
        if (albumCheck == null) {
            Album newAlbum = new Album(title, artist, genre, releaseDate);
            collection.add(newAlbum);
            System.out.println(newAlbum.toString() + " >> added.");
        }
        else {
            System.out.println(albumCheck.toString() + " >> is already in the collection.");
        }
    }


    /**
     * Capitalizes the first letter of a string.
     *
     * @param string input string that needs to be capitalized.
     * @return capitalized string.
     */
    private String capitalize(String string) {
        String name = string;
        String s = name.substring(0, 1).toUpperCase();
        String stringCapitalized = s + name.substring(1);
        return stringCapitalized;
    }

    /**
     * Checks what genre an album is in. If it is not one of the preset genres,
     * it will be considered Unknown.
     *
     * @param genre name of genre
     * @return the genre of the album. Returns "Unknown" if it is not a preset album.
     */
    private String checkGenre(String genre) {
        if (!genre.equals("Classical") && !genre.equals("Jazz")  &&
                !genre.equals("Pop") && !genre.equals("Country") ) {
            return "Unknown";
        }
        else {
            if (genre.equals("Classical")) {
                return "Classical";
            }
            else if(genre.equals("Jazz")) {
                return "Jazz";
            }
            else if (genre.equals("Pop")) {
                return "Pop";
            }
            else {
                return "Country";
            }
        }
    }


    /**
     * Handles the process to add an album in the collection
     *
     * @param command input command converted to StringTokenizer
     * @param collection collection of albums
     */
    private void handleA(StringTokenizer command, Collection collection) {
        String title = command.nextToken(",");
        String artist = command.nextToken(",");
        String tempGenre = command.nextToken(",");
        String genre = capitalize(tempGenre);
        String date = command.nextToken(",");
        Date newDate = new Date(date);
        if (newDate.isValid()) {
            add(title, artist, checkGenre(genre), date, collection);
        }
        else{
            System.out.println("Invalid Date!");
        }
    }

    /**
     * Handles the process to lend, return, or delete an album in the collection
     *
     * @param input user input command
     * @param command input converted to StringTokenizer
     * @param collection collection of albums
     */
    private void handleLRD(String input, StringTokenizer command, Collection collection) {
        String title = command.nextToken(",");
        String artist = command.nextToken(",");
        Album album = collection.findAlbum(title, artist);
        if (input.equals("L")) {
            if (album != null) {
                collection.lendingOut(album);
            }
            else {
                System.out.println(title + "::" + artist + " >> is not avaiable.");
            }
        }
        else if (input.equals("R")) {
            if (album != null) {
                collection.returnAlbum(album);
            }
            else {
                System.out.println(title + "::" + artist + " >>  return cannot be completed.");
            }
        }
        else if (input.equals("D")) {
            delete(title, artist, collection);
        }
    }

}