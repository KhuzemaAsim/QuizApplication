package com.example.assign1_21l_7644;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView tvResult;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = findViewById(R.id.tv_result);
        btnShare = findViewById(R.id.btn_share);

        int score = getIntent().getIntExtra("SCORE", 0);
        tvResult.setText("Your Score is: " + score + "/10");

        btnShare.setOnClickListener(v ->
        {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "I have scored " + score + " in the MCQBased Quiz App!");
            startActivity(Intent.createChooser(intent, "Share via"));
        });
    }
}