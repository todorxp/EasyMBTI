package com.mg.uros.easymbti;


// 1 is I
// 2 is E
// 3 is N
// 4 is S
// 5 is T
// 6 is F
// 7 is P
// 8 is J



import android.util.Log;

public class Score {

    static int I, E, S, N, T, F, P, J;
    static boolean mainPressed;
    static boolean otherPressed;
    static int mainType;



    static void Add(MBTIQuestion question, int answer) {

        // If we press left answer - we passed 1 as answer
        if (answer == 1) {

            mainPressed = question.answer1Pressed;
            otherPressed = question.answer2Pressed;
            mainType = question.answer1Type;

        } else if (answer == 2) {
            mainPressed = question.answer2Pressed;
            otherPressed = question.answer1Pressed;
            mainType = question.answer2Type;

        }



        // Clicked answer was not pressed before
        if (!mainPressed) {


            if (mainType == 1) {
                I++;
                // Other answer was clicked before so we must remove points from it
                if (otherPressed) {
                    E--;
                }
            }
            if (mainType == 2) {
                E++;
                if (otherPressed) {
                    I--;
                }
            }
            if (mainType == 3) {
                N++;
                if (otherPressed) {
                    S--;
                }
            }
            if (mainType == 4) {
                S++;
                if (otherPressed) {
                    N--;
                }
            }
            if (mainType == 5) {
                T++;
                if (otherPressed) {
                    F--;
                }
            }
            if (mainType == 6) {
                F++;
                if (otherPressed) {
                    T--;
                }
            }
            if (mainType == 7) {
                P++;
                if (otherPressed) {
                    J--;
                    }
                }
            if (mainType == 8) {
                J++;
                if (otherPressed) {
                    P--;
                    }
                }

            }


            Log.v("Score", "I is " + Integer.toString(I));
            Log.v("Score", "E is " + Integer.toString(E));
            Log.v("Score", "S is " + Integer.toString(S));
            Log.v("Score", "N is " + Integer.toString(N));
            Log.v("Score", "T is " + Integer.toString(T));
            Log.v("Score", "F is " + Integer.toString(F));
            Log.v("Score", "P is " + Integer.toString(P));
            Log.v("Score", "J is " + Integer.toString(J));


        }


    static String CalculateType ()
    {
        char first;
        char second;
        char third;
        char fourth;
        String MBTIType;

        if (E >= I)
        {
            first = 'E';
        }
        else
        {
            first = 'I';
        }

        if (S >= N)
        {
            second = 'S';
        }
        else
        {
            second = 'N';
        }
        if (T >= F)
        {
            third = 'T';
        }
        else
        {
            third = 'F';
        }

        if (J >= P)
        {
            fourth = 'J';
        }
        else
        {
            fourth = 'P';
        }
        MBTIType = String.valueOf(first) +  String.valueOf(second) +  String.valueOf(third) +  String.valueOf(fourth);
       // Log.v("Result", "MBTIType  is " + MBTIType);
        return  MBTIType;


    }
    static int FindPersonalityCode(String MBTI)
    {
        int code = 0;
        if (MBTI.equals("ESFJ"))
        {
            code = 0;
        }
        else if (MBTI.equals("ESFP"))
        {
            code = 1;
        }
        else if (MBTI.equals("ESTJ"))
        {
            code = 2;
        }
        else if (MBTI.equals("ESTP"))
        {
            code = 3;
        }
        else if (MBTI.equals("ENFJ"))
        {
            code = 4;
        }
        else if (MBTI.equals("ENFP"))
        {
            code = 5;
        }
        else if (MBTI.equals("ENTJ"))
        {
            code = 6;
        }
        else if (MBTI.equals("ENTP"))
        {
            code = 7;
        }
        else if (MBTI.equals("ISFJ"))
        {
            code = 8;
        }
        else if (MBTI.equals("ISFP"))
        {
            code = 9;
        }
        else if (MBTI.equals("ISTJ"))
        {
            code = 10;
        }
        else if (MBTI.equals("ISTP"))
        {
            code = 11;
        }
        else if (MBTI.equals("INFJ"))
        {
            code = 12;
        }
        else if (MBTI.equals("INFP"))
        {
            code = 13;
        }
        else if (MBTI.equals("INTJ"))
        {
            code = 14;
        }
        else if (MBTI.equals("INTP"))
        {
            code = 15;
        }

        return  code;
    }

}




