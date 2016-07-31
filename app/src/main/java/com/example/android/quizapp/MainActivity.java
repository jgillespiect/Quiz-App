package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myQuizApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void submitQuiz(View view) {
        int numberCorrect = 0; // tally of the number of correct answers
        int[] questionViewIDs = new int[]{R.id.question1, R.id.question2, R.id.question3, R.id.question4, R.id.question5};
        EditText studentName = (EditText) findViewById(R.id.Name);
        String sName = studentName.getText().toString();
        for (int i = 0; i < questionViewIDs.length; i++) {
            TextView tv = (TextView) findViewById(questionViewIDs[i]);
            switch (i) {
                case 0:
                    // Executed for question 1
                    EditText ev1 = (EditText) findViewById(R.id.Answer1);
                    String answer1 = ev1.getText().toString().toUpperCase();
                    Log.v(TAG, "Answer 1 = " + answer1);

                    if (answer1.equals("15") || answer1.equals("FIFTEEN") || answer1.equals("15 MINUTES") || answer1.equals("FIFTEEN MINUTES")) {
                        numberCorrect++;
                    }
                    Log.v(TAG, "number correct = " + Integer.toString(numberCorrect));
                    break;
                case 1:
                    // Executed for question 2
                    int rightAnswerChecked = 0;
                    CheckBox cb1 = (CheckBox) findViewById(R.id.Answer2A);
                    if (cb1.isChecked())
                        rightAnswerChecked++;
                    Log.v(TAG, "number of right answers for #2 is " + Integer.toString(rightAnswerChecked));

                    CheckBox cb2 = (CheckBox) findViewById(R.id.Answer2B);
                    if (cb2.isChecked())
                        rightAnswerChecked = -5;
                    CheckBox cb3 = (CheckBox) findViewById(R.id.Answer2C);
                    if (cb3.isChecked())
                        rightAnswerChecked++;
                    Log.v(TAG, "number of right answers for #2 is " + Integer.toString(rightAnswerChecked));
                    CheckBox cb4 = (CheckBox) findViewById(R.id.Answer2D);
                    if (cb4.isChecked()) {
                        rightAnswerChecked++;
                    }
                    if (rightAnswerChecked == 3) {
                        //if the number of selected checkboxes equals 3 good answer.
                        numberCorrect++;
                        Log.v(TAG, "number of right answers for #2 is " + Integer.toString(rightAnswerChecked));
                    }

                    break;
                case 2:
                    // Executed for question 3
                    RadioButton rb3 = (RadioButton) findViewById(R.id.Answer3C);
                    //if the 3rd checkbox is selected increment the number correct.
                    if (rb3.isChecked())
                        numberCorrect++;
                    break;
                case 3:
                    // Executed for question 4
                    RadioButton rb1 = (RadioButton) findViewById(R.id.Answer4A);
                    //if the 1st checkbox is selected increment the number correct.
                    if (rb1.isChecked())
                        numberCorrect++;
                    break;
                case 4:
                    // Executed for question 5
                    rightAnswerChecked = 0;
                    CheckBox cb5a = (CheckBox) findViewById(R.id.Answer5A);
                    if (cb5a.isChecked())  // incorrect answer
                        rightAnswerChecked = -5;
                    CheckBox cb5b = (CheckBox) findViewById(R.id.Answer5B);
                    if (cb5b.isChecked())
                        rightAnswerChecked++;
                    CheckBox cb5c = (CheckBox) findViewById(R.id.Answer5C);
                    if (cb5c.isChecked())
                        rightAnswerChecked = -5;
                    CheckBox cb5d = (CheckBox) findViewById(R.id.Answer5D);
                    if (cb5d.isChecked()) {
                        rightAnswerChecked++;
                    }
                    Log.v(TAG, "number of right answers for #5 is " + Integer.toString(rightAnswerChecked));
                    if (rightAnswerChecked == 2) {
                        //if the number of selected checkboxes equals 2 good answer.
                        numberCorrect++;
                    }
                    break;
                default:
                    //                statements // they are executed if none of the above case is satisfied
                    Toast.makeText(MainActivity.this, R.string.CaseDefault, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        int testScore = numberCorrect * 20;
        String scoreMessage = (sName + " your Quiz score = " + testScore + "%");
        numberCorrect = 0;
        Toast.makeText(MainActivity.this, scoreMessage, Toast.LENGTH_LONG).show();


    }
}
