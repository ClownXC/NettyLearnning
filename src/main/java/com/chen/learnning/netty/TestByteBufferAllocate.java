package com.chen.learnning.netty;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {

    public static void main(String[] args) {

        // class java.nio.HeapByteBuffer
        // class java.nio.HeapByteBuffer  堆内存， 读写效率较低，受到 GC 的影啊
        System.out.println(ByteBuffer.allocate(10).getClass());

        // class java.nio.DirectByteBuffer
        // class java.nio.DirectByteBuffer 直接内存，读写效率高（少一次拷贝），不会受 GC 影啊，分配效率低
        System.out.println(ByteBuffer.allocateDirect(10).getClass());





    }
}
