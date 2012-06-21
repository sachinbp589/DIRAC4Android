package dirac.android;


import oauth.signpost.OAuth;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserProfileActivity  extends Activity {



	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user);
		setTitle("User Profile");
		
		
		Button launchOauth = (Button) findViewById(R.id.getGrant);
		Button clearCredentials = (Button) findViewById(R.id.clearGrant);
		Button doneB = (Button) findViewById(R.id.doneUserButton);

		launchOauth.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		    	startActivity(new Intent().setClass(v.getContext(), PrepareRequestTokenActivity.class));	

		    }
		});
		
		



		doneB.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		    finish();		
		    }
		});
		

		clearCredentials.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		    clearCredentials();	
		    }
		});
		
		
		
		
		
		
		
	}
	
	private void clearCredentials() {

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		final Editor edit = prefs.edit();
		edit.remove(OAuth.OAUTH_TOKEN);
		edit.remove(OAuth.OAUTH_TOKEN_SECRET);
		edit.commit();
		Toast.makeText(this.getApplicationContext(), "Your credentials have been cleared", Toast.LENGTH_SHORT).show();
	}


}
		