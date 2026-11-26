package org.example.Utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShot {
    private static final Path CARPETA = Paths.get("evidencias");
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-SSS");

    public static void tomar(Actor actor, String nombre) {
        try {
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.createDirectories(CARPETA);
            Files.write(CARPETA.resolve(LocalDateTime.now().format(FORMATO) + "_" + nombre + ".png"), png);
        } catch (Exception e) {
            System.err.println("No se pudo guardar la captura '" + nombre + "': " + e.getMessage());
        }
    }
}