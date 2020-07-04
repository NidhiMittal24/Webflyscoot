package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Date d=new Date(2020,6,8);  
        Date d2=new Date(2020,6,5);  
        System.out.println("Date 'd' is after Date 'd2' : "+d.after(d2)); 
		}

	}


