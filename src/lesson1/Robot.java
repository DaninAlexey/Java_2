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

    public String getName() {
        return name;
    }

    @Override
    public int runDistance() {
        return runningDistanceLimit;
    }

    @Override
    public int jumpWall() {
        return jumpHeightLimit;
    }
}
