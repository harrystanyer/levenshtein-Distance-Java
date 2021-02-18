//https://en.wikipedia.org/wiki/Levenshtein_distance#Upper_and_lower_bounds
public class levenshteinDistance {
    public static void main(String[] args) {
		System.out.println(levDist(new char[]{'p','r','i','n','t'}, new char[]{'p','r','i','g'}));
	}

    public static int levDist(char[] s, char[] t){
        int m = s.length;
        int n = t.length;
        int[][] d = new int[m][n];
        int substitutionCost = 0;
        for (int[] is : d) {
            for (int is2 : is) {
                is2 = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            d[i][0]=i;
        }
        for (int i = 1; i < n; i++) {
            d[0][i]=i;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if(s[i]==t[j]){
                    substitutionCost = 0;
                }else{
                    substitutionCost = 1;
                }
                d[i][j] = minimum(d[i-1][j]+1, d[i][j-1]+1, d[i-1][j-1]+substitutionCost);
            }
        }
        return d[m-1][n-1];
    }

    public static int minimum(int a, int b, int c){
        int min = a;
        if(b<min){
            min = b;
        }
        if(c<min){
            min = c;
        }
        return min;
    }
}
