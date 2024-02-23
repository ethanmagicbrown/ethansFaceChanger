package com.example.facechanger;
// @author Ethan Brown
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.RadioGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    private FaceView defaultFV;
    public FaceView getDefaultFV(){
        return defaultFV;
    }
    @Override
    protected void onCreate(Bundle SIS) {
        super.onCreate(SIS);
        FaceController Controler = new FaceController(this);
        setContentView(R.layout.activity_main);
        defaultFV = findViewById(R.id.faceview);
        Spinner styles = findViewById(R.id.style);
        RadioGroup facial = findViewById(R.id.radio);
        facial.setOnCheckedChangeListener(Controler);
        Button random = findViewById(R.id.button);
        random.setOnClickListener(Controler);
        SeekBar Red = findViewById(R.id.Red);
        Red.setOnSeekBarChangeListener(Controler);
        SeekBar Green = findViewById(R.id.Green);
        Green.setOnSeekBarChangeListener(Controler);
        SeekBar Blue = findViewById(R.id.Blue);
        Blue.setOnSeekBarChangeListener(Controler);

    }
}
