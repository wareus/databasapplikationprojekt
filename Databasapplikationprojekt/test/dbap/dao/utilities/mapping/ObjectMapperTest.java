package dbap.dao.utilities.mapping;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

public class ObjectMapperTest
{
	private ObjectMapper<DummyDTO> objectMapper;
	private ResultSet resultSet;
	private Timestamp timestamp;
	
	@Before
	public void setUp() throws Exception
	{
		objectMapper = new ObjectMapper<DummyDTO>(DummyDTO.class);
		resultSet = mock(ResultSet.class);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("testString")).thenReturn("test");
		
		timestamp = new Timestamp(1447766874);
		when(resultSet.getTimestamp("testDate")).thenReturn(timestamp);
		
		ResultSetMetaData metaData = mock(ResultSetMetaData.class);
		
		when(metaData.getColumnCount()).thenReturn(3);
		when(metaData.getColumnName(1)).thenReturn("id");
		when(metaData.getColumnName(2)).thenReturn("testString");
		when(metaData.getColumnName(3)).thenReturn("testDate");
		
		when(resultSet.getMetaData()).thenReturn(metaData);
		
	}

	@Test
	public void testMapping()
	{
		DummyDTO dto = objectMapper.map(resultSet);
		
		assertEquals(1, dto.id);
		assertEquals("test", dto.testString);
		assertEquals(timestamp.toLocalDateTime(), dto.testDate);
	}

}
