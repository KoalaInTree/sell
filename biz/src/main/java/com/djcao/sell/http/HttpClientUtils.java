package com.djcao.sell.http;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/6
 */
public class HttpClientUtils {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        HttpClientUtils.sendHttps("https://121.8.131.196:8449/kunlun-gje/rest/gje/grantToken",null,"utf-8");
    }

    /**
     * ģ������
     *
     * @param url        ��Դ��ַ
     * @param map    �����б�
     * @param encoding    ����
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static String sendHttps(String url, Map<String,String> map,String encoding) throws KeyManagementException, NoSuchAlgorithmException,
        ClientProtocolException, IOException {
        String body = "";
        //�����ƹ���֤�ķ�ʽ����https����
        CloseableHttpClient client = new DefaultHttpClient();
        client = createIgnoreVerifySSL(client);
        //����post��ʽ�������
        HttpPost httpPost = new HttpPost(url);

        //װ�����
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(map!=null){
            for (Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //���ò��������������
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));

        //����header��Ϣ
        //ָ������ͷContent-type��User-Agent
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //ִ��������������õ������ͬ��������
        CloseableHttpResponse response = client.execute(httpPost);
        //��ȡ���ʵ��
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //��ָ������ת�����ʵ��ΪString����
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //�ͷ�����
        response.close();
        return body;
    }

    /**
     * ģ������
     *
     * @param url        ��Դ��ַ
     * @param map    �����б�
     * @param encoding    ����
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String send(String url, Map<String,String> map, String encoding) throws IOException, ParseException {
        String body = "";

        //����httpclient����
        CloseableHttpClient client = HttpClients.createDefault();
        //����post��ʽ�������
        HttpPost httpPost = new HttpPost(url);

        //װ�����
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(map!=null){
            for (Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //���ò��������������
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));

        System.out.println("�����ַ??"+url);
        System.out.println("�������??"+nvps.toString());

        //����header��Ϣ
        //ָ������ͷ???Content-type��??????User-Agent??
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //ִ��������������õ������ͬ��������
        CloseableHttpResponse response = client.execute(httpPost);
        //��ȡ���ʵ��
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //��ָ������ת�����ʵ��ΪString����
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //�ͷ�����
        response.close();
        return body;
    }

    /**
     * �ƹ���֤
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    private static CloseableHttpClient createIgnoreVerifySSL(CloseableHttpClient client) throws NoSuchAlgorithmException, KeyManagementException {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] xcs,
                                               String string) {
                }


                public void checkServerTrusted(X509Certificate[] xcs,
                                               String string) {
                }


                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            X509HostnameVerifier hv = new X509HostnameVerifier(){
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
                @Override
                public void verify(String arg0, SSLSocket arg1) throws IOException {
                }
                @Override
                public void verify(String arg0, X509Certificate arg1)
                    throws SSLException {
                }
                @Override
                public void verify(String arg0, String[] arg1, String[] arg2)
                    throws SSLException {
                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx,(X509HostnameVerifier) hv);
            ClientConnectionManager ccm = client.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("https", 443, ssf));
            return new DefaultHttpClient(ccm, client.getParams());
    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    }
    }
}
