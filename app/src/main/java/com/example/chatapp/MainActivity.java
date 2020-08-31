package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {
    private Button loginBtn;
    private Button createBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        createBtn = ( Button) findViewById(R.id.createAccBt);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateAccount.class));

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity.this, LoginActivity.class));

            }
        });


        /*
       ParseObject ob = new ParseObject("OKAY");
       ob.put("Name","Manoj");
       ob.saveInBackground();

       ParseUser user = new ParseUser();
        // Set the user's username and password, which can be obtained by a forms
        user.setUsername("User7");
        user.setPassword("user123");
        user.setEmail("jhkjhkjh@gmail.com");

        user.put("phone", "1234567809845435");

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if ( e == null )
                {
                    //done
                    Toast.makeText(getApplicationContext(), "Done!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    //Something is wrong
                }
            }
        }); */













    }
}