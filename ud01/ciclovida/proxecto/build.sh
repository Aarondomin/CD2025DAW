#!/usr/bin/env bash
set -euo pipefail
mkdir -p build
kotlinc src/main/kotlin -include-runtime -d build/app.jar
echo "✅ Compilado: build/app.jar"