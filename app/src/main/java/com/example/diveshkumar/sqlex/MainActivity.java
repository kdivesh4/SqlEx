package com.example.diveshkumar.sqlex;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etname,etcell;
    Button bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = (EditText)findViewById(R.id.etname);
        etcell = (EditText)findViewById(R.id.etcell);
        bt1 = (Button )findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button)findViewById(R.id.bt3);
        bt4 = (Button)findViewById(R.id.bt4);


    }



    public  void btnSubmit(View v){
        String name = etname.getText().toString().trim();
        String cell = etcell.getText().toString().trim();

        try{
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.createEntry(name,cell);
            db.close();
            Toast.makeText(MainActivity.this, "Sucesfully SAved", Toast.LENGTH_SHORT).show();
            etname.setText("");
            etcell.setText("");
        }
        catch (SQLException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void btnShowData(View v){
        startActivity(new Intent(this,Data.class));
    }

    public void btnDeleteData(View v){

        try{
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.deleteEntry("1");
            db.close();
        }
        catch(SQLException e){
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        }
    }
    public void btnEditData(View v){
        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.updateEntry("1","Divesh","9898686778");
            db.close();
            Toast.makeText(this, "UPDAETD", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
