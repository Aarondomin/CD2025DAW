### Análise (Requisitos)

Funcionais
- Programa que sume, reste, multiplique e divida dous números dados polo usuario a través do terminal.
- Lóxica e presentación deben estar en clases separadas.

Non Funcionais
- En linux
- En Kotlin
- En VSCode

### Deseño

```
├── pom.xml
├── src
│   ├── main
│   │   └── kotlin
│   │       └── com
│   │           └── exemplo
│   │               └── kotlindemo
│   │                   ├── Calculadora.kt
│   │                   ├── Main.kt
│   │                   └── VistaCalculadora.kt
│   └── test
│       └── kotlin
│           └── com
│               └── exemplo
│                   └── kotlindemo
│                       ├── CalculadoraTest.kt
│                       ├── MainTest.kt
│                       └── VistaCalculadoraTest.kt
```

### Implementación

Picar código.

### Probas

Probar polo menos a clase que fai operacións de xeito automático.

### Instalación

Crear executable e mandalo por correo.

### Mantemento

Non fai falta.

### Contorno de traballo

#### Compilar Kotlin en Linux

> sudo apt install kotlin

Co arquivo `Hello.kt`

```kotlin
fun main() {
    println("Hello, Kotlin!")
}
```

Compilar con:

> kotlinc Hello.kt -include-runtime -d Hello.jar

Executar

> java -jar Hello.jar