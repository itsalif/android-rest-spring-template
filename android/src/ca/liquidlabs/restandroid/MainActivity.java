package ca.liquidlabs.restandroid;

import ca.liquidlabs.restandroid.model.RestCallback;
import ca.liquidlabs.restandroid.model.User;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/**
 * A Demo Activity showing how to handle REST requests
 * in a clean/organized way.
 * 
 * @author Abdullah Rubiyath
 */

public class MainActivity extends Activity implements RestCallback {

	private static EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText = (EditText) super.findViewById(R.id.input_twitter_user);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	/**
	 * Event Handler for Button Clicks in the Activity
	 * 
	 * @param v  The View from where button was tapped
	 * 
	 * @return always returns false
	 */
	public boolean onActionBtnClick(View v) {
		
		switch (v.getId()) {
			case R.id.btn_tweet:
				// handle tweets

				// get the twitter username
				String username = editText.getText().toString();
				
				/* get the user's instance and then retrieve the Tweets */
				User user = User.getInstance();
				user.getTweets(username, this);
				
				break;
			
			case R.id.btn_upload:
						// upload picture
						break;
		}		
		
		return false;
		
	}

	@Override
	public void preExecute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postExecute(String response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String inExecute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelExecute() {
		// TODO Auto-generated method stub
		
	}

}
