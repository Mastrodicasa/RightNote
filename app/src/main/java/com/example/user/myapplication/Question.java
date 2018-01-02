package com.example.user.myapplication;

import java.util.List;

/**
 * Created by user on 1/01/2018.
 */

public class Question {

    private String mQuestion;
    private int mAnswerIndex;

    public Question(String question, int answerIndex) {
        this.setQuestion(question);
        this.setAnswerIndex(answerIndex);
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }


    public int getAnswerIndex() {
        return mAnswerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        if (answerIndex < 1 || answerIndex > 12) {
            throw new IllegalArgumentException("Answer index is out of bound");
        }
        mAnswerIndex = answerIndex;
    }
}