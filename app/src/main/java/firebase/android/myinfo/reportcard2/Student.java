package firebase.android.myinfo.reportcard2;

/**
 * Created by Baadjie on 2017/07/24.
 */

public class Student {

    private long id;
    private int studentNo;
    private String name;
    private String surname;

    private int mark1;
    private int mark2;
    private String gender;

    public Student() {
    }


    public Student(long id, int studentNo, String name, String surname, int mark1, int mark2, String gender) {
        this.id = id;
        this.studentNo = studentNo;
        this.name = name;
        this.surname = surname;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.gender = gender;
    }

    public Student(int studentNo, String name, String surname, int mark1, int mark2, String gender) {
        this.studentNo = studentNo;
        this.name = name;
        this.surname = surname;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                "id= " + id +"  "+
                ", studentNo= " + " "+studentNo +
                ", name= " + name +" "  +
                ", surname= " + "  "+surname  +
                ", mark1= " + "  "+mark1 +
                ", mark2= " + " "+mark2 +
                ", gender='" +"  "+ gender;

    }
}
