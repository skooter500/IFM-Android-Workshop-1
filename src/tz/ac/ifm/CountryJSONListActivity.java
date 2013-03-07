package tz.ac.ifm;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.os.Bundle;
import android.util.JsonReader;

import com.actionbarsherlock.app.SherlockListActivity;

public class CountryJSONListActivity extends SherlockListActivity 
{
	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
				
		DBHelper helper = new DBHelper(this);
		CountriesParser p = new CountriesParser(this);
		try {
			p.execute(new URL("http://ec2-23-22-135-25.compute-1.amazonaws.com/countries.php"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ArrayList<Country> countries = helper.getAllCountries();
		//setListAdapter(new CountryListAdapter(this, R.layout.country_row, 0, countries));
        
	}
}
