package com.example.user.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

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




    private MediaPlayer mp;
    private boolean AlreadyLaunched;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_record);

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

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(audioFilePath);
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("audio/*");
                share.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(Intent.createChooser(share, "Share Sound File"));
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


    @Override
    public void onClick(View v) {


        int responseIndex = (int) v.getTag();

        //Ma partie
        //mp.start();


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
