package com.example.billingproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private EditText clientIdEdit_View;
private EditText clientNameEdit_View;
private EditText productNameEdit_View;
private EditText productPriceEdit_View;
private EditText productQuantityEdit_View;
private TextView totalBillingText_View;
private TextView clientInfoText_View;
private Button inputBillingButton;
private Button recordBillingButton;
private Button previousButton;
private Button nextButton;
private Button billingDetails;

private int  currentIndex=0;
public static final String TAG="Billing Project";
public static final String KEY_INDEX="index";
public double  productTotalPrice;


//    Billing billing1=new Billing(105, "Johnston Jane", "Chair", 99.99, 2);
//    Billing billing2=new Billing (108, "Fikhali Samuel", "Table", 139.99, 1);
//    Billing  billing3=new Billing(113, "Samson Amina", "KeyUSB", 14.99, 2);

// Billing [] all_billings={billing1,billing2,billing3};
    ArrayList<Billing> all_billings=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    all_billings.add(new Billing(105, "Johnston Jane", "Chair", 99.99, 2));
    all_billings.add(new Billing (108, "Fikhali Samuel", "Table", 139.99, 1));
    all_billings.add(new Billing(113, "Samson Amina", "KeyUSB", 14.99, 2));


        if (savedInstanceState!=null)
        {
            currentIndex=savedInstanceState.getInt(KEY_INDEX);
        }


totalBillingText_View=(TextView) findViewById(R.id.totalbilling_Text_View);
totalBillingText_View.setText("View Total Billing ");

recordBillingButton=(Button) findViewById(R.id.recordbilling_Button);
recordBillingButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        clientInfoText_View=(TextView) findViewById(R.id.clientinfo_Text_View);
       // productTotalPrice=all_billings[currentIndex].getPrd_Price()*all_billings[currentIndex].getPrd_Qty();
        productTotalPrice=all_billings.get(currentIndex).getPrd_Price()*all_billings.get(currentIndex).getPrd_Qty();
        clientInfoText_View.setText("Client :"+all_billings.get(currentIndex).getClient_id()+" "+all_billings.get(currentIndex).getClient_name()+" "+all_billings.get(currentIndex).getProduct_Name()+"  "+productTotalPrice+"$");
        Toast.makeText(MainActivity.this,"Client :"+all_billings.get(currentIndex).getClient_id()+" "+all_billings.get(currentIndex).getClient_name()+" "+all_billings.get(currentIndex).getProduct_Name()+"  "+productTotalPrice+"$",Toast.LENGTH_SHORT).show();


//        clientInfoText_View.setText("Client :"+all_billings[currentIndex].getClient_id()+" "+all_billings[currentIndex].getClient_name()+" "+all_billings[currentIndex].getProduct_Name()+"  "+productTotalPrice+"$");
//        Toast.makeText(MainActivity.this,"Client :"+all_billings[currentIndex].getClient_id()+" "+all_billings[currentIndex].getClient_name()+" "+all_billings[currentIndex].getProduct_Name()+"  "+productTotalPrice+"$",Toast.LENGTH_SHORT).show();
    }
});

nextButton=(Button) findViewById(R.id.nextbilling_Button);
nextButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //currentIndex=(currentIndex+1)%all_billings.length;
        currentIndex=(currentIndex+1)%all_billings.size();
       // productTotalPrice=all_billings[currentIndex].getPrd_Price()*all_billings[currentIndex].getPrd_Qty();
        productTotalPrice=all_billings.get(currentIndex).getPrd_Price()*all_billings.get(currentIndex).getPrd_Qty();
        clientInfoText_View=(TextView) findViewById(R.id.clientinfo_Text_View);
       // clientInfoText_View.setText("Client :"+all_billings[currentIndex].getClient_id()+" "+all_billings[currentIndex].getClient_name()+" "+all_billings[currentIndex].getProduct_Name()+"  "+productTotalPrice+"$");
        clientInfoText_View.setText("Client :"+all_billings.get(currentIndex).getClient_id()+" "+all_billings.get(currentIndex).getClient_name()+" "+all_billings.get(currentIndex).getProduct_Name()+"  "+productTotalPrice+"$");
    }
});

previousButton=(Button) findViewById(R.id.previousbilling_Button);
previousButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        currentIndex=(currentIndex+(all_billings.size()-1))%all_billings.size();
        productTotalPrice=all_billings.get(currentIndex).getPrd_Price()*all_billings.get(currentIndex).getPrd_Qty();
        clientInfoText_View=(TextView) findViewById(R.id.clientinfo_Text_View);
        clientInfoText_View.setText("Client :"+all_billings.get(currentIndex).getClient_id()+" "+all_billings.get(currentIndex).getClient_name()+" "+all_billings.get(currentIndex).getProduct_Name()+"  "+productTotalPrice+"$");



//        currentIndex=(currentIndex+(all_billings.length-1))%all_billings.length;
//        productTotalPrice=all_billings[currentIndex].getPrd_Price()*all_billings[currentIndex].getPrd_Qty();
//        clientInfoText_View=(TextView) findViewById(R.id.clientinfo_Text_View);
//        clientInfoText_View.setText("Client :"+all_billings[currentIndex].getClient_id()+" "+all_billings[currentIndex].getClient_name()+" "+all_billings[currentIndex].getProduct_Name()+"  "+productTotalPrice+"$");
    }


});

inputBillingButton=(Button) findViewById(R.id.inputbilling_Button);
inputBillingButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
clientIdEdit_View=(EditText) findViewById(R.id.clientid_Edit_View);

Integer.parseInt(clientIdEdit_View.getText().toString());

clientNameEdit_View=(EditText) findViewById((R.id.clientname_Edit_View));
clientNameEdit_View.getText().toString();

productNameEdit_View=(EditText) findViewById(R.id.productname_Edit_View);
productNameEdit_View.getText().toString();

productPriceEdit_View=(EditText) findViewById(R.id.productprice_Edit_View);
Double.parseDouble(productPriceEdit_View.getText().toString());

productQuantityEdit_View=(EditText) findViewById(R.id.productquantity_Edit_View);
Integer.parseInt(productQuantityEdit_View.getText().toString());

Billing temClient=new Billing(Integer.parseInt(clientIdEdit_View.getText().toString()),clientNameEdit_View.getText().toString(),productNameEdit_View.getText().toString(),Double.parseDouble(productPriceEdit_View.getText().toString()),Integer.parseInt(productQuantityEdit_View.getText().toString()));
    all_billings.add(temClient);
        clientInfoText_View=(TextView) findViewById(R.id.clientinfo_Text_View);
        clientInfoText_View.setText("Client :"+temClient.getClient_id()+","+temClient.getClient_name()+",Product :"+temClient.getProduct_Name()+" is "+temClient.CalculateBilling()+"$");

        Toast.makeText(MainActivity.this,"Client :"+temClient.getClient_id()+","+temClient.getClient_name()+",Product :"+temClient.getProduct_Name()+" is "+temClient.CalculateBilling()+"$",Toast.LENGTH_SHORT).show();

   }
});
    billingDetails=(Button) findViewById(R.id.billingdetails_Button);
    billingDetails.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int clientId=all_billings.get(currentIndex).getClient_id();
            String clientName=all_billings.get(currentIndex).getClient_name();
            String productName=all_billings.get(currentIndex).getProduct_Name();
            double productPrice=all_billings.get(currentIndex).getPrd_Price();
            int productQuantity=all_billings.get(currentIndex).getPrd_Qty();





//            int clientId=all_billings[currentIndex].getClient_id();
//            String clientName=all_billings[currentIndex].getClient_name();
//            String productName=all_billings[currentIndex].getProduct_Name();
//            double productPrice=all_billings[currentIndex].getPrd_Price();
//            int productQuantity=all_billings[currentIndex].getPrd_Qty();

            Intent intent=BillingActivity.newIntent(MainActivity.this,clientId,clientName,productName,productPrice,productQuantity);
            //startActivity(intent);
            startActivityIntent.launch(intent);

        }
    });

    }
    ActivityResultLauncher<Intent> startActivityIntent=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() != Activity.RESULT_OK) {
                        return;
                    } else {
                        Billing billingUpdateInfo = BillingActivity.sendMessageSetBillingUpdateResult(result.getData());
                        clientInfoText_View=(TextView) findViewById(R.id.clientinfo_Text_View);
                        productTotalPrice=billingUpdateInfo.getPrd_Price()*billingUpdateInfo.getPrd_Qty();
                        clientInfoText_View.setText("Updated Billing:"+billingUpdateInfo.getClient_id()+" "+billingUpdateInfo.getClient_name()+" "+billingUpdateInfo.getProduct_Name()+"  "+productTotalPrice+"$");
                        Toast.makeText(MainActivity.this,"Updated Billing:"+billingUpdateInfo.getClient_id()+" "+billingUpdateInfo.getClient_name()+" "+billingUpdateInfo.getProduct_Name()+"  "+productTotalPrice+"$",Toast.LENGTH_SHORT).show();


                    }
                }
            });


    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG,"onStart() called");
    }
    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"onPause() called");
    }
    @Override
    public void onResume()
    {
        super.onResume();
        Log.d(TAG,"onResume() called");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG,"onSaveInstanceState() called");
        savedInstanceState.putInt(KEY_INDEX,currentIndex);
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(TAG,"onStop() called");
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG,"onDestroy() called");
    }
}