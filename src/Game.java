import com.xebisco.yield.*;

public class Game extends YldGame {

    @Override
    public void create() {
        view.setBgColor(Colors.WHITE);
        Texture texture = loadTexture(new Texture("com/xebisco/yield/assets/yieldlogo.png"));
        instantiate(e -> {
            e.addComponent(new Sprite());
            e.addComponent(new Presentation());
            e.getMaterial().setTexture(texture);
            e.center();
        });
    }

    public static void main(String[] args) {
        GameConfiguration config = new GameConfiguration();
        Ini.file(new RelativeFile("config.ini"), config);
        launch(new Game(), config);
    }
}

class Presentation extends YldScript {
    @Override
    public void create() {
        Sprite sprite = getComponent(Sprite.class);
        sprite.setSize(new Vector2(400, 400));
    }

    float counter;

    @Override
    public void update(float delta) {
        counter += delta * 3;
        transform.rotation = (float) Math.cos(counter) * 15;
    }
}