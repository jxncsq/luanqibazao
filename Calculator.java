package com.huawei.sq;

public class Calculator {

    public static int calculate(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            // do nothing
        }
        // +
        int operIndex = findOperOuterScope(str, '+');
        if (operIndex != -1) {
            return calculate(str.substring(0, operIndex)) + calculate(str.substring(operIndex + 1));
        }
        // -
        operIndex = findOperOuterScope(str, '-');
        if (operIndex != -1) {
            return calculate(str.substring(0, operIndex)) - calculate(str.substring(operIndex + 1));
        }
        // *
        operIndex = findOperOuterScope(str, '*');
        if (operIndex != -1) {
            return calculate(str.substring(0, operIndex)) * calculate(str.substring(operIndex + 1));
        }
        // /
        operIndex = findOperOuterScope(str, '/');
        if (operIndex != -1) {
            return calculate(str.substring(0, operIndex)) / calculate(str.substring(operIndex + 1));
        }
        // MAX|MIN
        if (str.startsWith("MAX") || str.startsWith("MIN")) {
            // MAX(1,2)
            String inner = str.substring(4, str.length() - 1);
            int indexComa = findOperOuterScope(inner, ',');
            if (str.startsWith("MAX")) {
                return Math.max(calculate(inner.substring(0, indexComa)), calculate(inner.substring(indexComa + 1)));
            } else {
                return Math.min(calculate(inner.substring(0, indexComa)), calculate(inner.substring(indexComa + 1)));
            }
        }
        // ()
        if (str.startsWith("(")) {
            return calculate(str.substring(1, str.length() - 1));
        }
        return 0;
    }

    public static int findOperOuterScope(String str, char oper) {
        int count = 0;
        for (int i = 0; i != str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {
                count--;
            } else if (str.charAt(i) == oper) {
                if (count == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
