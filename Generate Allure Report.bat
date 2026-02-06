@echo off
cd /d "%~dp0"

echo Generating Allure report from:
echo %CD%
echo.

allure serve target\allure-results

pause