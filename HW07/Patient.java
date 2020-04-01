//I worked on the homework assignment alone, using only course materials.

/**
 * Represents a Patient object with a particular name,
 * health attribute that will be always greater or equal to 0
 * but should never exceed maxHealth. (assume that whoever makes an instance of this
 * object does it in the correct way; you do not need to change the constructor.)
 * There are a few methods in here for you to implement, in addition to changing
 * the class header such that Patient properly implements the Comparable interface
 * @author Shen-Yi Cheng
 * @version 1.0
 */
public class Patient implements Comparable<Patient> {
    private final String name;
    private int health, patientID;

    /**
     * getter for patientID.
     * @return the value of patientID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * getter for health.
     * @return the value of health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Initializes a Patient object with a parameter list corresponding
     * to all of its fields.
     * @param  name      name of this Patient
     * @param  health    current health of this Patient
     * @param  patientID the identification number for our Patient
     */
    public Patient(String name, int health, int patientID) {
        this.name = name;
        this.health = health;
        this.patientID = patientID;
    }
    /**
     * @Override
     * a method override equals
     * @param o as patient object
     * @return boolean
     **/
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return name.equals(p.name) && health == p.health && patientID == p.patientID;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Patient '%s' with %d health and ID %d", name, health, patientID);
    }
    /**
     * @Override
     * a method override Compareto
     * @param other as a patient Object
     * @return comapare result
     **/
    public int compareTo(Patient other) {
        if (this.patientID < other.patientID) {
            return -1;
        } else if (this.patientID == other.patientID) {
            return 0;
        } else {
            return 1;
        }
    }
    /**
     * a method for Increase health point.
     * @param treatment as a treatment object
     **/
    public void increaseHealth(HealAbility treatment) {
        this.health += treatment.getHealAmount();
        System.out.println("Patient " + this.name + " has been healed by "
             + treatment.getHealAmount() + " health points!");
    }
}
