package dev.visualutils;

/** Ustawienia widoczne w zakladce "Opcje". Kazde ma kilka wartosci, klikniecie przelacza na nastepna. */
public enum Setting {
    TRACER_FROM("Tracery: start", "Skąd wychodzą linie", 0, "Dół ekranu", "Środek ekranu"),
    TRACER_COLOR("Tracery: kolor", "Kolor linii do celów", 0, "Wg typu celu", "Kolor motywu"),
    TRACER_WIDTH("Tracery: grubość", "Cienkie albo grube linie", 0, "Cienkie", "Grube"),
    ESP_STYLE("ESP: styl ramki", "Same rogi albo cała ramka", 0, "Rogi", "Pełna"),
    RANGE("Zasięg ESP i tracerów", "Maksymalny dystans celów (bloki)", 2, "64", "96", "128"),
    RADAR_RANGE("Zasięg radaru", "Ile bloków obejmuje radar", 1, "32", "48", "64", "96"),
    ZOOM_FOV("Zoom: FOV", "Im mniej, tym większe przybliżenie", 1, "15", "30", "45");

    private final String label;
    private final String description;
    private final int defaultIndex;
    private final String[] values;

    Setting(String label, String description, int defaultIndex, String... values) {
        this.label = label;
        this.description = description;
        this.defaultIndex = defaultIndex;
        this.values = values;
    }

    public String label() {
        return label;
    }

    public String description() {
        return description;
    }

    public int defaultIndex() {
        return defaultIndex;
    }

    public int count() {
        return values.length;
    }

    public String valueAt(int index) {
        return values[Math.floorMod(index, values.length)];
    }
}
