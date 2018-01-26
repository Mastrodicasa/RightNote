package com.example.user.myapplication;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.multiplyExact;

public class PianoActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String BUNDLE_EXERCICE= "BUNDLE_EXERCICE";
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";


    private ImageButton mb1;
    private ImageButton mb2;
    private ImageButton mb3;
    private ImageButton mb4;
    private ImageButton mb5;
    private ImageButton mb6;
    private ImageButton mb7;
    private ImageButton mb8;
    private ImageButton mb9;
    private ImageButton mb10;
    private ImageButton mb11;
    private ImageButton mb12;

    //DECLARER LES NOMS DES NOTES

    private TextView mTextDo;
    private TextView mTextRe;
    private TextView mTextMi;
    private TextView mTextFa;
    private TextView mTextSol;
    private TextView mTextLa;
    private TextView mTextSi;

    //SONS AJOUTER FICHIER RAW ET INCLURE LES SONS
    private SoundPool mSoundPool;

    private int mSoundDo;
    private int mSoundDoDies;
    private int mSoundRe;
    private int mSoundReDies;
    private int mSoundMi;
    private int mSoundFa;
    private int mSoundFaDies;
    private int mSoundSol;
    private int mSoundSolDies;
    private int mSoundLa;
    private int mSoundLaDies;
    private int mSoundSi;

    //DECLARER TOOLBAR
    private Toolbar mToolbar;

    private TextView mTextView;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;
    private int mScore;
    private int ratioGame;
    private int mNumberOfQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);

        //DEFINIR TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Exercise");
        getSupportActionBar().setIcon(getDrawable(R.drawable.exercises));

        //DECLARER TOUTES LES NOTES TEXT :

        mTextDo =(TextView) findViewById(R.id.text_do);
        mTextRe =(TextView) findViewById(R.id.text_re);
        mTextMi =(TextView) findViewById(R.id.text_mi);
        mTextFa =(TextView) findViewById(R.id.text_fa);
        mTextSol =(TextView) findViewById(R.id.text_sol);
        mTextLa =(TextView) findViewById(R.id.text_la);
        mTextSi =(TextView) findViewById(R.id.text_si);


        //SONS
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mSoundPool = new SoundPool.Builder().setMaxStreams(5).build();
        }else {
            mSoundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        }

        mSoundDo = mSoundPool.load(this, R.raw.donote, 1);
        mSoundDoDies = mSoundPool.load(this, R.raw.dodiesnote,1);
        mSoundRe = mSoundPool.load(this, R.raw.renote,1);
        mSoundReDies = mSoundPool.load(this, R.raw.rediesnote,1);
        mSoundMi = mSoundPool.load(this, R.raw.minote,1);
        mSoundFa = mSoundPool.load(this, R.raw.fanote,1);
        mSoundFaDies = mSoundPool.load(this, R.raw.fadiesnote,1);
        mSoundSol = mSoundPool.load(this, R.raw.solnote,1);
        mSoundSolDies = mSoundPool.load(this, R.raw.soldiesnote,1);
        mSoundLa = mSoundPool.load(this, R.raw.lanote,1);
        mSoundLaDies = mSoundPool.load(this, R.raw.ladiesnote,1);
        mSoundSi = mSoundPool.load(this, R.raw.sinote,1);



        //CHANGER BUTTON EN ImageButton

        mb1=(ImageButton) findViewById(R.id.Do);
        mb2=(ImageButton) findViewById(R.id.Dod);
        mb3=(ImageButton) findViewById(R.id.Ré);
        mb4=(ImageButton) findViewById(R.id.Réd);
        mb5=(ImageButton) findViewById(R.id.Mi);
        mb6=(ImageButton) findViewById(R.id.Fa);
        mb7=(ImageButton) findViewById(R.id.Fad);
        mb8=(ImageButton) findViewById(R.id.Sol);
        mb9=(ImageButton) findViewById(R.id.Sold);
        mb10=(ImageButton) findViewById(R.id.La);
        mb11=(ImageButton) findViewById(R.id.Lad);
        mb12=(ImageButton) findViewById(R.id.Si);

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


        //SONS

        if(responseIndex == 1){
            mSoundPool.play(mSoundDo,1,1,0,0,1);
        }else if(responseIndex == 2){
            mSoundPool.play(mSoundDoDies,1,1,0,0,1);
        }else if(responseIndex == 3){
            mSoundPool.play(mSoundRe,1,1,0,0,1);
        }else if(responseIndex == 4){
            mSoundPool.play(mSoundReDies,1,1,0,0,1);
        }else if(responseIndex == 5){
            mSoundPool.play(mSoundMi,1,1,0,0,1);
        }else if(responseIndex == 6){
            mSoundPool.play(mSoundFa,1,1,0,0,1);
        }else if(responseIndex == 7){
            mSoundPool.play(mSoundFaDies,1,1,0,0,1);
        }else if(responseIndex == 8){
            mSoundPool.play(mSoundSol,1,1,0,0,1);
        }else if(responseIndex == 9){
            mSoundPool.play(mSoundSolDies,1,1,0,0,1);
        }else if(responseIndex == 10){
            mSoundPool.play(mSoundLa,1,1,0,0,1);
        }else if(responseIndex == 11){
            mSoundPool.play(mSoundLaDies,1,1,0,0,1);
        }else if(responseIndex == 12){
            mSoundPool.play(mSoundSi,1,1,0,0,1);
        }


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

        ratioGame= multiplyExact(mScore,100)/mQuestionBank.getSize();

        if(ratioGame>=80) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Well done!")
                    .setMessage("Your score is " + mScore + "/" + mQuestionBank.getSize())
                    .setPositiveButton("Finish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Fin de l'ex et envoi du score
                            Intent intent = new Intent();
                            intent.putExtra(BUNDLE_EXTRA_SCORE, ratioGame);
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
                            intent.putExtra(BUNDLE_EXTRA_SCORE, ratioGame);
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
