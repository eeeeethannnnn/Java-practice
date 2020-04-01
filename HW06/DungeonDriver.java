//I worked on the homework assignment alone, using only course materials.
/**
 * Class representing a SmallBusiness.
 * @author Shen Yi Cheng GTID: 903514405
 * @version 1
 **/
public class DungeonDriver {
    /**
     * A main for DungeonDriver.
     * @param args default args
     **/
    public static void main(String[] args) {
        Knight galahad = new Knight("Galahad", 7, 6, true);
        Knight lancelot = new Knight("Lancelot", 30, 5, false);
        Archer archie = new Archer("Archie", 10, 2);

        archie.attack(lancelot);
        System.out.println(archie.toString());
        System.out.println(lancelot.toString());

        galahad.attack(archie);
        System.out.println(galahad.toString());
        System.out.println(archie.toString());

        lancelot.attack(galahad);
        System.out.println(galahad.toString());
        System.out.println(lancelot.toString());

        lancelot.challenge(galahad);
        System.out.println(galahad.toString());
        System.out.println(lancelot.toString());
    }
}
