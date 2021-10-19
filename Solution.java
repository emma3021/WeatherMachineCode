import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("What row? ");
        int wantedRow = input.nextInt();
        System.out.print("What column? ");
        int wantedColumn = input.nextInt();
        
        int rowStart = 1;
        int rowNum = 0;
        int codeNum = 0;
        // this loop runs through the rows until it finds the
        // desired row and the corresponding start number
        for(int i = 0; i < 5000; i++) {
            if(rowNum == wantedRow) {
                codeNum = row(rowStart, rowNum, wantedColumn);
                break;
            }
            rowStart += i;
            rowNum++;
        }
        
        // by this point we have determined the number
        // of the code we need to find
        
        long code;
        code = findCode(codeNum);
        System.out.println(code);
    }
    
    // this method returns the code # given the row & column
    public static int row(int start, int rowNum, int wantedColumn) {
        int column = 1; // the column we are on
        int n = start; // the code number we are on
        for(int i = rowNum + 1; i < rowNum + 5000; i++) {
            if(column == wantedColumn)
                break;
            n += i;
            column++;
        }
        System.out.println(n);
        return n;
    }
    
    // this method finds the code given the number
    public static long findCode(int num) {
        int code1 = 20151125; // the first code
        long code = code1; // the code we are on
        for(int i = 1; i < num; i++) {
            code *= 252533;
            code %= 33554393;
        }
        return code;
    }
}
