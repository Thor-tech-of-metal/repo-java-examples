package com.thor.tech.optional.service;

import com.thor.tech.optional.model.DisplayFeatures;
import com.thor.tech.optional.model.Mobile;
import com.thor.tech.optional.model.ScreenResolution;

import java.util.Optional;

public class MobileService {

    public Integer getMobileScreenWidth(Optional<Mobile> mobile){

        return mobile.flatMap(Mobile::getDisplayFeatures)
                .flatMap( DisplayFeatures::getResolution)
                .map( ScreenResolution::getWidth)
                .orElse(0);

    }

}
