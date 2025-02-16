package com.example.assign1_21l_7644;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    Button btnStartQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        btnStartQuiz = findViewById(R.id.btn_start_quiz);

        btnStartQuiz.setOnClickListener(v ->
        {
            String user_name = etName.getText().toString().trim();

            if (user_name.isEmpty())
            {
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
            }
            else if (containsInteger(user_name)|| containsSpecialSymbol(user_name))
            {
                Toast.makeText(this, "Name should not contain numbers or any special symbols", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Intent i = new Intent(MainActivity.this, QuizActivity.class);
                i.putExtra("USER_NAME", user_name);
                startActivity(i);
            }
        });
    }
    private boolean containsInteger(String input)
    {
        return input.matches(".*\\d+.*");
    }
    private boolean containsSpecialSymbol(String input)
    {
        return input.matches(".*[^a-zA-Z0-9 ].*");
    }
}