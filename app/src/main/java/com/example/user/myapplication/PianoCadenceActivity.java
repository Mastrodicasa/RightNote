package com.example.user.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PianoCadenceActivity extends AppCompatActivity implements View.OnClickListener {

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
    private Button mNext;

    private TextView mTextView;

    private QuestionCadenceBank mQuestionCadenceBank;
    private QuestionCadence mCurrentQuestionCadence;
    private int mScore;
    private Long mWhenStarted;
    private Long mWhenClicked;
    private MediaPlayer mp;
    private boolean mLaunchedOnce;
    private int whichQuestion;
    private int mNbrExercice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_cadence);

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
        mNext=(Button) findViewById(R.id.Next);

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
        mNext.setTag(13);

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
        mNext.setOnClickListener(this);

        whichQuestion=-1;

        //On récupère de Course activity quel bouton a été appuyé:
        // car différents boutons envoient vers des exercices différents
        Bundle extras=getIntent().getExtras();
        if (extras!=null)
        {
            //Ce nombre correspond au quantième groupe
            int nbEx=extras.getInt(BUNDLE_EXERCICE);
            mNbrExercice=nbEx;
            mScore=0;
            //On crée la liste de questions propre à l'exercice demandé
            mQuestionCadenceBank=new QuestionCadenceBank(nbEx);
            //On récupère une question pour savoir le texte à afficher et la bonne réponse
            mCurrentQuestionCadence = mQuestionCadenceBank.getQuestionCadence(0);
            //On affiche la question
            mTextView.setText(mQuestionCadenceBank.getQuestionCadenceList().get(0).getQuestion());

        }
        else
        {
            mTextView.setText("ERREUR: CourseLevelXActivity n'a pas renvoyé vers quelle exercice aller");
        }
        //On met la question avant que ca commence
        //mTextView.setText(mQuestionCadenceBank.getQuestionCadenceList().get(0).getQuestion());
        //To avoid a answer from the player without a question
        mLaunchedOnce=false;
        mWhenStarted=System.currentTimeMillis();

    }


    @Override
    public void onClick(View v) {
        mWhenClicked=System.currentTimeMillis();
        Long differenceTime=mWhenClicked-mWhenStarted;
        Log.i("Debug", "DifferenceTime OnClick= "+Long.toString(differenceTime));
        int responseIndex = (int) v.getTag();

        //Si l'utilisateur a appuyé sur next
        if(responseIndex==13)
        {
            mLaunchedOnce=true;
            whichQuestion++;
            // If this is the last question, ends the game.
            // Else, display the next question.
            if (whichQuestion>=mQuestionCadenceBank.getQuestionCadenceList().size()) {
                // End the game
                endGame();
            } else {
                mCurrentQuestionCadence = mQuestionCadenceBank.getQuestionCadence(whichQuestion);
                //mTextView.setText(mCurrentQuestionCadence.getQuestion());

                playCadence();

            }
        }
        else if(mLaunchedOnce) {
            int i= isTimeForNote(differenceTime);

            //C'est le temps pour jouer une bonne note
            if (i >= 0) {
                int rightNote=mCurrentQuestionCadence.getAnswers().get(i);
                //Si c est la bonne
                if (responseIndex==rightNote) {
                    //Si la note n'a pas encore été jouée
                    if(!mCurrentQuestionCadence.getAlreadyPlayed().get(i)) {
                        // Good answer
                        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                        mScore++;
                       mCurrentQuestionCadence.setAlreadyPlayedTrue(i);
                    }
                } else {
                    // Wrong answer
                    Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                }
            }
            //C'est pas le temps pour jouer une des notes qui rapportent des points
            else
            {
                //Rien à faire
            }
        }
    }

    private void playCadence()
    {
        if(mNbrExercice<=32) {
            mp= MediaPlayer.create(this, R.raw.v);
            mp.start();
            while(mp.isPlaying());
            mp= MediaPlayer.create(this, R.raw.i);
            mp.start();
            while(mp.isPlaying());
            mWhenStarted=System.currentTimeMillis();
            Log.i("Debug", "First Chord= " + Long.toString(System.currentTimeMillis()));
            mp = MediaPlayer.create(this, R.raw.cadence_v_i);
            mp.start();
        }
        else
        {
            mp= MediaPlayer.create(this, R.raw.backtrack_v);
            mp.start();
            mWhenStarted=System.currentTimeMillis();
            Log.i("Debug", "First Chord= " + Long.toString(System.currentTimeMillis()));

        }
    }



    private int isTimeForNote( Long differenceTime )
    {
        boolean isTime=false;
        int i;

        //Si il est dans un intervalle de temps pour une réponse
        for(i=0; i< mCurrentQuestionCadence.getAnswers().size();i++) {
            if (mCurrentQuestionCadence.getTimeAnswers().get(i) - 160 < differenceTime && differenceTime < mCurrentQuestionCadence.getTimeAnswers().get(i) + 160) {
                isTime = true;
                break;

            }
        }

        //Si on n'est pas dans les temps pour une reponse, on met un i negatif
        if (isTime==false)
            i=-1;
        //Sinon on renvoie l emplacement de la bonne note


        return i;

    }


    private void endGame() {

        //Le nombre dequestions*le nombre d'accords par question
        int totalNbrOfAnswers=mQuestionCadenceBank.getSize()*mCurrentQuestionCadence.getCadence().size();
        double ratioGame= (double) mScore/(totalNbrOfAnswers);
        if(ratioGame>=0.8) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Well done!")
                    .setMessage("Your score is " + mScore + "/" + totalNbrOfAnswers)
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
                    .setMessage("Your score is " + mScore + "/" + totalNbrOfAnswers)
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
