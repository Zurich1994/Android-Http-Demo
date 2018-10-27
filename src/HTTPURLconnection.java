import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;




public class HTTPURLconnection {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		String address= "http://www.baidu.com/index.html";
	     
		byte[]  b =  httpClinet(address);
		String a =new String(b);
		System.out.print(a);
	}
	static byte[] httpClinet(String address) throws IOException {
		
	    URL source =new URL(address);  
		HttpURLConnection conn = (HttpURLConnection)source.openConnection();
        //		 创建HttpURLConnection 实例

	      conn.setConnectTimeout(10000);//设置超时时间，首部，请求方法
	      conn.setReadTimeout(10000);
	      conn.setRequestMethod("GET");
	      conn.setRequestProperty("Accept","image/jpeg,*/*");
	      conn.setRequestProperty("Connection","close");
	      long size = conn.getContentLength();
	      InputStream in = conn.getInputStream();//获取服务器响应输入流
	      ByteArrayOutputStream out = new ByteArrayOutputStream();
	      byte[] buffer = new byte[1024];
	       while(true){
	    	   int len = in.read(buffer);
	    	   if(len==-1){break;}
	    	   out.write(buffer, 0, len);
	       }
	       in.close();
	       out.close();
	       return out.toByteArray();
		
		   
	    
   }
}
