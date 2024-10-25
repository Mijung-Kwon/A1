package com.mijung.mijungkwon8736638_assingment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;



import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button wishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.editTextName);
        wishButton = findViewById(R.id.buttonWish);

        wishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wishLuck();
            }
        });
    }

    private void wishLuck() {
        String userName = nameEditText.getText().toString();
        int luckyNumber = new Random().nextInt(1000) + 1;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("USERNAME", userName);
        intent.putExtra("LUCKY_NUMBER", luckyNumber);
        startActivity(intent);
    }


}