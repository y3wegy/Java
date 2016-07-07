package com.jdk.Enum.equal;

import com.jdk.Enum.WeekDayEnum;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by a549238 on 3/29/2016.
 * in distributed  server ,enum == operation  may be not work ,so need careful
 */
public class EnumServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8899);
            Socket socket = server.accept();
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            WeekDayEnum day = (WeekDayEnum) ois.readObject();


            //by if
            if (day == WeekDayEnum.Fri)
                System.out.println("Client Friday enum value is same as server's");
            else if (day.equals(WeekDayEnum.Fri))
                System.out.println("Client Friday enum value is equal to server's");
            else
                System.out.println("Client Friday enum is not same as server's");

            //by switch
            switch (day) {
                case Mon:
                    System.out.println("Do Monday Work");
                    break;
                case Tue:
                    System.out.println("Do Tueday Work");
                    break;
                case Wed:
                    System.out.println("Do Wednesday Work");
                    break;
                case Thu:
                    System.out.println("Do Thursday Work");
                    break;
                case Fri:
                    System.out.println("Do Friday Work");
                    break;
                case Sat:
                    System.out.println("Do Saturday Work");
                    break;
                case Sun:
                    System.out.println("Do Sunday Work");
                    break;
                default:
                    System.out.println("invalidate Enum");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
