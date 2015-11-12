package dbap.dao.dto.base;

import java.util.HashSet;

public class BaseDTO {
	public int id;
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof BaseDTO)
			return id==((BaseDTO)obj).id;
		return false;
	}
}
