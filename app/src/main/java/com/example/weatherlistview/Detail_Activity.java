package com.example.weatherlistview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Detail_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        TextView detailCity = findViewById(R.id.detailCity);
        TextView detailStatus = findViewById(R.id.detailStatus);
        TextView detailTemperature = findViewById(R.id.detailTemperature);
        ImageView detailImage = findViewById(R.id.detailImage);

        Intent intent = getIntent();
        if (intent != null) {
            String city = intent.getStringExtra("city");
            String status = intent.getStringExtra("status");
            int temperature = intent.getIntExtra("degree", 0);
            int image = intent.getIntExtra("image", 0);

            detailCity.setText(city);
            detailImage.setImageResource(image);
            detailTemperature.setText(temperature + "°C");
            detailStatus.setText(status);

        }
    }
}