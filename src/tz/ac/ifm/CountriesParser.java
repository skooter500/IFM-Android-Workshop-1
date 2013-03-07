package tz.ac.ifm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

public class CountriesParser extends AsyncTask<URL, Object, JSONObject>
{
	ProgressDialog progressDialog;
	CountryJSONListActivity context;
	
	public CountriesParser(CountryJSONListActivity context)
	{
		this.context = context;
	}
	
	public void reshowProgress() {
		progressDialog = null;
		progressDialog = ProgressDialog.show(context, null, "Submitting", true, true, new DialogInterface.OnCancelListener()
        {

            public void onCancel(DialogInterface arg0)
            {
                progressDialog.dismiss();
                cancel(true);
            }
        });		
	}

	@Override 
	protected void onPreExecute()
    {
    	reshowProgress();    
    }

    @Override
    protected void onCancelled()
    {    	
        if (progressDialog != null)
        {
            progressDialog.dismiss();
        }
    }

	@Override
	protected JSONObject doInBackground(URL... params) {
		URL url = params[0];
		JSONObject jsonObj = null;
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        String line;
	        StringBuffer sb = new StringBuffer();
	        while ((line = in.readLine()) != null)
	        {
	            sb.append(line);
	        }
	        
	        try {
	            jsonObj = new JSONObject("" + sb);
	        } catch (JSONException e) {
	            Log.e("JSON Parser", "Error parsing data " + e.toString());
	            cancel(true);
	        }
		}
		catch (Exception e)
		{
			Log.e("WORKSHOP 3", "Error loading data " + e.toString());
			e.printStackTrace();
			cancel(true);
		}
		// return JSON String
        return jsonObj;		
	}
	
	@Override
	protected void onPostExecute(JSONObject arg)
    {
		if (progressDialog != null)
        {
            progressDialog.dismiss();
        }
		
    	if (context != null)
    	{
    		Log.d("JSON", "" + arg);
    	}
    }
}
