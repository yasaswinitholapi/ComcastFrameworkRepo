package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
public int getRandomNumber() {
	Random random=new Random();
	int randomNumber=random.nextInt(5000);
	return randomNumber;
}
public String getSystemDateyyyyDDMM() {
	Date dateObj=new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	String date= sdf.format(dateObj);
	return date;	
}
public String getRequiredDateYYYYDDMM(int days) {
	//System.out.println(dateobj.toString());
	Date dateObj=new Date();
	System.out.println(dateObj);
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	sim.format(dateObj);
	Calendar cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,days);
	String reqdDate=sim.format(cal.getTime());
	return reqdDate;
}
}
