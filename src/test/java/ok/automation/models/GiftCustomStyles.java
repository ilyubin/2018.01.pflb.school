package ok.automation.models;

import java.util.EnumMap;

public class GiftCustomStyles {

    public enum COLORS{
        BLACK, YELLOW, ORANGE, RED, PINK, MAGENTA, GREEN, PURPLE, BLUE, WHITE
    }

    public static final EnumMap<COLORS, String> colors;
    static {
        colors = new EnumMap<>(COLORS.class);
        colors.put(COLORS.BLACK, ".__one");
        colors.put(COLORS.YELLOW, ".__two");
        colors.put(COLORS.ORANGE, ".__three");
        colors.put(COLORS.RED, ".__four");
        colors.put(COLORS.PINK, ".__five");
        colors.put(COLORS.MAGENTA, ".__six");
        colors.put(COLORS.GREEN, ".__seven");
        colors.put(COLORS.PURPLE, ".__eight");
        colors.put(COLORS.BLUE, ".__nine");
        colors.put(COLORS.WHITE, ".__ten");
    }
}
