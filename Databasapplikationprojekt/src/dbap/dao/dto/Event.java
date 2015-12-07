package dbap.dao.dto;

import java.time.LocalDateTime;

import dbap.dao.dto.base.BaseDTO;

public class Event extends BaseDTO{
	public String title;
    public LocalDateTime startDate,endDate;
    public int userID, projectID;
    
}
