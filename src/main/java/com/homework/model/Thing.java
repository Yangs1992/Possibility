package com.homework.model;

public class Thing {

    private final float possibilityOfHappening;

    public Thing(float possibilityOfHappening) {
        this.possibilityOfHappening = possibilityOfHappening;
    }

    public float getPossibilityOfHappening() {
        return possibilityOfHappening;
    }

    public float getPossibilityOfNotHappening() {
        return 1 - possibilityOfHappening;
    }

    public Thing and(float anothorThingPossibility) {
        return new Thing(getPossibilityOfHappening() * anothorThingPossibility);
    }

    public Thing or(float anothorThingHappenPossibility) {
        float result = getPossibilityOfHappening() * (1 - anothorThingHappenPossibility)
                + getPossibilityOfNotHappening() * anothorThingHappenPossibility;
        return new Thing(result);
    }
}
