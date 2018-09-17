package com.thor.tech.java8.examples.optional.service;

import com.thor.tech.java8.examples.optional.model.DisplayFeatures;
import com.thor.tech.java8.examples.optional.model.Mobile;
import com.thor.tech.java8.examples.optional.model.ScreenResolution;

import java.util.Optional;

public class MobileService {

    public Integer getMobileScreenWidth(Optional<Mobile> mobile){

        return mobile.flatMap(Mobile::getDisplayFeatures)
                .flatMap( DisplayFeatures::getResolution)
                .map( ScreenResolution::getWidth)
                .orElse(0);

    }

}
