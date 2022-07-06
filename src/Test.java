import java.sql.PreparedStatement;
import java.util.*;


public class Test {

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
        //插入未完成，分._ .__ .___ 三种情况
        if((i+2)<s.length()){
            //注意substring()函数左闭右开
            dfs(s.substring(0,i+2)+"."+s.substring(i+2,s.length()),i+2,num-1,al);
        }
        if((i+3)<s.length()){
            dfs(s.substring(0,i+3)+"."+s.substring(i+3,s.length()),i+3,num-1,al);
        }
        if((i+4)<s.length()){
            dfs(s.substring(0,i+4)+"."+s.substring(i+4,s.length()),i+4,num-1,al);
        }
        return;
    }

    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> al=new ArrayList<String>();
        dfs(s,-1,3,al);
        return al;
    }

    public static void main(String[] args){
        System.out.println("请输入数字字符串");
        Scanner input=new Scanner(System.in);
        String st=input.nextBigInteger().toString();
        while(!st.equals("exit")){
            System.out.println("可能的组合为：（“[]”表示没有可能的组合）");
            System.out.println(restoreIpAddresses(st));
            st=input.nextBigInteger().toString();
        }

    }
}