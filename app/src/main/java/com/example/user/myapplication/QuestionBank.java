package com.example.user.myapplication;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by user on 1/01/2018.
 */

public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(int whichEx) {
        mQuestionList = this.generateQuestions(whichEx);
        mNextQuestionIndex = 0;
    }

    public Question getQuestion() {
        // Ensure we loop over the questions
        if (mNextQuestionIndex == mQuestionList.size()) {
            mNextQuestionIndex = 0;
        }

        // Please note the post-incrementation
        return mQuestionList.get(mNextQuestionIndex++);
    }

    public int getSize()
    {
        return mQuestionList.size();
    }



    private List<Question> generateQuestions(int whichEx)
    {
        int i;
        Question question;
        List<Question> questionList= new ArrayList<Question>();
        //Log.i("OC_RSS", "On commence un nouvelle banque de questions");
        //Le premier nombre c'est le level, le deuxième nombre c'est le numero de l'exercice dans le level
        switch(whichEx){
            case 11:{
                for(i=1;i<=5; i++) {
                    question = generateQuestionEx11();
                    questionList.add(question);
                }
                return  questionList;}

            case 12:{
                for(i=1;i<=5; i++) {
                    question = generateQuestionEx12();
                    questionList.add(question);
                }
                return  questionList;}

            case 13:{
                for(i=1;i<=10; i++) {
                    question = generateQuestionEx13();
                    questionList.add(question);
                }
                return  questionList;

            }

            case 21:
            {
                for(i=1;i<=5; i++) {
                    question = generateQuestionEx21();
                    questionList.add(question);
                }
                return  questionList;
            }

            default:{
                question=new Question("ERROR Le nombre correspondant à l'ex ne mène à rien", 1);
                questionList.add(question);
                return  questionList;}

        }


    }

    public Question generateQuestionEx11()
    {
        Random rand = new Random();
        //Random note, elles vont de 1 à 12
        //rand.next int crée de [0 11]
        int  randNote = rand.nextInt(12) + 1;
        int  randNbrSemitone= rand.nextInt(5)+1;
        //%12 car il y a 12 notes en tout
        int answer= (randNote+randNbrSemitone)%12;
        //Pour éviter la reponse 0 qui est fausse
        if(answer==0)
            answer=12;
        Question question=new Question("What is the note which is " + Integer.toString(randNbrSemitone)+ " semitone(s) after " + nameOfTheNote(randNote)+ "?", answer);
        return question;
    }


    public String nameOfTheNote(int note)
    {
        switch (note)
        {
            case 1: return "Do";
            case 2:return "Do#";
            case 3: return "Re";
            case 4:return "Re#";
            case 5: return "Mi";
            case 6:return "Fa";
            case 7: return "Fa#";
            case 8:return "Sol";
            case 9: return "Sol#";
            case 10:return "La";
            case 11: return "La#";
            case 12:return "Si";
            default: return "ERROR NUMBER";
        }
    }

    //Jouer la tierce majeure de Do, quinte de do
    public Question generateQuestionEx12()
    {
            Random rand=new Random();
            Question question;
            int i=rand.nextInt(3);
            switch(i)
            {
                case 0:
                    question= new Question("Play the minor third of Do", 4);
                    break;
                case 1:
                    question= new Question("Play the major third of Do", 5);
                    break;
                case 2:
                    question= new Question("Play the fifth of Do", 8);
                    break;
                default:
                    question= new Question("ERROR PLAY DO", 1);
                    break;
            }
            return question;
    }

    //Meme que Ex12 mais avec n importe quelle note
    public Question generateQuestionEx13()
    {
        Random rand=new Random();
        Question question;
        int i=rand.nextInt(3);
        int randNote=1+rand.nextInt(12);
        int answer;
        switch(i)
        {
            case 0:
                answer= (randNote+3)%12;
                //Pour éviter la reponse 0 qui est fausse
                if(answer==0)
                    answer=12;
                question= new Question("Play the minor third of " + nameOfTheNote(randNote), answer);
                break;
            case 1:
                answer= (randNote+3)%12;
                //Pour éviter la reponse 0 qui est fausse
                if(answer==0)
                    answer=12;
                question= new Question("Play the major third of " + nameOfTheNote(randNote), answer);
                break;
            case 2:
                answer= (randNote+3)%12;
                //Pour éviter la reponse 0 qui est fausse
                if(answer==0)
                    answer=12;
                question= new Question("Play the fifth of " + nameOfTheNote(randNote), answer);
                break;
            default:
                question= new Question("ERROR PLAY DO", 1);
                break;
        }
        return question;
    }

    public Question generateQuestionEx21() {
        Random rand = new Random();
        Question question;
        int i = 1 + rand.nextInt(6);
        switch (i) {
            case 1:
                question = new Question("Play the major third of Do", 5);
                break;
            case 2:
                question = new Question("Play the minor third of Re", 6);
                break;
            case 3:
                question = new Question("Play the minor third of Mi", 8);
                break;
            case 4:
                question = new Question("Play the major third of Fa", 10);
                break;
            case 5:
                question = new Question("Play the major third of Sol", 12);
                break;
            case 6:
                question = new Question("Play the minor third of La", 1);
                break;

            default:
                question = new Question("Play the major third of Do", 5);
                break;

        }
        return question;
    }
}

