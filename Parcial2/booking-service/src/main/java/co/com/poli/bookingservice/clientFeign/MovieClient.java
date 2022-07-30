package co.com.poli.bookingservice.clientFeign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "movie-service", fallback = MovieClientImplHystrixFallback.class)
public interface MovieClient {

}
