#에코, 폿팅,ybd


   Command Entered                 After Shell Expansion           After echo Command Processing
       echo hi\\\\there                echo hi\\there                  hi\there
       echo 'hi\\\\there'              echo 'hi\\\\there'              hi\\there
       echo "hi\\\\there'              echo "hi\\there"                hi\there





       3    To use the echo command with pattern-matching characters, enter:

            echo  The  back-up  files  are:  *.bak
            This usage displays the message The back-up files are: followed by the file names in the
            current directory ending with .bak.
       4    To add a single line of text to a file, enter:

            echo  Remember  to  set  the  shell  search  path  to  $PATH.  >>notes
            This usage adds the message to the end of the file notes after the shell substitutes the
            value of the PATH shell variable.
       5    To write a message to the standard error output, enter:

            echo  Error:  file  already  exists.  >&2

