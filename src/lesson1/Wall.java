package lesson1;

public class Wall implements Obstacle {
    private final String name;
    private final int height;

    public Wall(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean youСanPass(Participant participant) {
        return participant.jump() >= height;
    }
}
