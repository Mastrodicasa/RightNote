package com.example.user.myapplication;

import java.util.ArrayList;
import java.util.List;


public class QuestionCadence {

    private String mQuestion;
    private List<Integer> mAnswers;
    private List<Long> mTimeAnswers;
    private List<Integer> mCadence;
    private  List<Boolean> mAlreadyPlayed;



    public QuestionCadence(String question, List<Integer> answers, List<Long> TimeAnswers, List<Integer> Cadence ) {
        this.setQuestion(question);
        this.setAnswers(answers);
        this.setTimeAnswers(TimeAnswers);
        this.setCadence(Cadence);

        mAlreadyPlayed=new ArrayList<>();
        mAlreadyPlayed.add(false);
        mAlreadyPlayed.add(false);

    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }



    public void setAnswers(List<Integer> answers) {
    for(int i=0; i<answers.size(); i++) {
        if (answers.get(i) < 1 || answers.get(i) > 12) {
            throw new IllegalArgumentException("Answer index is out of bound");
        }
    }
        mAnswers = answers;
    }

    public List<Integer> getAnswers() {
        return mAnswers;
    }

    public void setTimeAnswers(List<Long> timeAnswers) {
        mTimeAnswers = timeAnswers;
    }

    public List<Long> getTimeAnswers() {

        return mTimeAnswers;
    }

    public List<Integer> getCadence() {
        return mCadence;
    }

    public void setCadence(List<Integer> cadence) {
        mCadence = cadence;
    }

    public void setAlreadyPlayedTrue(int i) {
        mAlreadyPlayed.set(i, true);
    }

    public void setAlreadyPlayedFalse(int i) {
        mAlreadyPlayed.set(i, false);
    }


    public List<Boolean> getAlreadyPlayed() {
        return mAlreadyPlayed;
    }

}
