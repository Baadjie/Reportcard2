package firebase.android.myinfo.reportcard2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudents extends AppCompatActivity {

    private StudentDatabase sd = new StudentDatabase(this);
    private EditText editStudNo, editName, editSubject1,editSubject2,edtSurname,edtGender,edtSubName,edtTest1,edtTest2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students);



        editStudNo=(EditText) findViewById(R.id.editText6);
        editName=(EditText) findViewById(R.id.editText);
        edtSurname=(EditText) findViewById(R.id.editText2);
        editSubject1=(EditText) findViewById(R.id.editText3);
        editSubject2=(EditText) findViewById(R.id.editText4);
        edtGender=(EditText) findViewById(R.id.editText5);
//        edtSubName= (EditText) findViewById(R.id.editText7);
//        edtTest1= (EditText) findViewById(R.id.editText8);
//        edtTest2= (EditText) findViewById(R.id.editText10);

        Button btnAdd=(Button)findViewById(R.id.button);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int stdNum=Integer.parseInt(editStudNo.getText().toString());
                String name=editName.getText().toString();
                String surname=edtSurname.getText().toString();
                int mark1=Integer.parseInt(editSubject1.getText().toString());
                int mark2=Integer.parseInt(editSubject2.getText().toString());
                String gender=edtGender.getText().toString();

//                String subjectName=edtSubName.getText().toString();
//                double test1=Double.parseDouble(edtTest1.getText().toString());
//                double test2=Double.parseDouble(edtTest2.getText().toString());
//                int fkStude=Integer.parseInt(editStudNo.getText().toString());
                 Student students = new Student(stdNum, name, surname,mark1,mark2,gender);
//                Subject subject=new Subject(fkStude,subjectName,test1,test2);
//You owe me big time!!!!!!!! #Poison
                sd.addStudent(students);
//                sd.addSubject(subject);
                Intent intent =new Intent(AddStudents.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void delete(View view){
       String name = editName.getText().toString();

        sd.deleteStudent(name);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }



    public void update(View view){

        EditText editColumn= (EditText) findViewById(R.id.editText7);
        long id =Long.parseLong(editColumn.getText().toString());
       // long colomnID= Long.parseLong(id.getText().toString());
        String name =String.valueOf( editName.getText().toString() );
       // String faculty= (String) spinner.getSelectedItem();
        int studnu= Integer.parseInt(editStudNo.getText().toString());
        String surname= edtSurname.getText().toString();
        int test1= Integer.parseInt(editSubject1.getText().toString());
        int test2= Integer.parseInt(editSubject2.getText().toString());
      //  int average= Integer.parseInt(txtaverage.getText().toString());
        String gender=edtGender.getText().toString();
      //  int id=0;
        sd.updateShow(id,studnu,name,surname,test1,test2,gender);




        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

}
