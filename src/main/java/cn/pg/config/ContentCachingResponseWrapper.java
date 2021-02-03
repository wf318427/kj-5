package cn.pg.config;

import org.apache.commons.io.output.TeeOutputStream;


import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/2/1 11:41 上午
 */

public class ContentCachingResponseWrapper extends HttpServletResponseWrapper {

    /**
     * 我们的分支流
     */
    private ByteArrayOutputStream output;
    private ServletOutputStream filterOutput;

    private OutputStream bufferOutputStream;

    public ContentCachingResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new ByteArrayOutputStream();
    }

    /**
     * 利用TeeOutputStream复制流，解决多次读写问题
     * 用super.getOutputStream来获取源outputstream，也可以用注释的那种方式获取，传过来
     * @return
     * @throws IOException
     */
    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (filterOutput == null) {
            filterOutput = new ServletOutputStream() {

                //替换构造方法
                //拿父类的response，初始化的时候，里面还没有数据，只有一些request信息和response信息,但是调用了创建outputStream,
                //private TeeOutputStream teeOutputStream = new TeeOutputStream(bufferOutputStream,output);
                private TeeOutputStream teeOutputStream = new TeeOutputStream(ContentCachingResponseWrapper.super.getOutputStream(),output);

                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public void setWriteListener(WriteListener writeListener) {

                }

                @Override
                public void write(int b) throws IOException {
                    teeOutputStream.write(b);
                }
            };
        }
        return filterOutput;
    }

    public byte[] toByteArray() {
        return output.toByteArray();
    }
}
