package com.example.diveshkumar.sqlex;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Data extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tv = (TextView)findViewById(R.id.tv);
        try{

            ContactsDB db = new ContactsDB(this);
            db.open();
            tv.setText(db.getData());
            db.close();
        }

        catch (SQLException e)
        {
            Toast.makeText(Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
