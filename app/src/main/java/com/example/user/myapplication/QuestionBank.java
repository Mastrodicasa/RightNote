package com.example.user.myapplication;

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

    public Question generateQuestionsEx11()
    {
        Random rand = new Random();
        //Random note, elles vont de 1 à 12
        //rand.next int crée de [0 11]
        int  randNote = rand.nextInt(12) + 1;
        int  randNbrSemitone= rand.nextInt(5)+1;
        //%12 car il y a 12 notes en tout
        Question question=new Question("What is the note which is " + randNbrSemitone+ " semitone(s) after " + nameOfTheNote(randNote)+ "?", (randNote+randNbrSemitone)%12);
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



    private List<Question> generateQuestions(int whichEx)
    {
        int i;
        //Le premier nombre c'est le level, le deuxième nombre c'est le numero de l'exercice dans le level
        switch(whichEx){
            case 11:
                Question question;
                List<Question> questionList= new ArrayList<Question>();
                for(i=1;i<=5; i++) {
                    question = generateQuestionsEx11();
                    questionList.add(question);
                }
                return  questionList;
            default:
                Question questionnawak;
                List<Question> questionListnawak= new ArrayList<Question>();
                for(i=1;i<=5; i++) {
                    questionnawak = generateQuestionsEx11();
                    questionListnawak.add(questionnawak);
                }
                return  questionListnawak;

        }


    }
}

