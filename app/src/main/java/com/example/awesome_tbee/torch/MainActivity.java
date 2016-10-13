package com.example.awesome_tbee.torch;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Camera cam = null;
    ImageButton changer;
    Camera.Parameters p;
    int state = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changer = (ImageButton)findViewById(R.id.changer);

        getCam();

        changer.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {


                if(state == 0) {

                    p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    cam.setParameters(p);
                    cam.startPreview();
                    changer.setImageResource(R.drawable.moon);
                    state = 1;

                }

                else
                {

                    p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    cam.setParameters(p);
                    cam.stopPreview();
                    changer.setImageResource(R.drawable.torch);
                    state = 0;
                }
            }
        });
    }

    public void getCam()
    {
        cam = Camera.open();

        p = cam.getParameters();
    }
}
