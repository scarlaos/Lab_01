public class person {
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;
    static private int IDSeed = 1;

    public static void setIDSeed(int IDSeed) {
        person.IDSeed = IDSeed;
    }

    public static int getIDSeed() {
        return IDSeed;
    }

    public person(String IDNum, String firstName, String lastName, String title, int YOB) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title=title;
        this.YOB = YOB;
    }

    public person(String firstName, String lastName, int YOB) {
        this.IDNum = this.genIDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title="";
        this.YOB = YOB;
    }

    public String getIDNum() {
        return IDNum;
    }

    private String genIDNum(){
        String newID = "" + IDSeed;
        while(newID.length()<8) {
            newID = "0" + newID;
            IDSeed++;
        } return newID;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toCSV(){
        return String.format("%s,%s,%s,%s,%d",IDNum,firstName,lastName,title,YOB);
    }

    public String toJSON(){
        return String.format(
                "{\"id\":\"%s\", \"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"yob\":%d}", IDNum, firstName,lastName, title, YOB);

    }

    public String toXML(){
        return String.format("<person><ID>%s</ID><FirstName>%s</FirstName><LastName>%s</LastName><Title>%s</Title><YOB>%s</YOB></person>", IDNum, firstName, lastName, title, YOB);
    }


    @Override
    public String toString() {
        return "person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", YOB=" + YOB +
                '}';
    }



}
