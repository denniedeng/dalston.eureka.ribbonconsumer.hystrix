package cloud.dalston.eureka.ribbonconsumer.hystrix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon with hystrix
 *
 */
@EnableHystrix /** use hystrix **/
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonConsumerByHystrixInitApp 
{
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(RibbonConsumerByHystrixInitApp.class).web(true).run(args);
	}
}
