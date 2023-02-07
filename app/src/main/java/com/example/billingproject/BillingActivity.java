package com.example.billingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BillingActivity extends AppCompatActivity {

    private Button billingUpdadteButton;
    private EditText clientIdEditText;
    private EditText clientNameEditText;
    private EditText productNameEditText;
    private EditText productPriceEditText;
    private EditText productQuantityEditText;

    private int clientIdRetrieve;
    private String clientNameRetrieve;
    private String productNameRetrieve;
    private double productPriceRetrieve;
    private int productQuantityRetrieve;


    private static final String EXTRA_CLIENT_ID="com.example.billingproject.client_id";
    private static final String EXTRA_CLIENT_NAME="com.example.billingproject.client_name";
    private static final String EXTRA_PRODUCT_NAME="com.example.billingproject.product_Name";
    private static final String EXTRA_PRODUCT_PRICE="com.example.billingproject.product_Price";
    private static final String EXTRA_PRODUCT_QUANTITY="com.example.billingproject.product_Qty";



    public static Intent newIntent(Context packageContext ,int client_id, String client_name, String product_Name, double prd_Price, int prd_Qty){
          Intent intent=new Intent(packageContext,BillingActivity.class);
          intent.putExtra(EXTRA_CLIENT_ID,client_id);
          intent.putExtra(EXTRA_CLIENT_NAME,client_name);
          intent.putExtra(EXTRA_PRODUCT_NAME,product_Name);
          intent.putExtra(EXTRA_PRODUCT_PRICE,prd_Price);
          intent.putExtra(EXTRA_PRODUCT_QUANTITY,prd_Qty);
          return intent;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);

        clientIdRetrieve=getIntent().getIntExtra(EXTRA_CLIENT_ID,0);
        clientNameRetrieve=getIntent().getStringExtra(EXTRA_CLIENT_NAME);
        productNameRetrieve=getIntent().getStringExtra(EXTRA_PRODUCT_NAME);
        productPriceRetrieve=getIntent().getDoubleExtra(EXTRA_PRODUCT_PRICE,0);
        productQuantityRetrieve=getIntent().getIntExtra(EXTRA_PRODUCT_QUANTITY,0);

     clientIdEditText=(EditText) findViewById(R.id.childclientid_Edit_View);
     clientIdEditText.setText(clientIdRetrieve+"");

      clientNameEditText=(EditText) findViewById(R.id.childclientname_Edit_View);
      clientNameEditText.setText(clientNameRetrieve);

      productNameEditText=(EditText) findViewById(R.id.childproductname_Edit_View);
      productNameEditText.setText(productNameRetrieve);

      productPriceEditText=(EditText) findViewById(R.id.childproductprice_Edit_View);
      productPriceEditText.setText(productPriceRetrieve+"");

        productQuantityEditText=(EditText) findViewById(R.id.childproductquantity_Edit_View);
        productQuantityEditText.setText(productQuantityRetrieve+"");

                   billingUpdadteButton=(Button) findViewById(R.id.billingupdate_Button);
                   billingUpdadteButton.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           setBillingUpdateResult(Integer.parseInt(clientIdEditText.getText().toString()),
                                   clientNameEditText.getText().toString(),
                                   productNameEditText.getText().toString(),
                                 Double.parseDouble(productPriceEditText.getText().toString()),
                                   Integer.parseInt(productQuantityEditText.getText().toString()));


                       }
                   });

    }

    private void  setBillingUpdateResult(int client_id, String client_name, String product_Name, double prd_Price, int prd_Qty){

                 Intent dataIntent=new Intent();
                 dataIntent.putExtra(EXTRA_CLIENT_ID,client_id);
                 dataIntent.putExtra(EXTRA_CLIENT_NAME,client_name);
                 dataIntent.putExtra(EXTRA_PRODUCT_NAME,product_Name);
                 dataIntent.putExtra(EXTRA_PRODUCT_PRICE,prd_Price);
                 dataIntent.putExtra(EXTRA_PRODUCT_QUANTITY,prd_Qty);
                    setResult(RESULT_OK,dataIntent);


    }

  public static Billing sendMessageSetBillingUpdateResult(Intent resultIntent){

        Billing billingUpdateInfo=new Billing();
        billingUpdateInfo.setClient_id(resultIntent.getIntExtra(EXTRA_CLIENT_ID,0));
        billingUpdateInfo.setClient_name(resultIntent.getStringExtra(EXTRA_CLIENT_NAME));
        billingUpdateInfo.setClient_name(resultIntent.getStringExtra(EXTRA_PRODUCT_NAME));
        billingUpdateInfo.setPrd_Price(resultIntent.getDoubleExtra(EXTRA_PRODUCT_PRICE,0));
        billingUpdateInfo.setPrd_Qty(resultIntent.getIntExtra(EXTRA_PRODUCT_QUANTITY,0));

            return billingUpdateInfo;
  }



}