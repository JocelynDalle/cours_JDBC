package com.humanbooster.jdbc.utils.manager;

import java.util.Calendar;
import java.util.Date;

import com.humanbooster.jdbc.utils.service.DateUtilsService;

public class DateUtils implements DateUtilsService {

	public java.sql.Date convertCalendarToSQLDate(Calendar calen) {
		return new java.sql.Date(calen.getTime().getTime());
	}

	public Date convertCalendarToDate(Calendar calen) {
		return calen.getTime();
	}

	public java.sql.Date convertUtilDateToSQLDate(Date date) {
		return new java.sql.Date(date.getTime());
	}

}
