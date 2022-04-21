package cor;

import com.yin.tank.*;

public class BulletTankCollider extends Collider {
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            if(b.group == t.getGroup()) return true;
            if(b.rectangle.intersects(t.rectangle)) {
                t.die();
                b.die();
                int bX = t.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
                int bY = t.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
                new Explode(bX,bY);
                return false;
            }
        }else if(o1 instanceof Tank && o2 instanceof Bullet) {
            return collider(o2,o1);
        }
        return true;
    }
}
