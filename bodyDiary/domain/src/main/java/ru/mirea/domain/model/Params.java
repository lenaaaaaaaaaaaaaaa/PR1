package ru.mirea.domain.model;

public class Params {
    private final String date;
    private final Integer height;
    private final Integer weight;
    private final Integer waist;
    private final Integer hips;
    private final Integer breast;

    public Params(String date, Integer height, Integer weight, Integer waist, Integer hips, Integer breast) {
        this.date = date;
        this.height = height;
        this.weight = weight;
        this.waist = waist;
        this.hips = hips;
        this.breast = breast;
    }

    public String getDate() {
        return date;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getWaist() {
        return waist;
    }

    public Integer getHips() {
        return hips;
    }

    public Integer getBreast() {
        return breast;
    }

    @Override
    @SuppressWarnings("DefaultLocale")
    public String toString() {
        return String.format(
                "%s %d %d %d %d %d;",
                date,
                height,
                weight,
                waist,
                hips,
                breast
        );
    }

    public static Params parseFromString(String string) {
        var parts = string.substring(string.length() - 1).split(" ");
        return new Params(
                parts[0],
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]),
                Integer.parseInt(parts[3]),
                Integer.parseInt(parts[4]),
                Integer.parseInt(parts[5])
        );
    }
}
