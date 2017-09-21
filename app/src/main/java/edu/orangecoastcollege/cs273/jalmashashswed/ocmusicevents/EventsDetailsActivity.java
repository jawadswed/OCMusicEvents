package edu.orangecoastcollege.cs273.jalmashashswed.ocmusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_details);

        //Get the Data out of the Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String detail = intent.getStringExtra("details");

        //Create reference to the textViews

        TextView titleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView detailTextView = (TextView) findViewById(R.id.eventDetailtextView);

        ImageView eventImageView =(ImageView) findViewById(R.id.eventImageView);

        //set the text of the text views
        titleTextView.setText(title);
        detailTextView.setText(detail);


        // Use the Asset manager to retrieve a file (Image)
        AssetManager am =getAssets();
        String imageFileName = title.replace(" ", "") + ".jpeg";

        // Use the assest manager to open a stream to the file name
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream,title);
            eventImageView.setImageDrawable(image);
        } catch (IOException e) {
            Log.e("OC Music Events", "Error loading image: " + imageFileName, e);
        }

    }

    protected void goBackToList(View v)
    {
        //Terminate the current activity (terminate the details activity)
        finish();
    }

}
