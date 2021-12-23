package lesson1;

public class Robot implements Participant {
    private final String name;
    private final int jumpHeightLimit;
    private final int runningDistanceLimit;

    public Robot(String name, int jumpHeightLimit, int runningDistanceLimit) {
        this.name = name;
        this.jumpHeightLimit = jumpHeightLimit;
        this.runningDistanceLimit = runningDistanceLimit;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int run() {
        return runningDistanceLimit;
    }

    @Override
    public int jump() {
        return jumpHeightLimit;
    }
}
