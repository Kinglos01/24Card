package com.example._24card;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;

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

        equationText.setText("");

        try{

            winnerLabel.setText("Let's Begin!");

            // Finding the cards for the hand the player will use

            for (int i = 0; i < randomNumSelector.length; i++) {
                Random randomCardSelector = new Random();
                randomNumSelector[i] = randomCardSelector.nextInt(52);
                if (i == 0) {
                    card1 = randomNumSelector[i];
                } else if (i == 1) {
                    card2 = randomNumSelector[i];
                } else if (i == 2) {
                    card3 = randomNumSelector[i];
                } else {
                    card4 = randomNumSelector[i];
                }
            }

            hand.cardfiller();
            hand.cardNumberAllocator();

            // Initializing the map so I can fetch values
            handMap.put(hand.numValueOfDeck[card1], 0);
            handMap.put(hand.numValueOfDeck[card2], 0);
            handMap.put(hand.numValueOfDeck[card3], 0);
            handMap.put(hand.numValueOfDeck[card4], 0);


            // Creating Map keys for the 4 selected cards
            handMap.put(hand.numValueOfDeck[card1], handMap.get(hand.numValueOfDeck[card1]) + 1);
            handMap.put(hand.numValueOfDeck[card2], handMap.get(hand.numValueOfDeck[card2]) + 1);
            handMap.put(hand.numValueOfDeck[card3], handMap.get(hand.numValueOfDeck[card3]) + 1);
            handMap.put(hand.numValueOfDeck[card4], handMap.get(hand.numValueOfDeck[card4]) + 1);


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

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    protected void onVerifyButtonClick() {
        try {
            String userEquationString = equationText.getText();
            char[] userEquationArray = userEquationString.toCharArray();

            // making sure there is no letters
            for (char c : userEquationArray) {
                if (Character.isLetter(c)) {
                    winnerLabel.setText("No letters allowed!");
                    return;
                }
            }

            // creating a list for integers and operators
            List<Integer> numbers = new ArrayList<>();
            List<Character> operators = new ArrayList<>();

            int i = 0;
            while (i < userEquationArray.length) {
                if (Character.isDigit(userEquationArray[i])) {
                    int num = Character.getNumericValue(userEquationArray[i]);

                    // special case for 10-13
                    if (i + 1 < userEquationArray.length && Character.isDigit(userEquationArray[i + 1])) {
                        num = num * 10 + Character.getNumericValue(userEquationArray[i + 1]);
                        i++;
                    }

                    // making sure the numbers are allowed
                    if (!handMap.containsKey(num) || handMap.get(num) <= 0) {
                        winnerLabel.setText("A Card is not valid or used multiple times!");
                        return;
                    }
                    handMap.put(num, handMap.get(num) - 1); // Use the number
                    numbers.add(num);
                }
                else if (userEquationArray[i] == '+' || userEquationArray[i] == '-' ||
                        userEquationArray[i] == '*' || userEquationArray[i] == '/') {
                    operators.add(userEquationArray[i]);
                }
                i++;
            }

           //computing  the results with order of operations in mind
            for (int j = 0; j < operators.size(); j++) {
                if (operators.get(j) == '*' || operators.get(j) == '/') {
                    int left = numbers.get(j);
                    int right = numbers.get(j + 1);
                    int result = (operators.get(j) == '*') ? left * right : (right != 0 ? left / right : 0);

                    numbers.set(j, result);
                    numbers.remove(j + 1);
                    operators.remove(j);
                    j--;
                }
            }

            // now checking + and -
            int sum = numbers.get(0);
            for (int j = 0; j < operators.size(); j++) {
                if (operators.get(j) == '+') {
                    sum += numbers.get(j + 1);
                } else {
                    sum -= numbers.get(j + 1);
                }
            }


            if (sum == 24) {
                winnerLabel.setText("Congratulations, you won!");
            } else {
                winnerLabel.setText("Incorrect solution. Try again!");
            }

            System.out.println("Sum is: " + sum);
        } catch (Exception e) {
            e.printStackTrace();
            winnerLabel.setText("Invalid input format!");
        }
    }







//        System.out.println(hand.numValueOfDeck[card1]+ " | " + hand.numValueOfDeck[card2]);
//        System.out.println(hand.numValueOfDeck[card3]+ " | " + hand.numValueOfDeck[card4]);



    @FXML
    protected void onFindSolutionButtonClick(){}
}
