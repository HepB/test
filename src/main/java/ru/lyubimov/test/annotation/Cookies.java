package ru.lyubimov.test.annotation;

@ControlledObject(name = "biscuits")
public class Cookies {

    @StartObject
    public void createCookie() {}

    @StopObject
    public void stopCookie() {}
}
