package sample;

import java.util.ArrayList;

public class Learn {
    ArrayList<Integer> userData = new ArrayList<>();
    int case00;
    int case01;
    int case10;
    int case11;
    public void addData(int move) {
        userData.add(move); //adds data to the array
    }
    //precondition: gets number of times user used quick and charge attacks
    //postcondition: computer makes a move based on that data
    public int analyzeData() {
        if (userData.get(userData.size() - 1) == 0) { //if the last move is a quick attack, then the computer checks all the user data for the moves they did after a quick attack
            for (int i = 0; i < userData.size() - 1; i++) {
                if ((Integer.toString(userData.get(i)) + userData.get(i + 1)).equals("00")) { //the amount of times a quick attack was followed by a quick attack
                    case00++;
                }
                if ((Integer.toString(userData.get(i)) + userData.get(i + 1)).equals("01")) { //the amount of times a quick attack was followed by a charge attack
                    case01++;
                }
            }
            if (case00 > case01) { //if there are more occurrences of the user doing two quick attacks in a row, then the computer knows the next move will likely be a quick attack, and makes the correct counter move
                return 3;
            }
            else {
                return 8; //the computer knows the user will likely make a charge attack, and will be significantly more likely to use a block to stop the high damage charge attacks
            }
        }
        else {
            for (int i = 0; i < userData.size() - 1; i++) { //this means the most recent attack was a charge attack
                if ((Integer.toString(userData.get(i)) + userData.get(i + 1)).equals("10")) { //the occurrences of the user doing a quick attack after a charge attack
                    case10++;
                }
                if ((Integer.toString(userData.get(i)) + userData.get(i + 1)).equals("11")) { //the occurrences of the user doing two consecutive charge attacks
                    case11++;
                }
            }
            if (case10 > case11) { //the computer knows the user will likely use a quick attack
                return 3;
            }
            else {
                return 8; //the computer knows the user will likely use a charge attack
            }
        }
    }

}
