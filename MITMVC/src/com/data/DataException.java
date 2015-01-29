package com.data;

public class DataException extends Exception {
public DataException(){
	super("Database Connection Error");
}
public DataException(String str){
	super(str);
}

	
}
