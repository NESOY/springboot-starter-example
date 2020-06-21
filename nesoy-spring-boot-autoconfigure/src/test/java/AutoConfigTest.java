import static org.assertj.core.api.Assertions.assertThat;

import com.nesoy.configure.NesoyAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.web.client.RestTemplate;

public class AutoConfigTest {

    private ApplicationContextRunner applicationContextRunner
            = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(NesoyAutoConfiguration.class));

    @Test
    public void restTemplate() {
        applicationContextRunner
                .withPropertyValues("dooray.hook-url")
                .run(context -> assertThat(context).hasSingleBean(RestTemplate.class));
    }

    @Test
    public void noRestTemplateWithNoProperty() {
        applicationContextRunner
                .run(context -> assertThat(context).doesNotHaveBean(RestTemplate.class));
    }

//    @Test
//    public void doorayHookSender() {
//        applicationContextRunner
//                .withPropertyValues("dooray.hook-url")
//                .run(context -> assertThat(context).hasSingleBean(DoorayHookSender.class));
//    }
}