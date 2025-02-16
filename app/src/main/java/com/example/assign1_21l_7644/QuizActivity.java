package com.example.assign1_21l_7644;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    TextView tvQuestion;
    RadioGroup radioGroup;
    RadioButton radioOption1, radioOption2, radioOption3, radioOption4;
    Button btnPrevious, btnNext;

    String[] questions =
            {
            "What is the capital of Pakistan?",
            "Which planet is known as the Red Planet?",
            "Who wrote 'Romeo and Juliet'?",
            "What is the largest ocean on Earth?",
            "Which element has the chemical symbol 'O'?",
            "What is the smallest prime number?",
            "Who painted the Mona Lisa?",
            "What is the square root of 64?",
            "Which country is known as the Land of the Rising Sun?",
            "What is the hardest natural substance on Earth?"
    };

    String[][] options = {
            {"Lahore", "London", "Karachi", "Islamabad"},
            {"Mars", "Venus", "Jupiter", "Saturn"},
            {"William Shakespeare", "Charles Dickens", "Mark Twain", "Jane Austen"},
            {"Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean"},
            {"Oxygen", "Gold", "Silver", "Iron"},
            {"2", "3", "5", "7"},
            {"Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet"},
            {"8", "6", "4", "10"},
            {"Japan", "China", "India", "South Korea"},
            {"Diamond", "Gold", "Iron", "Platinum"}
    };

    int[] answers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int currentQuestionIndex = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuestion = findViewById(R.id.tv_question);
        radioGroup = findViewById(R.id.radio_group);
        radioOption1 = findViewById(R.id.radio_option1);
        radioOption2 = findViewById(R.id.radio_option2);
        radioOption3 = findViewById(R.id.radio_option3);
        radioOption4 = findViewById(R.id.radio_option4);
        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);

        loadQuestion();

        btnNext.setOnClickListener(v ->
        {
            if (radioGroup.getCheckedRadioButtonId() == -1)
            {
                Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
                return;
            }

            if (radioGroup.getCheckedRadioButtonId() == radioOption1.getId())
            {
                score++;
            }

            if (currentQuestionIndex < questions.length - 1)
            {
                currentQuestionIndex++;
                loadQuestion();
            }
            else
            {
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("SCORE", score);
                startActivity(intent);
                finish();
            }
        });

        btnPrevious.setOnClickListener(v ->
        {
            if (currentQuestionIndex > 0)
            {
                currentQuestionIndex--;
                loadQuestion();
            }
        });
    }

    void loadQuestion()
    {
        tvQuestion.setText(questions[currentQuestionIndex]);
        radioOption1.setText(options[currentQuestionIndex][0]);
        radioOption2.setText(options[currentQuestionIndex][1]);
        radioOption3.setText(options[currentQuestionIndex][2]);
        radioOption4.setText(options[currentQuestionIndex][3]);

        btnPrevious.setEnabled(currentQuestionIndex != 0);
        radioGroup.clearCheck();
    }
}