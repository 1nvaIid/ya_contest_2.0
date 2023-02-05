package ya_contest20_hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class parallelogram {

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

		new parallelogram().run();
	}

	public boolean isparallel_and_eqal(Point a, Point b, Point c, Point d) {	
		return (c.y - d.y) * (b.x - a.x) == (a.y - b.y) * (d.x - c.x) && ((b.x - a.x) * (b.x - a.x)
				+ (b.y - a.y) * (b.y - a.y) == (d.x - c.x) * (d.x - c.x) + (d.y - c.y) * (d.y - c.y));
	}

//	3
//	1 1 4 2 3 0 2 3
//	1 1 5 2 2 3 3 0
//	0 0 5 1 6 3 1 2
	
	public void solve() throws IOException {
		int n = nextInt();
		for (int i = 0; i < n; i++) {
			Point A = new Point(nextDouble(), nextDouble());
			Point B = new Point(nextDouble(), nextDouble());
			Point C = new Point(nextDouble(), nextDouble());
			Point D = new Point(nextDouble(), nextDouble());
			if (isparallel_and_eqal(A, B, C, D)
					&& (isparallel_and_eqal(A, C, B, D) || isparallel_and_eqal(A, D, C, B))) {
				out.println("YES");
			} else if (isparallel_and_eqal(A, C, B, D)
					&& (isparallel_and_eqal(A, B, C, D) || isparallel_and_eqal(A, D, C, B))) {
				out.println("YES");
			} else if (isparallel_and_eqal(A, D, B, C)
					&& (isparallel_and_eqal(A, B, C, D) || isparallel_and_eqal(A, C, D, B))) {
				out.println("YES");
			} else {
				out.println("NO");
			}
		}
	}

	public void run() {
		try {
			br = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
//					br = new BufferedReader(new InputStreamReader(System.in));
//					out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}

class Point {
	double x;
	double y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
