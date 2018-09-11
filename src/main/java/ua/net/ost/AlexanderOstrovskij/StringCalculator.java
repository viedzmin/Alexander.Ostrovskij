package ua.net.ost.AlexanderOstrovskij;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class StringCalculator {

    // * Wrapper Class to change a print view as needed
    private class CalcTreeMap extends TreeMap<Character,Integer> {
        @Override
        public String toString() {
            Iterator<Map.Entry<Character,Integer>> i = entrySet().iterator();
            if (!i.hasNext()) { return ""; }

            StringBuilder sb = new StringBuilder();
            for (;;) {
                Map.Entry<Character,Integer> e = i.next();
                Character key = e.getKey();
                Integer value = e.getValue();

                sb.append(key);
                sb.append(',');
                sb.append(value);

                if (! i.hasNext())
                    return sb.toString();
                sb.append('\n');
            }
        }
    }

    public String calculate(String input) {
        if (!(input == null) && !input.equals("")) {

            TreeMap<Character,Integer> charsMap = new CalcTreeMap();
            char[] chars = input.toCharArray();
            for (Character c : chars) {
                if (charsMap.containsKey(c)) {
                    charsMap.put(c, charsMap.get(c) + 1);
                } else {
                    charsMap.put(c, 1);
                }
            }
            return charsMap.toString();

        } else {
            return "";
        }
    }
}
