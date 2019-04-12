package com.example.t30_rating_stars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RatingBar mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        final TextView mRatingScale = (TextView) findViewById(R.id.tvRatingScale);
        final EditText mFeedback = (EditText) findViewById(R.id.etFeedback);
        Button mSendFeedback = (Button) findViewById(R.id.btnSubmit);

        // To be able to interact and give rating with Android RatingBar,
        // we need to use mRatingBar.setOnRatingBarChangeListener

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                // Next we need to show rating scale whenever the user gives a rating
                mRatingScale.setText(String.valueOf(rating));
                switch((int)ratingBar.getRating()){
                    case 1:
                        mRatingScale.setText("Very bad");
                        break;
                    case 2:
                        mRatingScale.setText("Need some improvement");
                        break;
                    case 3:
                        mRatingScale.setText("Good");
                        break;
                    case 4:
                        mRatingScale.setText("Great");
                        break;
                    case 5:
                        mRatingScale.setText("Awesome. I love it");
                        break;
                    default:
                        mRatingScale.setText("");
                }

            }
        });
        
        //last thing we need to do is make Android Button clickable. if the user didn’t 
        // fill-in the feedback form, a warning Android Toast message will appear on the screen, 
        // otherwise show a success Toast message and reset all views to an empty state.
        mSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFeedback.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill in feedback text box", Toast.LENGTH_SHORT).show();
                }else{
                    mFeedback.setText("");
                    mRatingBar.setRating(0);
                    Toast.makeText(MainActivity.this, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
    }
}
