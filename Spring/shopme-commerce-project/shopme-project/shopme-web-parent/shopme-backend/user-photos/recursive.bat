for /d /r . %%D in (*) do (
    copy replace.bat "%%D\replace.bat"
    cd "%%D"
    replace.bat
    del replace.bat
    cd..
)