@echo off
setlocal
set MVNW_DIR=%~dp0
if defined JAVA_HOME (
  set "JAVA_EXE=%JAVA_HOME%\bin\java"
) else (
  set "JAVA_EXE=java"
)
"%JAVA_EXE%" -jar "%MVNW_DIR%\.mvn\wrapper\maven-wrapper.jar" %*

