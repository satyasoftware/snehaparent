package com.satya.core.bean;

import java.util.ArrayList;
import java.util.List;

public class MedFrequency {

	private String frecode;
	private String frename;
	
	public MedFrequency(){}
	
	public MedFrequency(String frecode, String frename) {
		super();
		this.frecode = frecode;
		this.frename = frename;
	}
	public String getFrecode() {
		return frecode;
	}
	public void setFrecode(String frecode) {
		this.frecode = frecode;
	}
	public String getFrename() {
		return frename;
	}
	public void setFrename(String frename) {
		this.frename = frename;
	}
	public List<String> getDurUnitList(){
		List<String> durList=new ArrayList<String>();
		durList.add("Minutes");
		durList.add("Hours");
		durList.add("Days");
		durList.add("Weeks");
		durList.add("Months");
		durList.add("Years");
		return durList;
	}
	public List<MedFrequency> getFreqList(){
		List<MedFrequency> freList=new ArrayList<MedFrequency>();
		freList.add(new MedFrequency("A.M.","morning"));
		freList.add(new MedFrequency("ac","before meals"));
		freList.add(new MedFrequency("achs","before meals and at bedtime"));
		freList.add(new MedFrequency("alt. h.","every other hour"));
		freList.add(new MedFrequency("am, A.M.","in the morning; before noon"));
		freList.add(new MedFrequency("ap","before dinner"));
		freList.add(new MedFrequency("ATC","around the clock"));
		freList.add(new MedFrequency("bid, BID","twice a day"));
		freList.add(new MedFrequency("BT","bedtime"));
		freList.add(new MedFrequency("hs or HS","at bedtime, hours of sleep"));
		freList.add(new MedFrequency("mane","in the morning"));
		freList.add(new MedFrequency("n or noct.","in the night"));
		freList.add(new MedFrequency("noct. maneq.","night and morning"));
		freList.add(new MedFrequency("o.d.","once per day / overdose"));
		freList.add(new MedFrequency("p.r.n., prn","as needed"));
		freList.add(new MedFrequency("pc","after meals"));
		freList.add(new MedFrequency("PM","evening"));
		freList.add(new MedFrequency("q2h","every 2 hours"));
		freList.add(new MedFrequency("q3h","every 3 hours"));
		freList.add(new MedFrequency("q4h","every 4 hours"));
		freList.add(new MedFrequency("q6h","every 6 hours"));
		freList.add(new MedFrequency("q8h","every 8 hours"));
		freList.add(new MedFrequency("q12h","every 12 hours"));
		freList.add(new MedFrequency("q6PM, etc","every evening at 6 PM"));
		freList.add(new MedFrequency("qam","every morning"));
		freList.add(new MedFrequency("qh","every hour"));
		freList.add(new MedFrequency("qhs","each night at bedtime"));
		freList.add(new MedFrequency("qid, QD","four times a day"));
		freList.add(new MedFrequency("qn","Nightly or at bedtime"));
		freList.add(new MedFrequency("qod, QOD, q.o.d","every other day"));
		freList.add(new MedFrequency("TID, t.i.d.","three times a day"));
		freList.add(new MedFrequency("tid ac","three times a day before meals"));
		freList.add(new MedFrequency("TIN, t.i.n.","three times a night"));
		freList.add(new MedFrequency("TIW, tiw","3 times a week"));
		return freList;
	}
	
}
