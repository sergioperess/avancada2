    Baixe a biblioteca JSON simples (json-simple-1.1.1.jar) a partir deste link: https://code.google.com/archive/p/json-simple/downloads

    Coloque o arquivo "json-simple-1.1.1.jar" no mesmo diretório onde estão os arquivos Device1.java e Device2.java.

    Abra o terminal (ou prompt de comando) e navegue até o diretório que contém os arquivos .java e o arquivo "json-simple-1.1.1.jar".

    Compile os arquivos novamente, incluindo o arquivo "json-simple-1.1.1.jar" no classpath usando o seguinte comando:

    javac -cp json-simple-1.1.1.jar -Xlint:unchecked Device1.java Device2.java


   Em um terminal, execute primeiramente o `Device1`, que estará na escuta por conexõe:

   java -cp .;json-simple-1.1.1.jar Device1

   Em outro terminal, execute o `Device2` para receber a mensagem:

   java -cp .;json-simple-1.1.1.jar Device1
