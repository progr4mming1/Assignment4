package CourseDatabaseManager;


public class CourseDBElement implements Comparable{
    private String id;
    private int crn;
    private int nCr;
    private String rNm;
    private String ins;
    
    public CourseDBElement() {
    	/* default parameters */
        id = "";
        crn = 0;
        nCr = 0;
        rNm = "";
        ins = "";
    }
    /* accepting parameters */
     
    public CourseDBElement(String id, int crn, int nCr, String rNm, String ins) {
        this.id = id;
        this.crn = crn;
        this.nCr = nCr;
        this.rNm = rNm;
        this.ins = ins;
    }
    @Override
    public int compareTo(CourseDBElement element) {
        return (this.crn - element.crn);
    }
    
    public int getCRN() {
        return crn;
    }
    
    public void setCRN(int crn) {
        this.crn = crn;
    }
    
    @Override
    public int hashCode() {
        
    	String tmp = Integer.toString(crn);
    
        return tmp.hashCode();
    }
    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CourseDBElement other = (CourseDBElement) obj;
        if (crn != other.crn)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        String everything = "\nCourse:" + id + "\tCRN:" + crn + "\tCredits:" + nCr + "\tInstructor:" + ins + "\tRoom:" + rNm;
        return everything;
    }

}
