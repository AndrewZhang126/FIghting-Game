package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Controller {
    Character c1;
    Fight f1 = new Fight();
    Learn hData = new Learn();
    private ArrayList<Character> compChar = new ArrayList<>();
    int opponentChar;
    int userH;
    int userSt;
    int userSp;
    int compH;
    int compSt;
    int compSp;
    int uChargeCount;
    int cChargeCount;
    double uProgressH;
    double cProgressH;
    boolean uBlock = false;
    boolean cBlock = false;
    boolean easy = false;
    boolean hard = false;
    boolean learn = false;
    int stats = 15;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btnQuick;
    @FXML
    private Button btnCharge;
    @FXML
    private Button btnBlock;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private Label lbl5;
    @FXML
    private ListView lst1;
    @FXML
    private ListView lst2;
    @FXML
    private ProgressBar bar1;
    @FXML
    private ProgressBar bar2;
    @FXML
    private ProgressBar bar3;
    @FXML
    private ProgressBar bar4;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ChoiceBox<String> choice1;
    @FXML
    private ChoiceBox<String> choice2;
    @FXML
    private Slider slider1;
    @FXML
    private Slider slider2;
    @FXML
    private Slider slider3;
    @FXML
    public void initialize() { //once the project runs, it populates the choice boxes
        getChar();
        getMode();
        image3.setImage(new Image("images/world.png"));
    }
    @FXML
    private void getChar() {
        ObservableList<String> charOption = FXCollections.observableArrayList("Robert", "Jessica");
        choice1.setItems(charOption); //puts options into the choice box
    }
    @FXML
    private void getMode() {
        ObservableList<String> modeOption = FXCollections.observableArrayList("Easy", "Learning", "Hard");
        choice2.setItems(modeOption);
    }
    @FXML
    private void handlebtn1() {
         startGame();
    }
    private void startGame() {
        if ((int)(slider1.getValue()) + (int)(slider2.getValue()) + (int)(slider3.getValue()) == stats) { //once the user puts in acceptable stats, the game can run
            if (choice1.getSelectionModel().getSelectedItem().equals("Robert")) {
                c1 = new Character("Robert", (int)(slider1.getValue()) , (int)(slider2.getValue()) , (int)(slider3.getValue()) , 0, new Image("images/male.png")); //creates the user character
            }
            else {
                c1 = new Character("Jessica", (int)(slider1.getValue()) , (int)(slider2.getValue()) , (int)(slider3.getValue()) , 0, new Image("images/female.png"));
            }
            image1.setImage(c1.getImage());
            makeEnemy();
            btn1.setDisable(true);
            btn2.setDisable(false);
            choice1.setDisable(true);
            choice2.setDisable(false);
            slider1.setDisable(true);
            slider2.setDisable(true);
            slider3.setDisable(true);
            lst1.setDisable(false);
            lst2.setDisable(false);
        }
        else {
            lbl5.setText("Total Stats Must Be " + stats);
        }
    }
    private void makeEnemy() { //populates the list array with enemies
        lst1.getItems().clear();
        compChar.clear();
        String[] opponentName = {"ninja", "viking", "knight", "spartan", "pirate"};
        for (int i = 0; i < 5; i ++) {
            if (opponentName[(int)(Math.random() * 5)].equals("ninja")) {
                int nHealth = (int)(Math.random() * 4) + 1; //randomly generates a small number because ninjas do not have a lot of health
                int nSpeed = (int)(Math.random() * 4) + 9; //randomly generates a larger number because ninjas are fast
                while (nHealth + nSpeed > stats - 1) {
                    nHealth = (int)(Math.random() * 5) + 1;
                    nSpeed = (int)(Math.random() * 4) + 9; //rerolls stats until it is acceptable
                }
                int nStrength = stats - nHealth - nSpeed; //total stats cannot be more than 15
                compChar.add(new Character("Ninja", nHealth, nStrength, nSpeed, 0, new Image("images/ninja.png")));


            }
            else if (opponentName[(int)(Math.random() * 5)].equals("viking")) {
                int vHealth = (int)(Math.random() * 8) + 5; //vikings have more health and strength because they are muscular
                int vSpeed = (int)(Math.random() * 3) + 1; //vikings lack speed
                while (vHealth + vSpeed > stats - 1) {
                    vHealth = (int)(Math.random() * 9) + 5;
                    vSpeed = (int)(Math.random() * 4) + 1;
                }
                int vStrength = stats - vHealth - vSpeed;
                compChar.add(new Character("Viking", vHealth, vSpeed, vStrength, 0, new Image("images/viking.png")));
            }
            else if (opponentName[(int)(Math.random() * 5)].equals("knight")) {
                int kHealth = (int)(Math.random() * 4) + 7; //knights have more health due to armor
                int kSpeed = (int)(Math.random() * 3) + 5;
                while (kHealth + kSpeed > stats - 1) {
                    kHealth = (int)(Math.random() * 3) + 5;
                    kSpeed = (int)(Math.random() * 3) + 5;
                }
                int kStrength = stats - kHealth - kSpeed;
                compChar.add(new Character("Knight", kHealth, kStrength, kSpeed, 0, new Image("images/knight.png")));
            }
            else if (opponentName[(int)(Math.random() * 5)].equals("spartan")) {
                int sHealth = (int)(Math.random() * 3) + 5; //spartans are well rounded
                int sSpeed = (int)(Math.random() * 3) + 5;
                while (sHealth + sSpeed > stats - 1) {
                    sHealth = (int)(Math.random() * 4) + 7;
                    sSpeed = (int)(Math.random() * 3) + 6;
                }
                int sStrength = stats - sHealth - sSpeed;
                compChar.add(new Character("Spartan", sHealth, sStrength, sSpeed, 0, new Image("images/spartan.png")));
            }
            else {
                int pHealth = (int)(Math.random() * 4) + 5; //pirates are also well rounded, but are fast
                int pSpeed = (int)(Math.random() * 3) + 7;
                while (pHealth + pSpeed > stats - 1) {
                    pHealth = (int)(Math.random() * 4) + 5;
                    pSpeed = (int)(Math.random() * 3) + 7;
                }
                int pStrength = stats - pHealth - pSpeed;
                compChar.add(new Character("Pirate", pHealth, pStrength, pSpeed, 0, new Image( "images/pirate.png")));
            }
        }
        for (int j = 0; j < compChar.size(); j++) {
            lst1.getItems().add(compChar.get(j).getName());
        }
    }
    @FXML
    private void handlelst1(MouseEvent event) { //gets the opponent that the user selected
        lst2.getItems().clear();
        opponentChar = lst1.getSelectionModel().getSelectedIndex();
        lst2.getItems().add("Health: " + compChar.get(opponentChar).getHealth());
        lst2.getItems().add("Strength: " + compChar.get(opponentChar).getStrength());
        lst2.getItems().add("Speed: " + compChar.get(opponentChar).getSpeed());
        image2.setImage(compChar.get(opponentChar).getImage());
    }
    @FXML
    private void handlebtn2() {
        lbl3.setText("");
        userH = c1.getHealth() * 5; //assigns each characters stats to a variable so it is easier to manipulate
        uProgressH = c1.getHealth() * 5;
        userSt = c1.getStrength();
        userSp = c1.getSpeed();
        compH = compChar.get(opponentChar).getHealth() * 5;
        cProgressH = compChar.get(opponentChar).getHealth() * 5;
        compSt = compChar.get(opponentChar).getStrength();
        compSp = compChar.get(opponentChar).getSpeed();
        uChargeCount = 0;
        cChargeCount = 0;
        bar1.setProgress(uProgressH); //health bar starts at full value
        bar3.setProgress(cProgressH);
        bar2.setProgress(0);
        bar4.setProgress(0);
        if (choice2.getSelectionModel().getSelectedItem().equals("Easy")) {
            easy = true;
        }
        if (choice2.getSelectionModel().getSelectedItem().equals("Learning")) {
            learn = true;
        }
        if (choice2.getSelectionModel().getSelectedItem().equals("Hard")) {
            hard = true;
        }
        btn2.setDisable(true);
        btnQuick.setDisable(false);
        btnCharge.setDisable(false);
        btnBlock.setDisable(false);
        choice2.setDisable(true);
        lst1.setDisable(true);
        lst2.setDisable(true);
    }
    @FXML
    private void handlebtnQuick() {
        uBlock = false;
        uChargeCount++;
        hData.addData(0);
        bar2.setProgress(uChargeCount / 5.0); //changes the health bar each time health changes
        compH = f1.userQuickAttack(compH, userSp, compSp, cBlock); //user attack
        cBlock = false;
        bar3.setProgress(compH / cProgressH);
        if (easy) { //computer attack is based on the mode selected
           easyMode();
        }
        if (hard) {
            hardMode();
        }
        if (learn) {
            learnMode();
        }
        checkWin();
    }
    @FXML
    private void handlebtnCharge() {
        uBlock = false;
        uChargeCount++;
        hData.addData(1);
        bar2.setProgress(0);
        if (hard) { //computer will always block user charge attack on hard mode
            compH = f1.userChargeAttack(compH, userSt, compSp, uChargeCount, true);
        }
        else {
            compH = f1.userChargeAttack(compH, userSt, compSp, uChargeCount, cBlock);
        }
        cBlock = false;
        bar3.setProgress(compH / cProgressH);
        if (easy) {
            easyMode();
        }
        if (learn) {
            learnMode();
        }
        uChargeCount = 0;
        checkWin();
    }
    @FXML
    private void handlebtnBlock() { //blocks all attacks for the next turn
        uBlock = true;
        cBlock = false;
        uChargeCount++;
        if (easy) {
            easyMode();
        }
        if (hard) {
            hardMode();
        }
        if (learn) {
            learnMode();
        }
    }
    private void checkWin() { //check if win or loss
        if (userH <= 0) { //once user health has fallen below 0, they have lost
            lbl3.setText("You Lose");
            btn2.setDisable(true);
            btnQuick.setDisable(true);
            btnCharge.setDisable(true);
            btnBlock.setDisable(true);
        }
        if (compH <= 0) { //once computer health has fallen below 0, the user can play again
            btnQuick.setDisable(true);
            btnCharge.setDisable(true);
            btnBlock.setDisable(true);
            btn2.setDisable(false);
            choice2.setDisable(false);
            lst1.setDisable(false);
            lst2.setDisable(false);
            lbl3.setText("You Win");
            c1.setWin(c1.getWin() + 1);
            lbl4.setText("Wins " + c1.getWin());
        }
        if (compH == 0 && userH == 0) { //if both user and computer health are 0 at the same time, it is tie and user can play again
            btn2.setDisable(false);
            choice2.setDisable(false);
            lbl3.setText("Tie");
        }
        if (c1.getWin() > 6) {
            increaseStats(20);
        }
        if (c1.getWin() > 4) {
            increaseStats(18);
        }
        if (c1.getWin() > 2) {
            increaseStats(16);
        }
    }
    private void increaseStats(int newStat) {
        stats = newStat;
        btn1.setDisable(false);
        slider1.setDisable(false);
        slider2.setDisable(false);
        slider3.setDisable(false);
        choice2.setDisable(true);
        lst1.setDisable(true);
        lst2.setDisable(true);
        btn2.setDisable(true);
        startGame();
    }
    private void easyMode() {
        int temp = (int)(Math.random() * 3);
        if (temp == 0) { //computer attack is all random for easy mode
            cChargeCount++;
            bar4.setProgress(cChargeCount / 5.0);
            userH = f1.compQuickAttack(userH, compSp, userSp, uBlock);
        }
        else if (temp == 1){
            bar4.setProgress(0);
            userH = f1.compChargeAttack(userH, compSt, userSp, cChargeCount, uBlock);
            cChargeCount = 0;
        }
        else {
            cBlock = true;
        }
        bar1.setProgress(userH / uProgressH);
    }
    private void hardMode() {
        if (cChargeCount < 2) { //in hard mode, the computer is smarter and will charge up the charge attack to do more damage
            cChargeCount++;
            bar4.setProgress(cChargeCount / 5.0);
            userH = f1.compQuickAttackHard(userH, compH, compSp, userSp, uBlock);
            bar1.setProgress(userH / uProgressH);
        }
        else {
            cChargeCount++;
            bar4.setProgress(0);
            userH = f1.compChargeAttackHard(userH, compH, compSt, userSp, cChargeCount, uBlock);
            bar1.setProgress(userH / uProgressH);
            cChargeCount = 0;
        }
    }
    private void learnMode() {
        learnAttack(hData.analyzeData());
    }
    private void learnAttack(int x) { //determines the probability of using quick or charge attack
        int temp2 = (int)(Math.random() * 10);
        if (temp2 < x){
            cBlock = true;
        }
        else if (temp2 % 2 == 0) {
            cChargeCount++;
            bar4.setProgress(0);
            userH = f1.compChargeAttackHard(userH, compH, compSt, userSp, cChargeCount, uBlock);
            bar1.setProgress(userH / uProgressH);
            cChargeCount = 0;
        }
        else {
            cChargeCount++;
            bar4.setProgress(cChargeCount / 5.0);
            userH = f1.compQuickAttackHard(userH, compH, compSp, userSp, uBlock);
            bar1.setProgress(userH / uProgressH);
        }
    }
    @FXML
    private void handlebtn5() { //resets all stats and screen displays
        btn1.setDisable(false);
        slider1.setValue(slider1.getMin());
        slider2.setValue(slider1.getMin());
        slider3.setValue(slider1.getMin());
        lbl1.setText("Your Health");
        lbl2.setText("Computer Health");
        lbl3.setText("");
        lst1.getItems().clear();
        lst2.getItems().clear();
        bar1.setProgress(0);
        bar2.setProgress(0);
        bar3.setProgress(0);
        bar4.setProgress(0);
        image1.setImage(null);
        image2.setImage(null);
        slider1.setDisable(false);
        slider2.setDisable(false);
        slider3.setDisable(false);
        compChar.clear();
        opponentChar = 0;
        userH = 0;
        userSt = 0;
        userSp = 0;
        compH = 0;
        compSt = 0;
        compSp = 0;
        uChargeCount = 0;
        cChargeCount = 0;
        easy = false;
        hard = false;
        learn = false;
        cBlock = false;
        uBlock = false;
        choice1.setDisable(false);
        choice1.getSelectionModel().clearSelection();
        choice2.getSelectionModel().clearSelection();
    }
 }
