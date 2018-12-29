package com.forwardmovementtech.gerard.smartcart;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/*
TODO: Create a recyclcerview that will be used to display the items in the user's cart
* */
public class CartListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        FloatingActionButton myButton;

        myButton = findViewById(R.id.scan_barcode);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchBarcodeScanner();
            }
        });
    }


    public void launchBarcodeScanner(){
        Intent barcodeIntent = new Intent(this, BarcodeScannerActivity.class);
        startActivity(barcodeIntent);
    }
}
