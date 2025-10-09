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
kotlin-cli-calculator/
├─ build.sh
├─ run.sh
├─ .vscode/
│  ├─ tasks.json
│  └─ launch.json
└─ src/
   └─ main/
      └─ kotlin/
         └─ com/example/
            ├─ calculator/Calculator.kt
            ├─ ui/ConsoleUI.kt
            └─ Main.kt
```

Dar permisos de execución para os scripts

> chmod +x build.sh run.sh

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