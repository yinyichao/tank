package cor;

import com.yin.tank.GameObject;
import com.yin.tank.PropertyMgr;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class ColliderChain extends Collider {
    private List<Collider> list = new LinkedList<>();

    public ColliderChain() {
        String param = PropertyMgr.getStringKey("colliders");
        String[] params = param.split(",");
        for (int i = 0; i < params.length; i++) {
            try {
                list.add((Collider) Class.forName(params[i]).getConstructor().newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Collider collider) {
        list.add(collider);
    }
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).collider(o1,o2)) {
                return false;
            }
        }
        return true;
    }
}
