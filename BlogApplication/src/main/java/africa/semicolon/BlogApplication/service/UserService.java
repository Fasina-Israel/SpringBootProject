package africa.semicolon.BlogApplication.service;

import africa.semicolon.BlogApplication.dtos.request.RegistrationRequest;
import africa.semicolon.BlogApplication.dtos.response.UserDto;

public interface UserService {
    UserDto register(RegistrationRequest registrationRequest);
}
