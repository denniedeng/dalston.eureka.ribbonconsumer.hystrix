package cloud.dalston.eureka.ribbonconsumer.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;
    
    /**
     * 使用ribbon进行服务调用(包括hystrix熔断)
     * @param a
     * @param b
     * @return
     * @throws InterruptedException 
     */
    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public String add(@RequestParam("a")Integer a,@RequestParam("b")Integer b) throws InterruptedException {
    	System.out.println(">>>>>>>> a is " + a);
    	System.out.println(">>>>>>>> b is " + b);
       return consumerService.consumer(a, b);
    }
}
