/**
 * 求价格最优（最短距离）
 */
public class Solution {
//    public static int minDistance(int[][] citiesDistance, int start, int end) {
//        boolean[] isLabel = new boolean[citiesDistance[0].length];// 是否标号
//        int[] indexs = new int[citiesDistance[0].length];// 所有标号的点的下标集合，以标号的先后顺序进行存储
//        int top = -1;//顶点
//        int[] distance = citiesDistance[start].clone();// start 到各点的最优价格的初始值
//        int index = start;// 从start 开始
//        int temporaryMinDistance = 0;//当前临时最优价格
//
//        indexs[++top] = index;// 把已经标号的下标存入下标集中
//        isLabel[index] = true;
//
//        while (top<citiesDistance[0].length) {
//            // 第一步：标号北京（0）,即w[0][0]找到距离北京（0）最优价格的点
//
//            int min = Integer.MAX_VALUE;
//            for (int i = 0; i < distance.length; i++) {
//                if (!isLabel[i] && distance[i] != -1 && i != index) {
//                    // 如果到这个点有边,并且没有被标号
//                    if (distance[i] < min) {
//                        min = distance[i];
//                        index = i;// 把下标改为当前下标
//                    }
//                }
//            }
//            if (index == end) {//已经找到end，就结束程序
//                break;
//            }
//            isLabel[index] = true;//对点进行标号
//            indexs[++top] = index;// 把已经标号的下标存入下标集中
//            if (citiesDistance[indexs[top - 1]][index] == -1
//                    || temporaryMinDistance + citiesDistance[indexs[top - 1]][index] > distance[index]) {
//                // 如果两个点没有直接相连，或者两个点的路径大于最短路径
//                temporaryMinDistance = distance[index];
//            } else {
//                temporaryMinDistance += citiesDistance[indexs[top - 1]][index];
//            }
//
//            // 第二步：将distance中的距离加入
//            for (int i = 0; i < distance.length; i++) {
//                // 如果 到那个点有边，则start到后面点的价格加和
//                if (distance[i] == -1 && citiesDistance[index][i] != -1) {// 如果以前不可达，则现在可达了
//                    distance[i] = temporaryMinDistance + citiesDistance[index][i];
//                } else if (citiesDistance[index][i] != -1
//                        && temporaryMinDistance + citiesDistance[index][i] < distance[i]) {
//                    // 如果以前可达，但现在的价格比以前更优，则更换成更优价格
//                    distance[i] = temporaryMinDistance + citiesDistance[index][i];
//                }
//            }
//        }
//        //如果全部点都遍历完，则distance中存储的是开始点到各个点的最优价格
//        return distance[end] - distance[start];
//    }
//    public static void main(String[] args) {
//        /**
//         * 建立一个矩阵
//         * 北京 0 天津 1 廊坊 2 郑州 3 上海 4 广州 5 杭州 6 南昌 7 景德镇 8
//         */
//        int[][] citiesDistance = {
//                { 0, 6, 5, -1, -1, -1 ,-1 ,-1 ,-1 },
//                { 6, 0, -1, 10, 13, -1 ,-1 ,-1 ,-1 },
//                { 5, -1, 0, 8, 13, 13 ,-1 ,-1 ,-1 },
//                { -1, 10, 8, 0, 11, -1 ,12 ,-1 ,-1 },
//                { -1, 13, 13, 11, 0, 12 ,6 ,10 ,-1},
//                { -1, -1, 13, -1, 12, 0 ,-1 ,11 ,-1},
//                { -1, -1, -1, 12, 6, -1 ,0 ,-1 ,16},
//                { -1, -1, -1, -1, 10, 11 ,-1 ,0 ,6},
//                { -1, -1, -1, -1, -1, -1 ,16 ,6, 0},
//
//        };
//
//
//        System.out.println(minDistance(citiesDistance, 0,7));
//
//    }

    public String getStr(String s){
        int a = s.length();
        if(a < 2){
            return s;
        }
        String longestStr = "";
        String str = "";
        for (int i = 0; i < a - 1; i++) {
            str = find(s, i, i);
            if(str.length() > longestStr.length()){
                longestStr = str;
            }
            str = find(s, i, i + 1);
            if(str.length() > longestStr.length()){
                longestStr = str;
            }
        }
        return longestStr;
    }

    public String find(String s, int left, int right){
        int n = s.length();
        int l = left;
        int r = right;
        while (l >= 0 && r <= n - 1 && s.charAt((l)) == s.charAt(r)){
            l -- ;
            r ++ ;
        }
        return s.substring(l + r , r);

    }
}