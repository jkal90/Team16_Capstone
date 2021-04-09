package edu.msu.huangmax.ece480_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StartTimerActivity extends AppCompatActivity {

    private TextView countdownText;
    private Button stopButton;
    private Button endButton;
    private CountDownTimer timer;
    private long timeLeftInMilliseconds = 1800000; //30 minutes
     // 5000 for demo
    private boolean running = false;
    private final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    private String startTime;
    private String endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        countdownText = findViewById(R.id.timer);
        stopButton = findViewById(R.id.startStop);
        endButton = findViewById(R.id.endButton);
        startTime = formatter.format(new Date());
        startTimer();

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end(v);
            }
        });

    }
    public void startStop() {
        if (running) {
            stopTimer();
        } else {
            startTimer();
        }
    }
    public void startTimer() {
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                thankYou();
            }
        }.start();
        running = true;

    }
    public void stopTimer() {
        timer.cancel();
        running = false;
    }
    public void updateTimerText() {
        int secondsLeft = (int) timeLeftInMilliseconds / 1000;
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;

        String timeLeft = "" + minutes + ':';
        if (seconds < 10) {
            timeLeft += '0';
        }
        timeLeft += seconds;
        countdownText.setText(timeLeft);
    }
    public void end(View view) {
        if (timeLeftInMilliseconds > 0) {
            // The puzzle is done
            // Instantiate a dialog box builder
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(view.getContext());

            // Parameterize the builder
            builder.setTitle(R.string.warning);
            builder.setMessage(R.string.incomplete);
            builder.setPositiveButton(R.string.cont, null);
            builder.setNegativeButton(R.string.endTherapy, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    thankYou();
                }
            });

            // Create the dialog box and show it
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
    public void thankYou() {
        endTime = formatter.format(new Date());
        DatabaseTool databaseTool = new DatabaseTool();
        String[] responses = new String[2];
        responses[0] = startTime;
        responses[1] = endTime;
        databaseTool.writeTimerUse(responses);

        Intent intent = new Intent(this, ThankYouActivity.class);
        startActivity(intent);
    }
}
