package ca.liquidlabs.restandroid.model;


/**
* Defines all the methods that are related to REST callback.
* 
* This interface is required to be implemented by the Activities
* on which Models are invoked, and so these methods can be
* invoked/called back from the Models.
* 
* @author Abdullah Rubiyath
*
*/
public interface RestCallback {
	
	/* This should be invoked by {@link AsyncTask#onPreExecute()} on AsyncTask */
	public void preExecute();
	
	/* This should be invoked by {@link AsyncTask#onPostExecute()} on AsyncTask */
	public void postExecute(String response);
	
	/* This could be invoked by {@link AsyncTask#doInBackground()} on AsyncTask */
	public String inExecute();
	
	/* This could be used / invoked to cancel a running AsyncTask */
	public void cancelExecute();
}
