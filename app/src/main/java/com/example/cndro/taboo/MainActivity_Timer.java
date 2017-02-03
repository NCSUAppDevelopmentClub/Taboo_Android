package com.example.theodotious.taboolayout;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView countdown;

    // Declares a countdown of 60 seconds, with one second intervals
    CountDownTimerPausable CDT = new CountDownTimerPausable(60000, 1000) {

        public void onTick(long milliSLeft) {
            String SLeftString = String.valueOf(milliSLeft/1000);
            countdown.setText(SLeftString);
        }

        public void onFinish() {
            countdown.setText("Done!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdown = (TextView) findViewById(R.id.CountDown);

        CDT.start();

        // Listens for a button click on a button called PauseButton and calls
        // pause functions
        Button pauseButton = (Button) findViewById(R.id.PauseButton);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pauseTimer(view);
            }
        });

    }

    // Pauses the timer if it is not paused paused; starts the timer if is is paused.
    public void pauseTimer(View view) {
        long timeLeft = Long.parseLong(String.valueOf(countdown.getText()));

        if(!CDT.isPaused()) {
            CDT.pause();
        } else {
            CDT.start();
        }
    }
}
