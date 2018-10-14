package _5_wyszukiwarka_slow;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Szukaj {

    public static void main(String[] args) {
        String[] niewazneSlowa = {"oraz", "ponieważ", "się", "żeby", "aby", "dlatego",
                "czy", "czyli", "było", "była", "pod", "nad", "mogą", "może"};
        getHeadersArr("https://www.onet.pl", "popular_words.txt");
        filterHeadersArr("popular_words.txt", niewazneSlowa);

    }

    static void filterHeadersArr(String fileName, String[] filteredWords) {
        String fileName2 = "filtered_" + fileName;
        Path path = Paths.get(fileName);
        Path path2 = Paths.get(fileName2);
        ArrayList<String> lista = new ArrayList<>();

        try {
            for (String line : Files.readAllLines(path)) {
                for (int i = 0; i < filteredWords.length; i++) {
                    if (line.equalsIgnoreCase(filteredWords[i])) {
                        line = "";
                    }
                }
                if (line.length() > 3) {
                    lista.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.write(path2, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void getHeadersArr(String url, String fileName) {
        Connection connect = Jsoup.connect(url);
        String[] headers = new String[0];
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
//            String[] temp = new String[links.size()];
            String[] temp = new String[0];
            String[] result;
            int counter = 0;
            for (Element elem : links) {
                String[] temp1 = elem.text().replaceAll("\\.", " ")
                        .replaceAll("!", " ").replaceAll(":", " ").split(" ");
                counter += temp1.length;
                result = Arrays.copyOf(temp, temp.length + temp1.length);
                System.arraycopy(temp1, 0, result, temp.length, temp1.length);
                temp = result;

            }
            headers = temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Problem z zapisem do pliku.");
            }
        }
        List<String> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(headers));
        try {
            Files.write(path, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
