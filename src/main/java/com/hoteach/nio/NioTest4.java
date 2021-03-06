package com.hoteach.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hekai
 * @create 2017-10-21-15:26
 */
public class NioTest4 {

    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream("input.txt");
            FileOutputStream outputStream = new FileOutputStream("output.txt")){

            FileChannel inputChannel = inputStream.getChannel();
            FileChannel outputChannel = outputStream.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true){
                buffer.clear();
                int read = inputChannel.read(buffer);
                System.out.println(read);
                if(read == -1){
                    break;
                }
                buffer.flip();
                outputChannel.write(buffer);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
