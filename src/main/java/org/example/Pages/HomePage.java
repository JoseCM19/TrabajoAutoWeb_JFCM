package org.example.Pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target BTN_SIGNUP = Target.the("boton Sign up").located(By.id("signin2"));
    public static final Target TXT_USUARIO = Target.the("campo usuario").located(By.id("sign-username"));
    public static final Target TXT_PASSWORD = Target.the("campo password").located(By.id("sign-password"));
    public static final Target BTN_REGISTRAR = Target.the("boton registrar")
            .located(By.cssSelector("button[onclick='register()']"));
}