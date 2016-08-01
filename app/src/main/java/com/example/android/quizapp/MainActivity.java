package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        int testScore = 0;
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

                    if (answer1.equals("15") || answer1.equals("FIFTEEN") || answer1.equals("15 MINUTES") || answer1.equals("FIFTEEN MINUTES")) {
                        testScore = testScore + 20;
                    }
                    break;
                case 1:
                    // Executed for question 2

                    CheckBox cb1 = (CheckBox) findViewById(R.id.Answer2A);
                    CheckBox cb2 = (CheckBox) findViewById(R.id.Answer2B);
                    CheckBox cb3 = (CheckBox) findViewById(R.id.Answer2C);
                    CheckBox cb4 = (CheckBox) findViewById(R.id.Answer2D);
                    if (cb1.isChecked() && !cb2.isChecked() && cb3.isChecked() && cb4.isChecked()) { //Increase points
                        testScore = testScore + 20;
                    }
                    break;
                case 2:
                    // Executed for question 3
                    RadioButton rb3 = (RadioButton) findViewById(R.id.Answer3C);
                    //if the 3rd checkbox is selected increment the number correct.
                    if (rb3.isChecked())
                        testScore = testScore + 20;
                    break;
                case 3:
                    // Executed for question 4
                    RadioButton rb1 = (RadioButton) findViewById(R.id.Answer4A);
                    //if the 1st checkbox is selected increment the number correct.
                    if (rb1.isChecked())
                        testScore = testScore + 20;
                    break;
                case 4:
                    // Executed for question 5

                    CheckBox cb5a = (CheckBox) findViewById(R.id.Answer5A);
                    CheckBox cb5b = (CheckBox) findViewById(R.id.Answer5B);
                    CheckBox cb5c = (CheckBox) findViewById(R.id.Answer5C);
                    CheckBox cb5d = (CheckBox) findViewById(R.id.Answer5D);
                    if (cb5b.isChecked() && !cb5a.isChecked() && !cb5c.isChecked() && cb5d.isChecked()) { //Increase points
                        testScore = testScore + 20;
                    }
                    break;
                default:
                    //                statements // they are executed if none of the above case is satisfied
                    Toast.makeText(MainActivity.this, R.string.CaseDefault, Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        String scoreMessage = (sName + " your Quiz score = " + testScore + "%");
        Toast.makeText(MainActivity.this, scoreMessage, Toast.LENGTH_LONG).show();


    }
}
