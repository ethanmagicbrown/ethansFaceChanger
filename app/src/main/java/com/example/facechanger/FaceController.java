package com.example.facechanger;
// @author Ethan Brown
import android.view.View;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import java.util.Random;

public class FaceController {
    private FaceView FV;
    private FaceModel FM;
    public FaceController(FaceView faceView){
        FV =faceView;
        FM = FV.getFM();


    }
}
