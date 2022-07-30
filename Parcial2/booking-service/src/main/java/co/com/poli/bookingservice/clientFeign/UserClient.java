package co.com.poli.bookingservice.clientFeign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-service", fallback = MovieClientImplHystrixFallback.class)
public interface UserClient {
}
