package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    private Button signInBtn;
    private EditText usName;
    private EditText passW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInBtn = (Button) findViewById(R.id.signIN);
        usName = (EditText) findViewById(R.id.userNameId);
        passW = (EditText) findViewById(R.id.passWordId);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = usName.getText().toString();
                String uPas = passW.getText().toString();
                if ( !uName.equals("") || !uPas.equals("") )
                {
                    ParseUser.logInInBackground(uName, uPas, new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if ( e == null )
                            {
                                Toast.makeText(getApplicationContext(), "Signed In", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(LoginActivity.this, ChatActivity.class));

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "Failed To Sign In", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please Enter both the Fields", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}