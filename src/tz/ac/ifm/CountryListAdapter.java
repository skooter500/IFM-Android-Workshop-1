package tz.ac.ifm;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CountryListAdapter extends ArrayAdapter<Country>{
	int resourceId;
	Context context;
	
	
	
	public CountryListAdapter(Context context, int resource,
			int textViewResourceId, List<Country> objects) 
	{
		super(context, resource, textViewResourceId, objects);
		resourceId = resource;
		this.context = context;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;
        if (v == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(resourceId, null);            
        }
        
        Country country = getItem(position);
        TextView lblCountry = (TextView) v.findViewById(R.id.lblCountry);
        lblCountry.setText(country.getName());
        TextView lblPopulation = (TextView) v.findViewById(R.id.lblPopulation);
        lblPopulation.setText("" + country.getPopulation());
        TextView lblCapital = (TextView) v.findViewById(R.id.lblCapital);
        lblCapital.setText("" + country.getCapital());
        
        TextView lblCurrency = (TextView) v.findViewById(R.id.lblCurrency);
        lblCurrency.setText("" + country.getCurrency());
        
        return v;
    }
}
