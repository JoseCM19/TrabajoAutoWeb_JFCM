package org.example.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.example.Questions.AlertMessage;
import org.example.Taks.NagivateHome;
import org.example.Taks.RegisterUser;
import org.example.Utils.Parameters;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class RegistrarUsuario {

    @Given("que {actor} abre la pagina de Demoblaze")
    public void abrePagina(Actor actor) {
        actor.wasAbleTo(NagivateHome.demoblaze());
    }

    @When("{actor} se registra con un usuario nuevo y password {string}")
    public void registraUsuarioNuevo(Actor actor, String password) {
        actor.attemptsTo(RegisterUser.withCredentials(Parameters.usuarioNuevo(), password));
    }

    @When("{actor} se registra con usuario {string} y password {string}")
    public void registraConDatos(Actor actor, String usuario, String password) {
        actor.attemptsTo(RegisterUser.withCredentials(usuario, password));
    }

    @Then("{actor} deberia visualizar el mensaje {string}")
    public void validaMensaje(Actor actor, String mensaje) {
        actor.should(seeThat("el mensaje de alerta", AlertMessage.text(), containsString(mensaje)));
    }
}