Feature: Operaciones Matemáticas

  Scenario Outline: Multiplicación
    Given Se abre el programa de la calculadora
    When ingreso el <number1> y el <number2>
    Then escojo el operador de multiplicacion y debe coincidir con "<result>" en la calculadora

    Examples:
      | number1 | number2 | result |
      | 2       | 3       | 6      |
      | 5       | 4       | 20     |
      | 4       | 7       | 15     |
      | 3       | 2       | 10     |

  Scenario Outline: División
    Given Se abre el programa de la calculadora para division
    When ingreso el <number3> y el <number4> para dividir
    Then escojo el operador de división y debe coincidir con "<result>" en la calculadora

    Examples:
      | number3 | number4 | result |
      | 10      | 2       | 5      |
      | 25      | 5       | 5      |
      | 8       | 2       | 17     |
      | 5       | 3       | 2      |
