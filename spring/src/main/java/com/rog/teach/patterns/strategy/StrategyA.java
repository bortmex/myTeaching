package com.rog.teach.patterns.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategyA implements Strategy{
    @Override
    public void doStuff() {
        //implement algorithm A here
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.StrategyA;
    }
}
