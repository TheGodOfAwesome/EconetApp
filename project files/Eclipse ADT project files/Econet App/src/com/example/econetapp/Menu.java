package com.example.econetapp;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Context;
import android.net.Uri;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.ContextMenu.ContextMenuInfo;

public class Menu extends ListActivity {

	final Context context = this;
	String classes[] = { "Balance Enquiry", "EcoCash", "Recharge", "Call Me Back", "Data Bundles", "WhatsApp Bundles", "Facebook Bundles"};
	String encodedHash = Uri.encode("#");
	String NewPosition;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_activated_1, classes));
	    
		// add PhoneStateListener
				PhoneCallListener phoneListener = new PhoneCallListener();
				TelephonyManager telephonyManager = (TelephonyManager) this
						.getSystemService(Context.TELEPHONY_SERVICE);
				telephonyManager.listen(phoneListener,
						PhoneStateListener.LISTEN_CALL_STATE);
				
	
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String Position = classes[position];
		try{
			if (Position == "Balance Enquiry"){
				String Balance_Enq = "*125" + encodedHash;
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:" + Balance_Enq));
				startActivity(callIntent);
			}
			if (Position == "EcoCash"){
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:*151*200" + encodedHash));
				startActivity(callIntent);
			}
			if (Position == "Recharge"){
		        Class ourClass = Class.forName("com.example.econetapp." + Position);
		        Intent ourIntent = new Intent(Menu.this, ourClass);
		        startActivity(ourIntent);
		    }
			if (Position == "Call Me Back"){
			    Class ourClass = Class.forName("com.example.econetapp.Call_Me_Back");
			    Intent ourIntent = new Intent(Menu.this, ourClass);
			    startActivity(ourIntent);
			    }
			if (Position == "Data Bundles"){
				NewPosition = "Data Bundles";
				registerForContextMenu(v);
                openContextMenu(v);
			    }
			if (Position == "WhatsApp Bundles"){
				NewPosition = "WhatsApp Bundles";
				registerForContextMenu(v);
				openContextMenu(v);
			    }
			if (Position == "Facebook Bundles"){
				NewPosition = "Facebook Bundles";
				registerForContextMenu(v);
				openContextMenu(v);
			    }
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
			
		
	}
	
	
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		 if( NewPosition == "Data Bundles"){
		   
			menu.setHeaderTitle("Data Bundles");
			menu.add(0, v.getId(), 0, "Check Data Balance");
			menu.add(0, v.getId(), 0, "1. $0.50 - 5MB");
			menu.add(0, v.getId(), 0, "2. $1 - 10MB");
			menu.add(0, v.getId(), 0, "3. $5 - 80MB");
			menu.add(0, v.getId(), 0, "4. $10 - 200MB");
			menu.add(0, v.getId(), 0, "5. $20 - 500MB");
			menu.add(0, v.getId(), 0, "Cancel");
			NewPosition = "";
			
		 }else if( NewPosition == "WhatsApp Bundles"){
			
			    menu.setHeaderTitle("WhatsApp Bundles");
				menu.add(0, v.getId(), 0, "WhatsApp Monthly: $3");
				menu.add(0, v.getId(), 0, "WhatsApp Weekly : $0.95");
				menu.add(0, v.getId(), 0, "WhatsApp Daily  : $0.30");
				menu.add(0, v.getId(), 0, "Cancel");
				NewPosition = "";

		  }else if( NewPosition == "Facebook Bundles"){
			
			    menu.setHeaderTitle("Facebook Bundles");
				menu.add(0, v.getId(), 0, "Facebook Monthly: $3");
				menu.add(0, v.getId(), 0, "Facebook Weekly : $0.95");
				menu.add(0, v.getId(), 0, "Cancel");
				NewPosition = "";
				
				}else{
		        menu.setHeaderTitle("Info");
				menu.add(0, v.getId(), 0, "Select An Action On The List!"); 
				NewPosition = "";
   
		 }
	
	}
	public boolean onContextItemSelected(MenuItem item) {
		if (item.getTitle() == "Check Data Balance") {
			NewPosition = "";

			// restart app
			Intent intent = getIntent();
		    finish();
		    startActivity(intent); 
			
			String USSD_CODE = "*141" + encodedHash;
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:" + USSD_CODE));
			startActivity(callIntent);
			Toast.makeText(this, "Checking Data Balance", Toast.LENGTH_SHORT).show();
			
		}else if (item.getTitle() == "1. $0.50 - 5MB") {
			NewPosition = "";

			// restart app
			Intent intent = getIntent();
			finish();
			startActivity(intent); 
			
			String Balance_Enq = "*140*1*1*1" + encodedHash;
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:" + Balance_Enq));
			startActivity(callIntent);
			Toast.makeText(this, "Purchasing 5MB Of Data", Toast.LENGTH_SHORT).show();
			
		} else if (item.getTitle() == "2. $1 - 10MB") {
			NewPosition = "";

			// restart app
			Intent intent = getIntent();
			finish();
			startActivity(intent); 
			
			String Balance_Enq = "*140*1*1*2" + encodedHash;
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:" + Balance_Enq));
			startActivity(callIntent);
			Toast.makeText(this, "Purchasing 10MB Of Data", Toast.LENGTH_SHORT).show();

			} else if (item.getTitle() == "3. $5 - 80MB") {
				NewPosition = "";

				// restart app
				Intent intent = getIntent();
				finish();
				startActivity(intent); 
				
				String Balance_Enq = "*140*1*1*3" + encodedHash;
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:" + Balance_Enq));
				startActivity(callIntent);
				Toast.makeText(this, "Purchasing 80MB Of Data", Toast.LENGTH_SHORT).show();

			} else if (item.getTitle() == "4. $10 - 200MB") {
				NewPosition = "";

				// restart app
				Intent intent = getIntent();
				finish();
				startActivity(intent); 
				
				String Balance_Enq = "*140*1*1*4" + encodedHash;
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:" + Balance_Enq));
				startActivity(callIntent);
				Toast.makeText(this, "Purchasing 200MB Of Data", Toast.LENGTH_SHORT).show();

			} else if (item.getTitle() == "5. $20 - 500MB") {
				NewPosition = "";

				// restart app
				Intent intent = getIntent();
				finish();
				startActivity(intent); 
				
				String Balance_Enq = "*140*1*1*5" + encodedHash;
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:" + Balance_Enq));
				startActivity(callIntent);
				Toast.makeText(this, "Purchasing 500MB Of Data", Toast.LENGTH_SHORT).show();

			} else if (item.getTitle() == "WhatsApp Monthly: $3") {
				NewPosition = "";

				// restart app
				Intent intent = getIntent();
				finish();
				startActivity(intent); 
				
			    String Balance_Enq = "*143*1*1*1*1" + encodedHash;
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:" + Balance_Enq));
				startActivity(callIntent);
				Toast.makeText(this, "WhatsApp Unlimited Monthly Bundle", Toast.LENGTH_SHORT).show();
			
		} else if (item.getTitle() == "WhatsApp Weekly : $0.95") {
				NewPosition = "";

				// restart app
				Intent intent = getIntent();
				finish();
				startActivity(intent); 
				
				String Balance_Enq = "*143*1*1*1*1"  + encodedHash;
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:" + Balance_Enq));
				startActivity(callIntent);
				Toast.makeText(this, "WhatsApp Unlimited Weekly Bundle", Toast.LENGTH_SHORT).show();
			
		} else if (item.getTitle() == "WhatsApp Daily  : $0.30") {
			NewPosition = "";

			// restart app
			Intent intent = getIntent();
			finish();
			startActivity(intent); 
			
			String Balance_Enq = "*143*1*1*1*1" + encodedHash;
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:" + Balance_Enq));
			startActivity(callIntent);
			Toast.makeText(this, "WhatsApp Unlimited Daily Bundle", Toast.LENGTH_SHORT).show();
			
		} else if (item.getTitle() == "Facebook Monthly: $3") {
			NewPosition = "";

			// restart app
			Intent intent = getIntent();
			finish();
			startActivity(intent); 
			
		    String Balance_Enq = "*143*1*1*1*1"  + encodedHash;
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:" + Balance_Enq));
			startActivity(callIntent);
			Toast.makeText(this, "Facebook Unlimited Monthly Data Bundle", Toast.LENGTH_SHORT).show();
		
		} else if (item.getTitle() == "Facebook Weekly : $0.95") {
			NewPosition = "";

			// restart app
			Intent intent = getIntent();
			finish();
			startActivity(intent); 
			
			String Balance_Enq = "*143*1*1*1*1"  + encodedHash;
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:" + Balance_Enq));
			startActivity(callIntent);
			Toast.makeText(this, "Facebook Unlimited Weekly Data Bundle", Toast.LENGTH_SHORT).show();
		
		}else if (item.getTitle() == "Cancel") {
					NewPosition = "";
					// restart app
					Intent intent = getIntent();
				    finish();
				    startActivity(intent);					
		} else {
			NewPosition = "";
			 
			// restart app
						Intent intent = getIntent();
					    finish();
					    startActivity(intent); 
			return false;
		}
		return true;
	}

	private class PhoneCallListener extends PhoneStateListener {

		private boolean isPhoneCalling = false;

		String LOG_TAG = "LOGGING 123";

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {

			if (TelephonyManager.CALL_STATE_RINGING == state) {
				// phone ringing
				Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
			}

			if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
				// active
				Log.i(LOG_TAG, "OFFHOOK");

				isPhoneCalling = true;
			}

			if (TelephonyManager.CALL_STATE_IDLE == state) {
				// run when class initial and phone call ended, need detect flag
				// from CALL_STATE_OFFHOOK
				Log.i(LOG_TAG, "IDLE");

				if (isPhoneCalling) {

					Log.i(LOG_TAG, "restart app");

					// restart app
					Intent i = getBaseContext().getPackageManager()
							.getLaunchIntentForPackage(
									getBaseContext().getPackageName());
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);

					isPhoneCalling = false;
				}

			}
		}
	}

}
