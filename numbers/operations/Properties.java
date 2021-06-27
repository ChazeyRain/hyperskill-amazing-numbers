package numbers.operations;

import java.math.BigInteger;

public enum Properties {

    EVEN {

        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            this.exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            return exclude ^ !(number.and(BigInteger.ONE)).equals(BigInteger.ONE);
        }
    },

    ODD {

        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            this.exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            return exclude ^ (number.and(BigInteger.ONE)).equals(BigInteger.ONE);
        }
    },
    BUZZ {

        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            this.exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            return exclude ^ (number.mod(BigInteger.valueOf(7)).equals(BigInteger.ZERO)
                    || number.mod(BigInteger.valueOf(10)).equals(BigInteger.valueOf(7)));
        }
    },
    DUCK{

        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            this.exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            return exclude ^ String.valueOf(number).contains("0");
        }
    },
    PALINDROMIC {

        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            this.exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            String input = number.toString();
            StringBuilder firstHalf = new StringBuilder(input.substring(0, input.length() / 2));

            return exclude ^ firstHalf.reverse().toString().equals(input.substring((input.length() + 1) / 2));
        }
    },
    GAPFUL {

        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            this.exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            if (number.max(BigInteger.valueOf(99)).equals(BigInteger.valueOf(99))) {
                return exclude;
            }
            String strNumber = number.toString();
            int con = Integer.parseInt(strNumber.charAt(0) + "" + strNumber.charAt(strNumber.length() - 1));
            return exclude ^ number.mod(BigInteger.valueOf(con)).intValue() == 0;
        }
    },
    SPY {

        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            this.exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            int length = number.toString().length();
            BigInteger sum = BigInteger.ZERO;
            BigInteger mul = BigInteger.ONE;

            for (int i = 0; i < length; i++) {
                sum = sum.add(number.mod(BigInteger.TEN));
                mul = mul.multiply(number.mod(BigInteger.TEN));
                number = number.divide(BigInteger.TEN);
            }
            return exclude ^ sum.toString().equals(mul.toString());
        }
    },
    SUNNY {

        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            this.exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            return exclude ^ number.add(BigInteger.ONE).sqrtAndRemainder()[1].intValue() == 0;
        }
    },
    SQUARE {
        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            this.exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            return exclude ^  number.sqrtAndRemainder()[1].intValue() == 0;
        }
    },
    JUMPING {

        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            this.exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            int length = number.toString().length();

            int firstNumber = number.mod(BigInteger.TEN).intValue();
            int secondNumber;

            for (int i = 1; i < length; i++) {
                number = number.divide(BigInteger.TEN);
                secondNumber = number.mod(BigInteger.TEN).intValue();
                if (Math.abs(firstNumber - secondNumber) != 1) {
                    return exclude;
                }
                firstNumber = secondNumber;
            }
            return !exclude;
        }
    },
    HAPPY {
        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            BigInteger newNumber;
            BigInteger memNumber = number;

            while (number.intValue() != 1) {
                newNumber = BigInteger.ZERO;

                int length = number.toString().length();

                for (int i = 0; i < length; i++) {
                    newNumber = newNumber.add(number.mod(BigInteger.TEN).pow(2));
                    number = number.divide(BigInteger.TEN);
                }

                number = newNumber;
                if (number.intValue() == 4) {
                    return exclude;
                }
            }

            return !exclude;
        }
    },
    SAD {
        private boolean exclude = false;

        @Override
        public void include() {
            this.exclude = false;
        }

        @Override
        public void exclude() {
            exclude = true;
        }

        @Override
        public boolean isExcluded() {
            return exclude;
        }

        @Override
        public boolean check(BigInteger number) {
            BigInteger newNumber;
            BigInteger memNumber = number;

            while (number.intValue() != 1) {
                newNumber = BigInteger.ZERO;

                int length = number.toString().length();

                for (int i = 0; i < length; i++) {
                    newNumber = newNumber.add(number.mod(BigInteger.TEN).pow(2));
                    number = number.divide(BigInteger.TEN);
                }

                number = newNumber;
                if (number.intValue() == 4) {
                    return !exclude;
                }
            }

            return exclude;
        }
    },

    ;

    public abstract boolean isExcluded();

    public abstract void include();

    public abstract void exclude();

    public abstract boolean check(BigInteger number);

    public static void reset() {
        for (Properties value : values()) {
            value.include();
        }
    }

}
