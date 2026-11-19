import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) {
        new App();
    }

    private Reversi game;
    private Stack<Reversi> history;
    private ArrayList<Reversi.Pos> moves;

    private JFrame frame;
    private JPanel drawPanel;
    private int gridPadding = 25, gridCellSize = 100, piecePadding = 10;
    private Color borderColor = Color.BLACK,
            backgroundColor = Color.GREEN,
            blackPieceColor = Color.BLACK,
            whitePieceColor = Color.WHITE;

    public App() {
        game = new Reversi();
        history = new Stack<>();
        moves = new ArrayList<>();
        updateMoves();

        int panelSize = gridPadding * 2 + gridCellSize * 8;

        drawPanel =
                new JPanel() {
                    @Override
                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        // border
                        g.setColor(borderColor);
                        for (int i = 0; i <= 8; i++) {
                            int start = gridPadding;
                            int end = gridPadding + gridCellSize * 8;
                            int offset = gridPadding + gridCellSize * i;
                            // horizontal
                            g.drawLine(start, offset, end, offset);
                            // vertical
                            g.drawLine(offset, start, offset, end);
                        }

                        // pieces
                        for (int r = 0; r < 8; r++) {
                            for (int c = 0; c < 8; c++) {
                                if (game.isBlack(r, c)) {
                                    g.setColor(blackPieceColor);
                                } else if (game.isWhite(r, c)) {
                                    g.setColor(whitePieceColor);
                                } else {
                                    continue;
                                }

                                g.fillOval(
                                        gridPadding + piecePadding + r * gridCellSize,
                                        gridPadding + piecePadding + c * gridCellSize,
                                        gridCellSize - 2 * piecePadding,
                                        gridCellSize - 2 * piecePadding);
                            }
                        }

                        // moves
                        if (game.turn() == Reversi.BLACK) {
                            g.setColor(blackPieceColor);
                        } else {
                            g.setColor(whitePieceColor);
                        }
                        for (Reversi.Pos move : moves) {
                            g.drawOval(
                                    gridPadding + piecePadding + move.row * gridCellSize,
                                    gridPadding + piecePadding + move.col * gridCellSize,
                                    gridCellSize - 2 * piecePadding,
                                    gridCellSize - 2 * piecePadding);
                        }
                    }
                };
        drawPanel.setBackground(backgroundColor);
        drawPanel.setPreferredSize(new Dimension(panelSize, panelSize));
        drawPanel.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            int gridRow = (e.getX() - gridPadding) / gridCellSize;
                            int gridCol = (e.getY() - gridPadding) / gridCellSize;
                            if (Reversi.inBounds(gridRow, gridCol)
                                    && game.isLegal(gridRow, gridCol)) {
                                history.push(game);
                                game = game.move(gridRow, gridCol);
                                // pass if appropriate
                                if (game.isLegal(null)) {
                                    history.push(game);
                                    game = game.move(null);
                                }
                                updateMoves();
                                drawPanel.repaint();
                            }
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            if (!history.isEmpty()) {
                                game = history.pop();
                                // skip pass
                                if (game.isLegal(null)) {
                                    game = history.pop();
                                }
                                updateMoves();
                                drawPanel.repaint();
                            }
                        }
                    }
                });

        frame = new JFrame("Reversi");
        frame.add(drawPanel);
        frame.setFocusable(true);
        frame.requestFocus();
        frame.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            System.exit(0);
                        }
                    }
                });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateMoves() {
        moves.clear();
        Reversi.Moves m = game.getLegalMoves();
        while (m.hasNext()) {
            Reversi.Pos move = m.next();
            // no null check; shouldn't be called when pass is allowed
            moves.add(move);
        }
    }
}
