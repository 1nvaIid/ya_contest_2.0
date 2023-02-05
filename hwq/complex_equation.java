package ya_contest20_hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class complex_equation {

	BufferedReader br;
	StringTokenizer in;
	PrintWriter out;

	public String nextToken() throws IOException {
		while (in == null || !in.hasMoreTokens()) {
			try {
				in = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				return "fail";
			}
		}

		return in.nextToken();

	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public static void main(String[] args) throws IOException {

		new complex_equation().run();
	}


	public void solve() throws IOException {
		double a = nextDouble(), b = nextDouble(), c = nextDouble(), d = nextDouble();
		double x = -b/a;
		if(-d/c == -b/a) {
			out.println("NO");
		}else if(a == 0 && b == 0){
			out.println("INF");
		}else if((int) x == x) {
			out.println((int)x);
		}else {
			out.println("NO");
		}
	}

	public void run() {
		try {
			br = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
//				br = new BufferedReader(new InputStreamReader(System.in));
//				out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
