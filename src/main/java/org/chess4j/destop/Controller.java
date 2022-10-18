package org.chess4j.destop;

import java.net.URL;
import java.util.Objects;

import org.chess4j.model.Board;
import org.chess4j.model.Game;
import org.chess4j.model.Piece;
import org.chess4j.model.Player.Color;
import org.chess4j.model.SimpleGame;
import org.chess4j.model.Tile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    private static final URL BLACK_BISHOP_URL = Controller.class.getResource("images/BlackBishop.png");

    private static final URL BLACK_KING_URL = Controller.class.getResource("images/BlackKing.png");

    private static final URL BLACK_KNIGHT_URL = Controller.class.getResource("images/BlackKnight.png");

    private static final URL BLACK_PAWN_URL = Controller.class.getResource("images/BlackPawn.png");

    private static final URL BLACK_QUEEN_URL = Controller.class.getResource("images/BlackQueen.png");

    private static final URL BLACK_ROOK_URL = Controller.class.getResource("images/BlackRook.png");

    private static final URL WHITE_BISHOP_URL = Controller.class.getResource("images/WhiteBishop.png");

    private static final URL WHITE_KING_URL = Controller.class.getResource("images/WhiteKing.png");

    private static final URL WHITE_KNIGHT_URL = Controller.class.getResource("images/WhiteKnight.png");

    private static final URL WHITE_PAWN_URL = Controller.class.getResource("images/WhitePawn.png");

    private static final URL WHITE_QUEEN_URL = Controller.class.getResource("images/WhiteQueen.png");

    private static final URL WHITE_ROOK_URL = Controller.class.getResource("images/WhiteRook.png");

    @FXML
    private Node board;

    private boolean isFirstInput = true;

    private final Game game = new SimpleGame();

    @FXML
    public void processInput(ActionEvent e) {
        Button btn = (Button) e.getSource();
        if (isFirstInput) {
            game.setStart(Tile.valueOf(btn.getId()));
            isFirstInput = false;
        } else {
            game.setEnd(Tile.valueOf(btn.getId()));
            try {
                game.move();
                isFirstInput = true;
            } catch (Exception exception) {
                System.out.println(exception);
                isFirstInput = true;
            }
        }
        setPiecesOnBoard();
    }

    public void setPiecesOnBoard() {
        Board position = game.position();
        for (Tile tile : Tile.values()) {
            Button btn = (Button) board.lookup("#" + tile.toString());
            btn.setGraphic(getImage(position.get(tile)));

        }
    }

    private ImageView getImage(Piece piece) {
        if(Objects.isNull(piece)) {
            return null;
        }
        Image image;
        switch (piece.type()) {
        case BISHOP:
            image = piece.color() == Color.WHITE ? new Image(WHITE_BISHOP_URL.toString())
                    : new Image(BLACK_BISHOP_URL.toString());
            break;
        case KING:
            image = piece.color() == Color.WHITE ? new Image(WHITE_KING_URL.toString())
                    : new Image(BLACK_KING_URL.toString());
            break;
        case KNIGHT:
            image = piece.color() == Color.WHITE ? new Image(WHITE_KNIGHT_URL.toString())
                    : new Image(BLACK_KNIGHT_URL.toString());
            break;
        case PAWN:
            image = piece.color() == Color.WHITE ? new Image(WHITE_PAWN_URL.toString())
                    : new Image(BLACK_PAWN_URL.toString());
            break;
        case QUEEN:
            image = piece.color() == Color.WHITE ? new Image(WHITE_QUEEN_URL.toString())
                    : new Image(BLACK_QUEEN_URL.toString());
            break;
        case ROOK:
            image = piece.color() == Color.WHITE ? new Image(WHITE_ROOK_URL.toString())
                    : new Image(BLACK_ROOK_URL.toString());
            break;
        default:
            throw new RuntimeException("Unknown Piece");
        }

        ImageView view = new ImageView(image);
        view.setFitHeight(75);
        view.setPreserveRatio(true);

        return view;
    }

}
