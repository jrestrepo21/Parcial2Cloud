package co.com.poli.userservice;

import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.persistence.repository.UserRepository;
import co.com.poli.userservice.service.UserService;
import co.com.poli.userservice.service.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserServiceMockTest {
    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void begin() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);

        User user = User.builder()
                .id(8L)
                .name("Felipe")
                .lastName("Johan").build();
        Mockito.when(userRepository.findById(8L))
                .thenReturn(Optional.of(user));
    }

    @Test
    public void when_findById_return_name() {
        User user = userService.findById(8L);
        Assertions.assertThat(user.getName().equals("Felipe"));
    }
}
