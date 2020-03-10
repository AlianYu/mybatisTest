package com.book.exception;

import java.util.HashMap;
import java.util.Map;

public class ParaException extends Exception{
    
    Map<String, String> errormap = new HashMap<String, String>();

    public Map<String, String> getErrormap() {
        return errormap;
    }

    public void setErrormap(Map<String, String> errormap) {
        this.errormap = errormap;
    }
    
    public void addErrorField(String fieldName,String message) {
        errormap.put(fieldName, message);
    }

    public boolean isErrorField() {
        // TODO Auto-generated method stub
        
        return !errormap.isEmpty();
    }

}
