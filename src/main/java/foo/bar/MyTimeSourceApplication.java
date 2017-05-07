package foo.bar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class MyTimeSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTimeSourceApplication.class, args);
	}

	@EnableBinding(Source.class)
	static class MyTimeSourceConfiguration {

		@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
		public String publishTime() {
			return new SimpleDateFormat("MM/dd/yy HH:mm:ss").format(new Date());
		}

	}
}
