package com.example.multiscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;


public class Payment extends AppCompatActivity implements PaymentResultListener {

    String  TAG = "Payment Error";
    Button pay,rev;
    ImageView imageView3;
    private Button button25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        imageView3=findViewById(R.id.phonepay);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent99 = new Intent(Payment.this,Creditcard.class);
                startActivity(intent99);
            }
        });

        Checkout.preload(getApplicationContext());
        Intent intent14 = getIntent();
        rev = findViewById(R.id.review);
        rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Payment.this);
                builder.setContentTitle("Car(e)Takr");
                builder.setContentText("Your Payment is Successful");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                Intent intent38  = new Intent(Payment.this, Ratings.class);
                startActivity(intent38);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Payment.this);
                managerCompat.notify(1, builder.build());//id should be unique
            }
        });

/*
        pay = findViewById(R.id.paybutton);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayment();

            }
        });*/

    }
   /* public void Issue1(View view){
        Intent intent25 = new Intent(this, Issue1.class);
        startActivity(intent25);
    }*/
    public void Ratings (View view){
        Intent intent38  = new Intent(this, Ratings.class);
        startActivity(intent38);
    }
    public void payment_succesful(View view){
        Intent intent72 = new Intent(this, payment_succesful.class);
        startActivity(intent72);
    }

    public void startPayment() {

        /**
         * Instantiate Checkout
         */
        Checkout checkout = new Checkout();

        /**
         * Set your logo here
         */
        //checkout.setImage(R.drawable.logo);

        /**
         * Reference to current activity
         */
        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();

            options.put("name", "First Customer");
            options.put("description", "Testing Order");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "50000");//pass amount in currency subunits
            options.put("prefill.email", "arihantsurana22@gmail.com");
            options.put("prefill.contact","9652953576");
            checkout.open(activity, options);
        } catch(Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String S) {
        /**
         * Add your logic here for a successfull payment response
         */
        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i,String s) {
        /**
         * Add your logic here for a failed payment response
         */
        Toast.makeText(this, "Error in Payment", Toast.LENGTH_SHORT).show();
    }
}
