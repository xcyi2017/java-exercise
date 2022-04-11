package GetPI;

public class ThreeGatesEXperiment {
    private int N;

    public ThreeGatesEXperiment(int N) {
        if (N <= 0)
            throw new IllegalArgumentException("N must be larger than 0!");
        this.N = N;
    }

    public void run(boolean changeDoor) {
        int wins = 0;
        for (int i = 0; i < N; i++) {
            if (paly(changeDoor))
                wins++;
        }
        System.out.println(changeDoor ? "Change" : "Not change");
        System.out.println("winning rate: " + (double) wins / N);
    }

    private boolean paly(boolean changeDoor) {
        // Door 0, 1, 2
        int prizeDoor = (int) (Math.random() * 3);
        int palyerChoice = (int) (Math.random() * 3);
        if (palyerChoice == prizeDoor) {
            return changeDoor ? false : true;
        } else {
            return changeDoor ? true : false;
        }
    }

    public static void main(String[] args) {
        int N = 10000;
        ThreeGatesEXperiment exp = new ThreeGatesEXperiment(N);
        
        exp.run(true);
        System.out.println();
        exp.run(false);


    }
}
