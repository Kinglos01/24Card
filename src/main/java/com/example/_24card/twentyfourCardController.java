package com.example._24card;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.util.Random;

public class twentyfourCardController {
    @FXML
    private Button verify;
    @FXML
    private Button refresh;
    @FXML
    private Button findSolution;
    @FXML
    private ImageView card1Image;
    @FXML
    private ImageView card2Image;
    @FXML
    private ImageView card3Image;
    @FXML
    private ImageView card4Image;

    cardArrayBuilder hand = new cardArrayBuilder();



    int[] randomNumSelector = new int[4];

    int card1, card2, card3, card4;

    @FXML
    protected void onVerifyButtonClick() {

    }

    @FXML
    protected void onRefreshButtonClick() {

        // Finding the cards for the hand the player will use

        for (int i = 0; i < randomNumSelector.length; i++) {
            Random randomCardSelector = new Random();
            randomNumSelector[i]= randomCardSelector.nextInt(52);
            if(i == 0){card1 = randomNumSelector[i];}
            else if(i == 1){card2 = randomNumSelector[i];}
            else if(i == 2){card3 = randomNumSelector[i];}
            else{card4 = randomNumSelector[i];}
        }

        hand.cardfiller();
        System.out.println(hand.deck[card1] + " | " + hand.deck[card2] + " | "
                + hand.deck[card3] + " | " + hand.deck[card4]);

    }

    @FXML
    protected void onFindSolutionButtonClick(){}
}
