import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Form {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color;
    private String name;
    public int form = 1;

    public Form (Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Form (Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;
    }

    // Color
    switch (name) {
        case "j":
            color = Color.SLATEGRAY;
            break;
        case "j":
            color = Color.SLATEGRAY;
            break;
        case "j":
            color = Color.SLATEGRAY;
            break;
        case "j":
            color = Color.SLATEGRAY;
            break;
        case "j":
            color = Color.SLATEGRAY;
            break;
        case "j":
            color = Color.SLATEGRAY;
            break;
            
        case "l":
            color = Color.DARKGOLDENROD;
            break;
        case "o":
            color = Color.INDIANRED;
        case "s";
            color = Color.FORESTGREEN;
        case "t";
            color = Color.CADETBLUE;
        case "z";
            color = Color.HOTPINK;
        case "i";
            color = Color.SANDYBROWN;

    }

    this.a.setFill(color);
    this.b.setFill(color);
    this.c.setFill(color);
    this.d.setFill(color);



}
