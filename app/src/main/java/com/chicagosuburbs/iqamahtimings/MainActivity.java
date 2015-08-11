package com.chicagosuburbs.iqamahtimings;




import java.util.ArrayList;
import java.util.Arrays;






import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	
	int textLength=0;
	EditText et;
 	private ListView masjidListView;  //mainlistview
	//private ArrayAdapter<String> listAdapter ;
	ArrayList<String> array_sort= new ArrayList<String>();
    ArrayList<String> masajidListArray= new ArrayList<String>();

    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		// Find the ListView resource.   
		masjidListView = (ListView) findViewById(R.id.masjidListView1);
		et = (EditText) findViewById(R.id.EditTextSearch);
		
		// Create and populate a List of Masajids Names
		String[] masajids = new String[] {"ISNS Rolling Meadows", "Al-Huda Schaumburg", "IIE Elgin", "ICC Desplaines", "IFS Villa Park", 
				"MSI Glendale Heights", "ICN Naperville", "IFN Libertyville", "ICC Peterson Chicago", "MCC Chicago", "MEC Morton Grove", "Al-Islam Bolingbrook", "Mosque Foundation", "Al-Hira Wood Dale", "DarusSalam Lombard", "Masjid Uthman"};
 
		
		 
		masajidListArray.addAll(Arrays.asList(masajids)); 
		
		 
		 	
	masjidListView.setAdapter(new ArrayAdapter<String>(this,R.layout.listview_item_row, R.id.masjidListView1, masajidListArray));
	
	
   //Toast.makeText(getApplicationContext(), "Pass 1", Toast.LENGTH_LONG).show();	


	 
	// To find a particular zone   

	
	// To show what item from the listView is selected as an alert show
		masjidListView.setClickable(true);
		masjidListView.setTextFilterEnabled(true);
		
	//Enabling Search Functionality
	et.addTextChangedListener(new TextWatcher()
	{
		
		 
	public void afterTextChanged(Editable s)
	{
	   // Abstract Method of TextWatcher Interface.
		
	}
	public void beforeTextChanged(CharSequence s,
	int start, int count, int after)
	{
	// Abstract Method of TextWatcher Interface.
	}
	
	public void onTextChanged(CharSequence s, int start, int before, int count)
	{
		 
		textLength = et.getText().length();
		 
		 array_sort.clear();
		
		 
	
	for (int i = 0; i < masajidListArray.size(); i++)  // listView.length; i++)
	{
	if (textLength <= masajidListArray.get(i).length())
	{
	if(et.getText().toString().equalsIgnoreCase((String) masajidListArray.get(i).subSequence(0,textLength)))
	{
	   
		array_sort.add(masajidListArray.get(i));
		
		 
	 
		
	 }
	                                                                                }
	                                                                }
	
	
	
	masjidListView.setAdapter(new ArrayAdapter<String>(MainActivity.this,R.layout.listview_item_row, R.id.masjidListView1, array_sort));
	
	//listAdapter.notifyDataSetChanged();
	
	
	
	}
	});
   
	// To find a particular zone ends here
	 
	
	
	
	
	
	masjidListView.setOnItemClickListener(new OnItemClickListener()
		{
		 
		
		@Override
		public void onItemClick(AdapterView<?> arg0, View v, int position, long id)
	    {
 	
		 
	   
	// Toast.makeText(getApplicationContext(),  ""+ x, Toast.LENGTH_SHORT).show();
	//   Toast.makeText(getApplicationContext(),  ""+ masjidName, Toast.LENGTH_SHORT).show();
	   
	  
	/*		
	int x = (int) masjidListView.getItemIdAtPosition(position);
	 
	 
	  
	   
	   switch (x) {
	   case 0: //if x == 0
	     ISNS();
	     break;
	   case 1: 
		   ALHUDA();
	     break;
	   case 2: 
		   IIE();
	     break;  
	   case 3:
		   ICCDESPLAINES();  
	     break;
	   case 4: 
		   IFSVILLAPARK();
	     break;
	   case 5: 
		   MSIGLENDALEHEIGHTS();
	     break;
	   case 6: 
		   ICNNAPERVILLE();
	     break;
	   case 7: 
		   IFNLIBERTYVILLE();
	     break;
	   case 8: 
		   ICCPETERSONCHICAGO();
	     break;
	   case 9: 
	 	   MCCCHICAGO();
	     break;
	   case 10: 
	 	   MECMORTONGROVE();
	     break;
	   case 11: 
	 	   ALISLAMBB();
	     break;
	   case 12: 
	 	   MFBRIDGEVIEW();
	     break;
	   case 13: 
	 	   HIRAWOODDALE();
	     break;
	   case 14: 
		   DarusSalamLombard(); 
	     break;
	   case 15: 
		   MasjidUthmanLombard(); 
	     break;
	   default: 
		  
	 }
	   
	  */
	   
	   
	   String masjidName = (String) masjidListView.getItemAtPosition(position);
	   
	   if (masjidName.equals("ISNS Rolling Meadows"))
	   {
		   ISNS(); 
	   }else if (masjidName.equals("Al-Huda Schaumburg"))
	   {
		   ALHUDA();  
	   }else if (masjidName.equals("IIE Elgin"))
	   {
		   IIE();
	   }else if (masjidName.equals("ICC Desplaines"))
	   {
		   ICCDESPLAINES();  
	   }else if (masjidName.equals("IFS Villa Park"))
	   {
		   IFSVILLAPARK(); 
	   }else if (masjidName.equals("MSI Glendale Heights"))
	   {
		   MSIGLENDALEHEIGHTS(); 
	   }else if (masjidName.equals("ICN Naperville"))
	   {
		   ICNNAPERVILLE();
	   }else if (masjidName.equals("IFN Libertyville"))
	   {
		   IFNLIBERTYVILLE();
	   }else if (masjidName.equals("ICC Peterson Chicago"))
	   {
		   ICCPETERSONCHICAGO();  
	   }else if (masjidName.equals("MCC Chicago"))
	   {
		   MCCCHICAGO();  
	   }else if (masjidName.equals("MEC Morton Grove"))
	   {
		   MECMORTONGROVE(); 
	   }else if (masjidName.equals("Al-Islam Bolingbrook"))
	   {
		   ALISLAMBB(); 
	   }else if (masjidName.equals("Mosque Foundation"))
	   {
		   MFBRIDGEVIEW();  
	   }else if (masjidName.equals("Al-Hira Wood Dale"))
	   {
		   HIRAWOODDALE();
	   }
	   else if (masjidName.equals("DarusSalam Lombard"))
	   {
		   DarusSalamLombard(); 
	   }else if (masjidName.equals("Masjid Uthman"))
	   {
		   MasjidUthmanLombard();  
	   }
	   
	   
	//   Toast.makeText(getApplicationContext(),
    //            ""+selectedMasjidValue, Toast.LENGTH_SHORT).show();
	}

		  });
	
		}

	
	public void notifyDataSetChanged() {
		this.notifyDataSetChanged();
	    
	   
	}
	 
	public void showSoftKeyboard(View v1)
	{
		et.setFocusableInTouchMode(true);
		et.requestFocus();
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	
	 
	public void ISNS(){
		//String DBName = "ISNS2013DB.sqlite";
		//String TableName = "ISNS2013";
		
		 String DatabaseName = "ISNS2013DB.sqlite";
		 String TableName = "ISNS2013";
		 String WebsiteAddress = "www.isns.org";
		 int Address = 0;
		 int Phone = 0;
	 	 
		Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
		intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
		intentPrayerTimings.putExtra("TableName", TableName);
		intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
		intentPrayerTimings.putExtra("Address", Address);
		intentPrayerTimings.putExtra("Phone", Phone);
		startActivity(intentPrayerTimings); 
	}
	
	
	
	public void ALHUDA(){
				
		 String DatabaseName = "ALHUDA2013DB.sqlite";
		 String TableName = "AlHUDA2013";
		 String WebsiteAddress = "www.masjidalhuda.org";
		
		 int Address = 1;
		 int Phone = 1;
		 
	 	 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	

	public void IIE(){
		
		 String DatabaseName = "IIEELGIN2013DB.sqlite";
		 String TableName = "IIE2013";
		 String WebsiteAddress = "www.iieonline.org/";
		 int Address = 2;
		 int Phone = 2;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	
	
	public void ICCDESPLAINES(){
				
		 String DatabaseName = "ICCDesplaines2013DB.sqlite";
		 String TableName = "ICCD2013";
		 String WebsiteAddress = "http://www.islamiccommunitycenter.com/ICC/Home.asp";
	 	 int Address = 3;
		 int Phone = 3;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings);  
	}
	
	public void IFSVILLAPARK(){
		
		 String DatabaseName = "IFSVILLAPARK2013DB.sqlite";
		 String TableName = "IF2013"; 
		 String WebsiteAddress = "www.islamicfoundation.org";
		 int Address = 4;
		 int Phone = 4;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	public void MSIGLENDALEHEIGHTS(){
		
		 String DatabaseName = "MSIGLENDALEHEIGHTS2013DB.sqlite";
		 String TableName = "MSI2013";
		 String WebsiteAddress = "www.muslimsocietyinc.org";
		 int Address = 5;
		 int Phone = 5;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	
	public void ICNNAPERVILLE(){
		
		 String DatabaseName = "ICN2013DB.sqlite";
		 String TableName = "ICN2013";
		 String WebsiteAddress = "www.islamiccenterofnaperville.org";
		 int Address = 6;
		 int Phone = 6;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	public void IFNLIBERTYVILLE(){
		
		 String DatabaseName = "IFN2013DB.sqlite";
		 String TableName = "IFN2013";
		 String WebsiteAddress = "ifnonline.com";
		 int Address = 7;
		 int Phone = 7;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	
	public void ICCPETERSONCHICAGO(){
		
		 String DatabaseName = "ICCP2013DB.sqlite";
		 String TableName = "ICCP2013";
		 String WebsiteAddress = "www.icconline.org";
		 int Address = 8;
		 int Phone = 8;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	public void MCCCHICAGO(){
		
		 String DatabaseName = "MCCC2013DB.sqlite";
		 String TableName = "MCC2013";
		 String WebsiteAddress = "www.mccchicago.org";
		 int Address = 9;
		 int Phone = 9;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	public void MECMORTONGROVE(){
		
		 String DatabaseName = "MECM2013DB.sqlite";
		 String TableName = "MEC2013";
		 String WebsiteAddress = "www.mccchicago.org";
		 int Address = 10;
		 int Phone = 10;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	public void ALISLAMBB(){
		
		 String DatabaseName = "ALISLAMBB.sqlite";
		 String TableName = "ALISLAM2013";
		 String WebsiteAddress = "http://bolingbrookmasjid.com/index.php";
		 int Address = 11;
		 int Phone = 11;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	public void MFBRIDGEVIEW(){
		
		 String DatabaseName = "MFBRIDGEVIEW2013.sqlite";
		 String TableName = "MFBRIDGEVIEW2013";
		 String WebsiteAddress = "http://www.mosquefoundation.org/";
		 int Address = 12;
		 int Phone = 12;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	public void HIRAWOODDALE(){
		
		 String DatabaseName = "ALHIRAWD2013DB.sqlite";
		 String TableName = "ALHIRAWD2013";
		 String WebsiteAddress = "http://alhiracommunity.org/";
		 int Address = 13;
		 int Phone = 13;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	
	public void DarusSalamLombard(){
		
		 String DatabaseName = "DARUSSALAM2013DB.sqlite";
		 String TableName = "DARUSSALAM2013";
		 String WebsiteAddress = "http://darussalamfoundation.org/";
		 int Address = 14;
		 int Phone = 14;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	public void MasjidUthmanLombard(){
		
		 String DatabaseName = "UTHMAN2013DB.sqlite";
		 String TableName = "UTHMAN2013";
		 String WebsiteAddress = "http://masjiduthman.org/";
		 int Address = 15;
		 int Phone = 15;
		 
			Intent intentPrayerTimings = new Intent(this,test.class);  // To start DisplayMessageActivity.java activity and screen
			intentPrayerTimings.putExtra("DatabaseName", DatabaseName);
			intentPrayerTimings.putExtra("TableName", TableName);
			intentPrayerTimings.putExtra("WebsiteAddress", WebsiteAddress);
			intentPrayerTimings.putExtra("Address", Address);
			intentPrayerTimings.putExtra("Phone", Phone);
			startActivity(intentPrayerTimings); 
	}
	
	
	
}
