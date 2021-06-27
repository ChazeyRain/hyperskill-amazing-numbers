package numbers.operations;

import java.math.BigInteger;
import java.util.Locale;

public abstract class Operation {

     protected static String addSeparators(BigInteger number) {
        StringBuilder builder = new StringBuilder(number.toString());

        int length = builder.length();

        for (int i = 3; i < length; i += 3) {
            builder.insert(length - (i), ",");
        }

        return builder.toString();
    }

    public static Operation operationFactory(String input) throws IllegalArgumentException {
        String[] inputs = input.split(" ");

        if (inputs[0].matches("[0-9]*")) {

            BigInteger number = new BigInteger(inputs[0]);

            if (inputs.length == 1) {
                return new OneNumber(number);
            }

            if (inputs[1].matches("[0-9]*")) {

                int count = Integer.parseInt(inputs[1]);

                if (inputs.length == 2) {
                    return new ManyNumbers(number, count);
                }

                Properties[] param = getParams(input.substring(inputs[0].length() + inputs[1].length() + 1));
                return new ManyNumbersManyParam(number, count, param);
            }
            throw new IllegalArgumentException("The second parameter should be a natural number.");
        } else {
            throw new IllegalArgumentException("The first parameter should be a natural number or zero.");
        }
    }

    private static Properties[] getParams(String input) {
         input = input.toLowerCase(Locale.ROOT);

        String[] inputs = input.trim().split(" ");

        StringBuilder errors = new StringBuilder();
        int errorCount = 0;

        Properties[] params = new Properties[inputs.length];
        Properties.reset();

        for (int i = 0; i < inputs.length; i++) {
            switch (inputs[i]) {
                case "even":
                    params[i] = Properties.EVEN;
                    break;
                case "odd":
                    params[i] = Properties.ODD;
                    break;
                case "buzz":
                    params[i] = Properties.BUZZ;
                    break;
                case "duck":
                    params[i] = Properties.DUCK;
                    break;
                case "palindromic":
                    params[i] = Properties.PALINDROMIC;
                    break;
                case "gapful":
                    params[i] = Properties.GAPFUL;
                    break;
                case "spy":
                    params[i] = Properties.SPY;
                    break;
                case "square":
                    params[i] = Properties.SQUARE;
                    break;
                case "sunny":
                    params[i] = Properties.SUNNY;
                    break;
                case "jumping":
                    params[i] = Properties.JUMPING;
                    break;
                case "-even":
                    params[i] = Properties.EVEN;
                    params[i].exclude();
                    break;
                case "-odd":
                    params[i] = Properties.ODD;
                    params[i].exclude();
                    break;
                case "-buzz":
                    params[i] = Properties.BUZZ;
                    params[i].exclude();
                    break;
                case "-duck":
                    params[i] = Properties.DUCK;
                    params[i].exclude();
                    break;
                case "-palindromic":
                    params[i] = Properties.PALINDROMIC;
                    params[i].exclude();
                    break;
                case "-gapful":
                    params[i] = Properties.GAPFUL;
                    params[i].exclude();
                    break;
                case "-spy":
                    params[i] = Properties.SPY;
                    params[i].exclude();
                    break;
                case "-square":
                    params[i] = Properties.SQUARE;
                    params[i].exclude();
                    break;
                case "-sunny":
                    params[i] = Properties.SUNNY;
                    params[i].exclude();
                    break;
                case "-jumping":
                    params[i] = Properties.JUMPING;
                    params[i].exclude();
                    break;
                case "happy":
                    params[i] = Properties.HAPPY;
                    params[i].include();
                    break;
                case "-happy":
                    params[i] = Properties.HAPPY;
                    params[i].exclude();
                    break;
                case "sad":
                    params[i] = Properties.SAD;
                    break;
                case "-sad":
                    params[i] = Properties.SAD;
                    params[i].exclude();
                    break;

                default:
                    errors.append(", ").append(inputs[i].toUpperCase(Locale.ROOT));
                    errorCount++;
            }
        }

        if (errorCount != 0) {
            throw new IllegalArgumentException(errorCount == 1 ? "The property [" + errors.delete(0, 2).toString() +"] is wrong.\n" +
                    "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, SAD, HAPPY]"
                    : "The properties [" + errors.delete(0, 2).toString() +"] are wrong.\n" +
                    "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, SAD, HAPPY]");
        }

        for (String s : inputs) {
            if (input.contains("-" + s)) {
                throw new IllegalArgumentException("The request contains mutually exclusive properties: [" + s
                        + ", -" + s + "]");
            }
        }

        if(input.contains(" odd") && input.contains(" even")) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: " +
                    "[ODD, EVEN]\n" +
                    "There are no numbers with these properties.\n");
        }
        if (input.contains(" sunny") && input.contains(" square")) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: " +
                    "[SUNNY, SQUARE]\n" +
                    "There are no numbers with these properties.\n");
        }
        if (input.contains(" duck") && (input.contains(" spy"))) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: " +
                    "[DUCK, SPY]\n" +
                    "There are no numbers with these properties.\n");
        }
        if (input.contains(" sad") && (input.contains(" happy"))) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: " +
                    "[SAD, HAPPY]\n" +
                    "There are no numbers with these properties.\n");
        }

        if(input.contains("-odd") && input.contains("-even")) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: " +
                    "[-ODD, -EVEN]\n" +
                    "There are no numbers with these properties.\n");
        }
        if (input.contains("-sunny") && input.contains("-square")) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: " +
                    "[-SUNNY, -SQUARE]\n" +
                    "There are no numbers with these properties.\n");
        }
        if (input.contains("-duck") && (input.contains("-spy"))) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: " +
                    "[DUCK, SPY]\n" +
                    "There are no numbers with these properties.\n");
        }
        if (input.contains("-sad") && (input.contains("-happy"))) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: " +
                    "[SAD, HAPPY]\n" +
                    "There are no numbers with these properties.\n");
        }

        return params;

    }

    public abstract void start();
}


