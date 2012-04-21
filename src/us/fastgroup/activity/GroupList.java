package us.fastgroup.activity;

import us.fastgroup.R;
import android.app.ListActivity;
import android.os.Bundle;

/**
 * @author Oscar Salguero
 *
 */

public class GroupList extends ListActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_list);
        
    }	

}
