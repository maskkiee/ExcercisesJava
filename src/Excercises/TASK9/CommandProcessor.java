package Excercises.TASK9;

final class CommandProcessor {
    static void processCommand(String cmd) {
        if (cmd.equals("ARG")) {
            throw new IllegalArgumentException("bad arg");
        } else if (cmd.equals("STATE")) {
            throw new IllegalArgumentException("bad state");
        } else {
            System.out.println("Command processed: " + cmd);
        }

    }

    static void demo() {
        String[] commands = {"ARG", "STATE", "OK"};
        for (String command : commands) {
            try {
                processCommand(command);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Caught: " + e.getClass().getSimpleName() + " " + e.getMessage());
            }
        }

    }
}
