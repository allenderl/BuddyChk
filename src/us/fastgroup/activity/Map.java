package us.fastgroup.activity;

import us.fastgroup.R;
import android.os.Bundle;

import com.google.android.maps.MapActivity;

/**
 * @author Oscar Salguero
 *
 */

public class Map extends MapActivity {

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        
    }
	
}
