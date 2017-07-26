package com.weichikj.controller;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author frank  zmm@honggroup.com.cn
 * @Description:  模拟登陆163邮箱，输入邮箱地址与用户名后，response是服务器返回的状态
 * @Package com.weichikj.controller
 * @ClassName: com.weichikj.controller.LoginController
 * @date 2017年07月26日 17:28
 */
public class LoginController {
    private   static   final  String LOGON_SITE =  "http://mail.163.com/" ;
    private   static   final  String LOGON_SITE1 =  "http://localhost/springmvc11/login.action" ;
    private   static   final   int  LOGON_PORT =  80 ;


    public static void main(String [] args){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(LOGON_SITE1);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("email", "br****@163.com"));
        nvps.add(new BasicNameValuePair("password", "16*****"));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("response.getStatusLine()==  "+response.getStatusLine());
            HttpEntity entity = response.getEntity();
            System.out.println("entity -->");
            System.out.println(entity);
            // do something useful with the response body
            // and ensure it is fully consumed
            try {
                EntityUtils.consume(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            if(null != response){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
