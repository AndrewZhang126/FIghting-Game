package sample;

import java.util.ArrayList;

public class Fight {
    //precondition: puts the user's character against the computer's character
    //postcondition: determines winner from the stats
    public int randomNumber(int x) {
        return (int)(Math.random() * x);
    }
    public boolean checkDodge(int y, int z) {
        return randomNumber(y - z)  == randomNumber(y - z); //dodge is random, higher the speed the more likely for dodge
    }
    public int userQuickAttack(int ch, int usp, int csp, boolean cb) {
        if (cb) {
            return ch;
        }
        else if (checkDodge(20, csp)) { //checks if dodge occurred
            return ch;
        }
        else {
            ch -= usp * 0.3; //if not, damage is subtracted from health
            return ch;
        }
    }
    public int userChargeAttack(int ch, int ust, int csp, int uc, boolean cb) {
        if (cb) {
            return ch;
        }
        else if (checkDodge(20, csp)) {
            return ch;
        }
        else {
            ch -= ust * 0.1 + (uc * 1.5); //damage is calculated based on strength and charge
            return ch;
        }
    }
    public int compQuickAttack(int uh, int csp, int usp, boolean ub) {
        if (ub) {
            return uh;
        }
        else if (checkDodge(20, usp)) {
            return uh;
        }
        else {
            uh -= csp * 0.3;
            return uh;
        }
    }
    public int compChargeAttack(int uh, int cst, int usp, int cc, boolean ub) {
        if (ub) {
            return uh;
        }
        else if (checkDodge(20, usp)) {
            return uh;
        }
        else {
            uh -= cst * 0.1 * (cc * 1.5);
            return uh;
        }
    }
    public int compQuickAttackHard(int uh, int ch, int csp, int usp, boolean ub) {
        if (ub) {
            return uh;
        }
        else if (uh > ch) {
            if (ch < 5) { //this means computer is almost dead and has to cheat significantly
                if (checkDodge(12, usp)) { //much higher chance of dodge
                    return uh;
                }
                else {
                    uh -= csp * 0.5; //much higher damage
                    return uh;
                }
            }
            else { //computer is still losing the battle
                if (checkDodge(15, usp)) { //higher chance of dodge
                    return uh;
                }
                else {
                    uh -= csp * 0.4; //higher damage
                    return uh;
                }
            }

        }
        else {
            if (checkDodge(20, usp)) {
                return uh;
            }
            else {
                uh -= csp * 0.3;
                return uh; //normal damage and dodge because computer does not need to cheat yet
            }
        }
    }
    public int compChargeAttackHard(int uh, int ch, int cst, int usp, int cc, boolean ub) {
        if (ub) {
            return uh;
        }
        else if (uh > ch) {
            if (ch < 5) {
                if (checkDodge(12, usp)) {
                    return uh;
                }
                 else {
                    uh -= cst * 0.3 * (cc * 2);
                    return uh;
                }
            }
            else {
                if (checkDodge(15, usp)) {
                    return uh;
                }
                else {
                    uh -= cst * 0.2 * (cc * 1.5);
                    return uh;
                }
            }
        }
         else {
            if (checkDodge(20, usp)) {
                return uh;
            }
            else {
                uh -= cst * 0.1 * (cc * 1.5);
                return uh;
            }
        }
    }

}
