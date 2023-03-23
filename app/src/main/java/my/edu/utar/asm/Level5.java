package my.edu.utar.asm;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Level5 extends AppCompatActivity {

    private View[] views;
    private int highlightedIndex;
    private int successfulTaps;
    private TextView TapsTextView;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level5);

        // Initialize variables
        views = new View[] {
                findViewById(R.id.view1),
                findViewById(R.id.view2),
                findViewById(R.id.view3),
                findViewById(R.id.view4),
                findViewById(R.id.view5),
                findViewById(R.id.view6),
                findViewById(R.id.view7),
                findViewById(R.id.view8),
                findViewById(R.id.view9),
                findViewById(R.id.view10),
                findViewById(R.id.view11),
                findViewById(R.id.view12),
                findViewById(R.id.view13),
                findViewById(R.id.view14),
                findViewById(R.id.view15),
                findViewById(R.id.view16),
                findViewById(R.id.view17),
                findViewById(R.id.view18),
                findViewById(R.id.view19),
                findViewById(R.id.view20),
                findViewById(R.id.view21),
                findViewById(R.id.view22),
                findViewById(R.id.view23),
                findViewById(R.id.view24),
                findViewById(R.id.view25),
                findViewById(R.id.view26),
                findViewById(R.id.view27),
                findViewById(R.id.view28),
                findViewById(R.id.view29),
                findViewById(R.id.view30),
                findViewById(R.id.view31),
                findViewById(R.id.view32),
                findViewById(R.id.view33),
                findViewById(R.id.view34),
                findViewById(R.id.view35),
                findViewById(R.id.view36)

        };
        highlightedIndex = -1;

        TapsTextView = findViewById(R.id.TapsTextView);
        successfulTaps = getIntent().getIntExtra("score_level4",1);

        // Randomly highlight a view
        highlightRandomView();

        // Set up touch listeners for views
        for (View view : views) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (v == views[highlightedIndex]) {
                        // Player touched the highlighted view
                        successfulTaps++;
                        TapsTextView.setText("Successful touches: " + successfulTaps);
                        highlightRandomView();
                    }
                    return true;
                }
            });
        }

        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cancel the countdown timer to prevent the game from proceeding to the next level
                countDownTimer.cancel();
                Intent intent = new Intent(Level5.this, HomePage.class);
                // Set the FLAG_ACTIVITY_CLEAR_TOP flag to clear all activities on top of the home page activity
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });



        // Set up countdown timer
        countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish() {
                // Proceed to Level 2
                Intent intent = new Intent(Level5.this, EnterName.class);
                intent.putExtra("Level", 2);
                intent.putExtra("score_level5", successfulTaps);
                startActivity(intent);
                finish();
            }
        };
        countDownTimer.start();
    }

    private void highlightRandomView() {
        // Remove highlighting from previous view
        if (highlightedIndex != -1) {
            views[highlightedIndex].setBackgroundColor(Color.parseColor("#B8E2F2"));
        }
        // Randomly highlight a new view that is different from the previous view
        int randomIndex = highlightedIndex;
        while (randomIndex == highlightedIndex) {
            randomIndex = (int) (Math.random() * views.length);
        }
        highlightedIndex = randomIndex;
        views[highlightedIndex].setBackgroundColor(Color.parseColor("#1E3F66"));
    }
}