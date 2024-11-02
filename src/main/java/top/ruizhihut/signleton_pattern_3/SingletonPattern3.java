package top.ruizhihut.signleton_pattern_3;

/**
 * @description: 使用枚举持有单例对象
 * 1. 反序列化不会创建新对象 2. 反射调用枚举实例化会报错
 * @author：ruizhi
 * @date: 2024/10/26
 * @Copyright：
 */
public class SingletonPattern3 {
    private SingletonPattern3(){

    }
    private enum Singleton{
        INSTANCE;

        private final SingletonPattern3 instance;
        Singleton(){
            instance = new SingletonPattern3();
        }
        private SingletonPattern3 getInstance(){
            return instance;
        }
    }
    public static SingletonPattern3 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
}
