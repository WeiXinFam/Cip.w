import java.util.*;

//https://cryptii.com/

public class First10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Hey,Hey! Choose one of the following to cipher!");
        System.out.println("1. Vigenere Code");
        System.out.println("2. Morse Code");
        System.out.println("3. Caesar Cypher");
        System.out.println("4. Rail Fence Cipher");
        System.out.println("5. Custom Combination");
        /*System.out.println("6. ");*/
        int n = in.nextInt();

        //V


        switch(n){
            case 1:
                System.out.println("Sweet! You chose one of the hardest Code!");
                System.out.println("Message: ");
                String s1=in.next();
                System.out.println("Keyword to represent: eg.Lemon");
                String s2=in.next();
                System.out.println(Vig(s1,s2));
                
            case 2:
                System.out.println("You're in the oldest war station!");
                System.out.println("Message: ");
                String s3=in.next();
                char [] arr = s3.toCharArray();
                System.out.println(Mor(arr));
                
            case 3:
                System.out.println("You've chosen caesar!");
                System.out.println("Message: ");
                String s4=in.next();
                char [] ar = s4.toCharArray();
                System.out.println("Shift: eg. 1");
                int sh=in.nextInt();
                System.out.println(CS(sh,ar));

            case 4:
                System.out.println("the zigzag is at your disposal. Take a paper wth squares out!");
                System.out.println("Message: ");
                String s5=in.next();
                System.out.println("Key: eg. the number of rows");
                int ke=in.nextInt();
                System.out.println("Draw/Write this out in square grids in W's.");
                System.out.println(rails(ke,s5));

            case 5:
                System.out.println("You chose a combination cipher! Sweet! It's Rot+A1Z26");
                System.out.println("Message: ");
                String s6=in.next();
                System.out.println("Keyword: eg.LEMON (Remember the longer the better ");
                String kw=in.next();
                //System.out.println(plyA(ke,s5));
                
            /*default:
                System.out.println("Invalid Option Selected");
                */

        }

    }

    private static String rails(int ke, String s5) {
        String [] st = new String[ke];
        Arrays.fill(st," ");
        List<Integer> hld = new ArrayList<Integer>();

        for(int i=0;i<ke;i++){
            int [] temp = makeL(i,s5.length(),ke);
            for(int j:temp){
                hld.add(j);
            }
        }

        String fin="";
        for(int i=0;i<hld.size();i++){
            fin+=s5.charAt(hld.get(i)-1);
        }
        //System.out.println("f: "+fin);
        return fin;
    }

    private static int[] makeL(int i, int length, int key) {


        List<Integer> hl = new ArrayList<Integer>();
        int c=i+1;
        int a=i+1;
            for(int k=0;k<length;k++){
                if(k==0){
                    hl.add(a);
                }
                else if(c!=key){
                    c+=(key*2)-(2*a);
                    if(c<=length){
                        hl.add(c);
                    }
                }
            }

       // System.out.println(i+": "+String.valueOf(hl));
            int [] n1=new int[hl.size()];
            for(int p=0;p<hl.size();p++){
                n1[p]=hl.get(p);
            }
        //System.out.println(Arrays.toString(n1));
            return n1;
    }

    //limited number
    private static String CS(int sh, char[] ar) {

        char[] letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        //https://stackoverflow.com/questions/17575840/better-way-to-generate-array-of-all-letters-in-the-alphabet
        char[] out=new char[ar.length];

        for(int i=0;i<ar.length;i++){
            int ni=revert(ar[i])+sh;
            out[i]=find(ni);
        }

        return String.valueOf(out);

    }

    private static String Mor(char[] s3) {
        List<String> c=new ArrayList<>();

        for(int i=0;i<s3.length;i++){
            switch (s3[i]){
                case 'A':
                    c.add("\u00B7"+"- ");
                    break;
                case 'B':
                    c.add("-"+"\u00B7"+"\u00B7"+"\u00B7"+" ");
                    break;
                case 'C':
                    c.add("-"+"\u00B7"+"-"+"\u00B7"+" ");
                    break;
                case 'D':
                    c.add("-"+"\u00B7"+"\u00B7"+" ");
                    break;
                case 'E':
                    c.add("\u00B7"+" ");
                    break;
                case 'F':
                    c.add("\u00B7"+"\u00B7"+"-"+"\u00B7"+" ");
                    break;
                case 'G':
                    c.add("-"+"-"+"\u00B7"+" ");
                    break;
                case 'H':
                    c.add("\u00B7"+"\u00B7"+"\u00B7"+"\u00B7");
                    break;
                case 'I':
                    c.add("\u00B7"+"\u00B7");
                    break;
                case 'J':
                    c.add("\u00B7"+"--- ");
                    break;
                case 'K':
                    c.add("-"+"\u00B7"+"- ");
                    break;
                case 'L':
                    c.add("\u00B7"+"-"+"\u00B7"+"\u00B7"+" ");
                    break;
                case 'M':
                    c.add("-- ");
                    break;
                case 'N':
                    c.add("-"+"\u00B7"+" ");
                    break;
                case 'O':
                    c.add("--- ");
                    break;
                case 'P':
                    c.add("\u00B7"+"--"+"\u00B7"+" ");
                    break;
                case 'Q':
                    c.add("--"+"\u00B7"+"- ");
                    break;
                case 'R':
                    c.add("\u00B7"+"-"+"\u00B7"+" ");
                    break;
                case 'S':
                    c.add("\u00B7"+"\u00B7"+"\u00B7"+" ");
                    break;
                case 'T':
                    c.add("- ");
                    break;
                case 'U':
                    c.add("\u00B7"+"\u00B7"+"- ");
                    break;
                case 'V':
                    c.add("\u00B7"+"\u00B7"+"\u00B7"+"- ");
                    break;
                case 'W':
                    c.add("\u00B7"+"-- ");
                    break;
                case 'X':
                    c.add("-"+"\u00B7"+"\u00B7"+"- ");
                    break;
                case 'Y':
                    c.add("-"+"\u00B7"+"-- ");
                    break;
                case 'Z':
                    c.add("--"+"\u00B7"+"\u00B7"+" ");
                    break;
                case 1:
                    c.add("\u00B7"+"---- ");
                    break;
                case 2:
                    c.add("\u00B7"+"\u00B7"+"--- ");
                    break;
                case 3:
                    c.add("\u00B7"+"\u00B7"+"\u00B7"+"-- ");
                    break;
                case 4:
                    c.add("\u00B7"+"\u00B7"+"\u00B7"+"\u00B7"+"- ");
                    break;
                case 5:
                    c.add("\u00B7"+"\u00B7"+"\u00B7"+"\u00B7"+"\u00B7"+" ");
                    break;
                case 6:
                    c.add("-"+"\u00B7"+"\u00B7"+"\u00B7"+"\u00B7"+" ");
                    break;
                case 7:
                    c.add("--"+"\u00B7"+"\u00B7"+"\u00B7"+" ");
                    break;
                case 8:
                    c.add("---"+"\u00B7"+"\u00B7"+" ");
                    break;
                case 9:
                    c.add("----"+"\u00B7"+" ");
                    break;
                case 0:
                    c.add("----- ");
                    break;

            }
        }
        StringBuilder str = new StringBuilder();
        for(String s:c){
            str.append(s);
        }
        //https://stackoverflow.com/questions/599161/best-way-to-convert-an-arraylist-to-a-string
        return String.valueOf(str);

    }

    //MAKE ALL TO CAPS AND REMOVE OTHER CHARACTERS
    private static String Vig(String messageC, String keywordR) {
        //matrix
        char[][] m = new char[26][26];



        //rep keyword
        //from stackoverflow use of StringBuilder
        StringBuilder str = new StringBuilder();
        while (str.length()<messageC.length()){
            str.append(keywordR);
        }
        str.setLength(messageC.length());
        keywordR=str.toString();
        //https://stackoverflow.com/questions/11814647/repeat-the-string-sequence-until-it-reaches-a-certain-length-in-java?rq=1





        //idea was to repeat the word till it matches the length
       /* if (keywordR.length<messageC.length){
            int diff = messageC.length-keywordR.length;
            int toRep=diff/keywordR.length;
            for (int k=0;k<toRep;k++) {
                for (int i = 0; i < keywordR.length; i++) {
                    toRep--;
                    if (toRep == 0) {
                        break;
                    } else {
                        temp.add(keywordR[i]);
                    }
                }
            }
        }
        System.out.println(temp);*/



        int v;


        for(int col=0;col<26;col++){
            for (int row=0;row<26;row++) {
               // System.out.println("col: "+col+", row: "+row);
                v=col+row+1;
                m[row][col] = find(v);
                //VISUALISATION PURPOSE
                //System.out.print(m[row][col]);
            }
            //VISUALISATION PURPOSE
            //System.out.println("");
        }


        //System.out.println(Arrays.deepToString(m));

        //final char[]
        char[] c =new char[messageC.length()];
        for(int i=0;i<messageC.length();i++){
            int colu = revert(messageC.charAt(i));
            int rows=revert(keywordR.charAt(i));
            c[i]=m[rows-1][colu-1];
            System.out.println("col: "+colu+", row: "+rows+", the letter: "+c[i]);
        }

        System.out.println(Arrays.toString(c));
        return String.valueOf(c);
    }

    private static char find(int v) {

        if(v==1 || v==27){
            return 'A';
        }
        else if(v==2||v==28){
            return 'B';
        }
        else if(v==3||v==29){
            return 'C';
        }
        else if(v==4||v==30){
            return 'D';
        }
        else if(v==5||v==31){
            return 'E';
        }
        else if(v==6||v==32){
            return 'F';
        }
        else if(v==7||v==33){
            return 'G';
        }
        else if(v==8||v==34){
            return 'H';
        }
        else if(v==9||v==35){
            return 'I';
        }
        else if(v==10||v==36){
            return 'J';
        }
        else if(v==11||v==37){
            return 'K';
        }
        else if(v==12||v==38){
            return 'L';
        }
        else if(v==13||v==39){
            return 'M';
        }
        else if(v==14||v==40){
            return 'N';
        }
        else if(v==15||v==41){
            return 'O';
        }
        else if(v==16||v==42){
            return 'P';
        }
        else if(v==17||v==43){
            return 'Q';
        }
        else if(v==18||v==44){
            return 'R';
        }
        else if(v==19||v==45){
            return 'S';
        }
        else if(v==20||v==46){
            return 'T';
        }
        else if(v==21||v==47){
            return 'U';
        }
        else if(v==22||v==48){
            return 'V';
        }
        else if(v==23||v==49){
            return 'W';
        }
        else if(v==24||v==50){
            return 'X';
        } else if(v==25||v==51){
            return 'Y';
        }
        else if(v==26||v==52){
            return 'Z';
        }
        return'l';
    }

    private static int revert(char c) {

        switch (c) {
            case 'A':
                return 1;
            case 'B':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;
            case 'E':
                return 5;
            case 'F':
                return 6;
            case 'G':
                return 7;
            case 'H':
                return 8;
            case 'I':
                return 9;
            case 'J':
                return 10;
            case 'K':
                return 11;
            case 'L':
                return 12;
            case 'M':
                return 13;
            case 'N':
                return 14;
            case 'O':
                return 15;
            case 'P':
                return 16;
            case 'Q':
                return 17;
            case 'R':
                return 18;
            case 'S':
                return 19;
            case 'T':
                return 20;
            case 'U':
                return 21;
            case 'V':
                return 22;
            case 'W':
                return 23;
            case 'X':
                return 24;
            case 'Y':
                return 25;
            case 'Z':
                return 26;
            
        }
        return 0;
    }
}
