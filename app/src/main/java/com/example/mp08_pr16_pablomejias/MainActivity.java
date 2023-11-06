package com.example.mp08_pr16_pablomejias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = (EditText) findViewById(R.id.editName);
        EditText lastName = (EditText) findViewById(R.id.editLastName);
        EditText phone = (EditText) findViewById(R.id.editTextPhone);
        EditText mail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        Button guardar = (Button) findViewById(R.id.button);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream outputStream;
                String text="";
                text += name.getText() +";";
                text += lastName.getText()+";";
                text += phone.getText()+";";
                text += mail.getText()+";";
                try {
                    outputStream = openFileOutput("contactes.txt", Context.MODE_PRIVATE);
                    outputStream.write(text.getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}