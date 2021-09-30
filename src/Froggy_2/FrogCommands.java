package Froggy_2;

public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        return new FrogCommand() {
            @Override
            public boolean doCommand() {
                return frog.jump(steps);
            }

            @Override
            public boolean undoCommand() {
                return frog.jump(-steps);
            }
        };
    }

    public static FrogCommand jumpLeftCommand(Frog frog, int steps) {
        return new FrogCommand() {
            @Override
            public boolean doCommand() {
                return frog.jump(-steps);
            }

            @Override
            public boolean undoCommand() {
                return frog.jump(steps);
            }
        };
    }
}
