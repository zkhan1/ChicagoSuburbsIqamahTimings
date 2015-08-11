package com.chicagosuburbs.iqamahtimings;

 



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;




public class test extends Activity{
	
	 private static Context mcontext;


	//private static Context mcontext; 
	//super(mcontext, DB_NAME, null, 1);// 1? its Database Version 
	//this.mcontext = mcontext;
	private static String DB_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
//	private static String DB_PATH = mcontext.getApplicationInfo().dataDir + "/databases/";
	//private static String DB_PATH = "/data/data/" + mContext.getPackageName() + "/databases/"; 
	/*
	if(android.os.Build.VERSION.SDK_INT <= 17){
		
	}else{
		ContextWrapper context = null;
		DB_PATH = context.getApplicationInfo().dataDir + "/databases/"; 
		//DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
	}
	*/
 
	// Data Base Version.
	private final static int DATABASE_VERSION = 1;
	
	 
	 
	  static String receivedDataBaseName = "";
	  static String receivedTableName = "";
	  static int receivedAddress;
	  static int recievedPhone;
	  static String recievedWebsiteAddress = "";
 	
	  
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
	 
	 	DataBaseHelperClass db = new DataBaseHelperClass(this);   //1
	 	
		
		Bundle recdData = getIntent().getExtras();
		receivedDataBaseName = recdData.getString("DatabaseName");
		receivedTableName = recdData.getString("TableName");
		recievedWebsiteAddress = recdData.getString("WebsiteAddress"); 
		receivedAddress = recdData.getInt("Address");
		recievedPhone = recdData.getInt("Phone");
		
		

	

	    try {
			db.copyDataBase();
			//Toast.makeText(getApplicationContext(), "copyDataBase Passed ", Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			db.openDataBase();
			//Toast.makeText(getApplicationContext(), "openDataBase Passed ", Toast.LENGTH_LONG).show();

	 
		
		
		String testOutcome = db.getDayFromDB();
		//Toast.makeText(getApplicationContext(), "getDayFromDB Passed ", Toast.LENGTH_LONG).show();
		 

		  
	 	String[] test = testOutcome.split("\\n"); //  "\n\r\t,.;"
		String test1 = test[0];  
	    String test2 = test[1];
		String test3 = test[2] + " " + "a.m.";
		String test4 = test[3] + " " + "p.m.";
		String test5 = test[4] + " " + "p.m.";
		String test6 = test[5] + " " + "p.m.";
		
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("EEEE, MMMM dd,yyyy");// gives me Day, and full Date
		SimpleDateFormat month = new SimpleDateFormat("MMMMMMMMM"); 
//		String monthName = month.format(c.getTime());  Zee took it out to make a dummy month
        String monthName = "February";
		
	if (test1.equals(monthName)){
			
			
		//((TextView)findViewById(R.id.TextView02)).setText(part1.toUpperCase() + " , " + db.getTodaysDate().toString());
		
		((TextView)findViewById(R.id.testView02)).setText(df.format(c.getTime()));
		
		((TextView)findViewById(R.id.testView01)).setText(test2 + " , " + "1434");
		
		
		
		((TextView)findViewById(R.id.testView03)).setText(R.string.fajr);
		((TextView)findViewById(R.id.testView04)).setText(test3);
		((TextView)findViewById(R.id.testView05)).setText(R.string.dhur);
		((TextView)findViewById(R.id.testView06)).setText(test4);
		((TextView)findViewById(R.id.testView07)).setText(R.string.asr);
		((TextView)findViewById(R.id.testView08)).setText(test5);
		((TextView)findViewById(R.id.testView09)).setText(R.string.maghrib);
		((TextView)findViewById(R.id.testView10)).setText(R.string.sunset);
		((TextView)findViewById(R.id.testView11)).setText(R.string.isha);
		((TextView)findViewById(R.id.testView12)).setText(test6);
		 
	
				   
		   int x = receivedAddress; 
		   switch (x) {
		   case 0: //if x == 0
			((TextView)findViewById(R.id.testaddress)).setText(R.string.isnsaddress);
			((TextView)findViewById(R.id.testphone)).setText(R.string.isnsphone);
			((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.isnsiqamahtimings);
		     break;
		   case 1: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.alhudaaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.alhudaphone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.alhudaiqamahtimings);
		     break;
		   case 2: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.iieeaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.iieephone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.iieeiqamahtimings);
		     break;  
		   case 3:
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.iccdesplainesaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.iccdesplainesphone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.iccdesplainesiqamahtimings);
		     break;
		   case 4: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.ifsvillaparkaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.ifsvillaparkphone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.ifsvillaparkiqamahtimings);
		     break;
		   case 5: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.msiglendaleheightsaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.msiglendaleheightsphone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.msiiqamahtimings);
		     break;
		   case 6: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.icnnapervilleaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.icnnapervillephone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.icniqamahtimings);
		     break;
		   case 7: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.ifnlibertyvilleaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.ifnlibertyvillephone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.ifnlviqamahtimings);
		     break;
		   case 8: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.iccpaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.iccpphone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.iccpiqamahtimings);
		     break;
		   case 9: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.mccchicagoaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.mccchicagophone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.mccciqamahtimings);
		     break;
		   case 10: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.mecchicagoaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.mecchicagophone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.mecmiqamahtimings);
		     break;
		   case 11: 
		 	   ((TextView)findViewById(R.id.testaddress)).setText(R.string.alislambbaddress);
		 	  ((TextView)findViewById(R.id.testphone)).setText(R.string.alislambbphone);
		 	 ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.alislambbiqamahtimings);
		     break;
		   case 12: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.mfbridgeviewaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.mfbridgeviewphone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.mfbridgeviewiqamahtimings);
		     break;
		   case 13: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.hirawooddaleaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.hirawooddalephone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.hirawdiqamahtimings);
		     break;
		   case 14: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.darussalamaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.darussalamphone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.darussalamiqamahtimings);
		     break;  
		   case 15: 
			   ((TextView)findViewById(R.id.testaddress)).setText(R.string.uthmanaddress);
			   ((TextView)findViewById(R.id.testphone)).setText(R.string.uthmanphone);
			   ((TextView)findViewById(R.id.testIqamahtimings)).setText(R.string.uthmaniqamahtimings);
		     break;    
		   default: 
			  
		 } 
		
	}else{
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    // Get the layout inflater
	    builder.setMessage(R.string.noprayertimingsavailable);
	   // Add action buttons
         builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
             public void onClick(DialogInterface dialog, int id) {
                	finish();
              }
          });
        
	 
         AlertDialog alert = builder.create();
         alert.show();
		
		
	}
		
          
	}
		 
	
	


	public class DataBaseHelperClass extends SQLiteOpenHelper{
		 
		
//		private static final String DATABASE_NAME = test_Prayer_Timings.receivedDataBaseName;
//		private static final String TABLE_Name = test_Prayer_Timings.receivedTableName;

		// SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		// private final String DATABASE_NAME =  getPreferences(MODE_PRIVATE).getString("DatabaseName",DBName);


	public Context context;
	private SQLiteDatabase sqliteDataBase;


	/**
	 * Constructor
	 * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
	 * @param context
	 * Parameters of super() are    1. Context
	 *                              2. Data Base Name.
	 *                              3. Cursor Factory.
	 *                              4. Data Base Version.
	 */
	public DataBaseHelperClass(Context context) { 
		super(context, receivedDataBaseName, null ,DATABASE_VERSION);
	    this.context = context;
	    
	    
	}



	/**
	 * Creates a empty database on the system and rewrites it with your own database.
	 * By calling this method and empty database will be created into the default system path
	 * of your application so we are gonna be able to overwrite that database with our database.
	 * */
	public void createDataBase() throws IOException{
	    //check if the database exists
	    boolean databaseExist = checkDataBase();

	    if(databaseExist){
	        // Do Nothing.
	    }else{
	       // this.getWritableDatabase();         
	       // copyDataBase(); 
	    	this.getReadableDatabase();
	    	
	    	 
	    	try {

				copyDataBase();

			} catch (IOException e) {

	    		throw new Error("Error copying database");

	    	}
	    }// end if else dbExist
	

	
	
	} // end createDataBase().

	/**
	 * Check if the database already exist to avoid re-copying the file each time you open the application.
	 * @return true if it exists, false if it doesn't
	 */
	public boolean checkDataBase(){
	   // File databaseFile = new File(DB_PATH + DATABASE_NAME);
	   // return databaseFile.exists(); 
		
		
				
		
		SQLiteDatabase checkDB = null;
		 
		try{
			
					
			
			String myPath = DB_PATH + receivedDataBaseName;
			checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

		}catch(SQLiteException e){

			//database does't exist yet.

		}

		if(checkDB != null){

			checkDB.close();

		}

		return checkDB != null ? true : false;
		
		
		
	}

	/**
	 * Copies your database from your local assets-folder to the just created empty database in the
	 * system folder, from where it can be accessed and handled.
	 * This is done by transferring byte stream.
	 * */
	
	public void copyDataBase() throws IOException{ 
	    
	 
		 try {
	            AssetManager assetManager = getResources().getAssets();
	            InputStream myInput = assetManager.open(receivedDataBaseName);
	            String outFileName = DB_PATH + receivedDataBaseName; 
	            OutputStream myOutput = new FileOutputStream(outFileName); 
	            byte[] buffer = new byte[1024];
	    	    int length;
	    	    while ((length = myInput.read(buffer))>0){
	    	        myOutput.write(buffer, 0, length);
	    	    }
	    	    myOutput.flush();
	    	    myOutput.close();
	    	    myInput.close(); 
	    	  
	              
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		   //  final AssetManager assetMgr = context.getResources().getAssets();  
		   //  InputStream myInput = assetMgr.open(receivedDataBaseName); 
		 
	/*	 
		 //Open your local db as the input stream
	//    InputStream myInput = context.getAssets().open(receivedDataBaseName); 
		AssetManager assetManager = getResources().getAssets();
		
		InputStream myInput = assetManager.open(receivedDataBaseName); 
	    // Path to the just created empty db
	    String outFileName = DB_PATH + receivedDataBaseName; 
	    //Open the empty db as the output stream
	    OutputStream myOutput = new FileOutputStream(outFileName); 
	    //transfer bytes from the input file to the output file
	    byte[] buffer = new byte[1024];
	    int length;
	    while ((length = myInput.read(buffer))>0){
	        myOutput.write(buffer, 0, length);
	    }

	    //Close the streams
	    myOutput.flush();
	    myOutput.close();
	    myInput.close(); 
	  
	 */
		
	 
		
		
		
		/*
		InputStream sFile = getAssets().open(receivedDataBaseName); 
		File sourceFile = new File(sFile);
		//InputStream sourceFile = getAssets().open(receivedDataBaseName);
		 
		FileInputStream fis = new FileInputStream(sourceFile);
		//String outFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + receivedDataBaseName;
		String outFilePath = DB_PATH + receivedDataBaseName;
		
		OutputStream output = new FileOutputStream(outFilePath);

		byte[] buff = new byte[1024];
		int len;
		while ((len = fis.read(buff)) > 0) {
		    output.write(buff, 0, len);
		}
		output.flush();
		output.close();
		fis.close();
		*/
		
		
		
		
		
		
		
		
		
		 
	}



	/**
	 * This method opens the data base connection.
	 * First it create the path up till data base of the device.
	 * Then create connection with data base.
	 */
	public void openDataBase() throws SQLException{      
	    //Open the database
		
	    String myPath = DB_PATH + receivedDataBaseName;
	    sqliteDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE); 
	    
	}

	/**
	 * This Method is used to close the data base connection.
	 */
	@Override
	public synchronized void close() { 
	    if(sqliteDataBase != null)
	        sqliteDataBase.close(); 
	    super.close(); 
	}

	/**
	* Apply your methods and class to fetch data using raw or queries on data base using 
	* following demo example code as:
	*/

	public String getDayFromDB(){
		

		Calendar calc = Calendar.getInstance();
		int day = calc.get(Calendar.DATE);
	    int month = calc.get(Calendar.MONTH)+1;
	    int year = calc.get(Calendar.YEAR);

	   /*
	    // To show the day/date/month on the screen
	    String dayStr,monthStr;
	    if(day<10){
	        dayStr = "0"+day;
	    }else{
	        dayStr = ""+day;
	    }
	    if(month<10){
	        monthStr = "0"+month;
	    }else{
	        monthStr = ""+month;
	    }
	  
	     String currentdate = monthStr+"/"+dayStr+"/"+year+" ";
	     return currentdate;
	     */ 
	   
	     
		 
		 
		//String result = "Cursor is not implemented yet";
	   String result = "";
	   String lunarDate = "";
	   int lunarNumber = 23;	
		
		// String query = "SELECT Day FROM May2013 where Date='"+date+"'";
		// Cursor cursor = sqliteDataBase.rawQuery(query, null);
		
		
		
		 
		Cursor c1 = sqliteDataBase.query(receivedTableName, null, null, null, null, null, null);
		c1.moveToPosition(day-1);
		
		
		
		
		//result = result + "Today is" + (c1.getString(2)) + "\n" + "Fajr is at " + (c1.getString(5)) + " a.m. " + "\n" +
		//		"Dhur is at " + (c1.getString(8))+ " p.m. "  + "\n" + "Asr is at " + (c1.getString(10)) + " p.m. " + "\n" +
		//		"Maghrib is at " + (c1.getString(11))+ " p.m. "  + "\n" + "and Isha is at " + (c1.getString(13))+ " p.m. ";
		
		
		
		result = result + (c1.getString(1)) + "\n" + (c1.getString(2)) + "\n" +(c1.getString(3)) +  "\n" +
				(c1.getString(4))+  "\n" + (c1.getString(5)) + "\n" +
				(c1.getString(6));
		
		
		
		//result2[] = {c1.getString(2), c1.getString(5), c1.getString(8), c1.getString(10), c1.getString(11), c1.getString(13)}; 
		//result2[0] = c1.getString(2);
		//result2[1] = c1.getString(5);
		//result2[2] = c1.getString(8);
		//result2[3] = c1.getString(10);
		//result2[4] = c1.getString(11);
		//result2[5] = c1.getString(13);
		
		c1.close();
		
		return result.toString();
		//return result2.toString();
		
		//return Integer.toString(day);
		 
		
		
	    
	   
	    
	  
	} 
	  


	private Context getApplicationContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	    // No need to write the create table query.
	    // As we are using Pre built data base.
	    // Which is ReadOnly.
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    // No need to write the update table query.
	    // As we are using Pre built data base.
	    // Which is ReadOnly.
	    // We should not update it as requirements of application.
	}   
	  

	//Date format MM/DD/YYYY
	private String getTodaysDate() {

	  final Calendar c = Calendar.getInstance();
	  int dayOfTheMonth = c.get(Calendar.DAY_OF_MONTH);
	  return(new StringBuilder()
	          .append(c.get(Calendar.MONTH) + 1).append("/")
	          .append(c.get(Calendar.DAY_OF_MONTH)).append("/")
	          .append(c.get(Calendar.YEAR)).append(" ")).toString();
	}
	
 

	}	 
	

	
public void visittestWebsite(View view){
		
		String url = recievedWebsiteAddress;
		if (!url .startsWith("http://") && !url.startsWith("https://"))
			   url = "http://" + url;
		
		 Intent testWebsiteIntent = new Intent(this, webview.class);
		 testWebsiteIntent.putExtra("url", url);
		 
		 startActivity(testWebsiteIntent);
		 finish();
		 	
	}   
	  		
	
	}

 
