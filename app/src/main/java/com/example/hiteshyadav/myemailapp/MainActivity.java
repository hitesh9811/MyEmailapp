package com.example.hiteshyadav.myemailapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText et1 , et2 , et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.email);
        et2 = (EditText)findViewById(R.id.sub);
        et3 = (EditText)findViewById(R.id.message);

        b1 = (Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = et1.getText().toString();
                String sub = et2.getText().toString();
                String msg = et3.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.putExtra(Intent.EXTRA_EMAIL , new String[] {email});
                intent.putExtra(Intent.EXTRA_SUBJECT , sub);
                intent.putExtra(Intent.EXTRA_TEXT , msg);

                intent.setType("msg/rfc822");

                startActivity(Intent.createChooser(intent , "Please Select An Email App"));





            }
        });


    }
}
