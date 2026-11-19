import java.util.List;
import java.util.NoSuchElementException;

// immutable reversi class that takes up relatively little space
public final class Reversi {
    public static final int ROWS = 8;
    public static final int COLS = 8;

    public static final int EMPTY = -1;
    public static final int BLACK = 0;
    public static final int WHITE = 1;

    // The BLACK_START and WHITE_START values look mysterious, especially if you don't know how bit
    // shifting and bitwise or work. Look those up first. My explanation will assume you already
    // understand bitwise operations and shifts.
    //
    // The starting position for a game of reversi looks like this:
    //
    // _ _ _ _ _ _ _ _
    // _ _ _ _ _ _ _ _
    // _ _ _ _ _ _ _ _
    // _ _ _ B W _ _ _
    // _ _ _ W B _ _ _
    // _ _ _ _ _ _ _ _
    // _ _ _ _ _ _ _ _
    // _ _ _ _ _ _ _ _
    //
    // Each bit of our black and white variables represents the value of a space on that board: a 1
    // bit in black means it's black, a 1 bit in white means it's white, and a 0 bit in both means
    // it's empty. A 1 bit in both is not possible.
    //
    // We map the bits of a long to the positions on the board as follows: the top row of the board
    // consists of bits 0 to 7, the second row is bits 8 to 15, etc:
    //
    // 0 1 2 3 4 5 6 7
    // 8 9 ...
    //
    // This means that the two starting black pieces are bits 27 and 36, and the starting white
    // pieces are bits 28 and 35. We shift a 1 into these positions and combine them with a bitwise
    // OR to create the starting position.
    private long black, white;
    private static final long BLACK_START = (1L << 27) | (1L << 36);
    private static final long WHITE_START = (1L << 28) | (1L << 35);

    // Is this a bit (haha) much? The moves variable combines the following:
    //
    // - each 1 bit represents a legal move at that position
    // - the center (bits 27, 28, 35, and 36) will never be legal moves in standard reversi, and can
    //   therefore be used to store additional information:
    //   - bit 27 indicates whose turn it is (0 for BLACK, 1 for WHITE)
    //   - bit 28 indicates whether the game has ended (1 for yes, 0 for no)
    //   - bits 35 and 36 aren't used for anything, but are available if we wanted to store any more
    // information
    //
    // The point of all this is to minimize the space taken up by each instance while also
    // precomputing the possible moves, which is expensive.
    private long moves;
    private static final int TURN_BIT = 27;
    private static final long TURN_MASK = 1L << TURN_BIT;
    private static final int GAME_OVER_BIT = 28;
    private static final long GAME_OVER_MASK = 1L << GAME_OVER_BIT;
    private static final long CENTER = BLACK_START | WHITE_START;

    public Reversi() {
        this(BLACK_START, WHITE_START, BLACK);
    }

    private Reversi(long black, long white, int turn) {
        this.black = black;
        this.white = white;
        precomputeMoves(turn);
    }

    private void precomputeMoves(int turn) {
        long moveBits = 0;
        int plr = turn;
        int opp = (turn + 1) % 2;
        for (Pos pos : Pos.POSITIONS) {
            if (checkMove(pos, plr)) {
                moveBits = moveBits | pos.mask;
            }
        }

        moves = moveBits | (((long) turn) << TURN_BIT);

        if (moveBits == 0) {
            for (Pos pos : Pos.POSITIONS) {
                if (checkMove(pos, opp)) {
                    // opp can move, so game isn't over
                    return;
                }
            }

            // opp couldn't move either, so we set game over bit
            moves = moves | GAME_OVER_MASK;
        }
    }

    // TODO: I could probably make this way more efficient by using some bitwise operations to only
    // check the empty spaces bordering the opponent's pieces and checking all of those moves at
    // once.
    private boolean checkMove(Pos pos, int turn) {
        if (!isEmpty(pos)) {
            return false;
        }

        long[] board = {black, white};
        int plr = turn;
        int opp = (turn + 1) % 2;

        for (Pos.Dir dir : Pos.DIRS) {
            Pos next = pos.next(dir);
            // edge of board, nothing to flip
            if (next == null) {
                continue;
            }

            // no opponent piece to flip
            if ((board[opp] & next.mask) == 0) {
                continue;
            }

            // search for pos without opp's piece
            do {
                next = next.next(dir);
            } while (next != null && (board[opp] & next.mask) != 0);

            // if our piece is at the end of this run, then we can flip something and it's a legal
            // move
            if (next != null && (board[plr] & next.mask) != 0) {
                return true;
            }
        }

        return false;
    }

    public int get(int row, int col) {
        return get(Pos.valueOf(row, col));
    }

    public int get(Pos pos) {
        if ((black & pos.mask) != 0) {
            return BLACK;
        }
        if ((white & pos.mask) != 0) {
            return WHITE;
        }
        return EMPTY;
    }

    public int blackCount() {
        return Long.bitCount(black);
    }

    public int whiteCount() {
        return Long.bitCount(white);
    }

    public static boolean inBounds(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    public boolean isEmpty(int row, int col) {
        return isEmpty(Pos.valueOf(row, col));
    }

    public boolean isEmpty(Pos pos) {
        return ((black | white) & pos.mask) == 0;
    }

    public boolean isBlack(int row, int col) {
        return isBlack(Pos.valueOf(row, col));
    }

    public boolean isBlack(Pos pos) {
        return (black & pos.mask) != 0;
    }

    public boolean isWhite(int row, int col) {
        return isWhite(Pos.valueOf(row, col));
    }

    public boolean isWhite(Pos pos) {
        return (white & pos.mask) != 0;
    }

    public int turn() {
        return (int) ((moves & TURN_MASK) >>> TURN_BIT);
    }

    public boolean gameOver() {
        return (moves & GAME_OVER_MASK) != 0;
    }

    public boolean isLegal(int row, int col) {
        return isLegal(Pos.valueOf(row, col));
    }

    // null pos means pass
    public boolean isLegal(Pos pos) {
        long moveBits = moves & (~CENTER);
        return !gameOver()
                && ((moveBits == 0 && pos == null) || (pos != null && (moveBits & pos.mask) != 0));
    }

    public Reversi move(int row, int col) {
        return move(Pos.valueOf(row, col));
    }

    // null pos means pass
    public Reversi move(Pos pos) {
        if (!isLegal(pos)) {
            return null;
        }

        int plr = turn();
        int opp = (turn() + 1) % 2;

        if (pos == null) {
            return new Reversi(black, white, opp);
        }

        long[] board = {black, white};

        // plr gains placed piece
        board[plr] = board[plr] | pos.mask;

        for (Pos.Dir dir : Pos.DIRS) {
            Pos next = pos.next(dir);
            // edge of board, nothing to flip
            if (next == null) {
                continue;
            }

            // no opponent piece to flip
            if ((board[opp] & next.mask) == 0) {
                continue;
            }

            long flipMask = 0;

            // add each opponent's piece to the mask
            do {
                flipMask = flipMask | next.mask;
                next = next.next(dir);
            } while (next != null && (board[opp] & next.mask) != 0);

            // if our piece is at the end of this run, then we can flip something and it's a legal
            // move
            if (next != null && (board[plr] & next.mask) != 0) {
                // opp retains only the bits outside of the mask
                board[opp] = board[opp] & (~flipMask);
                // plr gains the bits in the mask
                board[plr] = board[plr] | flipMask;
            }
        }

        return new Reversi(board[BLACK], board[WHITE], opp);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(72);
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                sb.append(
                        switch (get(row, col)) {
                            case BLACK -> 'B';
                            case WHITE -> 'W';
                            default -> '-';
                        });
            }
            sb.append('/');
        }
        return sb.toString();
    }

    public Moves getLegalMoves() {
        return new Moves(gameOver(), moves & (~CENTER));
    }

    public static final class Moves {
        private long moves;
        private boolean gameOver, pass;

        Moves(boolean gameOver, long moves) {
            this.gameOver = gameOver;
            this.moves = moves;
            this.pass = !gameOver && moves == 0;
        }

        public Pos next() {
            if (pass) {
                pass = false;
                return null;
            }

            if (gameOver || moves == 0) {
                throw new NoSuchElementException();
            }

            long mask = Long.lowestOneBit(moves);

            // remove the mask's bit from the moves
            moves = moves & (~mask);

            return Pos.valueOfMask(mask);
        }

        public boolean hasNext() {
            return pass || moves != 0;
        }

        public int count() {
            return pass ? 1 : Long.bitCount(moves);
        }
    }

    // This feels like a really silly thing to create, especially given how little it affects your
    // code. However, I feel a strong compulsion to do it anyway, and maybe it'll turn out to be
    // worth doing.
    //
    // The ideas behind Pos are:
    //
    // - Creating a Pos performs a bounds check, and an existing Pos is guaranteed to be in bounds.
    // - All 64 valid Pos instances are generated ahead of time, and new instances cannot be
    //   created. This avoids creating a bunch of redundant instances for what is basically just an
    //   overengineered 6-bit unsigned integer. Use the valueOf method to get the appropriate Pos
    //   for a given row and col.
    // - Useful properties (row, col, bitmask, string) are precomputed. No idea if this was even
    //   worth doing, but there are only 64 of them so it's not like I'm wasting much memory.
    // - The Dir enum simplifies moving between neighboring positions, which will make the reversi
    //   logic easier to code.
    public static final class Pos {
        public static enum Dir {
            N(-1, 0),
            NE(-1, 1),
            E(0, 1),
            SE(1, 1),
            S(1, 0),
            SW(1, -1),
            W(0, -1),
            NW(-1, -1);
            final int deltaRow, deltaCol, deltaIndex;

            private Dir(int dr, int dc) {
                deltaRow = dr;
                deltaCol = dc;
                deltaIndex = dr * 8 + dc;
            }

            public Dir opposite() {
                return switch (this) {
                    case N -> S;
                    case NE -> SW;
                    case E -> W;
                    case SE -> NW;
                    case S -> N;
                    case SW -> NE;
                    case W -> E;
                    case NW -> SE;
                };
            }
        };

        public static final List<Dir> DIRS;
        public static final List<Pos> POSITIONS;

        public static int MAX_BIT_INDEX = ROWS * COLS;

        private static final Pos[] positions;

        static {
            positions = new Pos[MAX_BIT_INDEX];
            for (int i = 0; i < MAX_BIT_INDEX; i++) {
                positions[i] = new Pos(i);
            }
            DIRS = List.of(Dir.N, Dir.NE, Dir.E, Dir.SE, Dir.S, Dir.SW, Dir.W, Dir.NW);
            POSITIONS = List.of(positions);
        }

        public final int row, col, bitIndex;
        public final long mask;
        public final String str;

        private Pos(int i) {
            bitIndex = i;
            row = (bitIndex & 0b111000) >> 3;
            col = bitIndex & 0b111;
            mask = 1L << bitIndex;
            str = String.format("r%dc%d", row, col);
        }

        public static Pos valueOf(int row, int col) {
            if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
                throw new IllegalArgumentException("row and col must be from 0 to 7");
            }
            return positions[(row << 3) | col];
        }

        public static Pos valueOfBitIndex(int bitIndex) {
            if (bitIndex < 0 || bitIndex >= MAX_BIT_INDEX) {
                throw new IllegalArgumentException(
                        "bitIndex must be from 0 to " + (MAX_BIT_INDEX - 1));
            }
            return positions[bitIndex];
        }

        public static Pos valueOfMask(long mask) {
            if (Long.bitCount(mask) != 1) {
                throw new IllegalArgumentException(
                        "mask must contain exactly 1 1-bit and 63 0-bits");
            }
            // the number of zeros after the 1-bit is the bitIndex
            return positions[Long.numberOfTrailingZeros(mask)];
        }

        public String toString() {
            return str;
        }

        public Pos next(Dir dir) {
            int r = row + dir.deltaRow;
            int c = col + dir.deltaCol;
            if (r < 0 || r >= ROWS || c < 0 || c >= COLS) {
                return null;
            } else {
                return positions[bitIndex + dir.deltaIndex];
            }
        }
    }
}
