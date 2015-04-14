import java.util.Date;


public class RSA {
	static String navigatorAppName;
	static String aC = "F20CE00BAE5361F8FA3AE9CEFA495362FF7DA1BA628F64A347F0A8C012BF0B254A30CD92ABFFE7A6EE0DC424CB6166F8819EFA5BCCB20EDFB4AD02E412CCF579B1CA711D55B8B0B3AEB60153D5E0693A2A86F3167D7847A0CB8B00004716A9095D9BADC977CBB804DBDCBA6029A9710869A453F27DFDDF83C016D928B3CBF4C7";
	static String z = "3";
	
//	public static void main(String[] args) {
//		System.out.println(rsa_encrypt(""));
//	}

	public static String rsa_encrypt(String aD) {
		N t = new N();
		t.setPublic(aC, z);
		return t.encrypt(aD);
	}
	
	interface AI{
		au convert(Object t);

		void sqrTo(au aG, au aC);

		void mulTo(au aC, au aF, au aG);

		au revert(au aG);
	}
	
	
	private static void uv_alert(String str){
		if(str != null){
			throw new RuntimeException(str);
		}
	}
	
	private static boolean isEmpty(String str){
		return str == null || str.length() == 0;
	}
	
	private static au h(String z,int t){
		return new au(z, t);
	}
	
	private static au ah(String aD, int aG){
		return new au(aD, aG);
	}
	private static _m aq(){
		return new _m();
	}
	
	private static int l(long z) {
		long aC;
		int aD = 1;
		if ((aC = z >>> 16) != 0) {
			z = aC;
			aD += 16;
		}
		if ((aC = z >> 8) != 0) {
			z = aC;
			aD += 8;
		}
		if ((aC = z >> 4) != 0) {
			z = aC;
			aD += 4;
		}
		if ((aC = z >> 2) != 0) {
			z = aC;
			aD += 2;
		}
		if ((aC = z >> 1) != 0) {
			z = aC;
			aD += 1;
		}
		return aD;
	}
	
	
	static class au{
		int ay;
		long ak = 244837814094590l;
		boolean ab = ((ak & 16777215) == 15715070);
		final int DB ;
		final int DM ;
		final int DV ;
		final int ac = 52;
		final long FV = (long) Math.pow(2, ac);
		final int F1 ;
		final int F2 ;
		final String ag = "0123456789abcdefghijklmnopqrstuvwxyz";
		final int[] ai;
		
		int t;
		int s;
		
		int[] result;
		
		static au ZERO ,ONE;
		
		static{
			ZERO = c(0);
			ONE = c(1);
		}
		
		public au(){
			if("Microsoft Internet Explorer".equals(navigatorAppName)){
				ay = 30;
			}else if("Netscape".equals(navigatorAppName)){
				ay = 28;
			}else{
				ay = 26;
			}
			DB = ay;
			DM = ((1 << ay) - 1);
			DV = (1 << ay);
			F1 = ac - ay;
			F2 = 2 * ay - ac;
			ai = new int['z' + 1];
			int ar = '0',x;
			for (x = 0; x <= 9; ++x) {
				ai[ar++] = x;
			}
			ar = 'a';
			for (x = 10; x < 36; ++x) {
				ai[ar++] = x;
			}
			ar = 'A';
			for (x = 10; x < 36; ++x) {
				ai[ar++] = x;
			}
		}
		
		public au(Object z, Object t,Object aC) {
			this();
			if (z != null) {
				if(z instanceof Number){
					
				}else if(z instanceof String ){
					//int var = 0;
					if(t == null){
						fromString((String)z,256);
					}else if(t instanceof Integer){
						fromString((String)z,(Integer)t);
					}
				}
//				if ("number" == typeof z) {
//					this.fromNumber(z, t, aC)
//				} else {
//					if (t == null && "string" != typeof z) {
//						this.fromString(z, 256)
//					} else {
//						this.fromString(z, t)
//					}
//				}
			}
		}
		
		public au(Object z, Object t) {
			this(z, t, null);
		}
		
		public au(Object z) {
			this(z, null, null);
		}
		
		void fromString(String aGVar, int z) {
			int aD;
			if (z == 16) {
				aD = 4;
			} else if (z == 8) {
					aD = 3;
			} else if (z == 256) {
					aD = 8;
			} else if (z == 2) {
					aD = 1;
			} else if (z == 32) {
					aD = 5;
			} else if (z == 4) {
					aD = 2;
			} else {
//									this.fromRadix(aG, z);
				uv_alert("AU---------------------------");
				return;
			}
			char[] aG = aGVar.toCharArray();
			
			this.t = 0;
			this.s = 0;
			int aF = aG.length;
			boolean aC = false;
			int aE = 0;
			while (--aF >= 0) {
				
				int varT = (aD == 8) ? aG[aF] & 255 : C(aG, aF);
				if (varT < 0) {
					if (aGVar.charAt(aF) == '-') {
						aC = true;
					}
					continue;
				}
				aC = false;
				//TODO
				if (aE == 0) {
//					this[this.t++] = varT;
				} else {
//					if (aE + aD > this.DB) {
//						this[this.t - 1] |= (varT & ((1 << (this.DB - aE)) - 1)) << aE;
//						this[this.t++] = (varT >> (this.DB - aE));
//					} else {
//						this[this.t - 1] |= varT << aE;
//					}
				}
				aE += aD;
				if (aE >= this.DB) {
					aE -= this.DB;
				}
			}
			if (aD == 8 && (aG[0] & 128) != 0) {
				this.s = -1;
				if (aE > 0) {
					//TODO
//					this[this.t - 1] |= ((1 << (this.DB - aE)) - 1) << aE
				}
			}
			//TODO
//			this.clamp();
			if (aC) {
				//TODO
				ZERO.subTo(this, this);
			}
		}
		
		static au j(){
			return new au(null);
		}
		
		int am(int aE,int aJ,int[] aK,int aD,int aH,int t){
			if("Microsoft Internet Explorer".equals(navigatorAppName)){
				return aA(aE, aJ, aK, aD, aH, t);
			}else if("Netscape".equals(navigatorAppName)){
				return az(aE, aJ, aK, aD, aH, t);
			}else{
				return b(aE, aJ, aK, aD, aH, t);
			}
		}
		
		
		int b(int aE,int t, int[] z,int aD,int aG, int aF) {
			while (--aF >= 0) {
//				int aC = t * this[aE++] + z[aD] + aG;
				int aC = 0;//TODO
				aG = (int) Math.floor(aC / 67108864);
				z[aD++] = aC & 67108863;
			}
			return aG;
		}
		
		int aA(int aE,int aJ,int[] aK,int aD,int aH,int t) {
			int aG = aJ & 32767, aI = aJ >> 15;
			while (--t >= 0) {
//				int aC = this[aE] & 32767;
//				int aF = this[aE++] >> 15;
				int aC = 0,aF = 0;//TODO
				int z = aI * aC + aF * aG;
				aC = aG * aC + ((z & 32767) << 15) + aK[aD] + (aH & 1073741823);
				aH = (aC >>> 30) + (z >>> 15) + aI * aF + (aH >>> 30);
				aK[aD++] = aC & 1073741823;
			}
			return aH;
		}
		int az(int aE,int aJ,int[] aK,int aD,int aH,int t) {
			int aG = aJ & 16383, aI = aJ >> 14;
			while (--t >= 0) {
//				int aC = this[aE] & 16383;
//				int aF = this[aE++] >> 14;
				int aC = 0,aF = 0;//TODO
				int z = aI * aC + aF * aG;
				aC = aG * aC + ((z & 16383) << 14) + aK[aD] + aH;
				aH = (aC >> 28) + (z >> 14) + aI * aF;
				aK[aD++] = aC & 268435455;
			}
			return aH;
		}
		
		char aB(int t){
			return ag.charAt(t);
		}
		
		int C(char[] z,int t){
			int pos = z[t];
			if (pos >= ai.length) {
				return -1;
			}
			return ai[pos];
		}
		
		int bitLength() {
			if (this.t <= 0) {
				return 0;
			}
//			return this.DB * (this.t - 1);
//					+ l(this[this.t - 1] ^ (this.s & this.DM));
			return 0;//TODO
		}
		
		boolean isEven() {
//			return ((this.t > 0) ? (this[0] & 1) : this.s) == 0;
			return true;//TODO
		}
		
		au modPowInt(long aC,au t) {
			AI aD;
			if (aC < 256 || t.isEven()) {
				aD = new M(t);
			} else {
				aD = new g(t);
			}
			return this.exp(aC, aD);
		}
		
		au exp(long aH, AI aI) {
			if (aH > 4294967295l || aH < 1) {
				return au.ONE;
			}
			au aG = j(), aC = j();
			au aF = aI.convert(this);
			int aE = l(aH) - 1;
			aF.copyTo(aG);
			while (--aE >= 0) {
				aI.sqrTo(aG, aC);
				if ((aH & (1 << aE)) > 0) {
					aI.mulTo(aC, aF, aG);
				} else {
					au aD = aG;
					aG = aC;
					aC = aD;
				}
			}
			return aI.revert(aG);
		}
		
		void copyTo(au z) {
			for ( int t = this.t - 1; t >= 0; --t) {
//				z[t] = this[t];//TODO
				
			}
			z.t = this.t;
			z.s = this.s;
		}
		
		au negate() {
			au varT = j();
			ZERO.subTo(this, varT);
			return varT;
		}
		
		au an() {
			return (this.s < 0) ? this.negate() : this;
		}
		
		static au c(int t) {
			au z = j();
			z.fromInt(t);
			return z;
		}
		
		void fromInt(int t) {
			this.t = 1;
			this.s = (t < 0) ? -1 : 0;
			if (t > 0) {
//				this[0] = t;//TODO
			} else {
				if (t < -1) {
//					this[0] = t + DV;//TODO
				} else {
					this.t = 0;
				}
			}
		}
		
		void subTo(au z, au aD) {
			//TODO
			int aC = 0, aE = 0, t = Math.min(z.t, this.t);
//			while (aC < t) {
//				aE += this[aC] - z[aC];
//				aD[aC++] = aE & this.DM;
//				aE >>= this.DB;
//			}
//			if (z.t < this.t) {
//				aE -= z.s;
//				while (aC < this.t) {
//					aE += this[aC];
//					aD[aC++] = aE & this.DM;
//					aE >>= this.DB;
//				}
//				aE += this.s;
//			} else {
//				aE += this.s;
//				while (aC < z.t) {
//					aE -= z[aC];
//					aD[aC++] = aE & this.DM;
//					aE >>= this.DB;
//				}
//				aE -= z.s;
//			}
//			aD.s = (aE < 0) ? -1 : 0;
//			if (aE < -1) {
//				aD[aC++] = this.DV + aE;
//			} else {
//				if (aE > 0) {
//					aD[aC++] = aE;
//				}
//			}
//			aD.t = aC;
//			aD.clamp();
		}
		
		public String toString(int z) {
			if (this.s < 0) {
				return "-" + this.negate().toString(z);
			}
			int aC;
			if (z == 16) {
				aC = 4;
			} else {
				if (z == 8) {
					aC = 3;
				} else {
					if (z == 2) {
						aC = 1;
					} else {
						if (z == 32) {
							aC = 5;
						} else {
							if (z == 4) {
								aC = 2;
							} else {
//								return this.toRadix(z);
								uv_alert("------------------------------------");
								return null;
							}
						}
					}
				}
			}
			int aE = (1 << aC) - 1;
			int aH = 0;
			boolean t = false;
			String aF = "";
			int aD = this.t;
			int aG = this.DB - (aD * this.DB) % aC;
			if (aD-- > 0) {
				//TODO
//				if (aG < this.DB && (aH = this[aD] >> aG) > 0) {
//					t = true;
//					aF = String.valueOf(aB(aH));
//				}
				while (aD >= 0) {
					//TODO
//					if (aG < aC) {
//						aH = (this[aD] & ((1 << aG) - 1)) << (aC - aG);
//						aH |= this[--aD] >> (aG += this.DB - aC);
//					} else {
//						aH = (this[aD] >> (aG -= aC)) & aE;
//						if (aG <= 0) {
//							aG += this.DB;
//							--aD;
//						}
//					}
					if (aH > 0) {
						t = true;
					}
					if (t) {
						aF += aB(aH);
					}
				}
			}
			return t ? aF : "0";
		}
	}
	
	static class M implements AI{
		final au m ;
		public M(au t) {
			this.m = t;
		}
		
		@Override
		public au convert(Object t) {
			return null;
		}

		@Override
		public void sqrTo(au aG, au aC) {
			
		}

		@Override
		public void mulTo(au aC, au aF, au aG) {
			
		}

		@Override
		public au revert(au aG) {
			return null;
		}
		
//		function M(t) {
//			this.m = t
//		}
//		function X(t) {
//			if (t.s < 0 || t.compareTo(this.m) >= 0) {
//				return t.mod(this.m)
//			} else {
//				return t
//			}
//		}
//		function am(t) {
//			return t
//		}
//		function L(t) {
//			t.divRemTo(this.m, null, t)
//		}
//		function J(t, aC, z) {
//			t.multiplyTo(aC, z);
//			this.reduce(z)
//		}
//		function aw(t, z) {
//			t.squareTo(z);
//			this.reduce(z)
//		}
	}

	
    static class g implements AI{
    	private au m;
		private Object mp;
		private Object mpl;
		private int um;
		private Object mt2;
		private Object mph;

		public g(au t) {
    		this.m = t;
//    		this.mp = t.invDigit();
//    		this.mpl = this.mp & 32767;
//    		this.mph = this.mp >> 15;
    		this.um = (1 << (t.DB - 15)) - 1;
//    		this.mt2 = 2 * t.t;
    	}
//    	function al(t) {
//    		var z = j();
//    		t.abs().dlShiftTo(this.m.t, z);
//    		z.divRemTo(this.m, null, z);
//    		if (t.s < 0 && z.compareTo(au.ZERO) > 0) {
//    			this.m.subTo(z, z)
//    		}
//    		return z
//    	}
//    	function av(t) {
//    		var z = j();
//    		t.copyTo(z);
//    		this.reduce(z);
//    		return z
//    	}
//    	function R(t) {
//    		while (t.t <= this.mt2) {
//    			t[t.t++] = 0
//    		}
//    		for ( var aC = 0; aC < this.m.t; ++aC) {
//    			var z = t[aC] & 32767;
//    			var aD = (z * this.mpl + (((z * this.mph + (t[aC] >> 15) * this.mpl) & this.um) << 15))
//    					& t.DM;
//    			z = aC + this.m.t;
//    			t[z] += this.m.am(0, aD, t, aC, 0, this.m.t);
//    			while (t[z] >= t.DV) {
//    				t[z] -= t.DV;
//    				t[++z]++
//    			}
//    		}
//    		t.clamp();
//    		t.drShiftTo(this.m.t, t);
//    		if (t.compareTo(this.m) >= 0) {
//    			t.subTo(this.m, t)
//    		}
//    	}
//    	function ao(t, z) {
//    		t.squareTo(z);
//    		this.reduce(z)
//    	}
//    	function B(t, aC, z) {
//    		t.multiplyTo(aC, z);
//    		this.reduce(z)
//    	}

		@Override
		public au convert(Object t) {
			return null;
		}

		@Override
		public void sqrTo(au aG, au aC) {
		}

		@Override
		public void mulTo(au aC, au aF, au aG) {
		}

		@Override
		public au revert(au aG) {
			return null;
		}
    }
    
    
    static class af{
    	static final int O = 256;
    	_m o;
    	long[] W;
    	int ae;
    	public af(){
    		if (W == null) {
        		W = new long[O + 1];
        		ae = 0;
        		int K;
        		if ("Netscape".equals(navigatorAppName)
//        				&& navigator.appVersion < "5"
//        				&& window.crypto && window.crypto.random
        				) {
//        			var H = window.crypto.random(32);
//        			for (K = 0; K < H.length; ++K) {
//        				W[ae++] = H.charCodeAt(K) & 255
//        			}
        		}
        		while (ae < O) {
        			K = (int) Math.floor(65536 * Math.random());
        			W[ae++] = K >>> 8;
        			W[ae++] = K & 255;
        		}
        		ae = 0;
        		V();
        	}
    	}
    	
    	void d(long t) {
    		W[ae++] ^= t & 255;
    		W[ae++] ^= (t >> 8) & 255;
    		W[ae++] ^= (t >> 16) & 255;
    		W[ae++] ^= (t >> 24) & 255;
    		if (ae >= O) {
    			ae -= O;
    		}
    	}
    	void V() {
    		d(new Date().getTime());
    	}
    	
    	int E() {
    		if (o == null) {
    			V();
    			o = aq();
    			o.init(W);
    			for (ae = 0; ae < W.length; ++ae) {
    				W[ae] = 0;
    			}
    			ae = 0;
    		}
    		return o.next();
    	}
    	void nextBytes(Object[] z) {
    		int t;
    		for (t = 0; t < z.length; ++t) {
    			z[t] = E();
    		}
    	}
    }
    
    static class _m{
    	private int i;
		private int j;
		private int[] S;
		public _m() {
    		this.i = 0;
    		this.j = 0;
    		this.S = new int[256];
    	}
    	void init(long[] aE) {
    		int aD, z, aC;
    		for (aD = 0; aD < 256; ++aD) {
    			this.S[aD] = aD;
    		}
    		z = 0;
    		for (aD = 0; aD < 256; ++aD) {
    			z = (int) ((z + this.S[aD] + aE[aD % aE.length]) & 255);
    			aC = this.S[aD];
    			this.S[aD] = this.S[z];
    			this.S[z] = aC;
    		}
    		this.i = 0;
    		this.j = 0;
    	}
    	int next() {
    		int z;
    		this.i = (this.i + 1) & 255;
    		this.j = (this.j + this.S[this.i]) & 255;
    		z = this.S[this.i];
    		this.S[this.i] = this.S[this.j];
    		this.S[this.j] = z;
    		return this.S[(z + this.S[this.i]) & 255];
    	}
    }
	
	static class N{

		private au n;
		private int e;
//		private Object d;
//		private Object p;
//		private Object q;
//		private Object dmp1;
//		private Object dmq1;
//		private Object coeff;

		public N() {
//			this.n = null;
//			this.e = 0;
//			this.d = null;
//			this.p = null;
//			this.q = null;
//			this.dmp1 = null;
//			this.dmq1 = null;
//			this.coeff = null;
		}
		
		void setPublic(String z, String t) {
			if (!isEmpty(t) && !isEmpty(z)) {
				n = h(z, 16);
//				this.e = parseInt(t, 16)
				e = Integer.parseInt(t, 16);
			} else {
				uv_alert("Invalid RSA public key");
			}
		}

		au doPublic(au t) {
			return t.modPowInt(this.e, this.n);
		}

		String encrypt(String aC) {
			au t = ah(aC, (this.n.bitLength() + 7) >> 3);
			if (t == null) {
				return null;
			}
			au aD = this.doPublic(t);
			if (aD == null) {
				return null;
			}
			String z = aD.toString(16);
//			String z="";//TODO
			if ((z.length() & 1) == 0) {
				return z;
			} else {
				return "0" + z;
			}
		} 
		
	}
	
	
}
