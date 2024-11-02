package top.ruizhihut.signleton_pattern_3;

/**
 * @description: 使用静态内部类持有单例对象
 * @author：ruizhi
 * @date: 2024/10/26
 * @Copyright：
 */
public class SingletonPattern4 {
    private SingletonPattern4(){

    }
    public static class InnerSingleton {
        private static SingletonPattern4 instance=new SingletonPattern4();// 自行创建实例
    }

    public static SingletonPattern4 getInstance() {
        return InnerSingleton.instance;
    }
}
