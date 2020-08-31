package com.example.chatapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.FlatButton;
import com.dd.processbutton.iml.ActionProcessButton;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import Util.ProgressGenerator;

public class CreateAccount extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {
    private EditText email;
    private EditText userName;
    private EditText pass;
    private ProgressGenerator progressGenerator;
    private ActionProcessButton createAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        email = (EditText) findViewById(R.id.userEmailId);
        userName = (EditText) findViewById(R.id.usernameAccountId);
        pass = (EditText) findViewById(R.id.usernamePassId);

        progressGenerator = new ProgressGenerator(this);

        createAccountBtn = (ActionProcessButton) findViewById(R.id.actionBtn);

        createAccountBtn.setMode(ActionProcessButton.Mode.PROGRESS);

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatingTheAccount();
            }
        });






    }

    private void creatingTheAccount()
    {
        final String em = email.getText().toString();
        final String uName = userName.getText().toString();
        final String pas = pass.getText().toString();
        if ( em.equals("") || uName.equals("") || pas.equals("") )
        {
            AlertDialog.Builder dialog = new AlertDialog.Builder(CreateAccount.this);
            dialog.setTitle("Empty Fields");
            dialog.setMessage("Please Fill All The Fields");
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                }
            });
            dialog.show();
        }
        else
        {
            final ParseUser user = new ParseUser();
            user.setUsername(uName);
            user.setEmail(em);
            user.setPassword(pas);

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if ( e == null )
                    {
                        progressGenerator.start(createAccountBtn);
                        createAccountBtn.setEnabled(false);

                        email.setEnabled(false);
                        userName.setEnabled(false);
                        pass.setEnabled(false);

                        signInUser( uName, pas );
                    }
                }
            });
        }

    }

    private void signInUser(String uName, String pas) {
        if ( !uName.equals("") || !pas.equals("" ) )
        {
            ParseUser.logInInBackground(uName, pas, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if ( e == null )
                    {
                        Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_LONG).show();
                    }
                    else
                    {

                    }
                }
            });
        }
        else
        {

        }
    }


    @Override
    public void onComplete() {
        startActivity(new Intent(CreateAccount.this, MainActivity.class));


    }
}