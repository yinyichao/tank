package degisn.bridge.test2;

/**
 * 如果礼物分为温柔的礼物和狂野的礼物
 * WarmGift  WildGift
 * 这时Flower应该分为
 * WarmFlower WildFlower
 * WarmBook WildBook
 *
 * 如果再有别的礼物，比如抽象类型：ToughGift ClodGift
 * 或者具体的某种实现：Ring Car
 *
 * 就会产生类的爆炸
 * WarmCar ClodRing WildCar WildFlower。。。
 */
public class GG {
    public void chase(MM mm) {
        Gift g = new Book();
        give(mm,g);
    }

    private void give(MM mm, Gift g) {

    }
}
