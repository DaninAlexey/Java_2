package lesson1;

public class OvercomingObstacles {

    public static void main(String[] args) {
        Robot r2d1 = new Robot("r2d1", 30, 50);
        Robot r2d2 = new Robot("r2d2", 50, 100);
        Robot r2d3 = new Robot("r2d3", 100, 50);
        Person obiWan = new Person("ObiWan", 200, 150);
        Person luke = new Person("Luke", 200, 150);
        Cat matroskin = new Cat("Matroskin", 15, 40);

        Wall wall1 = new Wall("маленькая стена", 10);
        Wall wall2 = new Wall("средняя стена", 40);
        Wall wall3 = new Wall("большая стена", 90);
        Wall wall4 = new Wall("огромная стена", 150);

        Treadmill treadmill1 = new Treadmill("маленькая дорожка", 10);
        Treadmill treadmill2 = new Treadmill("средняя дорожка", 40);
        Treadmill treadmill3 = new Treadmill("большая дорожка ", 90);
        Treadmill treadmill4 = new Treadmill("огромная дорожка", 150);

        Participant[] participants = {r2d1, r2d2, r2d3, matroskin, obiWan, luke};
        Obstacle[] obstacles = {wall1, treadmill1, wall2, treadmill2, wall3, treadmill3, wall4, treadmill4};

        for (Participant participant : participants) {

            if (participant instanceof Robot) {
                boolean fl = true;
                for (int i = 0; i < obstacles.length && fl; i++) {
                    if (obstacles[i].passObstacle(participant)) {
                        if (obstacles[i] instanceof Wall)
                            System.out.printf("Участник %s смог перепрыгнуть препятствие %s%n", ((Robot) participant).getName(), ((Wall) obstacles[i]).getName());
                        if (obstacles[i] instanceof Treadmill)
                            System.out.printf("Участник %s смог пробежать препятствие %s%n", ((Robot) participant).getName(), ((Treadmill) obstacles[i]).getName());
                    } else {
                        if (obstacles[i] instanceof Wall)
                            System.out.printf("Участник %s не смог перепрыгнуть препятствие %s%n", ((Robot) participant).getName(), ((Wall) obstacles[i]).getName());
                        if (obstacles[i] instanceof Treadmill)
                            System.out.printf("Участник %s не смог пробежать препятствие %s%n", ((Robot) participant).getName(), ((Treadmill) obstacles[i]).getName());
                        fl = false;
                    }
                }
            }

            if (participant instanceof Person) {
                boolean fl = true;
                for (int i = 0; i < obstacles.length && fl; i++) {
                    if (obstacles[i].passObstacle(participant)) {
                        if (obstacles[i] instanceof Wall)
                            System.out.printf("Участник %s смог перепрыгнуть препятствие %s%n", ((Person) participant).getName(), ((Wall) obstacles[i]).getName());
                        if (obstacles[i] instanceof Treadmill)
                            System.out.printf("Участник %s смог пробежать препятствие %s%n", ((Person) participant).getName(), ((Treadmill) obstacles[i]).getName());
                    } else {
                        if (obstacles[i] instanceof Wall)
                            System.out.printf("Участник %s не смог перепрыгнуть препятствие %s%n", ((Person) participant).getName(), ((Wall) obstacles[i]).getName());
                        if (obstacles[i] instanceof Treadmill)
                            System.out.printf("Участник %s не смог пробежать препятствие %s%n", ((Person) participant).getName(), ((Treadmill) obstacles[i]).getName());
                        fl = false;
                    }
                }
            }

            if (participant instanceof Cat) {
                boolean fl = true;
                for (int i = 0; i < obstacles.length && fl; i++)  {
                    if (obstacles[i].passObstacle(participant)) {
                        if (obstacles[i] instanceof Wall)
                            System.out.printf("Участник %s смог перепрыгнуть препятствие %s%n", ((Cat) participant).getName(), ((Wall) obstacles[i]).getName());
                        if (obstacles[i] instanceof Treadmill)
                            System.out.printf("Участник %s смог пробежать препятствие %s%n", ((Cat) participant).getName(), ((Treadmill) obstacles[i]).getName());
                    } else {
                        if (obstacles[i] instanceof Wall)
                            System.out.printf("Участник %s не смог перепрыгнуть препятствие %s%n", ((Cat) participant).getName(), ((Wall) obstacles[i]).getName());
                        if (obstacles[i] instanceof Treadmill)
                            System.out.printf("Участник %s не смог пробежать препятствие %s%n", ((Cat) participant).getName(), ((Treadmill) obstacles[i]).getName());
                        fl = false;
                    }
                }
            }
            System.out.println();
        }
    }
}
