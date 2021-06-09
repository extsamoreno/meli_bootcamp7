package desafio1.demo.Config;

import org.modelmapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.*;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();

        Provider<LocalDate> localDateProvider = new AbstractProvider<LocalDate>() {
            @Override
            public LocalDate get() {
                return LocalDate.now();
            }
        };

        Converter<String, LocalDate> toStringDate = new AbstractConverter<String, LocalDate>() {
            @Override
            protected LocalDate convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                return LocalDate.parse(source, format);
            }
        };

        modelMapper.createTypeMap(String.class, LocalDate.class);
        modelMapper.addConverter(toStringDate);
        modelMapper.getTypeMap(String.class, LocalDate.class).setProvider(localDateProvider);

        Converter<LocalDate,String> toDateString = new AbstractConverter<LocalDate, String>() {
            @Override
            protected String convert(LocalDate localDate) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                return localDate.format(format);
            }
        };

        modelMapper.createTypeMap(LocalDate.class, String.class);
        modelMapper.addConverter(toDateString);

//        TypeMap<Post, NewPostDTO> typeMap = modelMapper.createTypeMap(Post.class, NewPostDTO.class);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//        typeMap.addMappings(mapper ->
//            mapper.map(src-> src.getDate().format(formatter), NewPostDTO::setDate)
//        );

        return modelMapper;
    }
}
