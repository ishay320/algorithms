import CycleDetection.cycleAlgo;
import CycleDetection.makeRandomCycle;
import org.junit.jupiter.api.Test;

public class cycle{
    @Test
    void parkingProblem(){
        makeRandomCycle root = new makeRandomCycle(98,0,15);
        root.setRandomDataInt(100);
        root.setRandomSign(10);
        cycleAlgo<Integer> c = new cycleAlgo<>(root.getRoot());
        System.out.println(root);
        System.out.println(c.parkingProblem()); //only on full loop
        System.out.println(root);
    }
    @Test
    void twoFingers(){
        makeRandomCycle root = new makeRandomCycle(98,6,4);
        root.setRandomDataInt(100);
        root.setRandomSign(10);
        cycleAlgo<Integer> c = new cycleAlgo<>(root.getRoot());
        System.out.println(root);
        System.out.println(c.twoFingersHaveLoop());
        System.out.println(c.twoFingersMeetingPoint());
        System.out.println(c.twoFingersCircleBegin(c.twoFingersMeetingPoint()));
        System.out.println(c.twoFingerLoopLength(c.twoFingersMeetingPoint()));
        System.out.println(root);

    }
}
