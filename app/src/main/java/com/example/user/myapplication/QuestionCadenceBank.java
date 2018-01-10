package com.example.user.myapplication;

import android.util.Log;

import java.util.*;

/**
 * Created by user on 1/01/2018.
 */

public class QuestionCadenceBank {


    private List<QuestionCadence> mQuestionCadenceList;
    private int mNextQuestionIndex;


    public QuestionCadenceBank(int whichEx) {
        mQuestionCadenceList = this.generateQuestionCadence(whichEx);
        mNextQuestionIndex = 0;
    }

    public List<QuestionCadence> getQuestionCadenceList() {
        return mQuestionCadenceList;
    }



    public QuestionCadence getQuestionCadence(int i)
    {
        return mQuestionCadenceList.get(i);
    }

    public int getSize()
    {
        return mQuestionCadenceList.size();
    }



    private List<QuestionCadence> generateQuestionCadence(int whichEx)
    {
        int i;
        QuestionCadence questionCadence;
        List<QuestionCadence> questionCadenceList= new ArrayList<QuestionCadence>();


        //Le premier nombre c'est le level, le deuxième nombre c'est le numero de l'exercice dans le level
        switch(whichEx){
            case 22:{
                for(i=1;i<=3; i++) {
                    questionCadence = generateQuestionCadenceEx22();
                    questionCadenceList.add(questionCadence);
                }
                return  questionCadenceList;}

            case 23:{
                for(i=1;i<=3; i++) {
                    questionCadence = generateQuestionCadenceEx23();
                    questionCadenceList.add(questionCadence);
                }
                return  questionCadenceList;}

            case 31:{
                for(i=1;i<=3; i++) {
                    questionCadence = generateQuestionCadenceEx31();
                    questionCadenceList.add(questionCadence);
                }
                return  questionCadenceList;}
            case 32:{
                for(i=1;i<=3; i++) {
                    questionCadence = generateQuestionCadenceEx32();
                    questionCadenceList.add(questionCadence);
                }
                return  questionCadenceList;}

            default:{
                questionCadence=generateQuestionCadenceEx22();
                questionCadenceList.add(questionCadence);
                return  questionCadenceList;}

        }


    }

    public QuestionCadence generateQuestionCadenceEx22()
    {
        String question="Play the fondamental note of each chord";
        List<Integer> answers= Arrays.asList(8,1);
        //L veut dire long
        List<Long> timeAnswers= Arrays.asList(400L, 1400L);
        List<Integer> cadence= Arrays.asList(5,1);

        QuestionCadence questionCadence= new QuestionCadence(question, answers, timeAnswers, cadence);

        return questionCadence;
    }

    public QuestionCadence generateQuestionCadenceEx23()
    {
        String question="Play the third note of each chord (3rd/V and I)";
        List<Integer> answers= Arrays.asList(12,5);
        //L veut dire long
        List<Long> timeAnswers= Arrays.asList(400L, 1400L);
        List<Integer> cadence= Arrays.asList(5,1);

        QuestionCadence questionCadence= new QuestionCadence(question, answers, timeAnswers, cadence);

        return questionCadence;
    }

    public QuestionCadence generateQuestionCadenceEx31()
    {
        String question="Play: 7h/V and the 1st/I ";
        List<Integer> answers= Arrays.asList(6,1);
        //L veut dire long
        List<Long> timeAnswers= Arrays.asList(400L, 1400L);
        List<Integer> cadence= Arrays.asList(5,1);

        QuestionCadence questionCadence= new QuestionCadence(question, answers, timeAnswers, cadence);

        return questionCadence;
    }

    public QuestionCadence generateQuestionCadenceEx32()
    {
        String question="Play: 5th/V and the 7th/I ";
        List<Integer> answers= Arrays.asList(3,12);
        //L veut dire long
        List<Long> timeAnswers= Arrays.asList(400L, 1400L);
        List<Integer> cadence= Arrays.asList(5,1);

        QuestionCadence questionCadence= new QuestionCadence(question, answers, timeAnswers, cadence);

        return questionCadence;
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




}

