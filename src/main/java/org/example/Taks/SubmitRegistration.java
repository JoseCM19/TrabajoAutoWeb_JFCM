package org.example.Taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.example.Pages.HomePage;
import org.example.Utils.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SubmitRegistration implements Interaction {
    public static SubmitRegistration andReadAlert() {
        return instrumented(SubmitRegistration.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Elemento Selenium puro: evita que Serenity revise la pagina tras el clic
        WebElement boton = HomePage.BTN_REGISTRAR.resolveFor(actor).getWrappedElement();
        boton.click();

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        String mensaje = alert.getText();
        alert.accept();
        actor.remember(Parameters.CLAVE_ALERTA, mensaje);
    }
}