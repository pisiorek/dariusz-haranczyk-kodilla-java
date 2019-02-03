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
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        /*getResource() jest to wywołanie metody, która wskazuje klasie ClassLoader, gdzie powinna szukać pliku, tu: w katalogu file,
         w którym umieściliśmy nasz plik names.txt (metoda ta zawsze szuka zasobów wewnątrz katalogu resources).
         Następnie pobieramy tak zwany “uchwyt” do pliku za pomocą metody getFile(), co pozwoli nam przekazać odwołanie
         do tego pliku w następnym kroku.
          Dzięki wywołaniu metody getFile() w poprzednim kroku, mamy już dostęp do pliku z imionami z poziomu kodu
          - teraz jesteśmy w stanie stworzyć obiekt reprezentujący nasz plik tekstowy file za pomocą klasy File, które
          również jest dostępna wewnątrz biblioteki Javy - java.io.*/
        //getPath(), zwraca nam dokładną ścieżkę do naszego pliku names.txt
        //Path path = Paths.get(file.getPath());  //możemy te linię pominąc i wstawić od razu nizej do metody lines() jako metoda statyczna Paths.get()

        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))){     //klasa Files pozwala czytać z pliku tekstowego za pomocą metody lines()

            //wynikiem wywołania lines() jest Stream obiektów typu String
            fileLines.forEach(System.out::println); //wyswietla cały powyzszy stream funkcja terminalną

        } catch (IOException e){
            System.out.println("Wystąpił wyjątek: " + e);
        }finally {
            System.out.println("Działanie finally - niezależnie od błędu. Wyświetlam się zawsze pomimo ");
        }
    }

        //System.out.println(file.getPath());

}
