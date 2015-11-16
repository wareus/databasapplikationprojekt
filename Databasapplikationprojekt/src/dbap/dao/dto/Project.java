package dbap.dao.dto;

import java.util.Date;


import dbap.dao.dto.base.BaseDTO;

public class Project extends BaseDTO {
	private String name;

	private Date date;
	
	public static java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return sqlDate;
    }
}
    
 
