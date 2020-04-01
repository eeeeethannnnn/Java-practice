//I worked on the homework assignment alone, using only course materials.
/**
 *a class for emergency treatment and inherited from treatment.
 * @author Shen-Yi Cheng
 * @version 1
 **/
public class EmergencyTreatment extends Treatment {
    /**
     * a constructor for EmergencyTreatment.
     * @param heal as heal Point
     * call the super class
     **/
    public EmergencyTreatment(int heal) {
        super(heal);
    }
    /**
     *@override
     * a method for EmergencyTreatment.
     * @param patientList a list of patient objects
    **/
    public void performHeal(Patient[] patientList) {
        if (patientList.length != 0) {
            Patient minHealth = patientList[0];
            for (int i = 0; i <= patientList.length - 1; i++) {
                if (patientList[i].getHealth() < minHealth.getHealth()) {
                    minHealth = patientList[i];
                } else {
                    continue;
                }
            }
            minHealth.increaseHealth(this);
        }
    }
}
