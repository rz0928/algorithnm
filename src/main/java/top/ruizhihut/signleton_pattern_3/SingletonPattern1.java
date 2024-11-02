package top.ruizhihut.signleton_pattern_3;
/**
 * @description: 双检锁实现,懒汉模式
 * @author：ruizhi
 * @date: 2024/10/26
 * @Copyright：
 */
public class SingletonPattern1 {
    //volatile 用于禁止JVM指令重排
    public static volatile SingletonPattern1 INSTANCE;
    public SingletonPattern1 getINSTANCE() {
        if(INSTANCE == null){
            synchronized (SingletonPattern1.class){
                if(INSTANCE == null){
                    //具体的初始化逻辑
                    INSTANCE = new SingletonPattern1();
                    try{
                        Thread.sleep(350L);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return INSTANCE;
    }
    private SingletonPattern1(){
        //将构造方法改为静态，防止外部调用
    }
}