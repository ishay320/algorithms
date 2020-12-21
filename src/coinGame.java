import java.util.Random;

public class coinGame{

    public static void main(String[] args){
        //setup
        Random r = new Random(1);
        int playerCount = 2;
        boolean[] coinToss = new boolean[playerCount];
        for (int i = 0; i < playerCount; i++) {
            coinToss[i] = r.nextBoolean();
        }
        boolean[] guesses = randomGuesses(coinToss);
        System.out.println("wins: "+check(guesses,coinToss));
    }
    public static boolean[] randomGuesses(boolean[] coinToss){
        boolean[] guesses = new boolean[coinToss.length];
        for (int i = 0; i < coinToss.length; i++) {
            guesses[i] = new Random().nextBoolean();
        }
        return guesses;
    }
    public static int check(boolean[] guesses, boolean[] coinToss){
        int wins = 0;
        for (int i = 0; i < guesses.length; i++) {
            if (guesses[i]==coinToss[i]) wins++;
        }
        return wins;
    }

}
