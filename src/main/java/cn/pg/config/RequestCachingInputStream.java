package cn.pg.config;

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
}
