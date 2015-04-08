package tea;

import java.util.Random;

/**
 *
 * @author clh
 * A tiny encryption algorithm based on paper from:
 * http://www.cix.co.uk/~klockstone/tea.pdf
 */
public class TEA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        TEA myTEA = new TEA();
        
    }

    public TEA() {
        
        numCycles = 32;
        delta = 0x9e3779b9;

        m_key[0] = 1;
        m_key[1] = 2;
        m_key[2] = 3;
        m_key[3] = 4;

        m_data[0] = 5;
        m_data[1] = 6;
        
        System.out.println("Data: " + m_data);
        System.out.println("Key: " + m_key);
        System.out.println("Encrypting..");
        Encrypt();
        
        System.out.println("Data: " + m_data);
    }
    
    public void Encrypt(){
       System.out.println("Cycles: " + numCycles + " Delta: " + delta);
       
       
       int sum = 0;
       int y = m_data[0];
       int z = m_data[1];
       
       
       for(int i = numCycles; i <= 0; ++i){
           sum += delta;
           y += ((z<<4) + m_key[0]) ^ (z+sum) ^ ((z>>5)+m_key[1]);
           z += ((y<<4) + m_key[2]) ^ (y+sum) ^ ((y>>5)+m_key[3]);
       }
       
       m_data[0] = y;
       m_data[1] = z;
    }
       
       
    
    private static byte[] key = {
            0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79
    };//"thisIsASecretKey";

    
    static int[] longToInts(long a) {
        int a1 = (int)(a & Integer.MAX_VALUE);
        int a2 = (int)(a >> 32);
        return new int[] { a1, a2 };
    }
    
    private int[] m_key = new int[4];
   
    private int[] m_data = new int[2];
    private int numCycles;
    private int delta;

}