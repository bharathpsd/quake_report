package com.example.android.quakereport;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.DecimalFormat;
import android.graphics.drawable.GradientDrawable;


/**
 * Created by Satya on 1/30/2018.
 */

public class EarthAdapter extends ArrayAdapter {
    private String primary,other;
    private String LOCATION_SEPARATOR = "of";

    /*Constructor created for the class passing the context activity and list of objects*/
    public EarthAdapter(@NonNull Context context, @NonNull List earthquakes) {
        super(context,0,earthquakes);
    }


    /*This override method must display the data that is being stored in earthquake class*/
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item,parent,false);
        }

        Earthquake currentEarthquake  = (Earthquake) getItem(position);

        /*changing the magnitude from string to decimal*/
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentEarthquake.getMagnitude());


        /*displaying the magnitude in one of the textview*/
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.mag);
        magnitudeView.setText(output);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        /*splitting the location into two strings*/
        String location = currentEarthquake.getPlace();

        if (location.contains(LOCATION_SEPARATOR)) {
            String[] parts = location.split(LOCATION_SEPARATOR);
            other = parts[0] + LOCATION_SEPARATOR;
            primary = parts[1];
        } else {
            other = "Near the";
            primary = location;
        }

        /*displaying the place in two textViews of the textview*/
        TextView otherView = (TextView) listItemView.findViewById(R.id.other_details);
        otherView.setText(other);

        TextView primaryView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryView.setText(primary);



        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        return listItemView;

    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(double mag){
        int color;
        int magnitude = (int) Math.floor(mag);
        switch(magnitude){
            case 1 : color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                        break;
            case 2 : color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3 : color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4 : color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5 : color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6 : color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7 : color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8 : color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9 : color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            case 10 : color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
            default: color = ContextCompat.getColor(getContext(), R.color.colorAccent);
                break;
        }

        return color;
    }

}
