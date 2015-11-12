package dbap.dao.utilities.mapping;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;

import dbap.dao.dto.base.BaseDTO;

public class ObjectMapperTest
{
	private ObjectMapper<DummyDTO> objectMapper;
	private ResultSet resultSet;
	
	@Before
	public void setUp() throws Exception
	{
		objectMapper = new ObjectMapper<>(DummyDTO.class);
		resultSet = mock(ResultSet.class);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getInt("test_string")).thenReturn(1);
		
	}

	@Test
	public void testMapping()
	{
		DummyDTO dto = objectMapper.map(resultSet);
		
		assertNotNull(dto);
		
		assertEquals(1, dto.id);
		assertEquals("test", dto.testString);
	}
	
	private class DummyDTO extends BaseDTO
	{
		public String testString;
	}

}
