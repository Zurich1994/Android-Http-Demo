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
	       HttpClient client = new DefaultHttpClient();  //����Httpclientʵ��
	    
		   HttpPost request = new HttpPost(URI.create(url));//ȷ�����󷽷�������ȡ��������Ӧ
		   List<NameValuePair> pairList = new ArrayList<NameValuePair>();//�������������List����
		   NameValuePair pair1 = new BasicNameValuePair("name","����");//��ֵ��
		   NameValuePair pair2 = new BasicNameValuePair("password","123456");
		   pairList.add(pair1);//�����ֵ��
		   pairList.add(pair2);
		   UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(pairList); //ʹ���������List���ϴ�������������ʵ��
			request.setEntity(requestEntity);//setEntity��HttpPost���еķ���,��ͨ��HttpRequest.setEntity()����������http����
			HttpResponse resp=client.execute(request);//�ͻ���ִ����Ӧ  ע��execute��ִ�е���˼��
			HttpEntity resEntity = resp.getEntity();//��ȡ��Ӧʵ�����
			String content = EntityUtils.toString(resEntity, "UTF-8");
			System.out.println("content:"+content);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	    
   }
}
