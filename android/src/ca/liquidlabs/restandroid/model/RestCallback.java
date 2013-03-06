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
	
	public void preExecute();
	public void postExecute(String response);
	public String inExecute();
	public void cancelExecute();
}
