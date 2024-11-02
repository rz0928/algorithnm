package top.ruizhihut.signleton_pattern_3;

/**
 * @description: 饿汉模式
 * @author：ruizhi
 * @date: 2024/10/26
 * @Copyright：
 */
public class SingletonPattern2 {
    public static final SingletonPattern2 INSTANCE = new SingletonPattern2();
    public SingletonPattern2 getInstance(){
        return INSTANCE;
    }
}
