package tz.ac.ifm;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.MenuItem;


public class CountryListActivity extends SherlockListActivity
{
	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		
		DBHelper helper = new DBHelper(this);
		ArrayList<Country> countries = helper.getAllCountries();
		setListAdapter(new CountryListAdapter(this, R.layout.country_row, 0, countries));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) 
        {
	        case android.R.id.home:
	        {	        	
	        	finish();
	        	return true;
	        }
        }
        return false;
	}
}
