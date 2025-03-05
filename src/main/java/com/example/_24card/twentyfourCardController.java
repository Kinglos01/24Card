package com.example._24card;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class twentyfourCardController {
    @FXML
    private Button verify;
    @FXML
    private Button refresh;
    @FXML
    private Button findSolution;
    @FXML
    private ImageView card1View;
    @FXML
    private ImageView card2View;
    @FXML
    private ImageView card3View;
    @FXML
    private ImageView card4View;
    @FXML
    private Label winnerLabel;
    @FXML
    private TextField equationText;


    Map<Integer,Integer> handMap = new HashMap<Integer,Integer>();

    cardArrayBuilder hand = new cardArrayBuilder();



    int[] randomNumSelector = new int[4];

    int card1, card2, card3, card4;

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
        hand.cardNumberAllocator();

        // Initializing the map so I can fetch values
        handMap.put(hand.numValueOfDeck[card1],0);
        handMap.put(hand.numValueOfDeck[card2],0);
        handMap.put(hand.numValueOfDeck[card3],0);
        handMap.put(hand.numValueOfDeck[card4],0);


        // Creating Map keys for the 4 selected cards
        handMap.put(hand.numValueOfDeck[card1],handMap.get(hand.numValueOfDeck[card1])+1);
        handMap.put(hand.numValueOfDeck[card2],handMap.get(hand.numValueOfDeck[card2])+1);
        handMap.put(hand.numValueOfDeck[card3],handMap.get(hand.numValueOfDeck[card3])+1);
        handMap.put(hand.numValueOfDeck[card4],handMap.get(hand.numValueOfDeck[card4])+1);


        String card1Path = hand.deck[card1];
        String card2Path = hand.deck[card2];
        String card3Path = hand.deck[card3];
        String card4Path = hand.deck[card4];

        Image card1Image = new Image(getClass().getResource(card1Path).toExternalForm());
        card1View.setImage(card1Image);

        Image card2Image = new Image(getClass().getResource(card2Path).toExternalForm());
        card2View.setImage(card2Image);

        Image card3Image = new Image(getClass().getResource(card3Path).toExternalForm());
        card3View.setImage(card3Image);

        Image card4Image = new Image(getClass().getResource(card4Path).toExternalForm());
        card4View.setImage(card4Image);



    }

    @FXML
    protected void onVerifyButtonClick() {

        int userEquation = 0;
        String userEquationString;

        try {

            //checking to see if all characters are valid
            userEquationString = equationText.getText();

            char[] userEquationArray = userEquationString.toCharArray();

            for (int i = 0; i < userEquationArray.length; i++) {

                //checking if letters where inputted
                if(userEquationArray[i] >= 'a' && userEquationArray[i] <= 'z' || userEquationArray[i] >= 'A' && userEquationArray[i] <= 'Z'){
                    winnerLabel.setText("No letters!!!");
                }

                //Checking for double digits such as 11 12 or 13
                if (userEquationArray[i] == '1' && i != userEquationArray.length - 1 ) {
                    if (userEquationArray[i+1] > '3' || userEquationArray[i+1] < '0' || userEquationArray[i+1] == ' ' ){
                        winnerLabel.setText("Invalid Number");
                    }
                    //Special clause for ace
                    if (userEquationArray[i+1] == ' '){
                        if(handMap.containsKey(1)){
                            handMap.put(1,handMap.get(1)-1);
                            if(handMap.get(1) < 0){winnerLabel.setText("Can't use duplicates!!!");}
                        }
                        else{winnerLabel.setText("Card is not valid !!!");}
                    }

                    // Checking for valid numbers and converting back to ints for double digit nums
                    String intBuilder = String.valueOf(userEquationArray[i]);
                    intBuilder += userEquationArray[i+1];
                    int doubleNum = Integer.parseInt(intBuilder);

                    if(handMap.containsKey(doubleNum)){
                        handMap.put(doubleNum,handMap.get(doubleNum)-1);
                        if(handMap.get(doubleNum) < 0){winnerLabel.setText("Can't use duplicates!!!");}
                    }
                    else{winnerLabel.setText("A Card is not valid !!!");}

                    i++;
                }

                if(userEquationArray[i] >= '2' && userEquationArray[i] <= '9' ) {

                    // Setting chars back to integers after check
                    String intBuilder = String.valueOf(userEquationArray[i]);
                    int soloNum = Integer.parseInt(intBuilder);

                    if (handMap.containsKey(soloNum)) {
                        handMap.put(soloNum, handMap.get(soloNum) - 1);
                        if (handMap.get(soloNum) < 0) {
                            winnerLabel.setText("Can't use duplicates!!!");
                        }
                    } else {

                        winnerLabel.setText("A Card is not valid !!!");

                    }
                }


            }


            if(userEquation == 24){winnerLabel.setText("Congratulations you won!");}



        }catch(NumberFormatException e){

        }







//        System.out.println(hand.numValueOfDeck[card1]+ " | " + hand.numValueOfDeck[card2]);
//        System.out.println(hand.numValueOfDeck[card3]+ " | " + hand.numValueOfDeck[card4]);
    }


    @FXML
    protected void onFindSolutionButtonClick(){}
}
