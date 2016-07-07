package com.jdk.Enum.equal;

import com.jdk.Enum.WeekDayEnum;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by a549238 on 3/29/2016.
 * test Enum equals
 */
public class EnumClient {
    public static void main(String[] args) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("127.0.0.1", 8899));
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(WeekDayEnum.Fri);
            oos.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
