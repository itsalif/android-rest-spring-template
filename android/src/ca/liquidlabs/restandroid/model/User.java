package ca.liquidlabs.restandroid.model;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.os.AsyncTask;

/**
 * User Model retrieves tweets from Twitter (using GET)
 * and also uploads a File using (POST)
 * 
 * It is not Thread-Safe!
 * 
 * @author Abdullah Rubiyath
 *
 */

public class User {

	private static User instance = null;	
	
	/* keeps track of the current AsyncTask thats running/executing */
	private static AsyncTask<Void, Void, String> currentTask = null;	
	
	// singleton - this is not thread-safe
	private User() {}
	
	
	/**
	 * Creates an Instance of the User 
	 * @return The User Singleton Object
	 */
	public User getInstance() 
	{
		if (instance == null) {
			instance = new User();
		}
		
		return instance;
	}
	
	
	/**
	 * Returns the Tweets from the User (uses Twitter API 1.0)
	 * @param user		The Twitter username
	 * @param callback  The callback
	 */
	public void getTweets(String user, RestCallback c) {
		
		final String url = "http://api.twitter.com/1/users/show.json?screen_name=" + user;
		currentTask = new TweetTask(url, c);
		currentTask.execute();
	}
	
	
	/**
	 * An Inner Class which retrieves the Tweets of a Particular User
	 */
	private class TweetTask extends AsyncTask<Void, Void, String>
	{
		private final String url;
		private final RestCallback callback;
		
		/**
		 * Creates a new TweetTask Object with url and callback
		 * @param u	The url to be accessed
		 * @param c The callback to be invoked
		 */
		public TweetTask(String u, RestCallback c)
		{
			url = u;
			callback = c;
		}
		

		@Override
		protected String doInBackground(Void... params) {
			
			/* Using RestTemplate */
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
			
			/* make a GET request and return the response */
			String response = restTemplate.getForObject(url, String.class);
			
			return response;
		}
		
		/**  
		 * @see android.os.AsyncTask#onPreExecute()
		 */
		@Override
		protected void onPreExecute() {
			callback.preExecute();
		}
		
		@Override
		protected void onPostExecute(String response) {			
			callback.postExecute(response);			
		}		
		
		
	}
		
	
	/**
	 * Cancels a Currently Running Task
	 */
	public void cancelTask() 
	{
		if (currentTask != null) {
			currentTask.cancel(true);
		}
	}
}
