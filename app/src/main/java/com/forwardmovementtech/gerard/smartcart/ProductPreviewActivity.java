package com.forwardmovementtech.gerard.smartcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
    Author: Gerard Rique
    Date: 27/12/2018

    This activity will display a summary of the scanned products data to the user. An image will
    also be included here in the future. A floating action button should also be included which can
    allow the user to add the previewed product to their current cart.

    Consideration: We can potentially add some kind of input field that can allow the user to enter
    how may units of the previewed product they would like to add to their cart. A corresponding price
    can also be displayed.
 */

public class ProductPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_preview);
    }
}
