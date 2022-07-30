package co.com.poli.bookingservice.clientFeign;

import co.com.poli.bookingservice.helpers.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShowtimeClientImplHystrixFallback implements ShowtimeClient{
    private final ResponseBuild builder;
}
