package my.edu.utar.asm;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class HomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // Set up Play button
        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                intent.putExtra("Level", 1);
                startActivity(intent);

            }
        });

        // Set up Leaderboard button
        Button leaderboardButton = findViewById(R.id.leaderboardButton);
        leaderboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Leaderboard.class);
                intent.putExtra("Level", 1);
                startActivity(intent);
            }
        });
    }

}