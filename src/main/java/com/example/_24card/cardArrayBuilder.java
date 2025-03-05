package com.example._24card;


public class cardArrayBuilder {

    int counter = 1;
    String[] deck = new String[52];

    public void cardfiller() {

        for (int i = 0; i < deck.length; i++) {
            if (i <= 12) {
                deck[i] = "Diamond of: " + counter;
                counter++;
            } else if (i <= 25) {
                if ( i == 13 ) {
                    counter = 1;
                }
                deck[i] = "Spade of: " + counter;
                counter++;
            } else if (i <= 38) {
                if ( i == 26) {
                    counter = 1;
                }
                deck[i] = "Heart of: " + counter;
                counter++;
            } else {
                if ( i == 39) {
                    counter = 1;
                }
                deck[i] = "Clubs of: " + counter;
                counter++;
            }
            // System.out.println(deck[i]);
        }
    }
}

