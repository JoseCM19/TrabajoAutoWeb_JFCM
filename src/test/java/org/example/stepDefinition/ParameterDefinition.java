package org.example.stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ParameterDefinition {
    @ParameterType("[A-Z][a-z]+")
    public Actor actor(String nombre) {
        return OnStage.theActorCalled(nombre);
    }

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }
}