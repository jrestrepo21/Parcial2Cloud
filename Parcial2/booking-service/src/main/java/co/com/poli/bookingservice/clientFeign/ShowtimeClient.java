package co.com.poli.bookingservice.clientFeign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "showtime-service", fallback = MovieClientImplHystrixFallback.class)
public interface ShowtimeClient {
}
