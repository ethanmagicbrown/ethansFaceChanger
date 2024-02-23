package com.example.facechanger;
// @author Ethan Brown
import android.view.View;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.graphics.Color;




import java.util.Random;

public class FaceController implements SeekBar.OnSeekBarChangeListener,
        RadioGroup.OnCheckedChangeListener,View.OnClickListener,
        AdapterView .OnItemSelectedListener{
    private FaceView FV;
    private MainActivity Main;
    private Spinner hairStyles;
    private RadioButton facial;
    private int redLevel;
    private int greenLevel;
    private int blueLevel;
    public FaceController(MainActivity m){
        Main = m;
        FV = m.getDefaultFV();
        hairStyles = Main.findViewById(R.id.style);
        if (FV.facial == 0) {
            facial = Main.findViewById(R.id.hairB);
            setSeekerBar(FV.hairColor);
        }
        if (FV.facial == 1) {
            facial = Main.findViewById(R.id.eyesB);
            setSeekerBar(FV.eyeColor);
        }
        if (FV.facial == 2) {
            facial = Main.findViewById(R.id.skinB);
            setSeekerBar(FV.skinColor);
        }
        facial.setChecked(true);
        hairStyles.setSelection(FV.hairStyle);
    }
    private void setSeekerBar(int c){
        redLevel = Color.red(c);
        SeekBar rs = Main.findViewById(R.id.Red);
        rs.setProgress(redLevel);
        greenLevel = Color.red(c);
        SeekBar gs = Main.findViewById(R.id.Green);
        gs.setProgress(greenLevel);
        blueLevel = Color.red(c);
        SeekBar bs = Main.findViewById(R.id.Blue);
        bs.setProgress(blueLevel);

    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == Main.findViewById(R.id.Red)){
            redLevel = progress;
        }
        if (seekBar == Main.findViewById(R.id.Green)){
            greenLevel = progress;
        }
        if (seekBar == Main.findViewById(R.id.Blue)){
            blueLevel = progress;
        }
        if (FV.facial == 0){
            FV.hairColor = Color.argb(255,redLevel,greenLevel,blueLevel);
        }
        if (FV.facial == 1){
            FV.eyeColor = Color.argb(255,redLevel,greenLevel,blueLevel);
        }
        if (FV.facial == 2){
            FV.skinColor = Color.argb(255,redLevel,greenLevel,blueLevel);
        }
        FV.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
    if (checkedId == R.id.hairB){
        FV.facial = 0;
        setSeekerBar(FV.hairColor);
    }
    if (checkedId == R.id.eyesB){
        FV.facial = 1;
        setSeekerBar(FV.eyeColor);
    }
    if (checkedId == R.id.skinB){
        FV.facial = 2;
        setSeekerBar(FV.skinColor);
    }
    }

    @Override
    public void onClick(View v) {
    FV.randomize();
        if (FV.facial == 0) {
            facial = Main.findViewById(R.id.hairB);
            setSeekerBar(FV.hairColor);
        }
        if (FV.facial == 1) {
            facial = Main.findViewById(R.id.eyesB);
            setSeekerBar(FV.eyeColor);
        }
        if (FV.facial == 2) {
            facial = Main.findViewById(R.id.skinB);
            setSeekerBar(FV.skinColor);
        }
        facial.setChecked(true);
        hairStyles.setSelection(FV.hairStyle);
        FV.invalidate();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int position, long id) {
            FV.hairStyle = position;
            FV.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
