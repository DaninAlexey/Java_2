package lesson1;

public class Treadmill implements Obstacle {
    private final String name;
    private final int length;

    public Treadmill(String name, int length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean youСanPass(Participant participant) {
        return participant.run() >= length;
    }
}
