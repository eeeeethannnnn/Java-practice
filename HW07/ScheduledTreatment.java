//I worked on the homework assignment alone, using only course materials.
/**
 *a class for scheduled treatment and inherited from treatment.
 * @author Shen-Yi Cheng
 * @version 1
 **/
public class ScheduledTreatment extends Treatment {
    private int treatPatientID;
    /**
     * a constructor for ScheduledTreatment.
     * @param heal input heal Point
     * @param treatPatientID who going to be treated
     **/
    public ScheduledTreatment(int heal, int treatPatientID) {
        super(heal);
        this.treatPatientID = treatPatientID;
    }
    /**
     * a binary search tree for searching Patient ID.
     * @param patientList as pat@ient objects List
     * @param left leftest index
     * @param right rightest index
     * @param id target id
     * @return int as the target index
     **/
    public int binarySearch(Patient[] patientList, int left, int right, int id) {
        if (left < right) {
            int mid = (left + right - 1) / 2;
            if (patientList[mid].getPatientID() == id) {
                return mid;
            } else if (patientList[mid].getPatientID() > id) {
                return binarySearch(patientList, left, mid - 1, id);
            } else {
                return binarySearch(patientList, mid + 1, right, id);
            }
        } else {
            return -1;
        }

    }
    /**
     *  @Override
     * a override method for perform heal in ScheduledTreatment.
     * @param patientList a list for patient objects
     **/
    public void performHeal(Patient[] patientList) {
        if (patientList.length > 0) {
            HealAbility.sortPatients(patientList);
            int index = binarySearch(patientList, 0, patientList.length - 1, treatPatientID);
            if (index > 0) {
                patientList[index].increaseHealth(this);
            }
        }

    }
    /**
     * a method for set treatPatientID.
     * @param treatPatientID as new treatPatientID
     **/
    public void setTreatPatientID(int treatPatientID) {
        this.treatPatientID = treatPatientID;
    }
    /**
     * a method to get treatPatientID.
     * @return treatPatientID
     **/
    public int getTreatPatientID() {
        return this.treatPatientID;
    }
}
