package africa.semicolon.BlogApplication.config;

import org.hibernate.id.Configurable;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

public class ModelMapperConfig {
    private ModelMapper modelMapper = new ModelMapper();

    public ModelMapper getModelMapper() {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        return modelMapper;
    }
}
