package com.mijung.mijungkwon8736638_assingment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        int luckyNumber = intent.getIntExtra("LUCKY_NUMBER", 0);

        TextView nameTextView = findViewById(R.id.textView2);
        TextView luckyNumberTextView = findViewById(R.id.textViewLuckyNumber);
        Button shareButton = findViewById(R.id.buttonShare);

        nameTextView.setText(username + "'s Lucky Number is "  );
        //luckyNumberTextView.setText(luckyNumber);
        luckyNumberTextView.setText(String.valueOf(luckyNumber));

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareLuck(username, luckyNumber);
            }
        });
    }


    private void shareLuck(String username, int luckyNumber) {
        String shareText = username + "'s lucky number is " + luckyNumber + ".";

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}