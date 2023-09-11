package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.Connection;
import edu.umd.enpm614.assignment2.interfaces.FileSystem;
import edu.umd.enpm614.assignment2.interfaces.Persistence;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class PersistenceOracle implements Persistence {
	private FileSystem FS;
	private Connection Con;

	@Inject
	public PersistenceOracle(FileSystem FS, Connection con){
		this.FS = FS;
		this.Con=con;
	}
	@Override
	public String getType() {
		return "Oracle Persistence";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		FS.run();
		Con.run();
		
		return true;
	}
}
