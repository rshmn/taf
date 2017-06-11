package qa.taf.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by rushman on 6/10/17.
 */
public class Collections {

    public static void main(String[] args) {



        List<String> languages = Arrays.asList("Java","C#","Python","PHP");

        for (String l: languages) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}