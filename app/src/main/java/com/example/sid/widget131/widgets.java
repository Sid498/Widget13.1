package com.example.sid.widget131;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Created by SID on 8/11/2017.
 */

public class widgets extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //if the user creates more than 1 widget, the code mentioned here will be applied to all of them and not just one
        for(int i = 0; i<appWidgetIds.length;i++){
            //creating remoteview
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.widget);

            //creating intent for opening the app
            Intent openapp = new Intent(context,MainActivity.class);
            //pending intent for the same
            PendingIntent pendingIntent = PendingIntent.getActivity(context,1,openapp,0);
            //on click event for the button
            remoteViews.setOnClickPendingIntent(R.id.btnOpen,pendingIntent);

            //creating itent for opening web
            Intent openweb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://acadgild.com/"));
            //pending intent for the same
            PendingIntent pendingIntent1 = PendingIntent.getActivity(context,2,openweb,0);
            //on click listener for the button
            remoteViews.setOnClickPendingIntent(R.id.btnAcadgild,pendingIntent1);
            //updating app widget
            appWidgetManager.updateAppWidget(appWidgetIds[i],remoteViews);
        }
    }
}
