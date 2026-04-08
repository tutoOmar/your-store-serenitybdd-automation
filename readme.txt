 # Your Store Automation

Proyecto de automatización del flujo de compra (invitado) sobre OpenCart usando Serenity BDD, Cucumber y el patrón Screenplay.

## Requisitos
- JDK 17+ instalado y `JAVA_HOME` configurado.
- Navegador Chrome instalado (se recomienda versión reciente).
- Opcional: `chromedriver` o que el sistema use el driver provisto por Selenium. Si hay discrepancias con CDP, puede requerirse una dependencia específica de `selenium-devtools`.

## Ejecutar la suite
Desde la raíz del proyecto ejecuta:

```bash
./gradlew clean test aggregate
```

Esto compila, ejecuta las pruebas y genera reportes de Serenity en `target/site/serenity/index.html`.

Para ejecutar una sola clase de tests (por ejemplo el runner principal):

```bash
./gradlew test --tests "com.yourstore.automation.runners.CartTestRunner"
```

## Diseño y notas importantes
- Las esperas son explícitas: el proyecto usa `WaitUntil.the(...).forNoMoreThan(N).seconds()` dentro de los `Task`.
- Las `Question` son puras: no realizan efectos secundarios ni esperas; sólo examinan el DOM y devuelven valores.
- Evitar `implicitlyWait`, `Thread.sleep` o esperas globales: estos fueron eliminados en la refactorización.

## Reportes
Los reportes HTML se generan en `target/site/serenity/index.html`. Abre ese archivo con tu navegador para ver resultados y capturas.

## Problemas comunes
- Si ves avisos sobre CDP/DevTools: puede deberse a la versión del navegador vs la versión de Selenium; revisar dependencias de `selenium-devtools` o instalar un `chromedriver` compatible.

## ¿Qué cambiar si las pruebas fallan?
- Revisar que el navegador esté actualizado y que las dependencias de Selenium sean compatibles.
- Ejecutar una única prueba localmente para aislar errores.
- Consultar `target/site/serenity/index.html` para el detalle de fallos y capturas.

---
