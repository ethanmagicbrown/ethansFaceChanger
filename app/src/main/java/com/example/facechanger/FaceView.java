package com.example.facechanger;
//@author Ethan brown
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class FaceView extends SurfaceView {
    Paint skinPaint = new Paint();
    Paint eyesPaint = new Paint();
    Paint hairPaint = new Paint();
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    public int facial;
    private Random rand;
    public final float Left = 800;
    public final float Top = 100f;
    public final float Width = 600f;
    public final float Height = 600f;


    public FaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        rand = new Random() ;
        randomize();


    }

    public void randomize(){
        skinColor = randomColor();
        eyeColor = randomColor();
        hairColor = randomColor();
        hairStyle = rand.nextInt(3);
        facial = rand.nextInt(3);

    }
    private int randomColor(){
        int c = Color.argb(255,rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        return c;
    }
    // actually draws everything
    public void onDraw(Canvas c){
    hairPaint.setColor(hairColor);
    eyesPaint.setColor(eyeColor);
    skinPaint.setColor(skinColor);
    drawSkin(c);
    drawHair(c);
    drawEyes(c);

    }
    // draws the hair
    public void drawHair(Canvas c){
        // draw bald
    if (hairStyle == 0){
        c.drawRect(Left+20*(Width/50),Top+(Height/20),Left+21*(Width/50),
                Top+4*(Height/20),hairPaint);
        c.drawRect(Left+35*(Width/50),Top+(Height/20),Left+36*(Width/50),
                Top+4*(Height/20),hairPaint);
    }
    if (hairStyle == 1){
        c.drawArc(Left,Top,Left+Width,Top+(Height/2),180,
                180,true,hairPaint);
    }
    if (hairStyle == 2){
        Path mowhawk = new Path();
        mowhawk.moveTo(Left+(Width/2),Top-80f);
        mowhawk.lineTo(Left+2*(Width/7),Top+200f);
        mowhawk.lineTo(Left+5*(Width/7),Top+200f);
        c.drawPath(mowhawk, hairPaint);
    }
    }
    // draws the eyes
    public void drawEyes(Canvas c){
    c.drawOval(Left+Width/4,Top+Height/2,Left+Width/3,Top+(2*Height/3),eyesPaint);
    c.drawOval(Left+(2*Width/3),Top+Height/2,Left+(3*Width/4),Top+(2*Height/3),eyesPaint);

    }
    // draws the head just the skin part
    public void drawSkin(Canvas c){
        c.drawOval(Left,Top,Left+Width,+Top+Height,skinPaint);

    }
}
