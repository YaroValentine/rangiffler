package org.rangiffler.utils;

import com.codeborne.selenide.ElementsCollection;

import java.util.Random;

public class TestUtils {

    public static void selectRandomUnique(ElementsCollection options, String currentSelection) {
        Random rand = new Random();
        int randomIndex;
        do {
            randomIndex = rand.nextInt(options.size());
        } while (options.get(randomIndex).getText().equals(currentSelection));
        options.get(randomIndex).click();
    }

}
