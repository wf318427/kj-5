package cn.pg.test;


/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 4:15 下午
 */
public class Hello {


    public void say() {
        System.out.println("Hello");
    }

    public void say1(byte[] bytes) {

        System.out.println(new String(bytes));
    }

    public void say1(String bytes) {

        System.out.println(new String(bytes));
    }
}

