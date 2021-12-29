package africa.semicolon.BlogApplication.service;

import africa.semicolon.BlogApplication.config.ModelMapperConfig;
import africa.semicolon.BlogApplication.data.model.User;
import africa.semicolon.BlogApplication.data.repository.UserRepository;
import africa.semicolon.BlogApplication.dtos.request.RegistrationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest{
    @Mock
    private UserRepository userRepository;
    @Captor
    ArgumentCaptor<User> userArgumentCaptor;
    private UserService userService;
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        ModelMapperConfig config = new ModelMapperConfig();
        modelMapper = config.getModelMapper();
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void testRegister(){
        RegistrationRequest request = RegistrationRequest.builder()
                .email("an@email.com")
                .dob(LocalDate.of(2010, 04, 25))
                .password("password").build();
        User user = modelMapper.map(request, User.class);
        user.setId("1");
        when(userRepository.save(any(User.class))).thenReturn(user);
        userService.register(request);
        verify(userRepository, times(1)).save(userArgumentCaptor.capture());
        User fromDatabase = userArgumentCaptor.getValue();
        assertAll(
                ()-> assertEquals(null
                        , fromDatabase.getId()),
                () -> assertEquals("an@email.com", fromDatabase.getEmail()),
                () -> assertEquals("password", fromDatabase.getPassword()),
                () -> assertEquals(LocalDate.of(2010, 04, 25), fromDatabase.getDob())
        );

    }

}