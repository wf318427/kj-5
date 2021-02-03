package cn.pg.config;

import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 5:41 下午
 */
public class RequestCachingInputStream extends ServletInputStream {

    private final ByteArrayInputStream inputStream;

    public RequestCachingInputStream(byte[] bytes) {
        inputStream = new ByteArrayInputStream(bytes);
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public boolean isFinished() {
        return inputStream.available() == 0;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener readlistener) {
    }

    public static void main(String[] args) throws IOException {
        byte[] bytes={1,3,5};
        RequestCachingInputStream stream=new RequestCachingInputStream(bytes);
        System.out.println(IOUtils.toString(stream.inputStream));
        System.out.println(bytes);
    }
}
