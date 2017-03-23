package com.vish.ff;

import org.ff4j.spring.autowire.FF4JFeature;

public class FeaturesBean {
    @FF4JFeature("hello")
    public  Boolean helloFeature;

    @FF4JFeature("multiplePayeeCodes")
    private Boolean multiplePayeeCodes;


}
