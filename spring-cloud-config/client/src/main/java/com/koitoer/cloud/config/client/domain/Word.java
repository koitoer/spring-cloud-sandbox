package com.koitoer.cloud.config.client.domain;

/**
 * Created by mauricio.mena on 07/06/2016.
 */
public class Word {

    public String word;

    public Word() {
        super();
    }

    public Word(String word) {
        this();
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String getString() {
        return getWord();
    }

    public void setWord(String word) {
        this.word = word;
    }


}