package com.example.scheduleeventex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView slot1;
    ImageView slot2;
    ImageView slot3;
    Button button;
   // Button cdButton;
   // Button resetButton;
   // RadioGroup radioGroup;
   // RadioButton slowButton;
   // RadioButton mediumButton;
   // RadioButton fastButton;


    int time;
    int speed1;
    int speed2;
    int speed3;
    Drawable cherry;
    Drawable strawberry;
    Drawable blueberry;
    Drawable pear;
    CountEvent event;
    CountEvent2 event2;
    CountEvent3 event3;
    Handler handler;
  //  CountDown eventDown;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slot1 = findViewById(R.id.slot1);
        slot2 = findViewById(R.id.slot2);
        slot3 = findViewById(R.id.slot3);
        button = findViewById(R.id.button);
        //  resetButton = findViewById(R.id.resetButton);
        //  cdButton = findViewById(R.id.cdButton);
        //  radioGroup = findViewById(R.id.radioGroup);
        //  slowButton = findViewById(R.id.slowButton);
        // mediumButton = findViewById(R.id.mediumButton);
        //  fastButton = findViewById(R.id.fastButton);


        //Speed is the time it takes the clock to count in milliseconds (1000 milliseconds = 1 sec)
        speed1 = 250;
        speed2 = 500;
        speed3 = 1000;
        time = 0;
        cherry = getDrawable(R.drawable.cherry);
        strawberry = getDrawable(R.drawable.strawberry);
        blueberry = getDrawable(R.drawable.blueberry);
        pear = getDrawable(R.drawable.pear);
        //The if statement below will save the time on the clock when the landscape is changed.
        //Is able to by using method below called: "onSaveInstanceState"
        if (savedInstanceState != null) {
            time = savedInstanceState.getInt("time");
            slot1.setImageDrawable(cherry);
            slot2.setImageDrawable(pear);
            slot3.setImageDrawable(strawberry);
        }

        event = new CountEvent();
        event2 = new CountEvent2();
        event3 = new CountEvent3();
        handler = new Handler();
        // eventDown = new CountDown();

        // resetButton.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //   public void onClick(View view) {
        //   handler.removeCallbacks(event);
        //       time = 0;
        //       slot1.setText(""+time);
        //      slot2.setText(""+time);
        //      slot3.setText(""+time);
        //   }
        // });

        //   cdButton.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //   public void onClick(View view) {
        //      if(cdButton.getText().equals("Count Down")) {
        //         handler.postDelayed(eventDown, speed1);
        //         cdButton.setText("Stop");
        //    }else{
        //        handler.removeCallbacks(eventDown);
        //       cdButton.setText("Count Down");
        //  }
        //  handler.removeCallbacks(event);
        // handler.postDelayed(eventDown, 1000);

        //   }
        //  });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button.getText().equals("Start")) {
                    handler.postDelayed(event, speed1);
                    handler.postDelayed(event2, speed2);
                    handler.postDelayed(event3, speed3);
                    button.setText("Stop");
                } else {
                    handler.removeCallbacks(event);
                    handler.removeCallbacks(event2);
                    handler.removeCallbacks(event3);
                    button.setText("Start");
                   // if(slot1.getText().equals(slot2.getText()) && slot1.getText().equals(slot3.getText())) {
                      if(slot1.getDrawable().equals(slot2.getDrawable()) && slot1.getDrawable().equals(slot3.getDrawable()))
                    {
                        Toast t = Toast.makeText(getApplicationContext(), "You Won!!!", Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        t.show();
                    }
                }
            }
        });

        //  radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        //    @Override
        //   public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //      if(i == R.id.slowButton){
        //        speed1 = 2000;

        //   }else if(i == R.id.mediumButton){
        //   speed1 = 1000;

        //  }else if (i == R.id.fastButton){
        //      speed1 = 100;

        //   }
        // }
        // });

        }






        private class CountEvent implements Runnable {
            @Override
            public void run() {
                time++;
               // slot1.setText(time + "");
                slot1.setImageDrawable(cherry);
                handler.postDelayed(event, speed1);
                if (time == 3) {
                    time = -1;
                }if(time == -1){
                    slot1.setImageDrawable(cherry);
                }else if(time == 0){
                    slot1.setImageDrawable(pear);
                }else if(time == 1){
                    slot1.setImageDrawable(strawberry);
                }else if(time == 2){
                    slot1.setImageDrawable(blueberry);
                }
            }
        }

        private class CountEvent2 implements Runnable {
            @Override
            public void run() {
                time++;
               // slot2.setText(time + "");
                slot2.setImageDrawable(pear);
                handler.postDelayed(event2, speed2);
                if (time == 3) {
                    time = -1;
                }if(time == -1){
                    slot2.setImageDrawable(pear);
                }else if(time == 0){
                    slot2.setImageDrawable(strawberry);
                }else if(time == 1){
                    slot2.setImageDrawable(blueberry);
                }else if(time == 2){
                    slot2.setImageDrawable(cherry);
                }
            }
        }

        private class CountEvent3 implements Runnable {
            @Override
            public void run() {
                time++;
                //slot3.setText(time + "");
                slot3.setImageDrawable(strawberry);
                handler.postDelayed(event3, speed3);
                if (time == 3) {
                    time = -1;
                }if(time == -1){
                    slot3.setImageDrawable(strawberry);
                }else if(time == 0){
                    slot3.setImageDrawable(blueberry);
                }else if(time == 1){
                    slot3.setImageDrawable(cherry);
                }else if(time == 2){
                    slot3.setImageDrawable(pear);
                }
            }
        }

        // private class CountDown implements Runnable{
        //      @Override
        //     public void run(){
        //        time--;
        //       slot2.setText(time+"");
        //       handler.postDelayed(eventDown, speed1);
        //    }
        //  }

        @Override
        public void onSaveInstanceState (Bundle savedInstanceState){
            savedInstanceState.putInt("time", time);
            super.onSaveInstanceState(savedInstanceState);
        }

}
