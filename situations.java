package ya_contest20_hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class situations {

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

		new situations().run();
	}

	public void solve() throws IOException {
		int xwin = 0, owin = 0;
		int countx = 0, counto = 0;
		int a;
		Line[] line = new Line[8];
		int[] xo = new int[9];
		for (int i = 0; i < 9; i++) {
			a = nextInt();
			xo[i] = a;
			if (a == 1) {
				countx += 1;
			} else if (a == 2) {
				counto += 1;
			}
		}
		line[0] = new Line(xo[0], xo[1], xo[2]);
		line[1] = new Line(xo[3], xo[4], xo[5]);
		line[2] = new Line(xo[6], xo[7], xo[8]);
		line[3] = new Line(xo[0], xo[3], xo[6]);
		line[4] = new Line(xo[1], xo[4], xo[7]);
		line[5] = new Line(xo[2], xo[5], xo[8]);
		line[6] = new Line(xo[0], xo[4], xo[8]);
		line[7] = new Line(xo[2], xo[4], xo[6]);
		for (int i = 0; i < line.length; i++) {
			if (line[i].isx()) {
				xwin += 1;
			} else if (line[i].iso()) {
				owin += 1;
			}
		}
		if (owin == 1 && xwin == 0 && countx == counto) {
			System.out.println("YES");
		} else if (owin == 0 && (xwin == 1 || xwin == 2) && counto + 1 == countx) {
			System.out.println("YES");
		} else if (owin == 0 && xwin == 0 && (countx == counto || counto + 1 == countx)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	public void run() {
		try {
			br = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
//						br = new BufferedReader(new InputStreamReader(System.in));
//						out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}

class Line {
	int a;
	int b;
	int c;

	Line(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;

	}

	public boolean isx() {
		if (a == b && a == c && a == 1) {
			return true;
		}
		return false;
	}

	public boolean iso() {
		if (a == b && a == c && a == 2) {
			return true;
		}
		return false;
	}
}
