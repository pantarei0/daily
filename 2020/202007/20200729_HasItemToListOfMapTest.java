//IKP

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class HasItemToListOfMapTest {

	...
	
	@Test public void hasItem_하나만_존재하면_됨() { 
		
		map1.put("pk", "pk1");
		map1.put("key1", "value1");
		map1.put("key2", "value2");
		map2.put("pk", "pk2");
		map2.put("key1", "value1");
		map2.put("key3", "value3");
		
		assertThat(list, hasItem(hasKey("key2")));
		assertThat(list, hasItem(hasValue("pk1")));
		assertThat(list, hasItem(hasEntry("pk", "pk1")));
		assertThat(list, hasItem(hasEntry("key3", "value3")));
	}	
}
