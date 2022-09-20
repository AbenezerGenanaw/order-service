package edu.miu.cs590.orderservice.clients;


import edu.miu.cs590.orderservice.clients.config.OrderFeignConfig;
import edu.miu.cs590.orderservice.entity.PaymentRequest;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "order-service", url = "http://localhost:9090",configuration = OrderFeignConfig.class)
public interface OrderFeignClient {

//    @RequestMapping(
//            method = RequestMethod.POST,
//            value = "/api/payment/paypal",
////            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
    @PostMapping("/api/payments/paypal")
    ResponseEntity<String> processPayPalPayment(@RequestBody PaymentRequest paymentRequest);

//    @RequestMapping(
//            method = RequestMethod.POST,
//            value = "/api/payment/cc",
////            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
    @PostMapping("/api/payments/cc")
    ResponseEntity<String> processCcPayment(@RequestBody PaymentRequest paymentRequest);

    @Headers("X-Auth-Token: {access_token}")
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/payments/bank",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
//    @PostMapping("/api/payments/bank")
       ResponseEntity<String> processBankPayment(@RequestBody PaymentRequest paymentRequest);
}
