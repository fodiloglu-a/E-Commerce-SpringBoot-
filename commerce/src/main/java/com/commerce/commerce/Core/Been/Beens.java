package com.commerce.commerce.Core.Been;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Component
public class Beens {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
