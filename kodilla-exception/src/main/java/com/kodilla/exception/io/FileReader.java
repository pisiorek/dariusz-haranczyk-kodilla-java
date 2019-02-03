package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public  void readFile() {

        /*ClassLoader jest to klasa odpowiedzialna
        za odnalezienie klas i plików wewnątrz naszej aplikacji - pozwoli nam to odwołać się do naszego pliku
        z imionami.*/
        ClassLoader classLoader = getClass().getClassLoader();

        /*Jest to wywołanie metody, która wskazuje klasie ClassLoader, gdzie powinna szukać pliku, tu: w katalogu file,
         w którym umieściliśmy nasz plik names.txt (metoda ta zawsze szuka zasobów wewnątrz katalogu resources).
         Następnie pobieramy tak zwany “uchwyt” do pliku za pomocą metody getFile(), co pozwoli nam przekazać odwołanie
         do tego pliku w następnym kroku.
          Dzięki wywołaniu metody getFile() w poprzednim kroku, mamy już dostęp do pliku z imionami z poziomu kodu
          - teraz jesteśmy w stanie stworzyć obiekt reprezentujący nasz plik tekstowy za pomocą klasy File, które
          również jest dostępna wewnątrz biblioteki Javy - java.io.*/
        File file = new File(classLoader.getResource("file/names.txt").getFile());

        //getPath(), zwróca nam dokładną ścieżkę do naszego pliku names.txt
        //Path path = Paths.get(file.getPath());
        Path path = Paths.get("file/name.txt");

        try {
            //klasa Files pozwala czytać z pliku tekstowego za pomocą metody lines()
            //wynikiem wywołania lines() jest Stream obiektów typu String
            Stream<String> fileLines = Files.lines(path);

        } catch (IOException e){
            System.out.println("Wystąpił wyjątek");
    }
        //System.out.println(file.getPath());
    }
}
