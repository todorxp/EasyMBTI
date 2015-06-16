package com.mg.uros.easymbti;

import android.content.res.Resources;
import android.graphics.Color;

public class MBTIQuestionArray {


    private Resources res = EasyMBTI.getContext().getResources();
    public MBTIQuestionArray()
    {

    }

    public MBTIQuestion[] Create(int numberOfQuestions)
    {

        MBTIQuestion[] mbtiQuestionArray = new MBTIQuestion[numberOfQuestions];





        for (int i = 0;i<numberOfQuestions;i++)
        {
            String question = res.getString(R.string.question_text) + "_" + Integer.toString(i);
            int resourceId= res.getIdentifier(question, "array", EasyMBTI.getContext().getPackageName());



            mbtiQuestionArray[i] =  new MBTIQuestion(
                    res.getStringArray(resourceId)[0],
                    res.getStringArray(resourceId)[1],
                    res.getStringArray(resourceId)[2],
                    Color.TRANSPARENT,
                    false,
                    res.getStringArray(resourceId)[3],
                    res.getStringArray(resourceId)[4],
                    Color.TRANSPARENT,
                    false,
                    res.getStringArray(resourceId)[5],
                    false);
        }


        return  mbtiQuestionArray;
    }
}
