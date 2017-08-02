package firebase.android.myinfo.reportcard2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private  StudentDatabase sd = new StudentDatabase(this);
     Student student=new Student();
   // private  StudentDatabase sd = new StudentDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentDatabase sd = new StudentDatabase(this);
         List<Student> students=sd.getAllStudents();
//        List<Subject> subject=sd.getSubject();

        ListView lv= (ListView) findViewById(R.id.listView1);
         ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, students);
//        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, subject);
        lv.setAdapter(arrayAdapter);
//        lv.setAdapter(arrayAdapter2);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Update");
                builder.setMessage("Are you sure you want to Update");
               // builder.show();
                builder.setPositiveButton("update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // builder.show();
                        Intent intent=new Intent(MainActivity.this,AddStudents.class);
                        startActivity(intent);
                    }

                });

                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }

        });

    }



       @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_student,menu);
        getMenuInflater().inflate(R.menu.delete,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_student:
                Intent intent = new Intent(MainActivity.this, AddStudents.class);

                startActivity(intent);
                finish();
                break;
            case R.id.delete_stud:
                 intent = new Intent(MainActivity.this, AddStudents.class);

                startActivity(intent);
        }
            return super.onOptionsItemSelected(item);
        }


}
