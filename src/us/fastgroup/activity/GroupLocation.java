package us.fastgroup.activity;

import us.fastgroup.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * @author Oscar Salguero
 *
 */

public class GroupLocation extends Activity {

	private Button buttonAddressMap;
	private EditText editTextAddressStreet;
	private EditText editTextAddressCrossStreet;
	private EditText editTextAddressCity;
	private Spinner spinnerTextAddressState;
	private EditText editTextAddressZipCode;
	private Button buttonAddressDone;
	
	private static final int NO_NETWORK_CONNECTION = 0;
	private static final int DIALOG_VENUE_SUGGEST_ADDRESS_VALIDATION = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.group_location);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);
        
    
	    //Inflating resources
        buttonAddressMap = (Button) findViewById(R.id.buttonAddressMap);
	    editTextAddressStreet = (EditText) findViewById(R.id.editTextAddressStreet);
	    editTextAddressCrossStreet = (EditText) findViewById(R.id.editTextAddressCrossStreet);        
	    editTextAddressCity = (EditText) findViewById(R.id.editTextAddressCity);
		spinnerTextAddressState = (Spinner) findViewById(R.id.spinnerTextAddressState);
		editTextAddressZipCode = (EditText) findViewById(R.id.editTextAddressZipCode);
		buttonAddressDone = (Button) findViewById(R.id.buttonAddressDone);
	
		buttonAddressMap.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent mapItIntent = new Intent(getBaseContext(), MapIt.class);
				mapItIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				getBaseContext().startActivity(mapItIntent);
			}
		});
		
		buttonAddressDone.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
	        		finish();
			}
		});
	    
	}

	@Override
	protected Dialog onCreateDialog(int id) {
	    Dialog dialog;
	    AlertDialog.Builder builder = null;
	    switch(id) {
	    case NO_NETWORK_CONNECTION:
	    	builder = new AlertDialog.Builder(this);
	    	builder.setTitle(R.string.dialog_title_network_error).setMessage(R.string.error_network_no_internet_connection).setCancelable(false).setNeutralButton(R.string.button_close, new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int id) {
	                dialog.cancel();
	            }
	        });
	    	dialog = builder.create();
	    break;
	    case DIALOG_VENUE_SUGGEST_ADDRESS_VALIDATION:
	    	builder = new AlertDialog.Builder(this);
	    	builder.setTitle(R.string.dialog_title_warning).setMessage(R.string.error_address_field_validation).setCancelable(false).setNeutralButton(R.string.button_close, new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int id) {
	                dialog.cancel();
	            }
	        });
	    	dialog = builder.create();
	    break;
	    default:
	        dialog = null;
	    }
	    return dialog;
	}

}
