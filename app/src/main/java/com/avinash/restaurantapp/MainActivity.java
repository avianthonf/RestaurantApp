package com.avinash.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LinearLayout bottomBanner;

    Button confirm;

    CheckBox[] cb = new CheckBox[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Find the checkboxes
        cb[0] = findViewById(R.id.drinks);
        cb[1] = findViewById(R.id.starters);
        cb[2] = findViewById(R.id.maincourse);
        cb[3] = findViewById(R.id.desserts);

        // Display Bottom banner
        bottomBanner = findViewById(R.id.banner);
        int[] list = {R.drawable.banner1, R.drawable.banner2};
        populateLinearLayout(bottomBanner, list);



        // button functionality
        confirm = findViewById(R.id.confirm);

        View.OnClickListener confirmListner;

        confirmListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Manager.class);
                // Data
                Bundle choice = new Bundle();

                //choice.putStr

                i.putExtras(choice);

                startActivity(i);
            }
        };

        confirm.setOnClickListener(confirmListner);







    }


    protected void populateLinearLayout(LinearLayout l, int[] id)
    {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                1500,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        for (int x : id)
        {
            ImageView imv = new ImageView(getApplicationContext());
            imv.setImageResource(x);
            imv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            l.addView(imv, params);
        }

    }
}