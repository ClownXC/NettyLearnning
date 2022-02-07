package com.chen.learnning.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 1. 向 buffer 写入数据，例如调用 channel.read(buffer)
 * 2. 调用 flip() 切换至读模式: flip会使得buffer中的limit变为position，position变为0
 * 3. 从 buffer 读取数据，例如调用 buffer.get()
 * 调用 clear() 或者compact()切换至写模式
 * 调用clear()方法时position=0，limit变为capacity
 * 调用compact()方法时，会将缓冲区中的未读数据压缩到缓冲区前面
 * 重复以上步骤
 */
@Slf4j
public class HelloByteBuffer {

    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            // 获得缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            int hasNext = 0;
            StringBuilder builder = new StringBuilder();
            while((hasNext = channel.read(buffer)) > 0) {
                // 切换模式 limit=position, position=0
                buffer.flip();
                // 当buffer中还有数据时，获取其中的数据
                while(buffer.hasRemaining()) {
                    builder.append((char)buffer.get());
                }
                // 切换模式 position=0, limit=capacity
                buffer.clear();
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
