package conflicts;

public class ConflictsSolver {

    private static boolean conflictsSolved = false;

    public static boolean isConflictsSolved() {
        return conflictsSolved;
    }

    public static void setConflictsSolved(boolean conf) {
        conflictsSolved = conf;
    }

    /**
     * This is a conflit solver method, modify me to have conflicts after pull from the git remote
     */
    void thisWilBeAConflict(){
        System.out.println("Conflit will be solved!!");
        if(isConflictSolved()){
            printConflictsToScreen(); // TODO add a new comment
            System.out.println("Conflit was solved!!");
        }

    }

    private boolean isConflictSolved() {
        return conflictsSolved;
    }

    private void printConflictsToScreen() {

        System.out.println("Conflict will be solved!!");
    }
}
