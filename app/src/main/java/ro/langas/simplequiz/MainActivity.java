package ro.langas.simplequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog( MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is \n"+currentScore + "/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }

    private void setDataToViews(int currentPos){
        questionNumberTV.setText("Questions attempted :"+questionAttempted + "/10");
        if(questionAttempted == 10){
            showBottomSheet();
        }else {

            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());
        }

    }
    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal( "Select a component which is NOT part of Android architecture", "Android Framework",  "Linux Kernel", "Libraries", "Android Document", "Android Document"));
        quizModalArrayList.add(new QuizModal( "Required folder when Android project is created", "build/",  "build", "bin", "bin/", "build"));
        quizModalArrayList.add(new QuizModal( "Adb stands for", "Android Drive Bridge",  "Android Debug Bridge", "Android Destroy Bridge", "Android Delete Bridge", "Android Drive Bridge"));
        quizModalArrayList.add(new QuizModal( "Which is NOT state of an activity?", "Active",  "Paused", "Stopped", "Stored", "Stored"));
        quizModalArrayList.add(new QuizModal( "What is AIDL?", "Android Interface Definition Language",  "Android Intermediate Definition Language", "Android Interface Descriptionn Language", "Android Interface Definition Language"," Android Interface Definition Language"));
        quizModalArrayList.add(new QuizModal( "What is splash screen in android?", "A - Initial activity of an application",  "B - Initial service of an application", "C - Initial method of an application", "D - Initial screen of an application", "D - Initial screen of an application"));
        quizModalArrayList.add(new QuizModal( "What is the difference between services and thread in android?", "A - Services performs functionalities in the background. By default services run on main thread only",  "B - Thread and services are having same functionalities.", "C - Thread works on services", "D - None of the above", "A - Services performs functionalities in the background. By default services run on main thread only"));
        quizModalArrayList.add(new QuizModal( "What is the time limit of broadcast receiver in android?", "10Sec",  "15Sec", "5Sec", "1Min", "10Sec"));
        quizModalArrayList.add(new QuizModal( "How to get current location in android?", "A - Using with GPRS",  "B - Using location provider", "C - A & B", "D - Network servers", "C - A & B"));
        quizModalArrayList.add(new QuizModal( "What is the package name of HTTP client in android?", "A - com.json",  "B - org.apache.http.client", "C - com.android.JSON", "D - org.json", "B - org.apache.http.client"));


    }
}