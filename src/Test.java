import java.sql.PreparedStatement;
import java.util.*;


public class Test {

    //深度优先探索
    public static void dfs(String s, int i, int num, ArrayList<String> al){
        //判断插入完成的是否满足
        if(num==0){
            String[] ss=s.split("\\.");
            for(String cs : ss){
                //每个数字是否有0开头或>255
                if(Integer.parseInt(cs)>255){
                    return;
                }
                if(cs.length()>1 && cs.charAt(0)=='0'){
                    return;
                }
            }
            al.add(s);
            return;
        }
    }

    //调用深度优先探索并存储合法的IP地址
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> al=new ArrayList<String>();
        dfs(s,-1,3,al);
        return al;
    }


    public static void main(String[] args){
        System.out.println("请输入数字字符串");
    }
}
