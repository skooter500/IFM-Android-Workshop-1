package tz.ac.ifm;

import java.util.ArrayList;
import java.util.Currency;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	
	private static String DB_NAME = "countries.sqlite";
    private SQLiteDatabase database;
    private final Context myContext;
    
	public DBHelper(Context ctx)
    {
        super(ctx, DB_NAME, null, 1);
        myContext = ctx;
    }

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		String createQuery = "CREATE TABLE country (id integer primary key autoincrement, name TXT, population TXT, capital TXT, currency TXT);";
		db.execSQL(createQuery);
		database = db;
		Country ireland = new Country(-1, "Ireland", 4487000, "Dublin", "Euro");
		long newID = addCountry(ireland);
		if (newID == -1)
		{
			Log.e("Workshop2", "Could not add country");
		}
		
		Country tanzania = new Country(-1, "Tanzania", 46218486, "Dodoma", "Shillings");
		newID = addCountry(tanzania);
		if (newID == -1)
		{
			Log.e("Workshop2", "Could not add country");
		}
	}
	
	public void open() throws SQLException 
	{
		//open database in reading/writing mode
		database = getWritableDatabase();
	}
	
	public void close() 
	{
		if (database != null)
		database.close();
	}
	
	public long addCountry(Country country)
	{
		ContentValues newCon = new ContentValues();
		newCon.put("name", country.getName());
		newCon.put("population", country.getPopulation());
		newCon.put("capital", country.getCapital());
		newCon.put("currency", country.getCurrency());
		long ret = database.insert("country", null, newCon);
		return ret;
	}
	
	public ArrayList<Country> getAllCountries() 
	{
		open();
		ArrayList<Country> countries = new ArrayList<Country>();		
		Cursor results = database.query("country", new String[] {"id", "name", "population", "capital", "currency"},
		null, null, null, null, "name");
		
		if (results.moveToFirst())
        {
            do
            {
            	Country country = new Country();
            	country.setId(results.getInt(0));
            	country.setName(results.getString(1));
            	country.setPopulation(results.getInt(2));
            	country.setCapital(results.getString(3));
            	country.setCurrency(results.getString(4));
            	countries.add(country);
            }
            while (results.moveToNext());
        }
		close();
		return countries;
	}

	public Cursor getCountry(long id) 
	{
		return database.query("country", null, "_id=" + id,
		null, null, null, null);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

}
