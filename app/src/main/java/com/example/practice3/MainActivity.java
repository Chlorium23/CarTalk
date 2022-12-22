package com.example.practice3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button imageButton = (Button) findViewById(R.id.btn1);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.practice3.StartActivity.class);
                startActivity(intent);

                Button imageButton = (Button) findViewById(R.id.btn3);
                imageButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), com.example.practice3.SubActivity3.class);
                        startActivity(intent);

                        Button imageButton = (Button) findViewById(R.id.btn4);
                        imageButton.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getApplicationContext(), com.example.practice3.SubActivity4.class);
                                startActivity(intent);

                            }
                        });

                    }
                });

            }
        });
    }


}