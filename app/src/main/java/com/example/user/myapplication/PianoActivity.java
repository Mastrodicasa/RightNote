package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PianoActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String BUNDLE_EXERCICE= "BUNDLE_EXERCICE";
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";



    private Button mb1;
    private Button mb2;
    private Button mb3;
    private Button mb4;
    private Button mb5;
    private Button mb6;
    private Button mb7;
    private Button mb8;
    private Button mb9;
    private Button mb10;
    private Button mb11;
    private Button mb12;

    private TextView mTextView;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;
    private int mScore;
    private int mNumberOfQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);

        mb1=(Button) findViewById(R.id.Do);
        mb2=(Button) findViewById(R.id.Dod);
        mb3=(Button) findViewById(R.id.Ré);
        mb4=(Button) findViewById(R.id.Réd);
        mb5=(Button) findViewById(R.id.Mi);
        mb6=(Button) findViewById(R.id.Fa);
        mb7=(Button) findViewById(R.id.Fad);
        mb8=(Button) findViewById(R.id.Sol);
        mb9=(Button) findViewById(R.id.Sold);
        mb10=(Button) findViewById(R.id.La);
        mb11=(Button) findViewById(R.id.Lad);
        mb12=(Button) findViewById(R.id.Si);

        mb1.setTag(1);
        mb2.setTag(2);
        mb3.setTag(3);
        mb4.setTag(4);
        mb5.setTag(5);
        mb6.setTag(6);
        mb7.setTag(7);
        mb8.setTag(8);
        mb9.setTag(9);
        mb10.setTag(10);
        mb11.setTag(11);
        mb12.setTag(12);

        mTextView=(TextView) findViewById(R.id.question);

        mb1.setOnClickListener(this);
        mb2.setOnClickListener(this);
        mb3.setOnClickListener(this);
        mb4.setOnClickListener(this);
        mb5.setOnClickListener(this);
        mb6.setOnClickListener(this);
        mb7.setOnClickListener(this);
        mb8.setOnClickListener(this);
        mb9.setOnClickListener(this);
        mb10.setOnClickListener(this);
        mb11.setOnClickListener(this);
        mb12.setOnClickListener(this);


        //On récupère de Course activity quel bouton a été appuyé:
        // car différents boutons envoient vers des exercices différents
        Bundle extras=getIntent().getExtras();
        if (extras!=null)
        {
            //Ce nombre correspond au quantième groupe
            int nbEx=extras.getInt(BUNDLE_EXERCICE);
            mScore=0;
            //On crée la liste de questions propre à l'exercice demandé
            mQuestionBank=new QuestionBank(nbEx);
            //Le nombre de questions pour cet exercice
            mNumberOfQuestions=mQuestionBank.getSize();
            //On récupère une question pour savoir le texte à afficher et la bonne réponse
            mCurrentQuestion = mQuestionBank.getQuestion();
            //On affiche la question
            mTextView.setText(mCurrentQuestion.getQuestion());
        }
        else
        {
            mTextView.setText("ERREUR: CourseLevelXActivity n'a pas renvoyé vers quelle exercice aller");
        }

    }


    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();
        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            // Good answer
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            // Wrong answer
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }

        // If this is the last question, ends the game.
        // Else, display the next question.
        if (--mNumberOfQuestions == 0) {
            // End the game
            endGame();
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            mTextView.setText(mCurrentQuestion.getQuestion());
        }
    }

    private void endGame() {

        double ratioGame= (double) mScore/mQuestionBank.getSize();
        if(ratioGame>=0.8) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Well done!")
                    .setMessage("Your score is " + mScore + "/" + mQuestionBank.getSize())
                    .setPositiveButton("Finish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Fin de l'ex et envoi du score
                            Intent intent = new Intent();
                            intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Not quite!")
                    .setMessage("Your score is " + mScore + "/" + mQuestionBank.getSize())
                    .setPositiveButton("Start again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Restart the same activity
                            recreate();
                        }
                    })
                    .setNegativeButton("Back to courses", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Fin de l'ex et envoi du score
                            Intent intent = new Intent();
                            intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        }
    }
}
