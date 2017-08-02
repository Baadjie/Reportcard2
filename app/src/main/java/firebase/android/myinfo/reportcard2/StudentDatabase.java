package firebase.android.myinfo.reportcard2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baadjie on 2017/07/24.
 */

public class StudentDatabase extends SQLiteOpenHelper {


    private static final String TABLE_STUDENT = "student";
    private static final String TABLE_SUBJECT = "subject";
    private final String COLUMN_ID = "_id";
    private final String COLUMN_STUDENT_NUMBER = "studentNumber";
    private final String COLUMN_NAME = "name";
    private final String COLUMN_SURNAME = "surname";
    private final String COLUMN_Mark1 = "mark1";
    private final String COLUMN_Mark2 = "mark2";
    private final String COLUMN_GENDER = "gender";
    private final static String DATABASE_NAME = "students.db";

    private final String COLUMN_SUBJECT_NAME = "surname";
    private final String COLUMN_TEST1 = "mark1";
    private final String COLUMN_TEST2 = "mark2";
    private final static int DATABASE_VERSION = 7;

    private final String DATABASE_CREATE = "create table " + TABLE_STUDENT + "( " + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_STUDENT_NUMBER + " text not null, " + COLUMN_NAME + " text not null, "
            + COLUMN_SURNAME + " text not null, " + COLUMN_Mark1 + " integer not null, " + COLUMN_Mark2 + " integer not null, " + COLUMN_GENDER + " text not null );";

    private final String DATABASE_CREATE2 = "create table " + TABLE_SUBJECT + "( " + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_STUDENT_NUMBER + " integer foreign key, " + COLUMN_SURNAME + " text not null, "
            + COLUMN_TEST1 + " text not null, " + COLUMN_TEST2 + " integer not null) ";


    public StudentDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL(DATABASE_CREATE);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBJECT);
        db.execSQL(DATABASE_CREATE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBJECT);
        onCreate(db);
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_STUDENT_NUMBER, student.getStudentNo());
        contentValues.put(COLUMN_NAME, student.getName());
        contentValues.put(COLUMN_SURNAME, student.getSurname());
        contentValues.put(COLUMN_Mark1, student.getMark1());
        contentValues.put(COLUMN_Mark2, student.getMark2());
        contentValues.put(COLUMN_GENDER, student.getGender());


        db.insert(TABLE_STUDENT, null, contentValues);
        db.close();
    }

    public void addSubject(Subject subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_STUDENT_NUMBER, subject.getFkStudentNo());
        contentValues.put(COLUMN_SUBJECT_NAME, subject.getSubName());
        contentValues.put(COLUMN_TEST1, subject.getTest1());
        contentValues.put(COLUMN_TEST2, subject.getTest2());


        db.insert(TABLE_SUBJECT, null, contentValues);
        db.close();
    }

    public int deleteStudent(String x) {


        SQLiteDatabase db = this.getWritableDatabase();

        String[] whereArgs = {x};
        int count = db.delete(this.TABLE_STUDENT, this.COLUMN_NAME + "=?", whereArgs);
        // db.delete(TABLE_STUDENT, COLUMN_ID + " = ?",
        // new String[]{String.valueOf(x)});
        // db.close();
        return count;
    }
//    public List<Student> getAllStudents() {
//        List<Student> students = new ArrayList<Student>();
//        // Select All Query
//         String selectQuery = "SELECT *  FROM " + TABLE_STUDENT;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//
//            do {     Student student = new Student();
//               student.setId(Integer.parseInt(cursor.getString(0)));
//                student.setStudentNo(cursor.getInt(1));
//                student.setName(cursor.getString(2));
//                student.setSurname(cursor.getString(3));
//                student.setMark1(cursor.getInt(4));
//                student.setMark2(cursor.getInt(5));
//                student.setGender(cursor.getString(6));
//
//               // String display="name" +stz;
//               students.add(student);
//            }
//            while (cursor.moveToNext());
//        }
//
//        return students;  }


    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_STUDENT,
                null,
                null,
                null,
                null,
                null,
                null);

        Student contactStudent;

        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                contactStudent = new Student();
                contactStudent.setId(cursor.getLong(0));
                System.out.println(cursor.getLong(0));
                contactStudent.setStudentNo(cursor.getInt(1));
                contactStudent.setName(cursor.getString(2));
                contactStudent.setSurname(cursor.getString(3));
                contactStudent.setMark1(cursor.getInt(4));
                contactStudent.setMark2(cursor.getInt(5));
                contactStudent.setGender(cursor.getString(6));
                students.add(contactStudent);
            }
        }
        cursor.close();
        db.close();
        return students;
    }

    public void updateShow(long colomnID, int studnu, String name, String surname, int mark1, int mark2, String gender) {
        ContentValues values = new ContentValues();

        SQLiteDatabase db = this.getWritableDatabase();
        values.put(COLUMN_STUDENT_NUMBER, studnu);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SURNAME, surname);
        values.put(COLUMN_GENDER, gender);
        values.put(COLUMN_TEST1, mark1);
        values.put(COLUMN_TEST2, mark2);

        db.update(TABLE_STUDENT, values, COLUMN_ID + "=" + colomnID, null);
    }
//    public ArrayList<Subject> getSubject() {
//        ArrayList<Subject> subjects = new ArrayList<Subject>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_SUBJECT,
//                null,
//                null,
//                null,
//                null,
//                null,
//                null);
//
//        Subject subject;
//
//        if (cursor.getCount() > 0) {
//            for (int i = 0; i < cursor.getCount(); i++) {
//                cursor.moveToNext();
//                subject = new Subject();
//                subject.setId(cursor.getLong(0));
//
//                subject.setFkStudentNo(cursor.getInt(1));
//                subject.setSubName(cursor.getString(2));
//                subject.setTest1(cursor.getDouble(3));
//                subject.setTest2(cursor.getDouble(4));
//
//                subjects.add(subject);
//            }
//        }
//        cursor.close();
//        db.close();
//        return subjects;
//    }


    public Student getStudent(int id) {
        Student s = new Student();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_STUDENT + " where " + COLUMN_ID + " = ? ";
        String args[] = {String.valueOf(id)};
        Cursor c = db.rawQuery(selectQuery, args);
        if (c.moveToFirst()) {
            s.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
            s.setName(c.getString(c.getColumnIndex(COLUMN_NAME)));
            s.setStudentNo(c.getInt(c.getColumnIndex(COLUMN_STUDENT_NUMBER)));
            s.setSurname(c.getString(c.getColumnIndex(COLUMN_SURNAME)));
            s.setMark1(c.getInt(c.getColumnIndex(COLUMN_Mark1)));
            s.setMark2(c.getInt(c.getColumnIndex(COLUMN_Mark2)));
            s.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        }
        return s;
    }
}