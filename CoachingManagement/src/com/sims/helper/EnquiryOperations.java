package com.sims.helper;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.sims.dao.EnquiryDAO;
import com.sims.dto.enquiry.Enquiry;

public interface EnquiryOperations {
	
	public static Enquiry searchEnquiry(Integer eid) throws ClassNotFoundException, SQLException{
		Iterator<Entry<Integer, Enquiry>> it=enquiryIterator();
		Enquiry enquiry = null;
		Map.Entry<Integer, Enquiry> me=null;
		while(it.hasNext()) {
		me=(Entry<Integer, Enquiry>)it.next();
		enquiry = (Enquiry)(me.getValue());	
		if(enquiry.getEnquiryId()==eid)
			break;
		}
		return enquiry;
	}
	
	public static Iterator<Entry<Integer, Enquiry>> enquiryIterator() throws ClassNotFoundException, SQLException{
		EnquiryDAO obj = new EnquiryDAO();
		TreeMap<Integer,Enquiry> enquiry=obj.fetchEnquiry();
		Set<Entry<Integer, Enquiry>> set=enquiry.entrySet();
		Iterator<Entry<Integer, Enquiry>> it=set.iterator();
		return it;
	}
	
//	try {
//		Enquiry e=EnquiryOperations.searchEnquiry(32);
//		System.out.println(e.getFirstName());
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
}
