package cloud.dalston.eureka.ribbonconsumer.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerService {
	@Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer(int a,int b) {
    	//构造一个不存在的url接口，即可验证熔断效果
    	//return restTemplate.getForObject("http://provider99/discovery/calculate?a="+a+"&b="+b, String.class);
    	
        return restTemplate.getForObject("http://provider1/discovery/calculate?a="+a+"&b="+b, String.class);
    }

    /**
     * 降级保护措施在此实现
     * @param a
     * @param b
     * @return
     */
    public String fallback(int a,int b) {
        return "fallback";
    }
}
