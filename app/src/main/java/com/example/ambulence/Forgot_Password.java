package com.example.ambulence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Forgot_Password extends AppCompatActivity {

    private Button Find;

    private EditText email;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    private DatabaseReference mCustomerDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);


        mAuth = FirebaseAuth.getInstance();


        Find = (Button)findViewById(R.id.FindPass);

        email = (EditText)findViewById(R.id.txtEmail) ;

        Find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();

                mAuth.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (!task.isSuccessful()){

                            android.widget.Toast.makeText(Forgot_Password.this, "This email Has not been registerd with the system", android.widget.Toast.LENGTH_SHORT).show();

                        }else{
                            android.widget.Toast.makeText(Forgot_Password.this, "Your password has been sent to your email", android.widget.Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                if (mail.isEmpty()){

                    email.setError("Please enter a valid email address");
                }else {



                }
            }
        });


    }
}