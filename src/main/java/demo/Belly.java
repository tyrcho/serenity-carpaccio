package demo;

public class Belly {
    private int cukes;
    private int hours;

    public void eat(int cukes) {
        this.cukes = cukes;
    }

    public void waitFor(int hours) {
        this.hours = hours;
    }

    public boolean isHungry() {
        return cukes <= hours;
    }
}
