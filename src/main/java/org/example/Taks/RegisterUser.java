package org.example.Taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.HomePage;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisterUser implements Task {
    private final String usuario;
    private final String password;

    public RegisterUser(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public static RegisterUser withCredentials(String usuario, String password) {
        return instrumented(RegisterUser.class, usuario, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String etiqueta = usuario.isBlank() ? "campos_vacios" : usuario;
        actor.attemptsTo(
                Click.on(HomePage.BTN_SIGNUP),
                WaitUntil.the(HomePage.TXT_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(usuario).into(HomePage.TXT_USUARIO),
                Enter.theValue(password).into(HomePage.TXT_PASSWORD),
                TakeEvidence.named(etiqueta + "_1_formulario"),
                SubmitRegistration.andReadAlert(),
                TakeEvidence.named(etiqueta + "_2_resultado")
        );
    }
}