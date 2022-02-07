package com.chen.learnning.netty;

import java.nio.ByteBuffer;

public class TestByteBufferReadWrite {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 0x61);
        ByteBufferUtil.debugAll(buffer);

        buffer.put(new byte[] {0x62, 0x63, 0x64, 0x65});
        ByteBufferUtil.debugAll(buffer);

        buffer.flip();
        System.out.println(buffer.get());
        ByteBufferUtil.debugAll(buffer);

        buffer.compact();
        ByteBufferUtil.debugAll(buffer);

        buffer.put(new byte[] {0x66, 0x67, 0x68});
        ByteBufferUtil.debugAll(buffer);


        buffer.get(new byte[]{4});
        ByteBufferUtil.debugAll(buffer);

        buffer.rewind();
        System.out.println((char) buffer.get());

        // mark & reset
        // mark 做一个标记，记录 position 位置，reset 是将 position 重置到 mark 的位置

        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());

        buffer.mark();
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());

        buffer.reset();
        System.out.println((char)buffer.get());




    }
}
