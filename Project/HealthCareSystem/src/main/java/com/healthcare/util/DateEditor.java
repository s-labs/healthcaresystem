package com.healthcare.util;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport {

    public void setAsText(String value) {
      try {
    	  System.out.println("--------------date-------------------");
        setValue(new SimpleDateFormat("dd/MM/yyyy").parse(value));
      } catch(ParseException e) {
        setValue(null);
      }
    }

    public String getAsText() {
    	System.out.println("--------------get as -------------------");
      String s = "";
      if (getValue() != null) {
         s = new SimpleDateFormat("dd/MM/yyyy").format((Date) getValue());
      }
      return s;
    }
}