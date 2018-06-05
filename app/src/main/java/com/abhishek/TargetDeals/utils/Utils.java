package com.abhishek.TargetDeals.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by akarmakar.
 */

public class Utils {

    /**
     * Checks Internet is connected or not.
     *
     * @param mContext
     * @return
     */
    public static boolean isInternetConnected(Context mContext) {
        ConnectivityManager connectivity = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            final NetworkInfo activeNetwork = connectivity
                    .getActiveNetworkInfo();
            if (activeNetwork != null && activeNetwork.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public static void openDailogWithSingleButton(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void openDailogWithSingleButtonWithOnClickListener(Context context, String message, DialogInterface.OnClickListener posClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", posClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void openDailogWithTwoButton(Context context, String message, String positiveClickButtionName, DialogInterface.OnClickListener posClickListener, DialogInterface.OnClickListener negClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(positiveClickButtionName, posClickListener).setNegativeButton("Cancel", negClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    /*
           Method to check device support camera or not
    */
    public static boolean isDeviceSupportCamera(Context context) {
        if (context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

    public static Uri getOutputMediaFileUri() {
        return Uri.fromFile(getOutputMediaFile());
    }

    private static File getOutputMediaFile() {
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HHmmss", Locale.getDefault()).format(new Date());
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath(), "IMG_" + timeStamp + ".jpg");
        return mediaStorageDir;
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static ProgressDialog getProgressbar(Context context, String message, boolean cancelable) {
        ProgressDialog progressDoalog = new ProgressDialog(context);
        progressDoalog.setMax(100);
        progressDoalog.setCancelable(cancelable);
        progressDoalog.setMessage(message);
//        progressDoalog.setTitle(title);
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return progressDoalog;
    }

    /**
     * Email Checker.
     *
     * @param target
     * @return boolean Value
     * @author Alok Giri
     */
    public static boolean isValidEmail(String target) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
