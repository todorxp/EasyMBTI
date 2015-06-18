package com.mg.uros.easymbti;


import java.io.Serializable;

public class MBTIQuestion implements Serializable {

    public String questionNumber;
    public String question;
    public int answer1Type;
    public int answer1Color;
    public String answer1;
    public int answer2Type;
    public int answer2Color;
    public String answer2;
    public Boolean isAnswered;
    public Boolean answer1Pressed;
    public Boolean answer2Pressed;

    public MBTIQuestion(String questionNumber,String question,int answer1Type,int answer1Color,Boolean answer1Pressed, String answer1, int answer2Type,int answer2Color,Boolean answer2Pressed, String answer2,Boolean isAnswered){

        this.questionNumber = questionNumber;
        this.question = question;
        this.answer1Type = answer1Type;
        this.answer1Color = answer1Color;
        this.answer1Pressed = answer1Pressed;
        this.answer1 = answer1;
        this.answer2Type = answer2Type;
        this.answer2Color = answer2Color;
        this.answer2Pressed = answer2Pressed;
        this.answer2 = answer2;
        this.isAnswered = isAnswered;


    }
}
