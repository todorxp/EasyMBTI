package com.mg.uros.easymbti;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class MyAdapter extends ArrayAdapter<MBTIQuestion> {

    private int answerPressed = Color.GREEN;
    private int answerUnPressed = Color.TRANSPARENT;

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.row_layout, parent, false);


        final TextView questionTextView = (TextView) theView.findViewById(R.id.question);
        final TextView answer1TextView =  (TextView) theView.findViewById(R.id.answer1);
        final TextView answer2TextView =  (TextView) theView.findViewById(R.id.answer2);

        // Finds MBTIQuestion dataobject at list position
        final MBTIQuestion question = getItem(position);

        questionTextView.setText(question.question);

        answer1TextView.setText(question.answer1);
        answer1TextView.setBackgroundColor(question.answer1Color);

        answer2TextView.setText(question.answer2);
        answer2TextView.setBackgroundColor(question.answer2Color);



        theView.setClickable(true);
        answer1TextView.setClickable(false);


        answer1TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer1TextView.setBackgroundColor(answerPressed);
                answer2TextView.setBackgroundColor(answerUnPressed);
                question.answer1Color = answerPressed;
                question.answer2Color = answerUnPressed;
                question.isAnswered = true;



            }
        });
        answer2TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer1TextView.setBackgroundColor(answerUnPressed);
                answer2TextView.setBackgroundColor(answerPressed);
                question.answer1Color = answerUnPressed;
                question.answer2Color = answerPressed;
                question.isAnswered = true;



            }
        });



        return theView;
    }

    public MyAdapter(Context context, MBTIQuestion[] mbtiQuestionArray) {
        super(context,R.layout.row_layout,mbtiQuestionArray);

    }


}
