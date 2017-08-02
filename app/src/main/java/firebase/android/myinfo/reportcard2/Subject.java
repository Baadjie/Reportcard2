package firebase.android.myinfo.reportcard2;

/**
 * Created by Baadjie on 2017/07/27.
 */

public class Subject {
    private long id;
    private int fkStudentNo;
    private String subName;
    private double test1;
    private double test2;

    public Subject() {
    }

    public Subject(int fkStudentNo, String subName, double test1, double test2) {
        this.fkStudentNo = fkStudentNo;
        this.subName = subName;
        this.test1 = test1;
        this.test2 = test2;
    }

    public Subject(long id, int fkStudentNo, String subName, double test1, double test2) {
        this.id = id;
        this.fkStudentNo = fkStudentNo;
        this.subName = subName;
        this.test1 = test1;
        this.test2 = test2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFkStudentNo() {
        return fkStudentNo;
    }

    public void setFkStudentNo(int fkStudentNo) {
        this.fkStudentNo = fkStudentNo;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public double getTest1() {
        return test1;
    }

    public void setTest1(double test1) {
        this.test1 = test1;
    }

    public double getTest2() {
        return test2;
    }

    public void setTest2(double test2) {
        this.test2 = test2;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", fkStudentNo=" + fkStudentNo +
                ", subName='" + subName + '\'' +
                ", test1=" + test1 +
                ", test2=" + test2 +
                '}';
    }
}
