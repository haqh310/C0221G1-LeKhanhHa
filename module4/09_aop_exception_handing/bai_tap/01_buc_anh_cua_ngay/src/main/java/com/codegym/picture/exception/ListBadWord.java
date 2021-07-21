package com.codegym.picture.exception;

import java.util.ArrayList;
import java.util.List;

public class ListBadWord {
   public static List<String> listBadWords;

    static {
        listBadWords = new ArrayList<>();
        listBadWords.add("abc");
        listBadWords.add("123");
        listBadWords.add("toan");
        listBadWords.add("dkm");
        listBadWords.add("000");
        listBadWords.add("dm");
    }
}
