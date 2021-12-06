@echo off
setlocal enabledelayedexpansion

set "pattern= "
set "replace=-"

for %%I in (*.png) do (
    set "file=%%~I"
    ren "%%I" "!file:%pattern%=%replace%!"
)