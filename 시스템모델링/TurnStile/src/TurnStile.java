public class TurnStile {
    private State itsState;
    private static String itsVersion="1.0";
    private static Locked itsLockedState;
    private static Unlocked itsUnlockedState;

    public TurnStile() {
        itsLockedState = new Locked();
        itsUnlockedState = new Unlocked();

        itsState = itsLockedState;
    }

    public String getVersion() {
        return itsVersion;
    }

    public String getCurrentStateName() {
        return itsState.stateName();
    }

    public void Pass() {
        itsState.pass();
    }

    public void Coin() {
        itsState.coin();
    }

    private abstract class State {
        public abstract String stateName();
        public abstract void pass();
        public abstract void coin();
        public void Alarm() {
            System.out.println("Current State: " + itsState.stateName() + "\tEvent: Alarm");
        }
        public void Unlock() {
            System.out.println("Current State: " + itsState.stateName() + "\tEvent: Unlocked");
        }
        public void Lock() {
            System.out.println("Current State: " + itsState.stateName() + "\tEvent: Locked");
        }
        public void Thankyou() {
            System.out.println("Current State: " + itsState.stateName() + "\tEvent: Thank you");
        }
    }

    private class Locked extends State {
        @Override
        public String stateName() {
            return "Locked";
        }

        @Override
        public void pass() {
            Alarm();
            itsState = itsLockedState;
        }

        @Override
        public void coin() {
            Unlock();
            itsState = itsUnlockedState;
        }
    }

    private class Unlocked extends State {
        @Override
        public String stateName() {
            return "Unlocked";
        }

        @Override
        public void pass() {
            Lock();
            itsState = itsLockedState;
        }

        @Override
        public void coin() {
            Thankyou();
            itsState = itsUnlockedState;
        }
    }

    public static void main(String[] args) {
        TurnStile stile = new TurnStile();

        System.out.println("===========\n\t" + stile.getVersion() + "\n===========");
        System.out.println(stile.itsState.stateName());
        System.out.println("=== Insert Coin ===");
        stile.Coin();
        System.out.println(stile.itsState.stateName());
        System.out.println("=== Pass ===");
        stile.Pass();
        System.out.println(stile.itsState.stateName());
        System.out.println("=== Pass ===");
        stile.Pass();
    }
}
