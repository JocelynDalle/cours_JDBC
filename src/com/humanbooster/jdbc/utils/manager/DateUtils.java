package com.humanbooster.jdbc.utils.manager;

import java.util.Calendar;

import com.humanbooster.jdbc.utils.service.DateUtilsService;

public class DateUtils implements DateUtilsService {

	public java.sql.Date convertCalendarToSQLDate(Calendar calen) {
		
		return new java.sql.Date(calen.getTime().getTime());
	}
	

	
}
