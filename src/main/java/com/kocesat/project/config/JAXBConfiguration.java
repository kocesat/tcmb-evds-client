package com.kocesat.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;
import java.util.HashMap;
import java.util.Map;

/**
 * Not used anywhere
 */
@Configuration
public class JAXBConfiguration {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jx2m = new Jaxb2Marshaller();
        jx2m.setPackagesToScan("com.kocesat.project");
        Map<String, Object> marshallerProps = new HashMap<>();
        marshallerProps.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jx2m.setMarshallerProperties(marshallerProps);
        return jx2m;
    }
}
