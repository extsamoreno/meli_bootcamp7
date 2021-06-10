package desafio1.demo.Config;

import org.modelmapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.*;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationConfig {

    //Model Mapper configuration to map automatically from LocalDate to String, and fom String to LocalDate.
    @Bean
    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();

        Provider<LocalDate> localDateProvider = new AbstractProvider<>() {
            @Override
            public LocalDate get() {
                return LocalDate.now();
            }
        };

        Converter<String, LocalDate> toStringDate = new AbstractConverter<>() {
            @Override
            protected LocalDate convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("d-M-y");
                return LocalDate.parse(source, format);
            }
        };

        modelMapper.createTypeMap(String.class, LocalDate.class);
        modelMapper.addConverter(toStringDate);
        modelMapper.getTypeMap(String.class, LocalDate.class).setProvider(localDateProvider);

        Converter<LocalDate,String> toDateString = new AbstractConverter<>() {
            @Override
            protected String convert(LocalDate localDate) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("d-M-y");
                return localDate.format(format);
            }
        };

        modelMapper.createTypeMap(LocalDate.class, String.class);
        modelMapper.addConverter(toDateString);

        return modelMapper;
    }
}

