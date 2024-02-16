package com.example.facechanger;
//@author Ethan brown
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class FaceView {
    Paint skinPaint = new Paint();
    Paint eyesPaint = new Paint();
    Paint hairPaint = new Paint();
    private FaceModel FM;

    public FaceModel getFM(){
        return FM;
    }
    public FaceView() {
        FM = new FaceModel();

    }
    public int randomize(){
        int r = new Random().nextInt(256);
        return r;
    }
    // actually draws everything
    public void onDraw(Canvas canvas){

    }
    // draws the hair
    public void drawHair(){

    }
    // draws the eyes
    public void drawEyes(){

    }
    // draws the head just the skin part
    public void drawSkin(){

    }
}
