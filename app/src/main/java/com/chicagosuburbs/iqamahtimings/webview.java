package com.chicagosuburbs.iqamahtimings;

 

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class webview extends Activity{
	
	private WebView webView; 
	static String receivedURL = "";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		
		
		Bundle recdURL = getIntent().getExtras();
		receivedURL = recdURL.getString("url");
		
		
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(receivedURL);
		
				
	}

}
