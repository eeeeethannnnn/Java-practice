//I worked on the homework assignment alone, using only course materials.

/**
 * a inferface for heal ability.
 * @author Shen-Yi Cheng
 * @version 1
 **/
public interface HealAbility {
    /**
     * an abstract method for perform heal.
     * @param patientList as a list of patient objects
     **/
    void performHeal(Patient[] patientList);
    /**
     * an abstract method for get heal amount.
     * @return heal anount
     **/
    int getHealAmount();
    /**
     * PROVIDED METHOD, DO NOT CHANGE
     * Sorts a list of Patients based on their compareTo method.
     * Note: this will not work until you implement compareTo in
     * Patient correctly!
     * @param patientlist a list of Patient objects to sort based on their
     *                    compareTo method
     */
    static void sortPatients(Patient[] patientlist) {
        for (int i = 1; i < patientlist.length; i++) {
            int j = i;
            while (j > 0 && patientlist[j - 1].compareTo(patientlist[j]) > 0) {
                Patient temp = patientlist[j];
                patientlist[j] = patientlist[j - 1];
                patientlist[j - 1] = temp;
                j--;
            }
        }
    }
}
