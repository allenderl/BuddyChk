package us.fastgroup.activity;

import us.fastgroup.R;
import us.fastgroup.custom.BadgeTabManager;
import us.fastgroup.custom.BadgeTabWidget;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * @author Oscar Salguero
 *
 */

public class Main extends TabActivity {
    
	private static final String LOG_TAG = Main.class.getSimpleName(); 
	
	private TabHost tabHost;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showMainUI();
    }
    
    private void setTabs(){
    	tabHost = getTabHost();
		addTab(R.string.tab_title_invite, R.drawable.tab_invite_selector, new Intent().setClass(this, Invite.class));
		addTab(R.string.tab_title_group_list, R.drawable.tab_list_selector, new Intent().setClass(this, MessagesList.class));
    }
    
    private void addTab(int labelId, int drawableId, Intent intent) {
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
		TextView title = (TextView) tabIndicator.findViewById(R.id.tab_title);
		title.setText(labelId);
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);
		
	}
    
    protected void showMainUI(){
    	//Window Features
    	this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        this.setContentView(R.layout.main);
        this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);
        
        //Setting up Tabs
        setTabs();
        tabHost.setCurrentTab(0);

        //Badges on Tabs
	    BadgeTabWidget tabWidget = (BadgeTabWidget) this.findViewById(android.R.id.tabs);
	    BadgeTabManager.init(tabWidget);
    }
    
}