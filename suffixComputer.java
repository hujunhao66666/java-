public class suffixComputer{
    public static boolean isChar(char a){
        return a=='+' || a=='-' || a=='*' || a=='/';
    }

    public static int priority(String a){
        if (a.equals("*") || a.equals("/"))return 1;
        return 0;
    }

    public static List<String> midConvert(String s){
        List<String> ls=new ArrayList<String>();
        int i=0;
        char c;
        String str;
        while (i<s.length()){
            c=s.charAt(i);
            if (c<48 || c>57){
                ls.add(""+c);
                i++;
            }else{
                str="";
                while ((i<s.length()) && ((c=s.charAt(i))>=48) && ((c=s.charAt(i))<=57)){
                    str+=c;
                    i+=1;
                }
                ls.add(str);

            }
        }
        return ls;
    }

    public static List<String> midToLate(List<String> a){
        int i=0;
        Stack<String> symbolStack=new Stack<String>();
        List<String> ansStack=new ArrayList<String>();
        for (String s:a){
            if (s.matches("\\d+")){
                ansStack.add(s);
            }else if (s.equals("(")){
                symbolStack.push(s);
            }else if (s.equals(")")){
                while (!(symbolStack.peek().equals("("))){
                    ansStack.add(symbolStack.pop());
                }
                symbolStack.pop();
            }else if(symbolStack.isEmpty()){
                symbolStack.push(s);
            }else {
                while (symbolStack.size()!=0 && priority(symbolStack.peek())>priority(s)){
                    ansStack.add(symbolStack.pop());
                }
                symbolStack.push(s);
            }
        }
        while (symbolStack.size()!=0){
            ansStack.add(symbolStack.pop());
        }
        return ansStack;
    }

    public static String computeLate(List<String> a){
        Stack<String> stack=new Stack<String>();
        for (String s:a){
            if (s.matches("\\d+")){
                stack.push(s);
            }else{
                stack.push(compute(stack.pop(),stack.pop(),s));
            }
        }
        return stack.pop();
    }

    public static String compute(String a,String b,String c){
        String ans="";
        switch (c){
            case "+":
                ans=Integer.toString((Integer.parseInt(a)+Integer.parseInt(b)));
                break;
            case "-":
                ans=Integer.toString((Integer.parseInt(b)-Integer.parseInt(a)));
                break;
            case "*":
                ans=Integer.toString((Integer.parseInt(a)*Integer.parseInt(b)));
                break;
            case "/":
                ans=Integer.toString((Integer.parseInt(b)/Integer.parseInt(a)));
                break;
            default:break;
        }
        return ans;
    }
    public static void main(String[]args){

        //System.out.println(Integer.parseInt("5"));

        System.out.println(midConvert("2*3+5"));
        System.out.println(midToLate(midConvert("2*3+5")));
        System.out.println(computeLate(midToLate(midConvert("6/3+2*(3+5)"))));

    }
}
