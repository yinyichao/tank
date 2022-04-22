package degisn.bridge.test3;

/**
 * 使用桥接模式
 * 分离抽象与具体实现，让他们可以独自发展
 * Gift -》 WarmGift ColdGift WildGift
 * GiftImpl -》 Flower Ring Car
 */
public class GG {
    public void chase(MM mm) {
        Gift g = new WarmGift(new Flower());
        give(mm, g);
    }

    private void give(MM mm, Gift g) {
        System.out.println(g + "gived!");
    }
}
