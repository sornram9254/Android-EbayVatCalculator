package com.sornram9254.ebayvatcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText inputPrice;
	private Button btn_calculator;
	private TextView	txt_total_price,txt_price_vat15,txt_price_vat7,
						txt_vat15,txt_vat7,txt_total_vat15,txt_total_vat7;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		widget();
		
		btn_calculator.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calPrice();
			}
		});
	}
	
	private void widget(){
		inputPrice = (EditText) findViewById(R.id.editText1);
		btn_calculator = (Button) findViewById(R.id.button1);
		txt_total_price = (TextView) findViewById(R.id.textView10);
		txt_price_vat15 = (TextView) findViewById(R.id.textView2);
		txt_price_vat7 = (TextView) findViewById(R.id.textView6);
		txt_vat15 = (TextView) findViewById(R.id.textView4);
		txt_vat7 = (TextView) findViewById(R.id.textView7);
		txt_total_vat15 = (TextView) findViewById(R.id.textView5);
		txt_total_vat7 = (TextView) findViewById(R.id.textView8);
	}

	private void calPrice(){
		try {
			DecimalFormat floatFormat = new DecimalFormat("#,####.##");
			
			/////	Vat 15%
			float intPrice15 = Integer.parseInt(inputPrice.getText().toString());
			float intVat15 = 15*(intPrice15/100);
			float totalPrice15 = intPrice15 + intVat15;
			txt_price_vat15.setText("Price "+floatFormat.format(intPrice15));
			txt_vat15.setText("Vat "+floatFormat.format(intVat15));
			txt_total_vat15.setText("Total "+floatFormat.format(totalPrice15));
			
			/////	Vat 7%
			float intVat7 = 7*(totalPrice15/100);
			float totalPrice7 = totalPrice15 + intVat7;
			txt_price_vat7.setText("Price "+floatFormat.format(totalPrice15));
			txt_vat7.setText("Vat "+floatFormat.format(intVat7));
			txt_total_vat7.setText("Total "+floatFormat.format(totalPrice7));
			
			/////	Total Price
			txt_total_price.setText("Total Price "+floatFormat.format(totalPrice7));
		} catch (Exception e) {
		/////	Error Message
			txt_total_price.setText("Error");
		}
	}

}
