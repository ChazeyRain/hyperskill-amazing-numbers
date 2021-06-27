package numbers.operations;

import java.math.BigInteger;

public class OneNumber extends Operation{

    private BigInteger number;

    public OneNumber(BigInteger number) {
        this.number = number;
    }

    @Override
    public void start() {
        System.out.println("Properties of " + addSeparators(number) + ":");
        System.out.println("\t\teven: " + Properties.EVEN.check(number));
        System.out.println("\t\todd: " + Properties.ODD.check(number));
        System.out.println("\t\tbuzz: " + Properties.BUZZ.check(number));
        System.out.println("\t\tduck: " + Properties.DUCK.check(number));
        System.out.println("\t\tpalindromic: " + Properties.PALINDROMIC.check(number));
        System.out.println("\t\tgapful: " + Properties.GAPFUL.check(number));
        System.out.println("\t\tspy: " + Properties.SPY.check(number));
        System.out.println("\t\tsquare: " + Properties.SQUARE.check(number));
        System.out.println("\t\tsunny: " + Properties.SUNNY.check(number));
        System.out.println("\t\tjumping: " + Properties.JUMPING.check(number));
        System.out.println("\t\thappy: " + Properties.HAPPY.check(number));
        System.out.println("\t\tsad: " + Properties.SAD.check(number));
    }
}
