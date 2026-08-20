@echo off
setlocal
if "%~1"=="" ( echo usage: new ProblemName [folder] & exit /b 1 )
set NAME=%~1
set FOLDER=%~2
if "%FOLDER%"=="" set FOLDER=striver-a2z\step15-graphs\Problems-On-BFS-DFS
if not exist "%FOLDER%" mkdir "%FOLDER%"
set FILE=%FOLDER%\%NAME%.java
if exist "%FILE%" ( echo %FILE% already exists & exit /b 1 )
(
echo /*
echo  * Problem: %NAME% —
echo  * Solved: %DATE% ^| TC:
echo  * Revisit: [date]
echo  */
echo import java.util.*;
echo.
echo public class %NAME% {
echo   public static void main^(String[] args^) {
echo.
echo   }
echo }
) > "%FILE%"
echo Created %FILE%
