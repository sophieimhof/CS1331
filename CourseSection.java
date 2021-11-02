/**
 *Represents a course at Georgia Tech.
 *
 *@author simhof3
 *@version 1331
 */
public class CourseSection {
    private String subject;
    private int courseNumber;
    private GtStudent[] roster;
    private long numStudents;
    private static final int MAX_ENROLL = 400;
    private static int numSections = 0;

    /**
    *Creates a course section with the subject, course number, roster,
    *and number of students.
    *
    *@param subject the course subject
    *@param courseNumber the course courseNumber
    *@param roster the course roster of GtStudents
    *@param numStudents the number of students enrolled
    */
    public CourseSection(String subject, int courseNumber, GtStudent[] roster, long numStudents) {
        this.subject = subject;
        this.courseNumber = courseNumber;
        this.roster = roster;
        this.numStudents = numStudents;
        numSections++;
    }
    /**
    *Adds a GtStudent to the roster for a course section and increases
    *the number of students in the course by one.
    *
    *@param student the GtStudent to be added to the course
    */
    public void addStudent(GtStudent student) {
        if (numStudents < MAX_ENROLL) {
            this.roster[(int) numStudents] = student;
            numStudents++;
        }
    }
}
