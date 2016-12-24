package com.satya.core.dto;

import java.util.Comparator;

import com.satya.core.bean.Notes;
public class NotesComparator implements Comparator<Notes> {
    public int compare(Notes n1, Notes n2) {
    	 return n1.toString().compareTo(n2.toString());
    }

	
} 