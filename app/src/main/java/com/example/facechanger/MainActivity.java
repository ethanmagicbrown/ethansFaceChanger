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
        setContentView(R.layout.activity_main);
        defaultFV = findViewById(R.id.faceview);
        FaceController Controler = new FaceController(this);
        SeekBar Red = findViewById(R.id.Red);
        SeekBar Green = findViewById(R.id.Green);
        SeekBar Blue = findViewById(R.id.Blue);

        Spinner styles = findViewById(R.id.style);
        RadioGroup facial = findViewById(R.id.radio);
        facial.setOnCheckedChangeListener(Controler);
        Button random = findViewById(R.id.button);
        random.setOnClickListener(Controler);
        Red.setOnSeekBarChangeListener(Controler);
        Green.setOnSeekBarChangeListener(Controler);
        Blue.setOnSeekBarChangeListener(Controler);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
          this, R.array.styles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        styles.setAdapter(adapter);
        styles.setOnItemSelectedListener(Controler);

    }
}
