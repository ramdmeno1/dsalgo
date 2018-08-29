package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowersOfHanoi {
    public static void main(String[] args) {
        List<Move> moves = tHanoi(2);
        System.out.println(Arrays.toString(moves.toArray()));
    }

    public static List<Move> tHanoi(int n) {
        List<Move> moves = new ArrayList<>();
        tHanoi(n, 0, 1, 2, moves);
        return moves;
    }

    public static void tHanoi(int n, int from, int to, int aux, List<Move> moves) {
        if (n == 1) {
            moves.add(new Move(n, from, to));
            return;
        }
        tHanoi(n-1, from, aux, to, moves);
        moves.add(new Move(n, from, to));
        tHanoi(n-1, aux, to, from, moves);
    }

    static class Move {
        int disk;
        int src;
        int dest;

        Move(int disk, int src, int dest) {
            this.disk = disk;
            this.src = src;
            this.dest = dest;
        }

        @Override
        public String toString() {
            return "Move disk " + disk + " from " + src + " to " + dest;
        }
    }
}
