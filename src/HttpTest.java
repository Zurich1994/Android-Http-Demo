import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class HttpTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
     String url= "http://www.baidu.com";
     
     httpClinet(url);
	}
   static void httpClinet(String url) throws ClientProtocolException, IOException {
		try {
	       HttpClient client = new DefaultHttpClient();  //创建Httpclient实例
	    
		   HttpPost request = new HttpPost(URI.create(url));//确定请求方法，并获取服务器相应
		   List<NameValuePair> pairList = new ArrayList<NameValuePair>();//创建请求参数的List集合
		   NameValuePair pair1 = new BasicNameValuePair("name","李游");//键值对
		   NameValuePair pair2 = new BasicNameValuePair("password","123456");
		   pairList.add(pair1);//加入键值对
		   pairList.add(pair2);
		   UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(pairList); //使用请求参数List集合创建并设置请求实体
			request.setEntity(requestEntity);//setEntity是HttpPost特有的方法,并通过HttpRequest.setEntity()方法来发出http请求。
			HttpResponse resp=client.execute(request);//客户端执行响应  注：execute是执行的意思。
			HttpEntity resEntity = resp.getEntity();//获取响应实体对象
			String content = EntityUtils.toString(resEntity, "UTF-8");
			System.out.println("content:"+content);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	    
   }
}
