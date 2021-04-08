package 图.秘密法官;

public class Judge {
    /*
        public int findJudge(int N, int[][] trust) {
            //从一个小镇之中，从1到N标记了N个人，传言称，这些人之中有一个是小镇之中的秘密法官
            //1.法官不相信小镇上的任何人
            //2.每个人都信任小镇的法官
            //3.只有一个人满足上述1,2
            //[a,b]表示前者信任后者
            // 1->3 2->3 3->1
            List<List<Integer>> trust_neighbours = new ArrayList<>();
            for(int i = 0;i < N;i++)
            {
                trust_neighbours.add(new ArrayList<>());
            }
            for(int[] array : trust)
            {
                trust_neighbours.get(array[0] - 1).add(array[1] - 1);
            }
            System.out.println(trust_neighbours);
            int i;
            boolean flag = false;
            for(i=0;i<N;i++)
            {
                List<Integer> temp = trust_neighbours.get(i);
                if(temp.size()==0)
                {
                    int j;
                    for(j = 0 ; j < N; j++)
                    {
                        if(i == j)
                        {
                            continue;
                        }
                        List<Integer> temp1 = trust_neighbours.get(j);
                        if(temp1.contains(i))
                        {

                        }
                        else
                        {
                            break;
                        }
                    }
                    if(j==N)
                    {
                        return i+1;
                    }
                    else{
                        //有人不信任他;
                    }
                }
            }
            return -1;

        }
    */

    /*
     public int findJudge(int N, int[][] trust) {
		int inDegree[] = new int[N + 1];
		int outDegree[] = new int[N + 1];
		for (int[] path : trust) {
			int start = path[0];
			int end = path[1];
			inDegree[end]++;
			outDegree[start]++;
		}
		for (int i = 1; i <= N; i++) {
			if (outDegree[i] == 0 && inDegree[i] == N - 1) {
				return i;
			}
		}
		return -1;
	}
    */
}
