package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.Authentication;
import edu.umd.enpm614.assignment2.interfaces.Frontend;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

public class FrontendGWT implements Frontend {

	private Authentication Auth;

	@Inject
	public FrontendGWT(Authentication Auth){
		this.Auth = Auth;
	}
	@Override
	public String getType() {
		return "GWT Frontend";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		Auth.run();
		
		return true;
	}
}
