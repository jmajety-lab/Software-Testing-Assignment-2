package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.Connection;
import edu.umd.enpm614.assignment2.interfaces.FileSystem;
import edu.umd.enpm614.assignment2.interfaces.Persistence;

import javax.inject.Inject;


public class PersistenceMySQL implements Persistence {
	private FileSystem FS;
	private Connection Con;

	@Inject
	public PersistenceMySQL(FileSystem FS, Connection Con){
		this.FS = FS;
		this.Con = Con;
	}


	@Override
	public String getType() {
		return "MySQL Persistence";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());

		FS.run();
		Con.run();
		// invoke services here if applicable
		
		return true;
	}
}
