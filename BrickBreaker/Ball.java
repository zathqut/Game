package BrickBreaker;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;

/**
 * This method creates the ball and makes its properties.
 * @author Tyler, Last updated: 2/24/2020
 */
public class Ball extends StandardGameObject {

    private int ballWidth = 15;
    private int ballHeight = 15;
    private int ballVelocityX = 5;
    private int ballVelocityY = -5;

    /**
     * This method declares the balls parameters.
     * @param _x
     * @param _y
     * @param sh
     */
    public Ball(double _x, double _y, StandardHandler sh) {
        super(_x, _y, StandardID.Ball);
        sh.addEntity(this);
        this.width = ballWidth;
        this.height = ballHeight;
        this.velX = ballVelocityX;
        this.velY = ballVelocityY;
    }

    /**
     * This method is the motion of the ball along with the other in objects.
     * the game and putting them into motion all as one.
     */
    @Override
    public void tick() {
        //This acts as a bounce back when it reaches the window bounds. Collision of the ball and the left and right walls.
        if (this._x < 0 || this._x >= Game.window.width() - this.width) {
            this.velX = -this.velX;
        }
        //If it hits the top of the window it will go back into the canvas and continue. Collision with the top wall.
        if (this._y < 0) {
            this.velY = -this.velY;
        }
        //If it goes past the paddle then it display a losing message.
        if (this._y >= Game.window.height()) {
            JOptionPane.showMessageDialog(null, "You lost! Your score was: " + Game.score);
            System.exit(0);
        }
        //This is the movement of the ball
        //This is the vertical motion of the ball.
        this._x += this.velX;
        //This is the motion of the ball horizontally.
        this._y += this.velY;
    }

    /**
     * This method draws the ball onto the canvas.
     * @param ball
     */
    @Override
    public void render(Graphics2D ball) {
        ball.setColor(Color.blue);
        ball.fillOval((int) _x, (int) _y, (int) this.width, (int) this.height);
    }
}
