package test.pivotal.pal.tracker.allocations;

import io.pivotal.pal.tracker.allocations.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class AllocationsAppTest {

    @Test
    //@RunWith(SpringJUnit4ClassRunner.class)
    //@TestPropertySource(properties = "debug=true")
    public void embedded() {
        App.main(new String[]{});

        String response = new RestTemplate().getForObject("http://localhost:8181/allocations?projectId=0", String.class);

        assertThat(response).isEqualTo("[]");
    }
}
