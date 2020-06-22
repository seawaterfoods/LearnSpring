package com.joe.designpattern.decoratorpattern.condiment;

import com.joe.designpattern.decoratorpattern.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
