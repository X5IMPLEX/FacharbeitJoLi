import javax.swing.*;
public class matrizenrechner{
    int m;
    int n;
    int o;
    int p;
    double [][]MatrixA;
    double [][]MatrixB;
    double [][]MatrixR;
    double [][]MatrixT;
    public void eingabe (){
        Object[] possibleValues = { "Eine Matrix", "Zwei Matrizen"};
        Object selectedValue = JOptionPane.showInputDialog(null,
        "Bitte Anzahl der Matrizen auswählen ", "Input",
        JOptionPane.INFORMATION_MESSAGE, null,
        possibleValues, possibleValues[0]);
        if (selectedValue == "Eine Matrix"){
          try{
            String as = JOptionPane.showInputDialog(null,"Zeilenanzahl:");
            String bs = JOptionPane.showInputDialog(null,"Spaltenanzahl:");
            int a = Integer.parseInt(as);
            int b = Integer.parseInt(bs);
            createMatrixA(a,b);
          }
          catch (NumberFormatException e){
              JOptionPane.showMessageDialog(null,"Bitte Zahlen eingeben");
              System.exit(0);
          }
          Object[] possibleValues2 = {"A transponieren"};
          Object selectedValue2 = JOptionPane.showInputDialog(null,
          "Bitte die Operation auswählen", "Input",
          JOptionPane.INFORMATION_MESSAGE, null,
          possibleValues2, possibleValues2[0]);
          if (selectedValue2 == "A transponieren"){ 
              transposeMatrix();
          }
        }
        else{
            try{
            String as = JOptionPane.showInputDialog(null,"Zeilenanzahl für Matrix A:");
            String bs = JOptionPane.showInputDialog(null,"Spaltenanzahl für Matrix A:");
            String cs = JOptionPane.showInputDialog(null,"Zeilenanzahl für Matrix B:");
            String ds = JOptionPane.showInputDialog(null,"Spaltenanzahl für Matrix B:");
            int rows1 = Integer.parseInt(as);
            int columns1 = Integer.parseInt(bs);
            int rows2 = Integer.parseInt(cs);
            int columns2 = Integer.parseInt(ds);
            createMatrixA(rows1,columns1);
            createMatrixB(rows2,columns2);
           }
           catch (NumberFormatException e){
               JOptionPane.showMessageDialog(null,"Bitte Zahlen eingeben");
               System.exit(0);
           }
            Object[] possibleValues2 = { "A + B", "A - B", "A * B" };
            Object selectedValue2 = JOptionPane.showInputDialog(null,
            "Bitte die Operation auswählen", "Input",
            JOptionPane.INFORMATION_MESSAGE, null,
            possibleValues2, possibleValues2[0]);
            if (selectedValue2 =="A + B"){ 
                addMatrixAB();
            }
            else if(selectedValue2 =="A - B"){
                subtractMatrixAB();     
            }
            else if(selectedValue2 =="A * B"){
                multiplyMatrixAB();
            }
        }
    }
    private void createMatrixA(int rows, int columns){
       try{
        MatrixA = new double [rows][columns];
        m = rows;
        n = columns;
       }
       catch (NegativeArraySizeException e){
           JOptionPane.showMessageDialog(null,"Bitte nur positive Zahlen eingeben");
           System.exit(0);
       }
       try {
        for(int i=0;i<rows;i++){
            for(int i2=0;i2<columns;i2++){
                int idisplay = i+1;
                int i2display = i2+1;
                String e = JOptionPane.showInputDialog(null,"Enter a"+idisplay+i2display);
                double c = Double.parseDouble(e);
                MatrixA [i][i2]=c;
            }
        }
       }
       catch (NumberFormatException e){
           JOptionPane.showMessageDialog(null,"Bitte gültige Zahlen eingeben");
           System.exit(0);
       }
    }
    private void createMatrixB(int rows, int columns){
       try{
        MatrixB = new double [rows][columns];
        o = rows;
        p = columns;
       }
       catch (NegativeArraySizeException e){
           JOptionPane.showMessageDialog(null,"Bitte nur positive Zahlen eingeben");
           System.exit(0);
       }
        try {
        for(int i=0;i<rows;i++){
            for(int i2=0;i2<columns;i2++){
                int idisplay = i+1;
                int i2display = i2+1;
                String e = JOptionPane.showInputDialog(null,"Enter b"+idisplay+i2display);
                double c = Double.parseDouble(e);
                MatrixB [i][i2]=c;
            }
        }
       }
       catch(NumberFormatException e){
           JOptionPane.showMessageDialog(null, "Bitte gültige Zahlen eingeben");
           System.exit(0);
       }    
    }
    
    private void addMatrixAB(){
        if(m !=o || n != p){
            JOptionPane.showMessageDialog(null,"Diese Matrizen können nicht addiert werden");
            System.exit(0);
        }
        MatrixR = new double [m][n];
        for(int i=0;i<m;i++){
            for(int i2=0;i2<n;i2++){
                MatrixR[i][i2] = MatrixA[i][i2] + MatrixB[i][i2];
            }
        }
        for(int i=0;i<m;i++){
            for(int i2=0;i2<n;i2++){
                int idisplay = i+1;
                int i2display  = i2+1;
                System.out.print(MatrixR[i][i2]+" ");
                if (i2display == n){
                   System.out.print("\n");
                }
            }
        }
    }
    private void subtractMatrixAB(){
        if(m !=o || n != p){
            JOptionPane.showMessageDialog(null,"Diese Matrizen können nicht subtrahiert werden");
            System.exit(0);
        }
        MatrixR = new double [m][n];
        for(int i=0;i<m;i++){
            for(int i2=0;i2<n;i2++){
                MatrixR[i][i2] = MatrixA[i][i2] - MatrixB[i][i2];
            }
        }
        for(int i=0;i<m;i++){
            for(int i2=0;i2<n;i2++){
                int idisplay = i+1;
                int i2display  = i2+1;
                System.out.print(MatrixR[i][i2]+" ");
                if (i2display == n){
                   System.out.print("\n");
                }
            }
        }
    }
    private void transposeMatrix(){
        MatrixT = new double [n][m];
        for(int i=0;i<n;i++){
            for(int i2=0;i2<m;i2++){
                MatrixT[i][i2] = MatrixA[i2][i];
            }
        }
        for(int i=0;i<n;i++){
            for(int i2=0;i2<m;i2++){
                int idisplay = i+1;
                int i2display  = i2+1;
                System.out.print(MatrixT[i][i2]+" ");
                if (i2display == m){
                   System.out.print("\n");
                }
            }
        }
        }
    private void multiplyMatrixAB(){
        if (n != o){
            JOptionPane.showMessageDialog(null,"Diese Matrizen können nicht multipliziert werden");
            System.exit(0);
        }
        MatrixR = new double [m][p];
        for(int i=0;i<m;i++){
            for(int i2=0;i2<p;i2++){
                for(int i3=0;i3<p;i3++){
                    MatrixR[i][i2] += MatrixA[i][i3]*MatrixB[i3][i2];
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int i2=0;i2<p;i2++){
                int idisplay = i+1;
                int i2display  = i2+1;
                System.out.print(MatrixR[i][i2]+" ");
                if (i2display == p){
                   System.out.print("\n");
                }
            }
        }       
    }
}