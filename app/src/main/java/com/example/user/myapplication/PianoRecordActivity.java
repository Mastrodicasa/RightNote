package com.example.user.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PianoRecordActivity extends AppCompatActivity implements View.OnClickListener {

    private static MediaRecorder mediaRecorder;
    private static MediaPlayer mediaPlayer;
    private static String audioFilePath;
    private static Button stopButton;
    private static Button playButton;
    private static Button recordButton;
    private static Button shareButton;
    private static final int MY_PERMISSIONS_REQUEST_RECORD_AUDIO=45;
    private static final int MY_PERMISSIONS_REQUEST_WRITE=46;

    private boolean isRecording = false;


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




    private MediaPlayer mp;
    private boolean AlreadyLaunched;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_record);

        //DEFINIR TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Recording");
        getSupportActionBar().setIcon(getDrawable(R.drawable.recordingbar));

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


        mp = MediaPlayer.create(this, R.raw.backtrack_3fois);

        recordButton = (Button) findViewById(R.id.recordButton);
        playButton = (Button) findViewById(R.id.playButton);
        stopButton = (Button) findViewById(R.id.stopButton);
        shareButton=(Button) findViewById(R.id.shareButton);

        if (!hasMicrophone())
        {
            stopButton.setEnabled(false);
            playButton.setEnabled(false);
            recordButton.setEnabled(false);
            shareButton.setEnabled(false);
        } else {
            playButton.setEnabled(false);
            stopButton.setEnabled(false);
            shareButton.setEnabled(false);
        }

        audioFilePath =
                Environment.getExternalStorageDirectory().getAbsolutePath()
                        + "/myaudio.3gp";

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio(v);
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    playAudio(v);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    recordAudio(v);
                    mp.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


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
        shareButton.setTag(13);



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
        shareButton.setOnClickListener(this);

        AlreadyLaunched=false;
        mediaRecorder = new MediaRecorder();

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.RECORD_AUDIO},
                    MY_PERMISSIONS_REQUEST_RECORD_AUDIO);
        }

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_WRITE);
        }


        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_2_TS);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        audioFilePath = Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/recording.3gp";
        mediaRecorder.setOutputFile(audioFilePath);
        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    //To avoid sound continuing playing outside the activity
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mp.isPlaying())
            mp.stop();
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
        //Share button
        else if( responseIndex==13){
            InputStream inputStream;
            FileOutputStream fileOutputStream;
            try {
                inputStream = getResources().openRawResource(R.raw.backtrack);
                fileOutputStream = new FileOutputStream(
                        new File(Environment.getExternalStorageDirectory(), "backtrack.mp3"));

                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }

                inputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Send Your Improvisation")
                    .setMessage("Challenge your friend or send the record?")
                    .setNegativeButton("Challenge", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent sendIntent = new Intent();
                            sendIntent.setAction(Intent.ACTION_SEND);
                            sendIntent.putExtra(Intent.EXTRA_TEXT, "Can you improvise as well as me? Let's compare via Right Note! http://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                            sendIntent.setType("text/plain");
                            startActivity(sendIntent);

                        }
                    })
                    .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(Intent.ACTION_SEND);
                            intent.putExtra(Intent.EXTRA_STREAM,
                                    Uri.parse("file://" + Environment.getExternalStorageDirectory() + "/backtrack.mp3" ));
                            intent.setType("audio/mp3");
                            startActivity(Intent.createChooser(intent, "Share improvisation"));

                        }
                    })
                    .setCancelable(true)
                    .create()
                    .show();

        }


    }
    protected boolean hasMicrophone() {
        PackageManager pmanager = this.getPackageManager();
        return pmanager.hasSystemFeature(
                PackageManager.FEATURE_MICROPHONE);
    }

    public void recordAudio (View view) throws IOException
    {




        isRecording = true;
        stopButton.setEnabled(true);
        playButton.setEnabled(false);
        recordButton.setEnabled(false);
        shareButton.setEnabled(false);
//
        try {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(audioFilePath);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.prepare();

        } catch (Exception e) {
            e.printStackTrace();
        }

        mediaRecorder.start();



    }

    public void stopAudio(View view)
    {
        //Ca ne marche pas mais ce serait bien de l'arreter
        if(mp.isPlaying())
            mp.stop();

        stopButton.setEnabled(false);
        playButton.setEnabled(true);
        shareButton.setEnabled(true);

        if (isRecording)
        {
            recordButton.setEnabled(false);
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
            isRecording = false;
        } else {
            mediaPlayer.release();
            mediaPlayer = null;
            recordButton.setEnabled(true);
        }
    }

    public void playAudio (View view) throws IOException
    {
        playButton.setEnabled(false);
        recordButton.setEnabled(false);
        stopButton.setEnabled(true);
        shareButton.setEnabled(false);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(audioFilePath);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }


}
