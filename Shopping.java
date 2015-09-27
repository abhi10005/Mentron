import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shopping {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int T, min = Integer.MAX_VALUE, N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		String line = "";
		while(T-- > 0){
			N = Integer.parseInt(br.readLine());
			int itemCost[][] = new int[N][3];
			int solutionSpace[][] = new int[N][3];
			
			// Storing first shop's items for comparisons as per dynamic programming
			line = br.readLine();
			String[] splitStr = line.split(" ");
			solutionSpace[0][0] = Integer.parseInt(splitStr[0]);
			solutionSpace[0][1] = Integer.parseInt(splitStr[1]);
			solutionSpace[0][2] = Integer.parseInt(splitStr[2]);
			
			for(int i=1; i<N; i++){
				line = br.readLine();
				splitStr = line.split(" ");
				itemCost[i][0] = Integer.parseInt(splitStr[0]);
				itemCost[i][1] = Integer.parseInt(splitStr[1]);
				itemCost[i][2] = Integer.parseInt(splitStr[2]);
				for(int j=0; j<3; j++){
					solutionSpace[i][j] = solutionSpace[i-1][(j+1)%3] + itemCost[i][j];
					if(solutionSpace[i-1][(j+2)%3]+itemCost[i][j]<solutionSpace[i][j])
						solutionSpace[i][j] = solutionSpace[i-1][(j+2)%3] + itemCost[i][j];
				}
			}
			min = solutionSpace[N-1][0];
			if(solutionSpace[N-1][1] < min){
				min = solutionSpace[N-1][1];
			}
			if(solutionSpace[N-1][2] < min){
				min = solutionSpace[N-1][2];
			}
			System.out.println(min);
		}
	}

}
