package com.swag_labs.other;

import com.github.javafaker.Faker;
import utils.PropertyManager;

public class TestData {
    public final String USER;
    public final String PASS;
    private final Faker generator;
    public final String FIRST_NAME;
    public final String LAST_NAME;

    public final String ZIP_CODE;

    public TestData() {
        USER = new PropertyManager().get("username");
        PASS = new PropertyManager().get("password");
        generator = new Faker();
        FIRST_NAME = generator.name().firstName();
        LAST_NAME = generator.name().lastName();
        ZIP_CODE = generator.address().countryCode();
    }
}