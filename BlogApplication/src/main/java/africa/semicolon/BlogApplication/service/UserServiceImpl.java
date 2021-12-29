package africa.semicolon.BlogApplication.service;


import africa.semicolon.BlogApplication.config.ModelMapperConfig;
import africa.semicolon.BlogApplication.data.model.User;
import africa.semicolon.BlogApplication.data.repository.UserRepository;
import africa.semicolon.BlogApplication.dtos.request.RegistrationRequest;
import africa.semicolon.BlogApplication.dtos.response.UserDto;
import org.modelmapper.ModelMapper;



public class UserServiceImpl implements UserService{
    private ModelMapperConfig config = new ModelMapperConfig();
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository repository) {
        userRepository = repository;
    }

    @Override
    public UserDto register(RegistrationRequest registrationRequest) {
        ModelMapper modelMapper = config.getModelMapper();
        User user =  modelMapper.map(registrationRequest, User.class);
        User savedUser = userRepository.save(user);
        UserDto userDto = new UserDto(savedUser.getEmail(), savedUser.getDob(), Long.valueOf(savedUser.getId()));
        return userDto;
    }
}
