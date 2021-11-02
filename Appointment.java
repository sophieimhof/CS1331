/**
 *Represents an appointment for a pet in the vet clinic.
 *
 *@author simhof3
 *@version 1331
 */
public class Appointment {
    private Pet thePet;
    private String entryTime;
    private String exitTime;
    /**
     *Creates an appointment.
     *
     *@param thePet a pet with an Appointment
     *@param entryTime the time pet enters the clinic
     *@param exitTime the time pet exits the clinic
     */
    public Appointment(Pet thePet, String entryTime, String exitTime) {
        this.thePet = thePet;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }
    @Override
    public String toString() {
        return (thePet.getPetInfo() + "," + this.entryTime + "," + this.exitTime);
    }
}
