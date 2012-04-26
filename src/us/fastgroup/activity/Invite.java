package us.fastgroup.activity;

import us.fastgroup.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Oscar Salguero
 *
 */

public class Invite extends Activity {

	private EditText editTextBuddies;
	private Button buttonSetLocation;
	private Button buttonSendMessage;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invite);
        
        editTextBuddies = (EditText) findViewById(R.id.edit_text_buddy_names);
        buttonSetLocation = (Button) findViewById(R.id.button_set_group_location);
        buttonSendMessage = (Button) findViewById(R.id.button_send);
        
        buttonSetLocation.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent setLocationIntent = new Intent(getBaseContext(), GroupLocation.class);
				setLocationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				getBaseContext().startActivity(setLocationIntent);
			}
		});
        
        
        buttonSendMessage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sendSms();
			}
		});
    }
	
	private void sendSms(){
		StringBuilder smsBodyText = new StringBuilder();
		smsBodyText.append("Let's gather at 7:00 PM, at ");
		smsBodyText.append("1445 New York Ave, Washington DC, 22057");
		smsBodyText.append("\n");
		//smsBodyText.append();
		
		Intent sendIntent = new Intent("android.intent.action.SEND_MSG"); 
		sendIntent.putExtra(Intent.EXTRA_SUBJECT, "BuddyChk Ping");
		sendIntent.putExtra("address", editTextBuddies.getText());
		sendIntent.putExtra("sms_body", smsBodyText.toString()); 
		sendIntent.setType("vnd.android-dir/mms-sms");
		startActivity(Intent.createChooser(sendIntent, getBaseContext().getResources().getString(R.string.send_sms)));
		finish();
	}
	
}
