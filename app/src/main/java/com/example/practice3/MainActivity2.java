package com.example.practice3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {

    private EditText nEtemail, nEtpwd, nEtPhoneNumber, nEtname, nEtCarNumber;
    private Button btn;
    FirebaseAuth firebaseAuth;
    private DatabaseReference nDatabaseRef;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nDatabaseRef = FirebaseDatabase.getInstance().getReference( "practice3");
        firebaseAuth = FirebaseAuth.getInstance();
        nEtemail = (EditText) findViewById(R.id.et_email);
        nEtpwd = (EditText) findViewById(R.id.et_pwd);
        nEtPhoneNumber=(EditText)findViewById(R.id.et_PhoneNumber);
        nEtCarNumber=(EditText)findViewById(R.id.et_CarNumber);
        nEtname=(EditText)findViewById(R.id.et_name2);
        btn = (Button) findViewById(R.id.btn_register);


        firebaseAuth = FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email =nEtemail.getText().toString().trim();
                final String pwd = nEtpwd.getText().toString().trim();
                final String PhoneNumber = nEtPhoneNumber.getText().toString().trim();
                final String name = nEtname.getText().toString().trim();
                final String CarNumber = nEtCarNumber.getText().toString().trim();
                //공백인 부분을 제거하고 보여주는 trim();


                firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()) {
                                    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                                    UserAccount account = new UserAccount();
                                    account.setIdToken(firebaseUser.getUid());
                                    account.setEmailId(firebaseUser.getEmail());
                                    account.setPhoneNumber(PhoneNumber);
                                    account.setName(name);
                                    account.setCarNumber(CarNumber);
                                    account.setPassword(pwd);

                                    nDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                                    Toast.makeText(MainActivity2.this, "회원가입에 성공하였습니다", Toast.LENGTH_SHORT ).show();
                                }
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(MainActivity2.this, loginActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    Toast.makeText(MainActivity2.this, "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });

            }
        });


    }

    public static class MainActivity3 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }
}