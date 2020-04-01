// I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * a YelpDB search class.
 * @author Shen-Yi Cheng
 * @version 1.0
 */
public class YelpDB {
    private static String targetRestaurant;
    private static String targetReview;
    private static String finalOutput = "";
    private static String forReview = "";
    /**
     * a load file directory method.
     * call loadHelper to read directory recursively
     * @param dir as a start location to look restaurant
     * @return myRestaurant as a Restaurant objects ArrayList
     */
    public static ArrayList load(File dir) {
        ArrayList<Restaurant> myRestaurant = new ArrayList<Restaurant>();
        loadHelper(dir, myRestaurant);
        return myRestaurant;
    }
    /**
     * a method for loading file helper to search all restaurant in directory .
     * call loadHelper to read directory recursively
     * @param open as a directory to look restaurant
     * @param restaurantList as an arraylist to store all restaurant objects
     * @return ArrayList contains all restaurant objects
     */
    public static ArrayList loadHelper(File open, ArrayList restaurantList) {
        if (open.isDirectory()) { // is directory
            String[] directoryList = open.list();
            for (String restaurantName : directoryList) { // check is restaurant or not
                if (restaurantName.contains("restaurant")) { // is restaurant directory
                    File restaurantReviewPath = new File(open + "/" + restaurantName);
                    String[] reviewList = restaurantReviewPath.list();
                    String name = restaurantName.replace("restaurant", "");
                    Restaurant nameItem = new Restaurant(name, reviewList.length); // new a restaurant
                    restaurantList.add(nameItem); // add to ArrayList
                } else { // not restaurant directory call recursion
                    File newPath = new File(open + "/" + restaurantName);
                    loadHelper(newPath, restaurantList);
                }
            }
        }
        return restaurantList;
    }
    /**
     * a method for count reviews in all restaurant in the restaurant objects arraylist .
     * @param inputList as an arraylist to store all restaurant objects
     * @return int count
     */
    public static int countNumReviews(ArrayList<Restaurant> inputList) {
        int count = 0;
        for (Restaurant name : inputList) {
            count += name.getNumReviews();
        }
        return count;
    }
    /**
     * a method for read target reviw in DB requested by args .
     * @param search as an directory to search target review
     * @param afterReadDB as a arraylist of restaurant objects
     * @param review as args[1]
     * @param restaurant as args[0]
     * @return result as String
     */
    public static String readReview(File search, ArrayList<Restaurant> afterReadDB, String restaurant, String review) {
        try {
            boolean foundRestaurant = false;
            String[] strRestaurant = new String[afterReadDB.size()];
            for (int i = 0; i < afterReadDB.size(); ++i) {
                strRestaurant[i] = afterReadDB.get(i).getName().toString();
                if (strRestaurant[i].equals(restaurant)) {
                    foundRestaurant = true;
                    break;
                } else {
                    foundRestaurant = false;
                }
            }
            if (foundRestaurant) {
                forReview = traverse(search, restaurant);
                if (forReview.equals("noReview")) {
                    throw new ReviewNotFoundException("That is not a review!"); // this review not found
                } else if (finalOutput.equals("notFound")) {
                    Scanner myScan = new Scanner(search);
                }
            } else {
                throw new NotARestaurantException(); // this restaurant not found
            }
        } catch (NotARestaurantException nare) {
            System.out.println("Error: " + nare.getMessage());
        } catch (ReviewNotFoundException rnfe) {
            System.out.println("Error: " + rnfe.getMessage());
        } catch (FileNotFoundException fnf) {
            System.out.println("Error: " + fnf.getMessage());
            //finalOutput = "notFound";
            //break;
        }
        return forReview;
    }
    /**
     * a method for traversing all files in the directory .
     * @param directory as an input location
     * @param restaurantDirectory target restaurant directory
     * @return string for review rate
     */
    public static String traverse(File directory, String restaurantDirectory) {
        try {
            if (directory.isDirectory()) { // is directory
                String[] directoryList = directory.list();
                for (String restaurantName : directoryList) { // check is restaurant or not
                    // if target restaurant directory
                    if (restaurantName.startsWith("restaurant") && restaurantName.endsWith(restaurantDirectory)) {
                        File newPath = new File(directory + "/" + restaurantName + "/review" + targetReview + ".txt");
                        //System.out.println(newPath);

                        if (newPath.exists() && newPath.isFile()) {
                            Scanner myScan = new Scanner(newPath);
                            ArrayList<String> content = new ArrayList<String>();
                            while (myScan.hasNext()) {
                                content.add(myScan.next());
                            }
                            //finalOutput = content.get(4).toString() + " " + content.get(5).toString();
                            finalOutput = content.get(5).toString();
                        } else {
                            finalOutput = "noReview";
                            //throw new ReviewNotFoundException("That is not a review!"); // this review not found
                        }
                    } else { // not target restaurant directory call recursion
                        File newPath = new File(directory + "/" + restaurantName);
                        traverse(newPath, restaurantDirectory);
                    }
                }
            }

        } catch (FileNotFoundException fnf) {
            //System.out.println("Error: " + fnf.getMessage());
            finalOutput = "notFound";
        }
        return finalOutput;
    }
    /**
     * a main to call all methods.
     * @param args as command line input
     */
    public static void main(String[] args) {
        File myFile = new File("./database_restaurants");
        targetRestaurant = args[0];
        targetReview = args[1];
        ArrayList<Restaurant> afterReadDB = load(myFile);
        String n = readReview(myFile, afterReadDB, targetRestaurant, targetReview);
        if (!n.equals("") && !n.equals("notFound") && !n.equals("noReview")) {
            System.out.println(n);
        }
    }
}
