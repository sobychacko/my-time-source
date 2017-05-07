package foo.bar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTimeSourceApplicationTests {

	@Autowired
	private Source source;

	@Autowired
	private MessageCollector messageCollector;

	@Test
	public void testTimeGetsPublishedToSource() throws InterruptedException {
		Thread.sleep(1000);
		assertEquals(2, messageCollector.forChannel(source.output()).size());
	}
}
