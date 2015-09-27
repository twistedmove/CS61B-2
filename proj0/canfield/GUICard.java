/**
 * @author MadcowD
 */
package canfield;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * @author MadcowD
 * The card sprite class
 */
class GUICard {
    
    /** Displayed dimensions of a card image. */
    private static final int HEIGHT = 125, WIDTH = 90;
    
    private static final int PADDING = 10;
    private static final int REVEAL = 30;
    
    /**
     * @param repr The representation of the card.
     * @param pos The center position of the card.
     * @param image The image of the card.
     * @param layer The layer of the card.
     */
    public GUICard(Card repr, CardType type, Point pos, int layer) {
        super();
        
        this.repr = repr;
        this.type = type;
        
        int x = (int)pos.getX() - WIDTH/2;
        int y = (int)pos.getY() - HEIGHT/2;
        
        this.boundingBox = new Rectangle(x,y,WIDTH,HEIGHT);
       
        this.image = this.getCardImage(repr);
        
        this.layer = layer;
    }
    
    
    
    /* ==== Sudo Event Listeners ==== */
    
    public void onDrag(Point pos) {}
    public void onRelease(Point pos, boolean justified) {}
    
    /* ==== Getters/Setters ==== */
    /**
     * @return the layer
     */
    public int getLayer() {
        return this.layer;
    }
    /**
     * @param layer the layer to set
     */
    public void setLayer(int layer) {
        this.layer = layer;
    }
    /**
     * @return the repr
     */
    public Card getRepr() {
        return this.repr;
    }
    /**
     * @return the boundingBox
     */
    public Rectangle getBoundingBox() {
        return this.boundingBox;
    }
    /**
     * @return the image
     */
    public Image getImage() {
        return this.image;
    }
    
    /**
     * @return the center of the bounding box.
     */
    public Point getCenter(){
        int x = (int)this.boundingBox.getCenterX();
        int y = (int)this.boundingBox.getCenterY();
        
        return new Point(x,y);
    }
    
    public Point getPos(){
        return boundingBox.getLocation();
    }
    
    /* ==== Helpers ==== */
    
    /** Return an Image read from the resource named NAME. */
    
    /** Return an Image of CARD. */
    private Image getCardImage(Card card) {
        if(card != Card.BACK)
            return GameDisplay.getImage("playing-cards/" + card + ".png");
        else
            return getBackImage();
    }

    /** Return an Image of the back of a card. */
    private Image getBackImage() {
        return GameDisplay.getImage("playing-cards/blue-back.png");
    }
    
    /**
     * @return the type
     */
    public CardType getType() {
        return this.type;
    }

    
    /* ==== Fields ==== */
    private Card repr; 
    private CardType type;
    private Rectangle boundingBox;
    private Image image;
    private int layer;
}