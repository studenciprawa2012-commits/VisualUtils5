package dev.visualutils;

/** Kolory motywu (akcent menu i HUD) oraz male funkcje pomocnicze do kolorow. */
public final class Theme {

    public static final int[] ACCENTS = {
            0xFF8B6CFF, // fiolet
            0xFF3DDC97, // zielony
            0xFF4DA3FF, // niebieski
            0xFFFF6B6B, // czerwony
            0xFFFFB84D, // pomaranczowy
            0xFFFF6BD6  // rozowy
    };

    private Theme() {}

    public static int accent() {
        return ACCENTS[Math.floorMod(Config.getTheme(), ACCENTS.length)];
    }

    /** Ten sam kolor, ale z innym przezroczystoscia (alpha 0-255). */
    public static int withAlpha(int color, int alpha) {
        return (alpha << 24) | (color & 0x00FFFFFF);
    }

    /** Plynne przejscie miedzy dwoma kolorami ARGB. */
    public static int lerp(int a, int b, float t) {
        t = Math.max(0f, Math.min(1f, t));
        int aa = (int) (((a >>> 24) & 0xFF) + ((((b >>> 24) & 0xFF) - ((a >>> 24) & 0xFF)) * t));
        int ar = (int) (((a >>> 16) & 0xFF) + ((((b >>> 16) & 0xFF) - ((a >>> 16) & 0xFF)) * t));
        int ag = (int) (((a >>> 8) & 0xFF) + ((((b >>> 8) & 0xFF) - ((a >>> 8) & 0xFF)) * t));
        int ab = (int) ((a & 0xFF) + (((b & 0xFF) - (a & 0xFF)) * t));
        return (aa << 24) | (ar << 16) | (ag << 8) | ab;
    }
}
