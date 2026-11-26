package org.example.Questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.example.Utils.Parameters;

public class AlertMessage implements Question<String> {
    public static AlertMessage text() {
        return new AlertMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.recall(Parameters.CLAVE_ALERTA);
    }
}