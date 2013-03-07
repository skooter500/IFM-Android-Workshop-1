package tz.ac.ifm;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Workshop2 extends SherlockActivity implements OnClickListener {
	EditText txtRadius;
	TextView lblCircumference;
	TextView lblArea;
	Button btnClick;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.workshop1);
		
		txtRadius = (EditText) findViewById(R.id.txtRadius);
		lblCircumference = (TextView) findViewById(R.id.txtCircumference);
		lblArea = (TextView) findViewById(R.id.txtArea);		
		btnClick = (Button) findViewById(R.id.btnClick);		
		btnClick.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.workshop1, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) 
        {
	        case R.id.countries:
	        {	        	
	        	Intent intent = new Intent(this, CountryListActivity.class);
	        	startActivity(intent);
	        	return true;
	        }
	        case R.id.countriesJSON:
	        {	        	
	        	Intent intent = new Intent(this, CountryJSONListActivity.class);
	        	startActivity(intent);
	        	return true;
	        }
        }
        return false;
	}

	@Override
	public void onClick(View v) {
		Log.d("Workshop1", "Test Message");
		String s = "" + txtRadius.getText();
		float radius = 0;
		try
		{
			radius = Float.parseFloat(s);
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
			Toast.makeText(this, "Please type in a number", Toast.LENGTH_SHORT).show();
			return;
		}
		float pi = 3.1459f;
		float circ = 2.0f * pi;
		float area = pi * radius * radius;
		
		lblArea.setText("Area: " + area);
		lblCircumference.setText("Circumference: " + circ);
		
		// TODO Auto-generated method stub
	}
}
