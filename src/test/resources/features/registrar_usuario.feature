Feature: Registro de usuario en Demoblaze

  @smoke
  Scenario: Registro exitoso de un usuario nuevo
    Given que Juan abre la pagina de Demoblaze
    When Juan se registra con un usuario nuevo y password "Clave123"
    Then Juan deberia visualizar el mensaje "Sign up successful."

  @negative
  Scenario Outline: Registro no permitido
    Given que Juan abre la pagina de Demoblaze
    When Juan se registra con usuario "<usuario>" y password "<password>"
    Then Juan deberia visualizar el mensaje "<mensaje>"

    Examples:
      | usuario | password | mensaje                                |
      | test    | test     | This user already exist.               |
      |         |          | Please fill out Username and Password. |