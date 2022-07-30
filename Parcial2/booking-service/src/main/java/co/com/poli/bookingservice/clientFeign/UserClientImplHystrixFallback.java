package co.com.poli.bookingservice.clientFeign;

import co.com.poli.bookingservice.helpers.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserClientImplHystrixFallback implements UserClient{
    private final ResponseBuild builder;
}
