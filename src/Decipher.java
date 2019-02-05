import java.util.Scanner;

public class Decipher {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Hey,Hey! Choose one of the following to decipher!");
        System.out.println("1. Vigenere Code");
        System.out.println("2. Morse Code");
        System.out.println("3. Caesar Cypher");
        System.out.println("4. ROT");
        System.out.println("5. Rail Fence Cip");
        System.out.println("6. Reverse");
        System.out.println("7. Reflect");
        System.out.println("8. Enigma Code");
        System.out.println("9. Date Shift Cip");
        System.out.println("10. Custom Combination");
        int n = in.nextInt();
        in.nextLine();
        theM(n, in);
    }

    private static void theM(int numberChosen, Scanner in) {
        switch (numberChosen) {
            case 1:
                System.out.println("Message: ");
                String s1 = in.nextLine();
                System.out.println("Keyword to represent: eg.Lemon");
                String s2 = in.next();
                System.out.println(revVig(s1.toUpperCase(), s2.toUpperCase()));
                break;
            case 2:
                System.out.println("You're in the oldest war station!");
                System.out.println("Message: ");
                String s3 = in.nextLine();
                char[] arr = s3.toCharArray();
                // System.out.println(Mor(arr));
                break;
            case 3:
                System.out.println("You've chosen caesar!");
                System.out.println("Message: ");
                String s4 = in.nextLine();
                System.out.println("Shift: eg. 1");
                int sh = in.nextInt();
                System.out.println(revCS(sh, s4.toUpperCase()));
                break;
            case 4:
                System.out.println("the zigzag is at your disposal. Take a paper wth squares out!");
                System.out.println("Message: ");
                String s5 = in.nextLine();
                System.out.println("Key: eg. the number of rows");
                int ke = in.nextInt();
                System.out.println("Draw/Write this out in square grids in W's.");
                //System.out.println(rails(ke,s5));
                break;
            case 5:
                System.out.println("You've chosen sth like ceasar. Diff is this shift is upwards!");
                System.out.println("Message: ");
                String s6 = in.nextLine();
                System.out.println("Shift: eg. 1");
                int shi = in.nextInt();
                //System.out.println(ROT(shi,s6));
                break;
            case 6:
                System.out.println("Starting Simple?");
                System.out.println("Message: ");
                String s7 = in.nextLine();
                //System.out.println(Reversy(s7));
                break;
            case 7:
                System.out.println("Starting Simple?");
                System.out.println("Message: ");
                String s8 = in.nextLine();
                //System.out.println(Reflecty(s8));
                break;
            case 8:
                System.out.println("Starting Simple?");
                System.out.println("Message: ");
                String s9 = in.nextLine();
                //System.out.println(Enig(s9));
                break;
            case 9:
                System.out.println("Well this is sth like ROT but you're shifting one by one?");
                System.out.println("Message: ");
                String s10 = in.nextLine();
                System.out.println("What's ur fav combination of number that matches the length of message?");
                int dats = in.nextInt();
                //System.out.println(shiftR(s10,dats));
                break;
            case 10:
                System.out.println("You're choosing a combination! Thinking of sth tricky aren't cha?");
                System.out.println("First off! Enter the number of cipher you want to combine.");
                int numToC = in.nextInt();
                int c = 1;
                while (c < numToC + 1) {
                    System.out.println("Now, type in the " + c + " cipher you want. Due to testing stage the string will not be overlay automatically, you have to do it by manual.");
                    int one = in.nextInt();
                    in.nextLine();
                    theM(one, in);
                    c++;
                }


        }
    }

    private static String revVig(String messageC, String keywordR) {
        char[][] m = new char[26][26];

        int v;


        for (int col = 0; col < 26; col++) {
            for (int row = 0; row < 26; row++) {
                // System.out.println("col: "+col+", row: "+row);
                v = col + row + 1;
                m[row][col] = Cip.find(v);
                //VISUALISATION PURPOSE
                //System.out.print(m[row][col]);
            }
            //VISUALISATION PURPOSE
            //System.out.println("");
        }

        //rep keyword
        StringBuilder str = new StringBuilder();
        while (str.length() < messageC.length()) {
            str.append(keywordR);
        }
        str.setLength(messageC.length());
        keywordR = str.toString();
        System.out.println("k: " + keywordR);

        int r;
        String oriPass = "";
        int in = 0;

        for (int i = 0; i < messageC.length(); i++) {
            r = Cip.revert(keywordR.charAt(i));
            System.out.println("char: " + keywordR.charAt(i));
            System.out.println("r: " + r);
            for (int j = 0; j < 26; j++) {
                System.out.println("j: " + j);
                System.out.println("intable: " + m[r - 1][j]);
                if (String.valueOf(m[r - 1][j]).equals(String.valueOf(messageC.charAt(i)))) {
                    System.out.println("index: " + i);
                    System.out.println("char at message: " + messageC.charAt(i));
                    oriPass += Cip.find(j + 1);
                    System.out.println("add: " + oriPass);
                }
            }
        }


        return oriPass;
    }

    private static String revCS(int sh, String ar) {

        //char[] letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        //https://stackoverflow.com/questions/17575840/better-way-to-generate-array-of-all-letters-in-the-alphabet
        char[] ar1 = ar.toCharArray();
        char[] out = new char[ar1.length];

        for (int i = 0; i < ar1.length; i++) {
            int ni = (Cip.revert(ar1[i])) + sh;
            if (ni <= 0) {
                ni = 26 + (ni);
            }
            out[i] = Cip.find(ni);
        }
    return String.valueOf(out);
    }
}




