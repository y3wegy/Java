package com.test;

import org.junit.Test;

import java.io.*;

public class INC {

    @Test
    public void aa() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\a549238\\Desktop\\a.txt")));
            StringBuilder sb = new StringBuilder(9000);
            String line = null;
            int index = 1;
            while ((line = buff.readLine()) != null) {
                String[] client_fund = line.split(",");
                String client_id = client_fund[0];
                String fund_id = client_fund[1];
                sb.append("Insert into RTS_FUND_HEADER (ID,CLIENT_ID,FUND_ID,CLIENT_NAME,FUND_NAME,LAST_UPDATE_DATE,LAST_UPDATE_BY) values (")
                        .append(index++).append(",'").append(client_id).append("','").append(fund_id).append("','NAME',null,sysdate,'A549238');").append("\n");
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
