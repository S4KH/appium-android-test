package com.example.hellosharedpreference;

public class BeaconInfoExtractor {

	public String obtainUUID(String str){
		String uuid=null;
		if(str.length()>=41) {
			uuid = str.substring(5, 41);
		}
		return uuid;
	}
	
	public String obtainMajorID(String str){
		String majorID=null;
		if(str.length()>=48) {
			majorID=str.substring(47, 48);	
		}
		return majorID;
	}
	
	public String obtainMinorID(String str){
		String minorID=null;
		int len = str.length();
		if(len>=54) {
			minorID=str.substring(54, len);	
		}
		return minorID;
	}
}
