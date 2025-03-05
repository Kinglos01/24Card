package com.example._24card;


public class cardArrayBuilder {

    int counter = 2;
    String[] deck = new String[52];
    int[] numValueOfDeck = new int[52];

    public void cardfiller() {

        // Array of all paths to their respective cards in the resource folder

        deck[0] = "/images/2_of_clubs.png";
        deck[1] = "/images/3_of_clubs.png";
        deck[2] = "/images/4_of_clubs.png";
        deck[3] = "/images/5_of_clubs.png";
        deck[4] = "/images/6_of_clubs.png";
        deck[5] = "/images/7_of_clubs.png";
        deck[6] = "/images/8_of_clubs.png";
        deck[7] = "/images/9_of_clubs.png";
        deck[8] = "/images/10_of_clubs.png";
        deck[9] = "/images/jack_of_clubs2.png";
        deck[10] = "/images/queen_of_clubs2.png";
        deck[11] = "/images/king_of_clubs2.png";
        deck[12] = "/images/ace_of_clubs.png";
        deck[13] = "/images/2_of_spades.png";
        deck[14] = "/images/3_of_spades.png";
        deck[15] = "/images/4_of_spades.png";
        deck[16] = "/images/5_of_spades.png";
        deck[17] = "/images/6_of_spades.png";
        deck[18] = "/images/7_of_spades.png";
        deck[19] = "/images/8_of_spades.png";
        deck[20] = "/images/9_of_spades.png";
        deck[21] = "/images/10_of_spades.png";
        deck[22] = "/images/jack_of_spades2.png";
        deck[23] = "/images/queen_of_spades2.png";
        deck[24] = "/images/king_of_spades2.png";
        deck[25] = "/images/ace_of_spades.png";
        deck[26] = "/images/2_of_hearts.png";
        deck[27] = "/images/3_of_hearts.png";
        deck[28] = "/images/4_of_hearts.png";
        deck[29] = "/images/5_of_hearts.png";
        deck[30] = "/images/6_of_hearts.png";
        deck[31] = "/images/7_of_hearts.png";
        deck[32] = "/images/8_of_hearts.png";
        deck[33] = "/images/9_of_hearts.png";
        deck[34] = "/images/10_of_hearts.png";
        deck[35] = "/images/jack_of_hearts2.png";
        deck[36] = "/images/queen_of_hearts2.png";
        deck[37] = "/images/king_of_hearts2.png";
        deck[38] = "/images/ace_of_hearts.png";
        deck[39] = "/images/2_of_diamonds.png";
        deck[40] = "/images/3_of_diamonds.png";
        deck[41] = "/images/4_of_diamonds.png";
        deck[42] = "/images/5_of_diamonds.png";
        deck[43] = "/images/6_of_diamonds.png";
        deck[44] = "/images/7_of_diamonds.png";
        deck[45] = "/images/8_of_diamonds.png";
        deck[46] = "/images/9_of_diamonds.png";
        deck[47] = "/images/10_of_diamonds.png";
        deck[48] = "/images/jack_of_diamonds2.png";
        deck[49] = "/images/queen_of_diamonds2.png";
        deck[50] = "/images/king_of_diamonds2.png";
        deck[51] = "/images/ace_of_diamonds.png";

            }

            public void cardNumberAllocator() {

            // An array that has the Integer value of each card in the same postion as the
                //cardfiller() method

                for (int i = 0; i < numValueOfDeck.length; i++) {
                    numValueOfDeck[i] = counter;
                    counter++;
                   // System.out.println(numValueOfDeck[i]);
                    if(counter == 14){counter = 1;}
                }
            }

        }


