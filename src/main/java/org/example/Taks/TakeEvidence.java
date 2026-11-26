package org.example.Taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.example.Utils.ScreenShot;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TakeEvidence implements Interaction {
    private final String nombre;

    public TakeEvidence(String nombre) {
        this.nombre = nombre;
    }

    public static TakeEvidence named(String nombre) {
        return instrumented(TakeEvidence.class, nombre);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ScreenShot.tomar(actor, nombre);
    }
}