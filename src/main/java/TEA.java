

import org.apache.commons.codec.binary.Base64;

public class TEA {
	/**
	 * codePointAt  == js String.charCodeAt
	 * @param args
	 */
	
//	public static void main(String[] args) {
		//System.out.println(Integer.toString(4, 16));
//	}
	//uncode转字符
	static char fromCharCode(String s){
		return (char)Integer.parseInt(s,16);
	}
	
//	static char fromCharCode(int s){
//		return (char)s;
//	}
//	
	static char fromCharCode(long s){
		return (char)s;
	}
	
	static long[] u;
	static int a = 0;
	static long[] h , o,v;
	static long[] z;
	static int A = 0, w = 0; 
	static boolean p = true;
	
	static long f() {
		return Math.round(Math.random() * 4294967295l);
	}
	
	static long k(long[] E, int F,int B) {
		B = Math.min(4, B);
		long C = 0;
		for ( int D = F; D < F + B; D++) {
			C <<= 8;
			C |= E[D];
		}
		return (C & 4294967295l) >>> 0;
	}
	static void b(long[] C,int D,long B) {
		C[D + 3] = (B >> 0) & 255;
		C[D + 2] = (B >> 8) & 255;
		C[D + 1] = (B >> 16) & 255;
		C[D + 0] = (B >> 24) & 255;
	}
	
//	bytesInStr : y,
	static String y(long[] E) {
		if (null == E) {
			return "";
		}
		String B = "";
		for (int C = 0; C < E.length; C++) {
			String D = Long.toString(E[C], 16);
			if (D.length() == 1) {
				D = "0" + D;
			}
			B += D;
		}
		return B;
	}
	
	//bytesToStr : x,
	static String x(String C) {
		StringBuilder D = new StringBuilder();
		for (int B = 0; B < C.length(); B += 2) {
			D.append(fromCharCode(C.substring(B, B+2)));
		}
		return D.toString();
	}
	
//	strToBytes : c,
	static String strToBytes(String E,boolean B) {
		if (null == E) {
			return "";
		}
		if (B) {
			E = m(E);
		}
		long[] D = new long[E.length()];
		for (int C = 0; C < E.length(); C++) {
			D[C] = E.codePointAt(C);
		}
		return y(D);
	}
	static String m(String E) {
		int D, F;
		StringBuilder C = new StringBuilder();
		int B = E.length();
		for (D = 0; D < B; D++) {
			F = E.codePointAt(D);
			if (F > 0 && F <= 127) {
//				C.push(E.charAt(D))
				C.append(E.charAt(D));
			} else {
				if (F >= 128 && F <= 2047) {
					C.append(fromCharCode(192 | ((F >> 6) & 31))).append(fromCharCode(128 | (F & 63)));
				} else {
					if (F >= 2048 && F <= 65535) {
						C.append(fromCharCode(224 | ((F >> 12) & 15))).append(fromCharCode(128 | ((F >> 6) & 63))).append(fromCharCode(128 | (F & 63)));
					}
				}
			}
		}
		return C.toString();
	}
	static long[] j(long[] D) {
		h = new long[8];
		z = new long[8];
		A = w = 0;
		p = true;
		a = 0;
		int B = D.length;
		int E = 0;
		a = (B + 10) % 8;
		if (a != 0) {
			a = 8 - a;
		}
		o = new long[(B + a + 10)];
		h[0] = ((f() & 248) | a) & 255;
		for (int C = 1; C <= a; C++) {
			h[C] = f() & 255;
		}
		a++;
		for (int C = 0; C < 8; C++) {
			z[C] = 0;
		}
		E = 1;
		while (E <= 2) {
			if (a < 8) {
				h[a++] = f() & 255;
				E++;
			}
			if (a == 8) {
				r();
			}
		}
		int C = 0;
		while (B > 0) {
			if (a < 8) {
				h[a++] = D[C++];
				B--;
			}
			if (a == 8) {
				r();
			}
		}
		E = 1;
		while (E <= 7) {
			if (a < 8) {
				h[a++] = 0;
				E++;
			}
			if (a == 8) {
				r();
			}
		}
		return o;
	}
	
	static long[] s(long[] F) {
		int E = 0;
		long[] C = new long[8];
		int B = F.length;
		v = F;
		if (B % 8 != 0 || B < 16) {
			return null;
		}
		z = n(F);
		a = (int) (z[0] & 7);
		E = B - a - 10;
		if (E < 0) {
			return null;
		}
		for (int D = 0; D < C.length; D++) {
			C[D] = 0;
		}
		o = new long[E];
		w = 0;
		A = 8;
		a++;
		int G = 1;
		while (G <= 2) {
			if (a < 8) {
				a++;
				G++;
			}
			if (a == 8) {
				C = F;
				if (!g()) {
					return null;
				}
			}
		}
		int D = 0;
		while (E != 0) {
			if (a < 8) {
				o[D] = (C[w + a] ^ z[a]) & 255;
				D++;
				E--;
				a++;
			}
			if (a == 8) {
				C = F;
				w = A - 8;
				if (!g()) {
					return null;
				}
			}
		}
		for (G = 1; G < 8; G++) {
			if (a < 8) {
				if ((C[w + a] ^ z[a]) != 0) {
					return null;
				}
				a++;
			}
			if (a == 8) {
				C = F;
				w = A;
				if (!g()) {
					return null;
				}
			}
		}
		return o;
	}
	static void r() {
		for (int B = 0; B < 8; B++) {
			if (p) {
				h[B] ^= z[B];
			} else {
				h[B] ^= o[w + B];
			}
		}
		long[] C = l(h);
		for (int B = 0; B < 8; B++) {
			o[A + B] = C[B] ^ z[B];
			z[B] = h[B];
		}
		w = A;
		A += 8;
		a = 0;
		p = false;
	}
	
	static long[] l(long[] B) {
		int C = 16;
		long H = k(B, 0, 4);
		long G = k(B, 4, 4);
		long J = k(u, 0, 4);
		long I = k(u, 4, 4);
		long F = k(u, 8, 4);
		long E = k(u, 12, 4);
		long D = 0;
		long K = 2654435769l >>> 0;
		while (C-- > 0) {
			D += K;
			D = (D & 4294967295l) >>> 0;
			H += ((G << 4) + J) ^ (G + D) ^ ((G >>> 5) + I);
			H = (H & 4294967295l) >>> 0;
			G += ((H << 4) + F) ^ (H + D) ^ ((H >>> 5) + E);
			G = (G & 4294967295l) >>> 0;
		}
		long[] L = new long[8];
		b(L, 0, H);
		b(L, 4, G);
		return L;
	}
	static long[] n(long[] B) {
		int C = 16;
		long H = k(B, 0, 4);
		long G = k(B, 4, 4);
		long J = k(u, 0, 4);
		long I = k(u, 4, 4);
		long F = k(u, 8, 4);
		long E = k(u, 12, 4);
		long D = 3816266640l >>> 0;
		long K = 2654435769l >>> 0;
		while (C-- > 0) {
			G -= ((H << 4) + F) ^ (H + D) ^ ((H >>> 5) + E);
			G = (G & 4294967295l) >>> 0;
			H -= ((G << 4) + J) ^ (G + D) ^ ((G >>> 5) + I);
			H = (H & 4294967295l) >>> 0;
			D -= K;
			D = (D & 4294967295l) >>> 0;
		}
		long[] L = new long[8];
		b(L, 0, H);
		b(L, 4, G);
		return L;
	}
	static boolean g() {
//		int B = v.length;
		for (int C = 0; C < 8; C++) {
			z[C] ^= v[A + C];
		}
		z = n(z);
		A += 8;
		a = 0;
		return true;
	}
	
	//dataFromStr : q
	static long[] q(String F,boolean E) {
		long[] D;
		if (E) {
			D = new long[F.length()];
			for (int C = 0; C < F.length(); C++) {
				D[C] = F.codePointAt(C) & 255;
			}
		} else {
			int B = 0;
			D = new long[F.length()/2];
			for (int C = 0; C < F.length(); C += 2) {
				D[B++] = Integer.parseInt(F.substring(C,C + 2), 16);
			}
		}
		return D;
	}
	
	
	static String encrypt (String E,boolean D) {
		long[] C = q(E, D);
		long[] B = j(C);
		return y(B);
	}
	static String enAsBase64(String G,boolean F) {
		long[] E = q(G, F);
		long[] D = j(E);
		StringBuilder B = new StringBuilder();
		for (int C = 0; C < D.length; C++) {
			B.append(fromCharCode(D[C]));
		}
//		return btoa(B);
		return new String(Base64.encodeBase64(B.toString().getBytes()));
	}
	static String decrypt(String D) {
		long[] C = q(D, false);
		long[] B = s(C);
		return y(B);
	}
	static void initkey(String B,boolean C) {
		u = q(B, C);
	}
}
