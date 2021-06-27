package numbers.operations;

import java.math.BigInteger;

public class ManyNumbers extends Operation {

    private BigInteger number;
    private int count;

    public ManyNumbers(BigInteger number, int count) {
        this.number = number.subtract(BigInteger.ONE);
        this.count = count;
    }

    @Override
    public void start() {
        for (int i = 0; i < count; i++) {
            number = number.add(BigInteger.ONE);
            System.out.print(addSeparators(number) + " is ");
            System.out.print(Properties.BUZZ.check(number) && !Properties.BUZZ.isExcluded() ? "buzz, " : "");
            System.out.print(Properties.DUCK.check(number) && !Properties.DUCK.isExcluded() ? "duck, " : "");
            System.out.print(Properties.PALINDROMIC.check(number) && !Properties.PALINDROMIC.isExcluded() ? "palindromic, " : "");
            System.out.print(Properties.GAPFUL.check(number) && !Properties.GAPFUL.isExcluded() ? "gapful, " : "");
            System.out.print(Properties.SPY.check(number) && !Properties.SPY.isExcluded() ? "spy, " : "");
            System.out.print(Properties.SQUARE.check(number) && !Properties.SQUARE.isExcluded() ? "square, " : "");
            System.out.print(Properties.SUNNY.check(number) && !Properties.SUNNY.isExcluded() ? "sunny, " : "");
            System.out.print(Properties.JUMPING.check(number) && !Properties.JUMPING.isExcluded() ? "jumping, " : "");
            System.out.print(Properties.HAPPY.check(number) && !Properties.HAPPY.isExcluded() ? "happy, " : "");
            System.out.print(Properties.SAD.check(number) && !Properties.SAD.isExcluded() ? "sad, " : "");
            System.out.print(Properties.ODD.check(number) && !Properties.ODD.isExcluded() ? "odd" : "even");
            System.out.println();
        }
    }
}
