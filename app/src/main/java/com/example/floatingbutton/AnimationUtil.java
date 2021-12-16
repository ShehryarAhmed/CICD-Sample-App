package com.example.floatingbutton;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

public class AnimationUtil {

    public static void loadFadeInAnimation(View view,Animation.AnimationListener listener) {
        view.setVisibility(View.VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.scale_up);
        animation.setAnimationListener(listener);
        view.startAnimation(animation);
    }

    public static void loadScaleDownAnimation(View view,Animation.AnimationListener listener) {
        view.setVisibility(View.VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.scale_down);
        animation.setAnimationListener(listener);
        view.startAnimation(animation);
    }


    public static void loadFadeOutAnimation(View view) {
        view.setVisibility(View.VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.fade_out);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }

//    public static void setSlideUpAnimation(View view) {
//        Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_in_up);
//        view.setVisibility(View.VISIBLE);
//        view.startAnimation(animation);
//    }

    /*
     * REFERENCE URL https://stackoverflow.com/questions/14141039/view-animation-right-to-left-android
     * */
    //inFromRightAnimation
    public static Animation inFromRightAnimation() {

        Animation inFromRight = new TranslateAnimation(
//                Animation.RELATIVE_TO_SELF, +1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        inFromRight.setDuration(250);
        inFromRight.setInterpolator(new FastOutSlowInInterpolator());
        return inFromRight;

    }

    //inFromLeftAnimation
    public static Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
//                Animation.RELATIVE_TO_SELF, -1.0f,
                Animation.RELATIVE_TO_SELF, -0.5f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        inFromLeft.setDuration(250);
        inFromLeft.setInterpolator(new FastOutSlowInInterpolator());
        return inFromLeft;
    }

    //outToLeftAnimation
    public static Animation outToLeftAnimation() {
        Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f,
//                Animation.RELATIVE_TO_SELF, -1.0f,
                Animation.RELATIVE_TO_SELF, -0.5f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        outtoLeft.setDuration(250);
        outtoLeft.setInterpolator(new FastOutSlowInInterpolator());
        return outtoLeft;
    }

    //outToRightAnimation
    public static Animation outToRightAnimation() {
        Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f,
//                Animation.RELATIVE_TO_SELF, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        outtoRight.setDuration(250);
        outtoRight.setInterpolator(new FastOutSlowInInterpolator());
        return outtoRight;
    }

}
