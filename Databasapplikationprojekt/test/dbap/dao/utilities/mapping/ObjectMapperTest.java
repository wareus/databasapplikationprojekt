package dbap.dao.utilities.mapping;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Before;
import org.junit.Test;

public class ObjectMapperTest
{
	private ObjectMapper<DummyDTO> objectMapper;
	private ResultSet resultSet;
	
	@Before
	public void setUp() throws Exception
	{
		objectMapper = new ObjectMapper<DummyDTO>(DummyDTO.class);
		resultSet = mock(ResultSet.class);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("testString")).thenReturn("test");
		//when(resultSet.getDate("Date")).thenReturn(Date);
		
		ResultSetMetaData metaData = mock(ResultSetMetaData.class);
		
		when(metaData.getColumnCount()).thenReturn(2);
		when(metaData.getColumnName(1)).thenReturn("id");
		when(metaData.getColumnName(2)).thenReturn("testString");
		
		when(resultSet.getMetaData()).thenReturn(metaData);
		
	}

	@Test
	public void testMapping()
	{
		DummyDTO dto = objectMapper.map(resultSet);
		
		assertEquals(1, dto.id);
		assertEquals("test", dto.testString);
	}

}
