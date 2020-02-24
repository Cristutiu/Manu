import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Masini {

    public static void main(String[] args) throws IOException
    {

        Path path = Paths.get("src/ListaMasini").toAbsolutePath();

        //Filling our array
        List<String> titles = Files.lines(path).collect(Collectors.toList());

        String searchCar = getInput();

        showResults(searchCar, titles);

    }
    // user input method:
    public static String getInput(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introdu datele masini: ");

        String titleName = scanner.nextLine();
        scanner.close();

        return titleName;

    }

    public static void showResults(String searchName, List<String> titles) throws IOException{

        boolean inFile = titles.stream().anyMatch(p->p.equalsIgnoreCase(searchName));

        if(inFile) {

            System.out.println(searchName + " exista.");
        }else System.out.println(searchName + " nu exista.");

    }

}

