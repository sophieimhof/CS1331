/**
 *Represents a student at Georgia Tech.
 *
 *@author simhof3
 *@version 1331
 */
public class GtStudent {
    private final String name;
    private int gtid;
    private int classYear;
    private double gpa;
    private double diningDollar;
    private double buzzfund;

    /**
     *Creates a GtStudent with the student's name, and default values
     *for all other parameters.
     *
     *@param name the student's name
     */
    public GtStudent(String name) {
        this(name, 1, 1);
    }
    /**
     *Creates a GtStudent with the student's name, gtid, and class year
     *with default values for gpa, diningDollar, and buzzfund.
     *
     *@param name the student's name
     *@param gtid the student's gtid
     *@param classYear the student's class year
     */
    public GtStudent(String name, int gtid, int classYear) {
        this(name, gtid, classYear, 4.0, 0.0, 0.0);
    }
    /**
     *Creates a GtStudent with the student's name, diningDollar,
     *and buzzfund with default values for gtid, class year, and gpa.
     *
     *@param name the student's name
     *@param diningDollar the student's amount of dining dollars
     *@param buzzfund the student's amount of buzzfunds
     */
    public GtStudent(String name, double diningDollar, double buzzfund) {
        this(name, 1, 1, 4.0, diningDollar, buzzfund);
    }
    /**
     *Creates a GtStudent that has the same information as the
     *student passed in besides name.
     *
     *@param student a GtStudent
     *@param name the student's name
     */
    public GtStudent(GtStudent student, String name) {
        this(name, student.gtid, student.classYear, student.gpa, student.diningDollar, student.buzzfund);
    }
    /**
     *Creates a GtStudent with all required parameters.
     *
     *@param name the student's name
     *@param gtid the student's gtid
     *@param classYear the student's class year
     *@param gpa the student's gpa
     *@param diningDollar the student's amount of dining dollars
     *@param buzzfund the student's amount of buzzFunds
     */
    public GtStudent(String name, int gtid, int classYear, double gpa, double diningDollar, double buzzfund) {
        this.name = name;
        if ((classYear != 1) && (classYear != 2) && (classYear != 3) && (classYear != 4)) {
            this.classYear = 1;
        } else {
            this.classYear = classYear;
        }
        String gtidString = Integer.toString(gtid);
        int gtidLength = gtidString.length();
        if (gtidLength != 9) {
            this.gtid = -1;
        } else {
            String firstThree = gtidString.substring(0, 3);
            if (!(firstThree.equals("903"))) {
                this.gtid = -1;
            } else {
                this.gtid = gtid;
            }
        }
        if (gpa < 1.0 || gpa > 4.0) {
            this.gpa = 4.0;
        } else {
            this.gpa = gpa;
        }
        if (diningDollar < 0.0) {
            this.diningDollar = 0;
        } else {
            this.diningDollar = diningDollar;
        }
        if (diningDollar < 0.0) {
            this.buzzfund =  0.0;
        } else {
            this.buzzfund = buzzfund;
        }
    }
    /**
     *Calculates the dining dollars and buzzfunds that a
     *student at Georgia Tech has left after a purchse.
     *
     *@param cost the cost of the item to be purchased
     */
    public void purchaseMeal(double cost) {
        if (diningDollar + buzzfund >= cost) {
            System.out.println(name + " has successfully purchased the meal");
            double amountLeft = diningDollar - cost;
            if (amountLeft < 0.0) {
                diningDollar = 0.0;
                buzzfund = buzzfund - Math.abs(amountLeft);
            } else {
                diningDollar = amountLeft;
            }
        } else {
            System.out.println(name + " does not have enough funds to purchase the meal");
        }
    }
    /**
     *Adds an amount to a student's dining dollars.
     *
     *@param dD the amount of dining dollars added
     */
    public void addDiningDollars(double dD) {
        this.diningDollar = this.diningDollar + dD;
    }
    /**
     *Adds an amounts to a student's buzzfunds.
     *
     *@param bF the amount of buzzfunds added
     */
    public void addBuzzfund(double bF) {
        this.buzzfund = this.buzzfund + bF;
    }
    /**
     *Increases a student's class year by one.
     */
    public void increaseClassYear() {
        if (classYear < 4) {
            classYear = classYear + 1;
        }
    }
}
