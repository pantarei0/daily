package tools;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpCon {

	public static void main(String[] args) throws Exception{
		if(args.length != 1) {
			System.err.println("Usage : HttpCon PROTOCOL://ADDRESS:PORT/...");
			System.exit(1);
		}

		URL url = new URL(args[0]);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();

		//Print Headers
		Map<String, List<String>> headers = con.getHeaderFields();
		System.out.println(headers.get(null).get(0)); //응답코드를 우선 출력

		Iterator<String> iter = headers.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			if(key == null) {
				continue;
			}
			List<String> value = headers.get(key);
			System.out.println(key + ": " + (value.size() == 1 ? value.get(0) : value));
			//2개 이상인 경우 어떻게 표시해야 하나?
		}
		System.out.println();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while((line = reader.readLine()) != null) {
//				result.append(line);
				System.out.println(line);
			}
		}finally {
			if(reader != null) {
				reader.close();
			}
		}
	}
}
