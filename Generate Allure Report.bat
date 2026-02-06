@echo off
cd /d "%~dp0"
allure serve target\allure-results
pause