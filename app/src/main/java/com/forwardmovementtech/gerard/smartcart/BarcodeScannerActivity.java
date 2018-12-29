package com.forwardmovementtech.gerard.smartcart;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import java.util.Scanner;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission_group.CAMERA;

public class BarcodeScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    private static final int REQUEST_CAMERA = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);

        if(!checkCameraPermission()){
            //Permission is not granted by the user. Call method to request camera permission from the user.
            requestCameraPermission();
        }
    }

    //Returns true if the user has allowed the application to access the device camera and returns false otherwise.
    private boolean checkCameraPermission(){
        return (ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    //Provides a popup to the user that allows them to give device camera access to the application.
    private void requestCameraPermission(){
        String[] permissionList = {Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(this, permissionList, REQUEST_CAMERA);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        String scanResult = result.getText();
        Toast.makeText(getApplicationContext(), scanResult, Toast.LENGTH_LONG).show();

        /* TODO: Here we will make a request to the server and get product data using the ID
        received from the barcode and display the data to the user. We can either make the server
        request here and pass product data to the new Activity or just pass the ID to the new
        activity and mae the server request there. */

        Intent intent = new Intent(this, ProductPreviewActivity.class);
        startActivity(intent);
    }
}
