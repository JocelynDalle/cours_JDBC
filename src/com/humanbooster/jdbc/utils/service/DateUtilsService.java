package com.humanbooster.jdbc.utils.service;

import java.util.Calendar;
import java.util.Date;

public interface DateUtilsService {

	public java.sql.Date convertCalendarToSQLDate(Calendar calen);

	public java.sql.Date convertUtilDateToSQLDate(Date date);

	public Date convertCalendarToDate(Calendar calen);

}
