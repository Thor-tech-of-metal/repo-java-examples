package com.thor.tech.java8.examples.optional;

import com.thor.tech.java8.examples.optional.model.DisplayFeatures;
import com.thor.tech.java8.examples.optional.model.Mobile;
import com.thor.tech.java8.examples.optional.model.ScreenResolution;
import com.thor.tech.java8.examples.optional.service.MobileService;

import java.util.Optional;

public class MobileTesterWithOptional {

    public static void main(String[] args) {

        final ScreenResolution resolution = new ScreenResolution(750,1334);
        final DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
        final Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));
        final MobileService mService = new MobileService();

        final int width = mService.getMobileScreenWidth(Optional.of(mobile));

        System.out.println("Apple iPhone 6s Screen Width = " + width);

        final Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.empty());
        final int width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
        System.out.println("Apple iPhone 16s Screen Width = " + width2);
    }
}